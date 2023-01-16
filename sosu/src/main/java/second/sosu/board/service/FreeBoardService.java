package second.sosu.board.service;

import java.util.Map;

import javax.servlet.http.HttpSession;

public interface FreeBoardService {
	
	//리뷰 페이징 리스트
	Map<String, Object>freeList(Map<String, Object> map, HttpSession session) throws Exception; 
	
	void insertFree(Map<String, Object> map, HttpSession session) throws Exception;
	
	void insertFreeFile(Map<String, Object> map, HttpSession session) throws Exception;
		
	void freeMemberList(Map<String, Object> map, HttpSession session) throws Exception;
	
	void updateFree(Map<String, Object> map, HttpSession session) throws Exception;
	
	void updateFreeFile(Map<String, Object> map, HttpSession session) throws Exception;
	
	void deleteFree(Map<String, Object> map, HttpSession session) throws Exception;
	
	void deleteFreeFile(Map<String, Object> map, HttpSession session) throws Exception;

}
