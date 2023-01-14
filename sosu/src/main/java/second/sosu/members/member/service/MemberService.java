package second.sosu.members.member.service;

import java.util.Map;

public interface MemberService {
   
		//회원가입
	   int join(Map<String, Object> map) throws Exception;
	   
	   //로그인
	   Map<String,Object> login(Map<String,Object> map) throws Exception;

}