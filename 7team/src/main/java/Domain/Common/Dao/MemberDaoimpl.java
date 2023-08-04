package Domain.Common.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Domain.Common.Dto.MemberDto;
import Domain.Common.Service.MemberService;
import Domain.Common.Service.MemberServiceimpl;

public class MemberDaoimpl extends ConnectionPool implements MemberDao {

	private static MemberDao instance;
	public static MemberDao getInstance() {
		if(instance == null) {
			instance = new MemberDaoimpl();
		}
		return instance;
	}
	
	private MemberDaoimpl() {}
	
	@Override
	public MemberDto select1(String name) throws Exception{
		List<MemberDto> list = new ArrayList();
		MemberDto dto = null;
		pstmt = conn.prepareStatement("select * from tbl_member where name like '%"+ name +"%'" );
		rs=pstmt.executeQuery();
		if(rs!=null) {
			rs.next();
				dto = new MemberDto();
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setName(rs.getString("name"));
//				dto.setTel(rs.getString("tel"));
//				dto.setAddr(rs.getString("addr"));
				dto.setRole(rs.getInt("role"));
			rs.close();
		}
		pstmt.close();
		return dto;
	}
	@Override
	public MemberDto select2(String id) throws Exception{
		List<MemberDto> list = new ArrayList();
		MemberDto dto = null;
		pstmt = conn.prepareStatement("select * from tbl_member where member_id=?" );
		pstmt.setString(1, id);
		rs=pstmt.executeQuery();
		if(rs!=null) {
			rs.next();
				dto = new MemberDto();
				dto.setId(rs.getString("member_id"));
				dto.setPw(rs.getString("pw"));
				dto.setName(rs.getString("member_name"));
//				dto.setTel(rs.getString("tel"));
//				dto.setAddr(rs.getString("addr"));
				dto.setRole(rs.getInt("role"));
			
			rs.close();
		}
		pstmt.close();
		return dto;
	}
	@Override
	public int insert(MemberDto dto) throws Exception{
		pstmt = conn.prepareStatement("insert into tbl_member values(?,?,?,?)");
		pstmt.setString(1, dto.getId());
		pstmt.setString(2, dto.getPw());
		pstmt.setString(3, dto.getName());
//		pstmt.setString(4, dto.getTel());
//		pstmt.setString(5, dto.getAddr());
		pstmt.setInt(4, dto.getRole());
		int result=pstmt.executeUpdate();
		pstmt.close();
		return result;
	}
	@Override
	public int update(MemberDto dto) throws Exception{
		pstmt=conn.prepareStatement("update tbl_member set pw=?,name=?");
		pstmt.setString(2, dto.getPw());
		pstmt.setString(3, dto.getName());
//		pstmt.setString(4, dto.getTel());
//		pstmt.setString(5, dto.getAddr());
		int result=pstmt.executeUpdate();
		pstmt.close();
		return result;
	}
	//회원탈퇴하기 - 정재원
	@Override
	public int delete(String id)  throws Exception{
		if(id==null|| id.isEmpty()) {
			System.out.println("유효하지 않은 ID");
			return 0;
		}
		pstmt=conn.prepareStatement("delete from tbl_member where member_id=?" );
		pstmt.setString(1, id);
		int result=pstmt.executeUpdate();
		pstmt.close();
		return result;
	}
}





















