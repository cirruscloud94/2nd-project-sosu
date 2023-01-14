package second.sosu.members.member.dao;

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
   
}