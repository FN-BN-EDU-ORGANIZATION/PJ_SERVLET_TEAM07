package Controller.Member.Auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.SubController;
import Domain.Common.Service.MemberService;
import Domain.Common.Service.MemberServiceimpl;

public class LoginController implements SubController {
	private MemberService service = MemberServiceimpl.getInstance();

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		System.out.println("LoginController execute");
		
		//GET 요청 처리
		if(req.getMethod().equals("GET"))
		{
			try {
				req.getRequestDispatcher("/WEB-INF/View/Main_Login.jsp").forward(req, resp);
			
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ;
		}
		
		
		
		// POST 요청 처리
		// 1 파라미터 추출
		String id = (String) req.getParameter("id");
		String pw = (String) req.getParameter("pw");
		System.out.println("LoginController paramtes : " + id + " " + pw);

		try {
			// 2 입력값 검증
			if (id.isEmpty() || pw.isEmpty()) {
				System.out.println("[ERROR] Data Validation Check Error!");
				req.setAttribute("msg", "[ERROR] ID나 PW가 공백입니다.");
				req.getRequestDispatcher("/WEB-INF/View/Main_Login.jsp").forward(req, resp);
				return;
			}
			// 3 서비스 실행
			boolean isLogin = false;
			req.setAttribute("id", id);
			req.setAttribute("pw", pw);

			isLogin = service.login(req);

			// 4 View로 전달
			if (isLogin) {
				// 로그인 성공 시 세션에 "member_id" 값을 저장
			    HttpSession session = req.getSession();
			    session.setAttribute("member_id", id); // 여기서 id는 로그인된 사용자의 ID 값
			    
				// main.do 이동 - Redirect
				resp.sendRedirect(req.getContextPath() + "/main.do");
			} else {
				// login.do 이동 - Forward
				req.getRequestDispatcher("/WEB-INF/View/member/auth/Main_Login.jsp").forward(req, resp);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}