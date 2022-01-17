package hello.servlet.web.servletmvc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//Controller
@WebServlet(name = "MvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //WEB-INF 안에 있는 경로는 외부에서 다이렉트로 호출되지 않는다.
        //꼭 Controller를 이용하여 호출하고 싶을때 해당 디렉토리를 만들어 사용해주면 된다.
        String viewPath = "/WEB-INF/views/new-form.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);   //Controller에서 View로 이동할 때 사용
        dispatcher.forward(request, response);                                   //jsp 호출

        //forward는 viewPath경로의 파일을 호출하지만 URL은 변하지 않는다.
        //즉 redirect 기능이 아니라 서버 내부적으로 호출을 하기때문에
        //URL이 viewPath로 바뀌는것이 아닌 new-form 그대로 나타난다.
    }
}
