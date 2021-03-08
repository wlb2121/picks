package com.tts.ecommerce.model;

import java.util.Collection;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.Transient;


//import com.fasterxml.jackson.annotation.JsonProperty;
//import com.fasterxml.jackson.annotation.JsonProperty.Access;

//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
@Entity

public class User implements UserDetails {
	
	
	   /**
	 * 
	 */
//	private static final long serialVersionUID = 1L;

	@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "user_id")
	    private long id;

	    @NotEmpty(message = "Please provide a username")
	    private String username;

	    @NotEmpty(message = "Please provide a password")
	  //  @JsonProperty(access = Access.WRITE_ONLY)
	    private String password;
	    
	    @ElementCollection
	    public Map<Product, Integer> cart;

	    
	    
		public User(@NotEmpty(message = "Please provide a username") String username,
				@NotEmpty(message = "Please provide a password") String password, Map<Product, Integer> cart) {
			super();
			this.username = username;
			this.password = password;
			this.cart = cart;
		}
		public User() {
			
		}
		

		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public Map<Product, Integer> getCart() {
			return cart;
		}
		public void setCart(Map<Product, Integer> cart) {
			this.cart = cart;
		}
		@Override
		@Transient

		public Collection<? extends GrantedAuthority> getAuthorities() {
			// TODO Auto-generated method stub
			return null;
		}

		

		
		
		
	   


		

		@Override
		@Transient
		public boolean isAccountNonExpired() {
			// TODO Auto-generated method stub
			return true;
		}

		@Override
		@Transient
		public boolean isAccountNonLocked() {
			// TODO Auto-generated method stub
			return true;
		}

		@Override
		@Transient
		public boolean isCredentialsNonExpired() {
			// TODO Auto-generated method stub
			return true;
		}

		@Override
		@Transient
		public boolean isEnabled() {
			// TODO Auto-generated method stub
			return true;
		}

	
	    
	    
	    
	
}
