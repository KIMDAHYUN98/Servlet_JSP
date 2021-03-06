package co.micol.minipro;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.minipro.common.Service;
import co.micol.minipro.member.service.MemberIdCheck;
import co.micol.minipro.member.service.MemberJoin;
import co.micol.minipro.member.service.MemberJoinForm;
import co.micol.minipro.member.service.login;
import co.micol.minipro.member.service.loginForm;
import co.micol.minipro.member.service.logout;

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private HashMap<String, Service> map = new HashMap<String, Service>();
    // 어떤 요청이 들어오면 어떤 것을 실행할 것인가?
    // String = 요청명, Service = 실행할 Command
   
    public FrontController() {
        super(); 
    }


	public void init(ServletConfig config) throws ServletException {
		map.put("/main.do", new MainService()); // 메인화면 호출
		map.put("/loginForm.do", new loginForm()); // 로그인 폼 호출
		map.put("/login.do", new login()); // 로그인 처리
		map.put("/logout.do", new logout()); // 로그아웃 처리
		map.put("/memberJoinForm.do", new MemberJoinForm()); // (요청명, 실행할 command)
		map.put("/memberJoin.do", new MemberJoin()); // 회원가입
		map.put("/idCheck.do", new MemberIdCheck()); // 아이디 중복체크
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String contextPath = request.getContextPath(); // 최상위 경로
		String uri = request.getRequestURI();
		String path = uri.substring(contextPath.length()); // 실제 요청한 경로 확인
		
		Service service = map.get(path); // new MainService(), 적절한 command를 찾는 부분
		String viewPage = service.run(request, response); // 실행해서 결과를 돌려주는 페이지
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
		// service가 동작 할 때 어떻게 끝낼 것 인지를 설정
	}

}
