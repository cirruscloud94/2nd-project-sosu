package second.sosu.board.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import second.sosu.board.service.FreeBoardService;
import second.sosu.common.domain.CommandMap;

@Controller
public class FreeBoardController {
	
Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="freeboardService")
	private FreeBoardService freeboardService;
	
	//리뷰 페이징 리스트
	@RequestMapping(value="/sosuboard") 
	public ModelAndView freeList(CommandMap commandMap, HttpSession session) throws Exception {
		
		ModelAndView mv = new ModelAndView("/board/freeboard");
	  
		return mv; 
	}

}
