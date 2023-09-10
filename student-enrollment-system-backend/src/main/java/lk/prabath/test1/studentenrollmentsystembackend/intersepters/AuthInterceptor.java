package lk.prabath.test1.studentenrollmentsystembackend.intersepters;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getRequestURI().endsWith("/login")){
            System.out.println("login auth");
            return true;
        }else if (request.getSession(false) != null){
            System.out.println("auth session true");
            return true;
        }else{
            System.out.println("auth session false");
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Access Denied");
        }
    }

}
