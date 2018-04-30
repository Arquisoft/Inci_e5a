package asw.inciManager.inciManager_e5a.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;;

@Service
public class SecurityService {
	
	@Autowired
	private AuthenticationManager authenticationManager;


	public void autoLogin(String email, String password) {

		UsernamePasswordAuthenticationToken aToken = new UsernamePasswordAuthenticationToken(email, password);
		Authentication a= authenticationManager.authenticate(aToken);
		if (a.isAuthenticated()) {
			SecurityContextHolder.getContext().setAuthentication(aToken);
		}
	}
}