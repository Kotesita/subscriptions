package com.kote.subscriptions.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kote.subscriptions.models.Pack;
import com.kote.subscriptions.models.User;
import com.kote.subscriptions.services.PackService;
import com.kote.subscriptions.services.UserService;

@Controller
public class PackController {
    private final PackService packService;
    private final UserService userService;
    
    public PackController(PackService packService, UserService userService) {
        this.packService = packService;
        this.userService = userService;
    }
    
    @RequestMapping("/packages")
    public String home(Model model, HttpSession session) {
        List<Pack> pack = packService.allPackages();
        model.addAttribute("pack", pack);
        List<User> user = userService.allUsers();
        model.addAttribute("user", user);
        return "packages.jsp";
    }
  
    @RequestMapping("/pack/new")
    public String createPack(@Valid @ModelAttribute("pack") Pack pack, Model model) {
        return "/newPackage.jsp";
    }
    
    @RequestMapping(value="/pack/new", method=RequestMethod.POST)
    public String createpack(@Valid @ModelAttribute("pack") Pack pack, Model model) {
    	pack = packService.createPack(pack);
        model.addAttribute(pack);
        return "redirect:/packages";
    }
    
    @RequestMapping("/pack/{id}/edit")
    public String editPack(@PathVariable("id") Long id, Long cost, Model model) {
    	if(cost != null) {
	        Pack pack = packService.findById(id);
	        pack = packService.updatePack(id,cost);
	        model.addAttribute("pack", pack);
	        return "redirect:/packages";
        } else {
        	Pack pack = packService.findById(id);
	        pack = packService.updatePack(pack);
	        model.addAttribute("pack", pack);
        	return "/editPackage.jsp";
        }
    }
    
    @RequestMapping(value="/pack/{id}/edit", method=RequestMethod.PUT)
    public String update(@ModelAttribute("pack") Pack pack, BindingResult result) {       
    	if (result.hasErrors()) {
            return "/editPackage.jsp";
        } else {
 
            packService.updatePack(pack);
            return "redirect:/packages";
        }
    }
    
    @RequestMapping("/pack/{id}/delete")
    public String deletePack(@PathVariable("id") Long id) {
        packService.deletePack(id);
        return "redirect:/packages";
    }
}
