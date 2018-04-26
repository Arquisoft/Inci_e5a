package asw.inciManager.inciManager_e5a.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;;

@Service
public class SecurityService {
	@Autowired
	private AuthenticationManager authenticationManager;

	public String findLoggedInDni() {
		System.out.println("Entra en el metodo findlogged");
		Object userDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();
		if (userDetails instanceof UserDetails) {
			return ((UserDetails) userDetails).getUsername();
		}
		return null;
	}

	public void autoLogin(String email, String password) {

		UsernamePasswordAuthenticationToken aToken = new UsernamePasswordAuthenticationToken(email, password);
		authenticationManager.authenticate(aToken);
		if (aToken.isAuthenticated()) {
			SecurityContextHolder.getContext().setAuthentication(aToken);
		}
	}
}