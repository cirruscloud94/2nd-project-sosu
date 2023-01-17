package second.sosu.members.member.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import second.sosu.common.domain.CommandMap;
//import second.sosu.members.member.dao.MypageQuery;
import second.sosu.members.member.service.MemberService;

@Controller
public class MemberController {
   
   Logger log = Logger.getLogger(this.getClass());
   
   @Resource(name="memberService")
   private MemberService memberService;
   
//   @Resource(name="mypageQuery")
//   private MypageQuery mypageQuery;
   
   //회원가입 폼
   @RequestMapping(value="/joinform", method=RequestMethod.GET)
   public String joinForm(CommandMap commandMap) throws Exception{
      return "/com/join/join";
   }
   
   //회원가입 처리
   @RequestMapping(value="/join", method=RequestMethod.POST)
   public ModelAndView join(CommandMap commandMap) throws Exception{
      ModelAndView mv = new ModelAndView();
      memberService.join(commandMap.getMap());
      mv.setViewName("/com/login/login");
      return mv;
   }
   
 //로그인 폼
   @RequestMapping(value="/loginform", method=RequestMethod.GET)
   public String loginForm(CommandMap commandMap) throws Exception{
	   List<Map<String,Object>> list = new ArrayList<>();
	   Map<String,Object> map = new HashMap<>();
	   map.put("test", 123);
	   list.add(map);
	   System.out.println(list);
      return "/com/login/login";
   }
   
   //로그인 처리
   @RequestMapping(value="/login", method=RequestMethod.POST)
   public ModelAndView login(CommandMap commandMap, HttpSession session) throws Exception{
      ModelAndView mv = new ModelAndView();
      
      //로그인 성공 시 세션값 저장
      if(memberService.login(commandMap.getMap())!=null) {
         Map<String,Object> map = memberService.login(commandMap.getMap());
         mv.setViewName("/com/main/main");

         session.setAttribute("M_IDX", map.get("M_IDX"));
         session.setAttribute("M_NAME", map.get("M_NAME"));
         session.setAttribute("M_GENDER", map.get("M_GENDER"));
         session.setAttribute("M_NICKNAME", map.get("M_NICKNAME"));
         session.setAttribute("M_EMAIL", map.get("M_EMAIL"));
         session.setAttribute("M_PW", map.get("M_PW"));
         session.setAttribute("M_PHONE", map.get("M_PHONE"));
         session.setAttribute("M_JUMIN", map.get("M_JUMIN"));
         session.setAttribute("M_TYPE", map.get("M_TYPE"));
         session.setAttribute("M_DEL_YN", map.get("M_DEL_YN"));
         session.setAttribute("M_REGDATE", map.get("M_REGDATE"));
         session.setAttribute("M_QUE", map.get("M_QUE"));
         session.setAttribute("M_ANS", map.get("M_ANS"));
         session.setAttribute("M_PRIVATE", map.get("M_PRIVATE"));
         session.setAttribute("M_BAN_DATE", map.get("M_BAN_DATE"));
         
         return mv;
      }
      mv.setViewName("redirect:/loginform");
      //      mv.setViewName("/com/login/login");
      return mv;
      
   }
   
   //아이디찾기 폼
   @RequestMapping(value="/findidform", method=RequestMethod.GET)
   public String findIdForm(CommandMap commandMap) throws Exception{
      return "/com/login/find_id";
   }
   
   //아이디 찾기 처리
   @RequestMapping(value="/findid", method=RequestMethod.POST)
   public ModelAndView findId(CommandMap commandMap) throws Exception{
	   ModelAndView mv = new ModelAndView();
	   
	   if(memberService.findId(commandMap.getMap())!=null) {
		   mv.addObject("M_EMAIL",memberService.findId(commandMap.getMap()).get("M_EMAIL"));
		   mv.setViewName("/com/login/find_result");
	   }else {
		   mv.setViewName("redirect:/findidform");
	   }

	   return mv;
   }
   
   //비밀번호찾기 폼
   @RequestMapping(value="/findpwform", method=RequestMethod.GET)
   public String findPwForm(CommandMap commandMap) throws Exception{
      return "/com/login/find_pw";
   }   
   
   //비밀번호 찾기 처리
   @RequestMapping(value="/findpw", method=RequestMethod.POST)
   public ModelAndView findPw(CommandMap commandMap) throws Exception{
	   ModelAndView mv = new ModelAndView();
	   
	   if(memberService.findPw(commandMap.getMap())!=null) {
		   mv.addObject("M_PW",memberService.findPw(commandMap.getMap()).get("M_PW"));
		   mv.setViewName("/com/login/find_result");
	   }else {
		   mv.setViewName("redirect:/findpwform");
	   }

	   return mv;
   }
   
   
   //마이페이지
   @RequestMapping(value="/mypage", method=RequestMethod.GET)
   public ModelAndView mypage(CommandMap commandMap, HttpSession session) throws Exception{
	   ModelAndView mv = new ModelAndView();

	   commandMap.put("M_IDX", session.getAttribute("M_IDX"));

	   mv.addObject("mypageInfo",memberService.mypage(commandMap.getMap()));
	
	   
	   mv.setViewName("/members/mypage/mypage");
	   
	   return mv;
   }
   
   
   
   
   
   
}