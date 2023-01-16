package second.sosu.board.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import second.sosu.common.dao.AbstractDAO;

@Repository("freeboardDAO")
public class FreeBoardDAO extends AbstractDAO {
	
//	페이징
	@SuppressWarnings("unchecked") 
	public Map<String,Object>freeList(Map<String, Object> map) throws Exception {
		
		return(Map<String, Object>)selectPagingList("freeboard.freeList", map); 
	}
	
//	작성
	public void insertFree(Map<String, Object> map) throws Exception {
		
		insert("freeboard.insertFree", map);
	}
	
//	사진 파일 등록
	public void insertFreeFile(Map<String, Object> map) throws Exception {
		
		insert("freeboard.insertFreeFile", map);
	}
	
// 	프로필 리스트
	public void freeMemberList(Map<String, Object> map) throws Exception {
		
		insert("freeboard.freeMemberList", map);
	}
	
//	수정
	public void updateFree(Map<String, Object> map) throws Exception {
		
		update("freeboard.updateFree", map);
	}
	
//	사진 파일 수정
	public void updateFreeFile(Map<String, Object> map) throws Exception {
		
		update("freeboard.updateFreeFile", map);
	}
	
//	삭제
	public void deleteFree(Map<String, Object> map) throws Exception {
		
		update("freeboard.deleteFree", map);
	}
	
//	이미지 파일 삭제
	public void deleteFreeFile(Map<String, Object> map) throws Exception {
		
		update("freeboard.deleteFreeFile", map);
	}
}
