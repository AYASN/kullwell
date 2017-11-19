package com.yandm.assir.bo.controller;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginFilter implements Filter {

    List<String> excludedPaths = new ArrayList<>();

    public void init(FilterConfig config) throws ServletException {
        buildExcludedPathsList(excludedPaths);
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);
        String path = req.getRequestURI();

        if (session == null || session.getAttribute("user") == null) {
            if (excludedFromFilter(path)) {
                chain.doFilter(req, resp);
            } else {
//                System.out.println("Not logged in!");
                resp.sendRedirect("/admin/login.jsp");
                return;
            }
        }else {
            if (excludedFromFilter(path)) {
                session.setAttribute("alreadyLoggedIn", "You're already logged in!");
                resp.sendRedirect("/admin/index.jsp");
            } else {
//                System.out.println("Logged In!");
                chain.doFilter(req, resp);
            }
        }
    }

    public void destroy() {

    }

    private boolean excludedFromFilter(String path) {
        if (excludedPaths.contains(path)) return true;
        else return false;
    }

    private void buildExcludedPathsList(List<String> excludedPaths) {
        excludedPaths.add("/admin/login.jsp");
        excludedPaths.add("/admin/login");
    }

}