package Controller.Member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.SubController;
import Domain.Common.Dao.MemberDao;
import Domain.Common.Dao.MemberDaoimpl;
import Domain.Common.Service.MemberService;
import Domain.Common.Service.MemberServiceimpl;

public class MemberDeleteController implements SubController {

	private MemberService service = MemberServiceimpl.getInstance();

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("MemberDeleteController execute");

		
		try {
			HttpSession session = req.getSession();
			String Id = (String) session.getAttribute("member_id");
			MemberDao memberDao = MemberDaoimpl.getInstance();
			int result = memberDao.delete(Id);
			
		
			System.out.println(Id);
			if(result>0) {
				// 회원 탈퇴 성공 시 세션에서 "member_id" 값을 삭제
				
				
				System.out.println("탈퇴성공");
				resp.sendRedirect(req.getContextPath()+"/main.do");
			}else {
				// 회원 탈퇴 실패 시 세션에서 "member_id" 값을 삭제
	            session.removeAttribute("member_id");
				System.out.println("탈퇴실패");
				resp.sendRedirect(req.getContextPath()+"/WEB-INF/view/member/UserInfo.jsp");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
//		String userId = (String) req.getSession().getAttribute("member_id");
//
//		System.out.println(userId);
//		if (userId != null) {
//			
//			Boolean rValue = false;
//			try {
//				rValue = service.memberDelete(userId);
//				if (rValue) {
//					resp.sendRedirect(req.getContextPath() + "/main.do"); // 탈퇴 성공시 메인페이지 이동!
//				} else {
//					req.getRequestDispatcher("/WEB-INF/view/member/UserInfo.jsp").forward(req, resp); // 탈퇴 실패 시 유저페이지
//																										// 유지!
//
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
		}

	}


