package Domain.Common.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Domain.Common.Dto.BookDto;
import Domain.Common.Service.MemberServiceimpl;

public class BookDaoimpl extends ConnectionPool implements BookDao {

	private static BookDao instance;
	public static BookDao getInstance() {
		if(instance == null) {
			instance = new BookDaoimpl();
		}
		return instance;
	}
	
	private BookDaoimpl() {}
	
	@Override
	public List<BookDto> select(String keyword) throws Exception{
		List<BookDto> list = new ArrayList();
		BookDto dto = null;
		pstmt = conn.prepareStatement("select * from tbl_booklist where bookname like '%"+ keyword +"%'");
//		pstmt.setString(1, keyword);
		rs = pstmt.executeQuery();
		if(rs!=null) {
			while(rs.next()) {
				dto = new BookDto();
				dto.setBookcode(rs.getString("bookcode"));
				dto.setBookname(rs.getString("bookname"));
				dto.setAuthor(rs.getString("author"));
				dto.setPublisher(rs.getString("publisher"));
				dto.setPubdate(rs.getInt("Pubdate"));
				list.add(dto);
			}
			rs.close();
		}
		pstmt.close();
		return list;
	}
	@Override
	public int insert(BookDto dto)throws Exception{
		pstmt=conn.prepareStatement("insert into tbl_booklist values(?,?,?,?,?)");
		pstmt.setString(1, dto.getBookcode());
		pstmt.setString(2, dto.getBookname());
		pstmt.setString(3, dto.getAuthor());
		pstmt.setString(4,dto.getPublisher());
		pstmt.setInt(5, dto.getPubdate());
		int result=pstmt.executeUpdate();
		pstmt.close();
		
		return result;
	}
	@Override
	public int update(BookDto dto) throws Exception{
		pstmt=conn.prepareStatement("update tbl_booklist set bookname=?,author=?,publisher=?,pubdate=? where bookcode=?");
		pstmt.setString(1,dto.getBookname() );
		pstmt.setString(2, dto.getAuthor() );
		pstmt.setString(3,dto.getPublisher() );
		pstmt.setInt(4,dto.getPubdate());
		pstmt.setString(5,dto.getBookcode() );
		int result=pstmt.executeUpdate();
		pstmt.close();
		return result;
	}
	@Override
	public int delete(String bookcode)  throws Exception{
		pstmt=conn.prepareStatement("delete from tbl_booklist where bookcode like '%"+ bookcode +"%'" );
//		pstmt.setString(1, bookcode);
		int result=pstmt.executeUpdate();
		pstmt.close();
		return result;
	}

}
