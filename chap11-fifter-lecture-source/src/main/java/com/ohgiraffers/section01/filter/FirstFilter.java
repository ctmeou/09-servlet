package com.ohgiraffers.section01.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/first/*")
public class FirstFilter implements Filter {

    public FirstFilter() {
        /* 기본 생성자
         * 필터는 톰캣 서버를 start하는 시점부터 인스턴스를 미리 생성한다. */
        System.out.println("FirstFilter 인스턴스 생성!");
    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        /* 필터 인스턴스가 최초 생성될 때 호출되는 초기화 메소드 */
        System.out.println("Filter init 호출!");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        /* Servlet으로 request가 전달되기 전에 요청을 가로채는 역할을 하는 메소드 */
        System.out.println("Filter doFilter 호출");

        /* 필터에서 처리할 코드를 작성한다. */

        /* 필터에서 처리를 한 뒤 다음 필터 혹은 서블릿을 호출한다. */
        chain.doFilter(request, response);

        /* 서블릿에서 처리 후에 다시 수행할 내용이 있으면 작성한다. */
        System.out.println("Servlet 요청 수행 완료!");
    }

    @Override
    public void destroy() {
        /* 필터 인스턴스가 소멸할 때 호출되는 메소드(= 톰캣 종료 시) */
        System.out.println("Filter destory 호출!");
    }
}