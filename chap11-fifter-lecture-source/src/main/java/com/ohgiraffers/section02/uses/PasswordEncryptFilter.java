package com.ohgiraffers.section02.uses;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/* member 서비스인 경우에만 암호화 필터를 처리하도록 필터 등록 */
@WebFilter("/member/*")
public class PasswordEncryptFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest hrequest = (HttpServletRequest) request;
        RequestWrapper wrapper = new RequestWrapper(hrequest);

        chain.doFilter(wrapper, response);

    }
}