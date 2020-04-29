package web.config.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import web.model.RolesEnum;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component

public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException, ServletException {



        for (RolesEnum role : RolesEnum.values()) {
            for (GrantedAuthority g : authentication.getAuthorities()) {
                String userRole = g.getAuthority();
                if (userRole.equals(role.name())) {
                    String direction = "/"+role.name().toLowerCase()+"/";
                    httpServletResponse.sendRedirect(direction);
                }
            }
        }
    }
}