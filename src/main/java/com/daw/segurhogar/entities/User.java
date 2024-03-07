package com.daw.segurhogar.entities;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "USUARIOS")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User extends AuditEntity implements Serializable, UserDetails {
	
	private static final long serialVersionUID = -3472438600170751491L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID_USER")
	private Long idUser;
	
	@Column(name = "USER_NAME", nullable = true, unique = true)
	private String userName;
	
	@Column(name = "ROLES", nullable = false)
	private String roles;
	
	@Column(name = "PASSWORD", nullable = false)
	private String password;
	
	@Column(name = "NOMBRE", nullable = false)
	private String name;
	
	@Column(name = "APELLIDOS")
	private String lastName;
	
	@Column(name = "EMAIL", nullable = false, unique = true)
	@Email
	private String email;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	    return Arrays.stream(getRoles().split(","))
	    		.map(role -> new SimpleGrantedAuthority(role))
	    		.collect(Collectors.toSet());	
	}

	
    @Override
    public boolean isAccountNonExpired() {
       return true;
    }
    @Override
    public boolean isAccountNonLocked() {
       return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }

	@Override
	public String getUsername() {
		return this.userName;
	}
	
}
