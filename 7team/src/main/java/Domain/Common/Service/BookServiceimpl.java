package Domain.Common.Service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import Domain.Common.Dao.BookDao;
import Domain.Common.Dao.BookDaoimpl;
import Domain.Common.Dto.BookDto;

public class BookServiceimpl implements BookService{

	private BookDao dao;
	
	private static BookService instance;

	public static BookService getInstance() {
		if (instance == null) {
			instance = new BookServiceimpl();
		}
		return instance; 
	}
	private BookServiceimpl() {
		dao = BookDaoimpl.getInstance();
	}
	@Override
	public List<BookDto> getBook() throws Exception {
		System.out.println("전체 도서조회 서비스");
		return null;
	}
	public List<BookDto> getBook(String keyword) throws Exception {
		System.out.println("전체 도서조회 서비스");
		return dao.select(keyword);
	}
	
	@Override
	public boolean addBook(BookDto dto) throws Exception{
		System.out.println("도서 정보 추가 서비스");
		int result = dao.insert(dto);
		if(result>0) {
			return true;
		}
		return false;
	}
	@Override
	public boolean updateBook(BookDto dto) throws Exception{
		System.out.println("도서 정보 수정 서비스");
		int result = dao.update(dto);
		if(result>0) {
			return true;
		}
		return false;
	}
	@Override
	public boolean removeBook(String bookcode) throws Exception{
		System.out.println("도서 정보 삭제 서비스");
		int result = dao.delete(bookcode);
		if(result>0) {
			return true;
		}
		return false;
	}
	@Override
	public List<BookDto> getBook(HttpServletRequest req) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
