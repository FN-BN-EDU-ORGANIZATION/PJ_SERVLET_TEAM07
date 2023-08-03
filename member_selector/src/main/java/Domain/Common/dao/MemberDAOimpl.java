package Domain.Common.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Domain.Common.dto.MemberVO;



public class MemberDAOimpl implements MemberDAO {
	
	private String id;
	private String pw;
	private String url;
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private static MemberDAOimpl instance;
	public static MemberDAOimpl getInstance() {
		if(instance == null)
			instance=new MemberDAOimpl();
		return instance;
	}		
	private MemberDAOimpl() {
		id="root";
		pw="1234";
		url="jdbc:mysql://localhost:3306/testdb";
				
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(url,id,pw);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
		public List<MemberVO> select() throws Exception{
			List<MemberVO> membersList = new ArrayList();
			MemberVO dto=null;
			pstmt=conn.prepareStatement("select * from tbl_members");
			rs=pstmt.executeQuery();
			if(rs!=null)
			{
				while(rs.next()) {
					dto=new MemberVO();
					dto.setId(rs.getString("id"));
					dto.setPwd(rs.getString("pwd"));
					dto.setName(rs.getString("name"));
					dto.setEmail(rs.getString("email"));
					dto.setJoinDate(rs.getDate("joinDate"));
					membersList.add(dto);
				}
				rs.close();
			}
			pstmt.close();
				
			return membersList;
		}
	}


