package com.petclinic.controller;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "Filter",urlPatterns = "/testServlet")
public class Filter implements javax.servlet.Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        resp.getWriter().append(" Before ");
        chain.doFilter(req, resp);
        resp.getWriter().append(" After ");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
