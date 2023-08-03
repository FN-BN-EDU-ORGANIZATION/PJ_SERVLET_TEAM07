package Domain.Common.Dao;

import Domain.Common.Dto.MemberDto;

public interface MemberDao {

	MemberDto select1(String name) throws Exception;

	MemberDto select2(String id) throws Exception;

	int insert(MemberDto dto) throws Exception;

	int update(MemberDto dto) throws Exception;

	int delete(String id) throws Exception;

}