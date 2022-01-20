package com.example.getmesocialservice.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

//todo:may be removed
@Configuration
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CORSFilter implements Filter {

    private final List<String> allowedOrigins = Arrays.asList(
    		"http://photo-application-bucket.s3-website.us-east-2.amazonaws.com",
            "http://localhost:4200",
    		"http://p.mdashikjs.com", 
    		"http://63.142.253.15",
    		"http://higherstudyabroad.com",
    		"https://higherstudyabroad.com",
            "http://app.higherstudyabroad.com",
            "https://app.higherstudyabroad.com",
    		"http://www.higherstudyabroad.com",
    		"https://www.higherstudyabroad.com",
            "http://app.wissenlms.com",
            "https://app.wissenlms.com",
            "http://www.wissenlms.com",
            "https://www.wissenlms.com",
            "http://qa.wissenlms.com",
            "https://qa.wissenlms.com",
            "http://104.251.212.239");

    private FilterConfig config;

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpServletRequest request = (HttpServletRequest) req;
        String origin = request.getHeader("Origin");
        response.setHeader("Access-Control-Allow-Origin", allowedOrigins.contains(origin) ? origin : "");
        response.setHeader("Access-Control-Allow-Credentials","true");
        response.setHeader("Access-Control-Allow-Methods", "PUT, POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with, authorization, Content-Type, Authorization, credential, X-XSRF-TOKEN, idToken");

        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            chain.doFilter(req, resp);
        }

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        config = filterConfig;
    }
}

