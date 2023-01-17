package second.sosu.members.member.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import second.sosu.members.member.dao.MemberDAO;

@Service("memberService")
public class MemberServiceImpl implements MemberService{
   
   @Resource(name = "memberDAO")
   private MemberDAO memberDAO;
   
   //회원가입
   @Override
   public int join(Map<String, Object> map) throws Exception {
      return memberDAO.join(map);
   }
   
   //로그인
   @Override
   public Map<String, Object> login(Map<String, Object> map) throws Exception {
      return memberDAO.login(map);
   }
   
   //아이디찾기
	@Override
	public Map<String, Object> findId(Map<String, Object> map) throws Exception {
		return memberDAO.findId(map);
	}
	
	//비밀번호찾기
	@Override
	public Map<String, Object> findPw(Map<String, Object> map) throws Exception {
		return memberDAO.findPw(map);
	}
	
	//마이페이지
	@Override
	public List<List<Map<String,Object>>> mypage(Map<String, Object> map) throws Exception {
		return memberDAO.mypage(map);
	}

	
	
	
	
	
	
	
   
   
}