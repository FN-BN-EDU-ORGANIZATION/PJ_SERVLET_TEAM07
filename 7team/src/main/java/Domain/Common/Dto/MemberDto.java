package Domain.Common.Dto;

public class MemberDto {
	
	private String member_id;
	private String pw;
	private String member_name;
	private String tel;
	private String addr;
	private int role;
	
	public MemberDto(){}

	@Override
	public String toString() {
		return "MemberDto [id=" + member_id + ", pw=" + pw + ", name=" + member_name + ", role="
				+ role + "]";
	}

	public MemberDto(String id, String pw, String name,int role) {
		super();
		this.member_id = id;
		this.pw = pw;
		this.member_name = name;
//		this.tel = tel;
//		this.addr = addr;
		this.role = role;
	}
	
	public MemberDto(String id, String pw) {
		super();
		this.member_id = id;
		this.pw = pw;
//		this.tel = tel;
//		this.addr = addr;
	}

	public String getId() {
		return member_id;
	}

	public void setId(String id) {
		this.member_id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return member_name;
	}

	public void setName(String name) {
		this.member_name = name;
	}

//	public String getTel() {
//		return tel;
//	}

//	public void setTel(String tel) {
//		this.tel = tel;
//	}
//
//	public String getAddr() {
//		return addr;
//	}
//
//	public void setAddr(String addr) {
//		this.addr = addr;
//	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}
	
	
	
	
}
