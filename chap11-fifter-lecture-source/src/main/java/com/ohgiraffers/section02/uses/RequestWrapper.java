package com.ohgiraffers.section02.uses;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/* 기존의 HttpServletRequest 객체를 감싸는 RequestWrapper 객체를 만들어서
* 패스워드와 관련된 처리를 암호화하는 기능을 추가할 목적의 클래스 */
public class RequestWrapper extends HttpServletRequestWrapper {

    /* 부모에 기본 생성자가 존재하지 않으므로 request를 전달해주는 */
    public RequestWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String getParameter(String name) {
        String value = "";
        if ("password".equals(name)) {
            /* 암호화 처리된 값 */
            /* 스프링 시큐리티의 Bcrypt 암호화를 제공해주는 라이브러리를 추가한 뒤 코드를 작성한다. */
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            value = passwordEncoder.encode(super.getParameter(name));
        } else {
            /* 기존에 전달 된 값 */
            value = super.getParameter(name);
        }
        return value;
    }
}
