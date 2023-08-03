package Controller.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Domain.Common.dto.MemberVO;
import Domain.Common.service.MemberService;
import Domain.Common.service.MemberServiceImpl;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/mem.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	MemberService service;
    
    public void init() throws ServletException{
    	service = MemberServiceImpl.getInstance();
    }
   
    public MemberController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			doHandler(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			doHandler(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void doHandler(HttpServletRequest request, HttpServletResponse response) throws Exception, ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		List<MemberVO> membersList = service.listMembers();
		
		request.setAttribute("membersList", membersList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/member/listmembers.jsp");
		dispatcher.forward(request, response);
		
	}
	
	

}
