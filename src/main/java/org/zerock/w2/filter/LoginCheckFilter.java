package org.zerock.w2.filter;

import lombok.extern.log4j.Log4j2;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = {"/todo/*"})
@Log4j2
public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("Login check filter....");
        chain.doFilter(request,response);

        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse)response;

        HttpSession session = req.getSession();
        if(session.getAttribute("loginInfo")==null){
            resp.sendRedirect("/login");
            return;
            }
        chain.doFilter(request, response);
    }
}
