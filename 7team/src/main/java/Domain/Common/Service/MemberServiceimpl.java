package Domain.Common.Service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import Domain.Common.Dao.MemberDao;
import Domain.Common.Dao.MemberDaoimpl;
import Domain.Common.Dto.MemberDto;

public class MemberServiceimpl implements MemberService {

	public Map<String, Session> sessionMap;

	private MemberDao dao;

	// 싱글톤
	private static MemberService instance;

	public static MemberService getInstance() {
		if (instance == null) {
			instance = new MemberServiceimpl();
		}
		return instance;
	}

	private MemberServiceimpl() {
		dao = MemberDaoimpl.getInstance();
		sessionMap = new HashMap();
	}

	// 회원 조회하기 - 사서
	@Override
	public MemberDto getMember1(String name) throws Exception {
		System.out.println("이름으로 고객 검색 서비스");
		return dao.select1(name);
	}

	@Override
	public MemberDto getMember2(String id) throws Exception {
		System.out.println("ID로 고객 검색 서비스");
		return dao.select1(id);
	}

	// 회원 가입
	@Override
	public boolean addMember(MemberDto dto) throws Exception {
		System.out.println("회원가입 서비스");
		int result = dao.insert(dto);
		if (result > 0) {
			return true;
		}
		return false;
	}

	// 회원 수정하기
	@Override
	public boolean updateMember(MemberDto dto) throws Exception {
		System.out.println("회원정보 수정 서비스");
		int result = dao.update(dto);
		if (result > 0) {
			return true;
		}
		return false;
	}

	// 회원 탈퇴하기 -정재원
	@Override
	public boolean deleteMember(String id) throws Exception {
		System.out.println("회원탈퇴 서비스");
		int result = dao.delete(id);
		if (result > 0) {
			return true;
		}
		return false;
	}

	// =================================================================
	// 로그인

	// 로그아웃

//	@Override
//	public Map<String,Object> login(String id, String pw) throws Exception{
//		MemberDto dbDto = dao.select2(id);
//		if(dbDto==null) {
//			System.out.println("[Error] 일치하는 아이디가 없습니다. 다시 입력해주세요....");
//			return null;
//		}
//		if(!pw.equals(dbDto.getPw())) {
//			System.out.println("[Error] 비밀번호가 일치하지 않습니다. 다시 입력해주세요....");
//		}
//		String sid=UUID.randomUUID().toString();
//		Session session = new Session(sid,dbDto.getId(),dbDto.getRole());
//		sessionMap.put(sid, session);
//		
//		Map<String,Object> result = new HashMap();
//		result.put("sid", sid);
//		result.put("role", dbDto.getRole());
//		return result;
//	}
//
//	@Override
//	public boolean logout(String id,String sid) {
//		Session session =  sessionMap.get(sid);
//		
//		if( ! session.getId().equals(id) ) {
//			System.out.println("[ERROR] ID가 일치하지 않습니다.");
//			return false;
//		}
//		sessionMap.remove(sid);
//		return true;
//	}
//	
//	//역할반환함수 
//	@Override
//	public String getRole(String sid) {
//		Session session = sessionMap.get(sid);
//		System.out.println("getRole's Session : " + session);
//		if(session!=null)
//			return session.getRole();
//		
//		return null;
//	}
	@Override
	public boolean login(HttpServletRequest req) throws Exception {
		String member_id = (String) req.getParameter("id");
		String pw = (String) req.getParameter("pw");
		MemberDto dbDto = dao.select2(member_id);
		if (dbDto == null) {
			System.out.println("[Error] 일치하는 아이디가 없습니다. 다시 입력해주세요....");
			return false;
		}
		if (!pw.equals(dbDto.getPw())) {
			System.out.println("[Error] 비밀번호가 일치하지 않습니다. 다시 입력해주세요....");
			return false;
		}
		System.out.println("login func's dbDto" + dbDto);
		HttpSession session = req.getSession(true);
		System.out.println("login func's session : " + session);
		session.setAttribute("ID", member_id);
		session.setAttribute("ROLE", dbDto.getRole());
		session.setMaxInactiveInterval(60 * 30);
		return true;
	}

	@Override
	public boolean logout(HttpServletRequest req) throws Exception {
		HttpSession session = req.getSession(true);

		if (!session.getId().equals(req)) {
			System.out.println("[ERROR] ID가 일치하지 않습니다.");
			return false;
			
		}
		sessionMap.remove(req);
		return true;
	}

	@Override
	public String getRole(String sid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean memberDelete(String id) throws Exception {
		int result = dao.delete(id);
		if(result>0) {
			return true;
		}
		return false;
	}
}
