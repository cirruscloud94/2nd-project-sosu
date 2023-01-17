package second.sosu.members.member.service;

import java.util.List;
import java.util.Map;

public interface MemberService {
   
		//회원가입
	   int join(Map<String, Object> map) throws Exception;
	   
	   //로그인
	   Map<String,Object> login(Map<String,Object> map) throws Exception;
	   
	   //아이디찾기
	   Map<String,Object> findId(Map<String,Object> map) throws Exception;
	   
	   //비밀번호찾기
	   Map<String,Object> findPw(Map<String,Object> map) throws Exception;
	   
	   //마이페이지
	   public List<List<Map<String,Object>>> mypage(Map<String, Object> map) throws Exception;
	   
	   
	   


}