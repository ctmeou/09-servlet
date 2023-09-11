package com.ohgiraffers.section01.contextlistener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListenerTest implements ServletContextListener, ServletContextAttributeListener {

    /* 리스너는 특정 이벤트 행위가 동작할 때 컨테이너에 의해 호출되는 메소드를 인터페이스에 정의해두었다.
     * 이를 상속 받아 구현한 메소드가 특정 이벤트 발생에 대해 필요한 로직을 작성하는데, 크게 3가지 범주의 이벤트로 분류한다.
     * 1. context (→ 톰캣 컨테이너 자체에 리스너 연결)
     * 1-1. ServletContextListener : 웹 애플리케이션의 시작, 종료에 대한 이벤트 리스너
     * 1-2. ServletContextAttributeListener : context에 attribute를 추가, 제거, 수정에 대한 이벤트 리스너
     * 2. session (→ 세션에서 발생 가능한 이벤트)
     * 2-1. HttpSessionListener : Http 세션의 시작, 종료에 대한 이벤트 리스너
     * 2-2. HttpSessionAttributeListener : HttpSession에 attribute를 추가, 제거, 수정에 대한 이벤트 리스너
     * 3. request (→ request 관련 이벤트)
     * 3-1. ServletRequestListener : ServletRequest 생성과 소멸에 대한 이벤트 리스너
     * 3-2. ServletRequest에 attribute를 추가, 제거, 수정하는 것에 대한 이벤트 리스너
     * */
    public ContextListenerTest() {
        /* context가 생성될 때 변화를 감지하는 Listener 인스턴스가 함께 생성된다. */
        System.out.println("context listener 인스턴스 생성");
    }

    @Override
    public void attributeAdded(ServletContextAttributeEvent scae) {
        /* context에 attribute가 추가될 때 동작한다. */
        System.out.println("context attribute added!!");
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent scae) {
        /* context에 attribute가 제거될 때 동작한다. */
        System.out.println("context attribute removed!!");
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent scae) {
        /* context에 attribute가 변경될 때 동작한다. */
        System.out.println("context attribute replaced!!");
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        /* context가 최초 생성될 때 생성자 호출 이후 동작하는 메소드이다. */
        System.out.println("context init!!");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        /* context가 소멸할 때 동작한다. */
        System.out.println("context destroy!!");
    }

}