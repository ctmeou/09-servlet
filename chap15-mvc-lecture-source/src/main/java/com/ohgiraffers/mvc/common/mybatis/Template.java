package com.ohgiraffers.mvc.common.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Template {

    //하나만 선언이 가능하기 때문에 선언
    private static SqlSessionFactory sqlSessionFactory;
    public static SqlSession getSqlSession() {
        //SqlSession이 생성된 적이 없을 경우에만 실행
        if (sqlSessionFactory == null) {
            String resource = "mybatis/mybatis-config.xml";

            try {
                InputStream inputStream = Resources.getResourceAsStream(resource);
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        SqlSession sqlSession = sqlSessionFactory.openSession(false);
        //요청 시마다 sqlSession이 생성
        return sqlSession;

    }
}
