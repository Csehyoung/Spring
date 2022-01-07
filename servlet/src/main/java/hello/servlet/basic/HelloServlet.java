package hello.servlet.basic;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println(getServletName());
        System.out.println("request = " + request);
        System.out.println("response= " + response);

        String username = request.getParameter("username");
        System.out.println("username = " + username);

        response.setContentType("text/plain");      //컨텐트 타입 지정 (단순 텍스트)
        response.setCharacterEncoding("utf-8");     //문자 인코딩
        response.getWriter().write("hello~ " + username);       //http 메세지 바디에 메세지가 들어감


    }
}
