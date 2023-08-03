package Domain.Common.service;

import java.util.List;

import Domain.Common.dao.MemberDAO;
import Domain.Common.dao.MemberDAOimpl;
import Domain.Common.dto.MemberVO;

public class MemberServiceImpl implements MemberService{
	
	private MemberDAO dao;
	
	private static MemberService instance;
	public static MemberService getInstance() {
		if(instance==null)
			instance = new MemberServiceImpl();
		return instance;
	}
	
	
	private MemberServiceImpl() {
		dao=MemberDAOimpl.getInstance();
	}
	
	@Override
	public List<MemberVO> listMembers() throws Exception {
		List<MemberVO> list=dao.select();
		return list;
	}

}
