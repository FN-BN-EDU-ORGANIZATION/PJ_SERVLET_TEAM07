package Controller.Member;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.SubController;
import Domain.Common.Dto.MemberDto;
import Domain.Common.Service.MemberService;
import Domain.Common.Service.MemberServiceimpl;

public class MemberInsertController implements SubController {
	
	private MemberService service = MemberServiceimpl.getInstance();

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		//GET 요청 처리
		try {
				if(req.getMethod().equals("GET"))
				{	
					req.setAttribute("msg", "");
					req.getRequestDispatcher("/WEB-INF/View/Join.jsp").forward(req, resp);
					return ;
				}
				
				//회원가입 구현 성공! -주현
				// POST 요청 처리
				// 1 파라미터 추출
				String id = (String) req.getParameter("id");
				String pw = (String) req.getParameter("pw");
				System.out.println("LoginController paramtes : " + id + " " + pw);

				
					// 2 입력값 검증
					if (!isValid(req.getParameterMap())) {
						req.setAttribute("msg", "유효성체크 오류");
						req.getRequestDispatcher("/WEB-INF/View/Join.jsp").forward(req, resp);
						return;
					}
					MemberDto dto = new MemberDto();
					dto.setId(id);
					dto.setPw(pw);
					// 3 서비스 실행
					boolean isLogin = service.addMember(dto);

					// 4 View로 전달
					if (isLogin) {
						// main.do 이동 - Redirect
						resp.sendRedirect(req.getContextPath() + "/login.do");
					} else {
						req.setAttribute("msg", "회원가입 실패...");
						req.getRequestDispatcher("/WEB-INF/View/Join.jsp").forward(req, resp);
					}

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		
	}

	private boolean isValid(Map<String, String[]> parameterMap) {
		// TODO Auto-generated method stub
		return true;
	}
}

