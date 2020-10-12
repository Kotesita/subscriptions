package com.kote.subscriptions.models;

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
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="packages")
public class Pack{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "El campo no debe estar vacío")
	private String name;
	
	@NotNull(message = "El campo no debe estar vacío")
	private Long cost;
	
	private Boolean available;
	
	@Column(updatable=false)
	private Date createdAt;
	
	private Date updatedAt;

	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "subscriptions", 
        joinColumns = @JoinColumn(name = "package_id"), 
        inverseJoinColumns = @JoinColumn(name = "subscriptor_id")
    )
    private List<User> subscriptor;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="creator_id")
    private User creator;
	
	public Pack(String name, Long cost) {
		this.name = name;
		this.cost = cost;
		this.available = true;
	}
	
	public Pack() {
		this.available = true;
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
	
	public Long getCost() {
		return cost;
	}
	
	public void setCost(Long cost) {
		this.cost = cost;
	}
	
	public Boolean getAvailable() {
		return available;
	}
	
	public void setAvailable(Boolean available) {
		this.available = available;
	}
	
	public List<User> getSubscriptor() {
		return subscriptor;
	}

	public void setSubscriptor(List<User> subscriptor) {
		this.subscriptor = subscriptor;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
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