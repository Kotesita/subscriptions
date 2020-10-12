package com.kote.subscriptions.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull( message = "El campo no debe estar vacío")
	private String name;
	
	@NotNull( message = "El campo no debe estar vacío")
	
	@Email
	private String email;
	
	@NotNull ( message = "El campo no debe estar vacío")
	@Size(min= 8, message = "La contraseña debe tener mínimo 8 caracteres")
	private String password;
	
	@Transient
	private String passwordConfirmation;
	
	@OneToMany(mappedBy="creator", fetch = FetchType.LAZY)
    private List<Pack> packages;
	
	@Column(updatable=false)
	private Date createdAt;
	
	private Date updatedAt;
	
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "subscriptions", 
        joinColumns = @JoinColumn(name = "subscriptor_id"), 
        inverseJoinColumns = @JoinColumn(name = "package_id")
    )
    private List<Pack> packageCustomer;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="role_id")
    private Role role;
	 
	public User(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	public User() {
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}
	
	public List<Pack> getPackages() {
		return packages;
	}

	public void setPackages(List<Pack> packages) {
		this.packages = packages;
	}

	public List<Pack> getPackageCustomer() {
		return packageCustomer;
	}

	public void setPackageCustomer(List<Pack> packageCustomer) {
		this.packageCustomer = packageCustomer;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
	 
	@PreUpdate
	 protected void onUpdate(){
	     this.updatedAt = new Date();
	 }
}