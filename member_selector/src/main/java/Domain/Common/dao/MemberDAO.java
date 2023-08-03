package Domain.Common.dao;

import java.util.List;

import Domain.Common.dto.MemberVO;

public interface MemberDAO {
	
	public List<MemberVO> select() throws Exception;
}
