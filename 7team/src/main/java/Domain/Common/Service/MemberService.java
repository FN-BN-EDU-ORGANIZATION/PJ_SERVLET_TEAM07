package Domain.Common.Service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import Domain.Common.Dto.MemberDto;

public interface MemberService {

	MemberDto getMember1(String name) throws Exception;

	MemberDto getMember2(String id) throws Exception;

	boolean addMember(MemberDto dto) throws Exception;

	boolean updateMember(MemberDto dto) throws Exception;

	boolean deleteMember(String member_id) throws Exception;

	//로그인
	boolean login(HttpServletRequest req) throws Exception;


	//역할반환함수 
	String getRole(String sid);

	//로그아웃
	boolean logout(HttpServletRequest req) throws Exception;

	

}