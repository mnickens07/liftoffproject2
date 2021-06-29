package org.launchcode.liftoffproject2;

import org.launchcode.liftoffproject2.controllers.AuthenticationController;
import org.launchcode.liftoffproject2.data.UserRepository;
import org.launchcode.liftoffproject2.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class AuthenticationFilter extends HandlerInterceptorAdapter {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationController authenticationController;

   private static final List<String> whitelist = Arrays.asList("/login", "/register", "logout", "/css", "/", "/passtime-logo2.png");
// a whitelist field filters which pages are allowed without authentication. The index/home page should not be
// one of the protected pages because I want users visiting to be able to see the homepage before they register/login.
// At minimum the user should be allowed to access the routes associated with login, logout, and register.

    private static boolean isWhitelisted(String path) {
        for (String pathRoot :whitelist) {
            if (path.equals(pathRoot)) { //could also use .equals() instead of startsWith() to be more restrictive.
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler)throws IOException {

        //Don't require sign-in for whitelisted pages
        if (isWhitelisted(request.getRequestURI())) {// request.getRequestURI returns the request path.
            //returning true means that request can proceed
            return true;
        }

            HttpSession session =  request.getSession();
            User user = authenticationController.getUserFromSession(session);

            //the user is logged in
        if (user !=null) {
            return true;
        }

        //the user is NOT logged in
        response.sendRedirect("/login");
        return false;
    }
}
