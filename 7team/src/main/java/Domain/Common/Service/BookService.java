package Domain.Common.Service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import Domain.Common.Dto.BookDto;

public interface BookService {

	List<BookDto> getBook() throws Exception;

	List<BookDto> getBook(HttpServletRequest req) throws Exception;

	boolean addBook(BookDto dto) throws Exception;

	boolean updateBook(BookDto dto) throws Exception;

	boolean removeBook(String bookcode) throws Exception;

}