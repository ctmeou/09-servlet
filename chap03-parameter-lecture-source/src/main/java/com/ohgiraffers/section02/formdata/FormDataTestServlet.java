package com.ohgiraffers.section02.formdata;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@WebServlet("/formdata")
public class FormDataTestServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /* GET 방식의 데이터는 HTML charset에 기술된 인코딩 방식으로 브라우저가 한글을 이해하고, %문자로 URLEncoder를 이용해 변환한 뒤 url 요청으로 전송한다.
        * 이 때 header의 내용은 ascii 코드로 전송되기 때문에 어떤 언어든 서버의 설정 인코딩 방식과 맞기만 하면 해석에 문제가 없어 한글 값이 깨지지 않는다.
        * GET 요청은 보통 서버의 리소스를 가져오는 행위를 요청하는 http 요청 방식이기 때문에 별도의 데이터가 필요 없어 요청 body(페이로드)는 해석하지 않는다.
        *
        * POST 요청은 서버의 리소스에 내용을 추가하는 요청이기 때문에 요청하는 데이터가 필요한 경우가 대부분이다.
        * 서버의 리소스에 추가해야 하는 정보를 페이로드에 key&value 방식으로 담아 전송하는데, 헤더와는 별개로 URLEncoder를 이용하지 않고
        * 페이지 meta에 기술된 charset에 따라 UTF-8로 해석된 데이터를 서버로 전송한다.
        * 서버에 페이로드를 디코딩하는 방식은 지정되어 있지 않으므로 request.getCharacterEncoding()을 호출하면 null이 반환되는데
        * default로는 IS0-8859-1로 해석하므로 한글이 깨지는 현상이 발생한다.
        * */

        /* 기본 설정 인코딩 방식이 null이므로 톰캣의 기본 세팅 값인 IS0-8859-1로 디코딩을 시도한다. */
        System.out.println(request.getCharacterEncoding());

        /* 파라미터 값을 꺼내기 전에 디코딩할 인코딩 방식을 설정하면 설정한 방식으로 페이로드의 값을 해석한다. */
        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        System.out.println("name : " + name);

        /* 인코딩 설정을 제외한 나머지 값들은 GET 방식에서 값을 꺼내온 것과 동일하다. */

        /* 만약 클라이언트 쪽에서 요청한 데이터의 key와 value를 하나 하나 확인하기 힘들다면
        * 모든 데이터의 Key를 이용하여 전송된 값들을 일괄 처리 할 수 있다. */
        Map<String, String[]> requestMap = request.getParameterMap();
        Set<String> keySet = requestMap.keySet();
        Iterator<String> keyIter = keySet.iterator();

        while (keyIter.hasNext()) {
            String key = keyIter.next();
            String[] value = requestMap.get(key);

            System.out.println("key : " + key);
            for (int i = 0; i < value.length; i++) {
                System.out.println("value[" + i + "] : " + value[i]);
            }
        }
    }
}
