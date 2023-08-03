package Controller.Member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.SubController;
import Domain.Common.Service.MemberService;
import Domain.Common.Service.MemberServiceimpl;

public class MemberDeleteController implements SubController{

	private MemberService service = MemberServiceimpl.getInstance();
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("MemberDeleteController execute");
		
	
		
	
		Boolean rValue=false;
		try {
			rValue = service.memberDelete(req); 
			if(rValue) {
				resp.sendRedirect(req.getContextPath()+"/Main.do"); //탈퇴 성공시 메인페이지 이동!
			}else {
				req.getRequestDispatcher("/WEB-INF/view/member/UserInfo.jsp").forward(req, resp); //탈퇴 실패 시 유저페이지 유지!
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		
	}

}
