package be.ifapme.sab.config.security;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SameSiteCookieFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        chain.doFilter(request, response);

        if (response instanceof HttpServletResponse httpResp) {
            for (String header : httpResp.getHeaders("Set-Cookie")) {
                if (header.startsWith("JSESSIONID")) {
                    httpResp.setHeader("Set-Cookie", header + "; SameSite=Strict");
                }
            }
        }
    }
}
