package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * 1. parameter 전송 기능
 * http:localhost:8080/request-param?username=sehyoung&age=32
 */
@WebServlet(name = "RequestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Value 중복 시 맨 첫번째 것만 반환함
        System.out.println("[전체 파라미터 조회] - Start");
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> System.out.println(paramName + " = " + request.getParameter(paramName)));
        System.out.println("[전체 파라미터 조회] - End");
        System.out.println();


        System.out.println("[단일 파라미터 조회] - Start");
        String name = request.getParameter("username");
        String age = request.getParameter("age");
        System.out.println("username = " + name);
        System.out.println("age = " + age);
        System.out.println("[단일 파라미터 조회] - End");
        System.out.println();


        //하나의 파라미터에 여러 값을 넘길 수도 있다
        //ex) http://localhost8080/request-param?username=sehyoung&username=sehyoung2
        System.out.println("[파라미터 여러 값 조회] - Start");
        String[] usernames = request.getParameterValues("username");
        for (String username : usernames) {
            System.out.println("username = " + username);
        }
        System.out.println("[파라미터 여러 값 조회] - End");

        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("ok!");

    }
}
