package com.GimnasioCertant.Gimnasio.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

public class authInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        HttpSession session = request.getSession(false);
        String uri = request.getRequestURI();

        // Excepciones: login y recursos estáticos
        if (uri.startsWith("/Redirect/login") || uri.startsWith("/Redirect/Ingresar") || uri.startsWith("/css/") || uri.startsWith("/js/")) {
            return true;
        }

        // Validación de sesión
        if (session == null || session.getAttribute("SocioSession") == null) {
            if (uri.startsWith("/api/")) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // API
            } else {
                response.sendRedirect("/Redirect/login"); // Vistas
            }
            return false;
        }

        return true;
    }
}
