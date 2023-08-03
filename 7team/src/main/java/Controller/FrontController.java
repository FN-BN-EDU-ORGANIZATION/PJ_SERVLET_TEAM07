package Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.Book.BookDeleteController;
import Controller.Book.BookInsertController;
import Controller.Book.BookSelectController;
import Controller.Book.BookUpdateController;
import Controller.Member.MemberDeleteController;
import Controller.Member.MemberInsertController;
import Controller.Member.MemberSelect1Controller;
import Controller.Member.MemberSelect2Controller;
import Controller.Member.MemberUpdateController;
import Controller.Member.Auth.LoginController;
import Controller.Member.Auth.LogoutController;


public class FrontController extends HttpServlet {
	
	private Map<String,SubController> map = new HashMap();

	
	

	@Override
	public void init(ServletConfig config) throws ServletException {
		
		String projectPath = config.getServletContext().getContextPath();
		
		
		//Book
		map.put(projectPath+"/book/select.do", new BookSelectController());
		map.put(projectPath+"/book/insert.do", new BookInsertController());
		map.put(projectPath+"/book/update.do", new BookUpdateController());
		map.put(projectPath+"/book/delete.do", new BookDeleteController());
		
		//member
		map.put(projectPath+"/member/select1.do", new MemberSelect1Controller());
		map.put(projectPath+"/member/select2.do", new MemberSelect2Controller());
		map.put(projectPath+"/Join.do", new MemberInsertController());
		map.put(projectPath+"/member/update.do", new MemberUpdateController());
		map.put(projectPath+"/member/delete.do", new MemberDeleteController());
		
		//member.auth
		map.put(projectPath+"/login.do", new LoginController());
		map.put(projectPath+"/member/auth/logout.do", new LogoutController());
		
		//main
		map.put(projectPath+"/main.do", new MainController());
		
		
		
	}



	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		SubController controller = map.get(req.getRequestURI());
		controller.execute(req, resp);
		
		
	}

	


	
	
	
//	@Override
//	public Map<String,Object> execute(String request, int serviceNo, Map<String,Object> param){
//		Object controller = map.get(request);
//		
//		Map<String,Object> result = new HashMap();
//		
//		if(controller instanceof BookController) {
//			BookController down=(BookController)controller;
//			result = down.execute(serviceNo,param);
//			System.out.println("BookController!");
//		}else if(controller instanceof MemberController){
//			MemberController down = (MemberController)controller;
//			result = down.execute(serviceNo, param);
//			System.out.println("MemberController!");
//		}else {
//			System.out.println("Request Error Occured");
//		}
//		return result;
//	}
}
