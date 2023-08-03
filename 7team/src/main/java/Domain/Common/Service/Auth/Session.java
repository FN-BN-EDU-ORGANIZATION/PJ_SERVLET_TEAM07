package Domain.Common.Service.Auth;

public class Session {
	private String s_id;
	private String member_id;
	private int role;
	
	public Session() {}

	public String getS_id() {
		return s_id;
	}
	public Session(String s_id, String member_id, int role) {
		super();
		this.s_id = s_id;
		this.member_id = member_id;
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "Session [s_id=" + s_id + ", member_id=" + member_id + ", role=" + role + "]";
	}

	public void setS_id(String s_id) {
		this.s_id = s_id;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	

	
	
}
