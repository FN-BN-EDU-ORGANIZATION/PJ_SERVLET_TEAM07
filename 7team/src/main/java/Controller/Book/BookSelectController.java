package Controller.Book;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import Controller.SubController;
import Domain.Common.Dto.BookDto;
import Domain.Common.Service.BookService;
import Domain.Common.Service.BookServiceimpl;

public class BookSelectController implements SubController {

	private BookService service = BookServiceimpl.getInstance();
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		List<BookDto> list = null;
		
		try {
			list=service.getBook(req);
			
			ObjectMapper objectMapper = new ObjectMapper();
			String jsonConverted = objectMapper.writeValueAsString(list);
			
			//View로 전달
			resp.setContentType("application/json");
			PrintWriter out = resp.getWriter();
			out.print(jsonConverted);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
