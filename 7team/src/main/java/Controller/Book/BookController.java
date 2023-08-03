package Controller.Book;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Domain.Common.Dto.BookDto;
import Domain.Common.Service.BookService;
import Domain.Common.Service.BookServiceimpl;

public class BookController {
	
	private BookService service;
	
	public BookController() {
		service = BookServiceimpl.getInstance();
	}
	
	// 1 Select , 2 Insert , 3 Update , 4 Delete
	public Map<String,Object> execute(int serviceNo, Map<String,Object> param){
		if(serviceNo == 1) {
			
//			파라미터 추출
			String keyword = (String)param.get("keyword");
//			입력값 검증
			
//			서비스 실행
			List<BookDto> list = null;	
			try {
				list = service.getBook();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
//			뷰로 전달
			Map<String,Object> result = new HashMap();
			result.put("result",list);
			return result;
		}else if(serviceNo == 2) {
			String bookcode = (String) param.get("bookcode");
			String bookname = (String) param.get("bookname");
			String author = (String) param.get("author");
			String publisher = (String) param.get("publisher");
			Integer pubdate = (Integer) param.get("pubdate");
			
			if(bookcode == null || bookname == null || author == null || publisher == null || pubdate == null) {
				System.out.println("[Error] Data validation check Error Occured");
				return null;
			}
			BookDto dto = new BookDto(bookcode,bookname,author,publisher,pubdate);
			System.err.println("Dto : " + dto);
			
			Boolean value = false;
			
			try {
				value = service.addBook(dto);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("책 정보가 입력되었습니다.");
			Map<String,Object> result = new HashMap();
			result.put("result", value);
			return result;
		}else if (serviceNo == 3) {
			String bookcode = (String) param.get("bookcode");
			String bookname = (String) param.get("bookname");
			String author = (String) param.get("author");
			String publisher = (String) param.get("publisher");
			Integer pubdate = (Integer) param.get("pubdate");
			
			if(bookcode == null || bookname == null || author == null || publisher == null || pubdate == null) {
				System.out.println("[Error] Data validation check Error Occured");
				return null;
			}
			BookDto dto = new BookDto(bookcode,bookname,author,publisher,pubdate);
			System.err.println("Dto : " + dto);
			
			Boolean value = false;
			
			try {
				value = service.updateBook(dto);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("책 정보가 수정되었습니다.");
			Map<String,Object> result = new HashMap();
			result.put("result", value);
			return result;
		}else if(serviceNo ==4) {
			String bookcode = (String) param.get("bookcode");
			
			if (bookcode == null) {
				System.out.println("[Error] Data validation check Error Occured");
				return null;
			}
			Boolean value = false;
			try {
				value = service.removeBook(bookcode);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("책 정보가 삭제되었습니다.");
			Map<String,Object> result = new HashMap();
			result.put("result", value);
			return result;
		}
		return null;
	}
}
