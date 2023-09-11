package com.ohgiraffers.section02.uses;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/* 필터 등록을 web.xml(배포 서술자)에서 처리 */
public class EncodingFilter implements Filter {

    private String encodingType;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        encodingType = filterConfig.getInitParameter("encoding-type");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest hrequest = (HttpServletRequest) request;
        if("POST".equals(hrequest.getMethod())) {
            request.setCharacterEncoding(encodingType);
        }
        chain.doFilter(request, response);
    }
}