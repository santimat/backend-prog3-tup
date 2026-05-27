package com.santi.learningspringboot.filter.jwt;

import com.santi.learningspringboot.service.jwt.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

// Spring boot's component, it allows run some actions without business logic.
@Component
public class JwtFilter extends OncePerRequestFilter {
    private final JwtService jwtService;

    public JwtFilter(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String path = request.getRequestURI();
        String method = request.getMethod();

        boolean isLogin = path.startsWith("/api/auth");
        boolean isSignIn = path.startsWith("/api/users") && method.equals("POST");

        if (isLogin || isSignIn) {
            // skip the JWT validation
            filterChain.doFilter(request, response);
            return;
        }

        String authHeader = request.getHeader("Authorization");
        boolean isMissingToken = authHeader == null || !authHeader.startsWith("Bearer ");
        if (isMissingToken) {
            // 401 Unauthorized
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Access token is required");
            return;
        }

        // get token from header. Example: authHeader= "Bearer mundial2026" we just get mundial2026
        String token = authHeader.substring(7);

        if (!jwtService.isValid(token)) {
            response.setStatus(HttpServletResponse.SC_ACCEPTED);
            response.getWriter().write(("Invalid or expired Access token"));
        }

        filterChain.doFilter(request, response);
    }
}
