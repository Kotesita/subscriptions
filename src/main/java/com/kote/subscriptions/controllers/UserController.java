package com.kote.subscriptions.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kote.subscriptions.models.Subscription;
import com.kote.subscriptions.models.User;
import com.kote.subscriptions.services.PackService;
import com.kote.subscriptions.services.RoleService;
import com.kote.subscriptions.services.SubscriptionService;
import com.kote.subscriptions.services.UserService;

@Controller
public class UserController {
    private final UserService userService;
    private final RoleService roleService;
    private final PackService packService;
    private final SubscriptionService subsService;

    
    public UserController(UserService userService, RoleService roleService, SubscriptionService subsService, PackService packService) {
        this.userService = userService;
        this.roleService = roleService;
        this.packService = packService;
        this.subsService = subsService;
       
    }
    
    @RequestMapping("/registration")
    public String registerForm(@ModelAttribute("user") User user) {
        return "registration.jsp";
    }
    
   @RequestMapping("/login")
    public String login() {
        return "registration.jsp";
    }
    
    @RequestMapping(value="/registration", method=RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
    //si el resultado tiene errores, retornar a la página de registro 
	    if (result.hasErrors()) {
	    	return "registration.jsp";
	    } else {
	    	if(userService.allUsers().isEmpty()) {
	    		user.setRole(roleService.findByName("ROLE_ADMIN"));
	    		User u = userService.registerUser(user);
			    session.setAttribute("id", u.getId());
			    return "redirect:/packages";
	    	} else {
	    		user.setRole(roleService.findByName("ROLE_USER"));
	    		Subscription subs = new Subscription();
	    		subs.setCreatedAt(user.getCreatedAt());
	    		subs.setUser(user);
	    		subs.setPack(packService.findByName("Basic"));
	    		User u = userService.registerUser(user);
			    session.setAttribute("userId", u.getId());
			    
			    return "redirect:/users/"+session.getAttribute("userId");
	    	}
	    }
    }
    
    @RequestMapping("/loginUser")
    public String loginUser(@ModelAttribute("user") User user, @RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
    //Si el usuario está autenticado, guarde su id de usuario en el objeto Session
    boolean isAuthenticated = userService.authenticateUser(email, password);
		if (isAuthenticated) {
			User u = userService.findByEmail(email);
			session.setAttribute("userId", u.getId());
			if(u.getRole().equals(roleService.findByName("ROLE_ADMIN"))) {
				return "redirect:/packages";
			} else {
				return "redirect:/users/"+session.getAttribute("userId");   
			}
		} else {
			model.addAttribute("error", "Credenciales invalidas, intenta otra vez");
			return "registration.jsp";
		}
    }
   
    @RequestMapping("/users/{id}")
    public String userDetail(@PathVariable("id") Long id, Model model, @ModelAttribute("subs") Subscription subs, @ModelAttribute("user") User user, BindingResult result) {
    	if (result.hasErrors()) {
            return "/registration.jsp";
        } else {
            user = userService.findUserById(id);
            model.addAttribute(user);
            return "/userDetails.jsp";
        }
    }
    
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        // invalidar la sesión
    	session.invalidate();
        // redireccionar a la página de inicio de sesión.
    	return "redirect:/registration";
    }
}
