package Controller.Member;

import java.util.HashMap;
import java.util.Map;

import Domain.Common.Dto.MemberDto;
import Domain.Common.Service.MemberService;
import Domain.Common.Service.MemberServiceimpl;

public class MemberController {

	private MemberService service;

	public MemberController() {
		service = MemberServiceimpl.getInstance();
	}

//	1) select(with name) 2) select(with id) 3) insert 4) update 5) delete
	public Map<String, Object> execute(int serviceNo, Map<String, Object> param) {
		if (serviceNo == 1) {
			// 파라미터 추출
			String name = (String) param.get("name");

			MemberDto list = null;

			try {
				list = service.getMember1(name);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 뷰로 전달
			Map<String, Object> result = new HashMap();
			result.put("result", list);
			return result;
		} else if (serviceNo == 2) {
			// 파라미터 추출
			String id = (String) param.get("id");

			MemberDto list = null;

			try {
				list = service.getMember2(id);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 뷰로 전달
			Map<String, Object> result = new HashMap();
			result.put("result", list);
			return result;
		} else if (serviceNo == 3) {
			String id = (String) param.get("id");
			String pw = (String) param.get("pw");
			String name = (String) param.get("name");
			String tel = (String) param.get("tel");
			String addr = (String) param.get("addr");
			int role = (int) param.get("role");

//			입력값 검증
			if (id == null || pw == null || name == null || role == null) {
				System.out.println("[Error] * 필수정보를 입력해주세요..");
				return null;
			}
			MemberDto dto = new MemberDto(id, pw, name,role);
			System.out.println("Dto : " + dto);

			Boolean value = false;

			try {
				value = service.updateMember(dto);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("회원가입에 성공하셨습니다.");
			Map<String, Object> result = new HashMap();
			result.put("result", value);
			return result;
		} else if (serviceNo == 4) {
			String pw = (String) param.get("pw");
			String tel = (String) param.get("tel");
			String addr = (String) param.get("addr");
			String id = (String) param.get("id");

			if (pw == null || tel == null || addr == null || id == null) {
				System.out.println("[Error] 변경 내용를 모두 입력해주세요..");
				return null;
			}
			MemberDto dto = new MemberDto(pw, tel, addr, id);
			System.out.println("Dto : " + dto);

			Boolean value = false;

			try {
				value = service.updateMember(dto);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("회원정보 수정에 성공하셨습니다.");
			Map<String, Object> result = new HashMap();
			result.put("result", value);
			return result;
		} else if (serviceNo == 5) {
			String id = (String) param.get("id");

			if (id == null) {
				System.out.println("[Error] 삭제할 ID를 입력해주세요");
				return null;
			}
			Boolean value = false;
			try {
				value = service.deleteMember(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("회원탈퇴에 성공했습니다.");
			Map<String, Object> result = new HashMap();
			result.put("result", value);
			return result;
		} else if (serviceNo == 6) {
			String id = (String) param.get("id");
			String pw = (String) param.get("pw");
			if (id == null || pw == null) {
				System.out.println("[ERROR] ID 또는 비밀번호를 입력하지 않았습니다.");
				return null;
			}
			Map<String, Object> result = new HashMap();
			try {
				result = service.login(id, pw);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;

		} else if (serviceNo == 7) {
			String id = (String) param.get("id");
			String s_id = (String) param.get("sessionId");
			if (s_id == null) {
				System.out.println("[ERROR] 세션 ID가 없습니다. 로그인이 필요합니다.");
				return null;
			}

			boolean success = false;
			try {
				// Call the logout method from the service with the sessionId
				success = service.logout(id, s_id);
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (success) {
				System.out.println("로그아웃 성공!");
				Map<String, Object> result = new HashMap();
				result.put("result", true);
				return result;
			} else {
				System.out.println("[ERROR] 로그아웃에 실패했습니다.");
				Map<String, Object> result = new HashMap();
				result.put("result", false);
				return result;
			}
		}
		return null;
	}

}
