package second.sosu.members.member.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import second.sosu.common.dao.AbstractDAO;

@Repository("memberDAO")
public class MemberDAO extends AbstractDAO{
   
   //회원가입
   public int join(Map<String, Object> map) throws Exception{
      return Integer.parseInt(insert("members.join", map).toString());
   }
   
   //로그인
   @SuppressWarnings("unchecked")
   public Map<String,Object> login(Map<String,Object> map) throws Exception{
      return (Map<String,Object>)selectOne("members.login",map);
   }
   
   //아이디찾기
   @SuppressWarnings("unchecked")
   public Map<String,Object> findId(Map<String,Object> map) throws Exception{
	   return (Map<String,Object>)selectOne("members.findId",map);
   }
   
   
   //비밀번호찾기
   @SuppressWarnings("unchecked")
   public Map<String,Object> findPw(Map<String,Object> map) throws Exception{
	   return (Map<String,Object>)selectOne("members.findPw",map);
   }
   
   //마이페이지
   @SuppressWarnings("unchecked")
   public List<List<Map<String,Object>>> mypage(Map<String, Object> map) throws Exception{
	   
	   List<List<Map<String,Object>>> mypageInfo = new ArrayList<>();
	   
	   Map<String,Object> m = new HashMap<>();
	   
	   //공통 목록
	   mypageInfo.add(selectList("members.mypageNE",map));
	   mypageInfo.add(selectList("members.mypageStarFloat",map));
	   mypageInfo.add(selectList("members.mypageStarInt",map));
	   
	   //내가 개설한 모임
	   mypageInfo.add(selectList("members.mypageOpenMoim", map));
	   
	   
	   //참여한 모임
	   mypageInfo.add(selectList("members.mypagePartyMoim", map));
	   
	   //내가 남긴 리뷰
	   mypageInfo.add(selectList("members.mypageMyReview", map));
	   
	   //나에게 남긴 리뷰
	   mypageInfo.add(selectList("members.mypageToMeReview", map));
	   
	   //자유게시판 찜
	   mypageInfo.add(selectList("members.mypageZzimFree", map));
	   
	   //모임 찜
	   mypageInfo.add(selectList("members.mypageZzimMoim", map));

	   //비공개 처리 (후)
	   
	   
	   return mypageInfo;
   }
   
   
   
}