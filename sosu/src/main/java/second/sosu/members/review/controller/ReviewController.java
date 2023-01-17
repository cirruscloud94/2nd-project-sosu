package second.sosu.members.review.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import second.sosu.common.domain.CommandMap;
import second.sosu.members.review.service.ReviewService;

@Controller
public class ReviewController {
	
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="reviewService")
	private ReviewService reviewService;
	
	/** 리뷰 페이징 리스트
	 * 
	 * @param commandMap
	 * @param session
	 * @throws Exception
	 * @return
	 * @author seungju han
	 */
	@RequestMapping("/members/review") 
	public ModelAndView reviewList(CommandMap commandMap, HttpSession session) throws Exception {
		
		ModelAndView mv = new ModelAndView("/members/review/review");
		
		return mv; 
	}
	
	/** 리뷰 작성폼
	 * 
	 * @category review
	 * @param commandMap
	 * @throws Exception
	 * @author seungju han
	 */
	@GetMapping("/members/reviewForm")
	public ModelAndView reviewForm(CommandMap commandMap) throws Exception {
		
		ModelAndView mv = new ModelAndView("/members/review/reviewForm");
		
		return mv;
	}
	
	/** 리뷰 작성
	 * 
	 * @param commandMap
	 * @param session
	 * @throws Exception
	 * @return insert, update, delete 쿼리문은 int값으로 반환하므로
	 * 리턴타입을 map으로 받으면 안된다. (dao, service, serviceimpl 수정 완료) 
	 * @author seungju han
	 */
	@PostMapping("/members/reviewForm")
	public ModelAndView reviewForm_insert(CommandMap commandMap) throws Exception {
		
		ModelAndView mv = new ModelAndView("redirect:/members/mypage");
		
		reviewService.insertReview(commandMap.getMap());
		
		return mv;
	}
}
