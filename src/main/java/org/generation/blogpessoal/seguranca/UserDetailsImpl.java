package org.generation.blogpessoal.seguranca;

import java.util.Collection;

import org.generation.blogpessoal.model.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsImpl implements UserDetails  {

	private static final long serialVersionUID = 1L;
	
	
	private String Username;
	private String Password;
	
	
	public UserDetailsImpl (Usuario user) {
		
		this.Username= user.getUsuario();
		this.Password=user.getSenha();
	}
	
	public UserDetailsImpl () {
	}
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return Password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return Username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	
	
}
