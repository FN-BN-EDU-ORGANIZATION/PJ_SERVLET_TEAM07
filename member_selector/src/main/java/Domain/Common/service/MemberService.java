package Domain.Common.service;

import java.util.List;

import Domain.Common.dto.MemberVO;

public interface MemberService {
	List<MemberVO> listMembers() throws Exception;
}
