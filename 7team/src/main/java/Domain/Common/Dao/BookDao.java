package Domain.Common.Dao;

import java.util.List;

import Domain.Common.Dto.BookDto;

public interface BookDao {

	List<BookDto> select(String keyword) throws Exception;

	int insert(BookDto dto) throws Exception;

	int update(BookDto dto) throws Exception;

	int delete(String bookcode) throws Exception;

}