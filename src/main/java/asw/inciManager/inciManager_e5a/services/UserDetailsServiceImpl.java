package asw.inciManager.inciManager_e5a.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import asw.inciManager.inciManager_e5a.entities.Agent;
import asw.inciManager.inciManager_e5a.repositories.AgentRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private AgentRepository usersRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Agent user = usersRepository.findByEmail(email);
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		System.out.println(user);
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				grantedAuthorities);
	}
}
