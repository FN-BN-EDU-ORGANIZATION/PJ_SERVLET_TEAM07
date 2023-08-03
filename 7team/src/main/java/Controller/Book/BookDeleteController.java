package Controller.Book;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.SubController;
import Domain.Common.Service.BookService;
import Domain.Common.Service.BookServiceimpl;

public class BookDeleteController implements SubController {
	private BookService service = BookServiceimpl.getInstance();

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
	}

	

}
