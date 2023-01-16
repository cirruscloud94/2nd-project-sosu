<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<h1>자유게시판 등록</h1>
	<table>
		<tbody>
			<tr>
				<th scope="row">제목</th>
				<td><input type="text" id="FR_TITLE" name="FR_TITLE" value="${map.FR_TITLE }" style="width: 400px;"  maxlength="70"></input></td>
			</tr>
			<tr>
				<th scope="row">게시글</th>
				<td class="view_text">
				<textarea rows="5" style="width: 80%; height: auto;" title="내용" id="FR_CONTENT" name="FR_CONTENT">${map.FR_CONTENT }</textarea>
				</td>
			</tr>
			<tr>
				<th scope="row">첨부파일</th>
				<td colspan="3">
					<div id="fileDiv" style="white-space: pre-line;">
						<c:forEach var="row" items="${list }" varStatus="var">
							<p>
								<input type="hidden" id="F_IDX" name="F_IDX_${var.index }" value="${row.F_IDX }"> 
								< href="#this" id="name_${var.index }" name="name_${var.index }">${row.F_OGNAME }</a>
								<input type="file" id="file_${var.index }" name="file_${var.index }"> (${row.F_SIZE }kb) 
								<a href="#this" class="btn" id="delete_${var.index }" name="delete_${var.index }">삭제</a>
							</p>
						</c:forEach>
					</div>
				</td>
			</tr>
		</tbody>
	</table>
					 <a href="#this" class="btn" id="addFile">파일 추가</a> 
					 <a href="#this" class="btn" id="list">목록으로</a>
					 <a Href="#this" class="btn" id="update">저장하기</a> 
					 <a href="#this" class="btn" id="deleteCafeinfo">삭제하기</a> 
					 
<script type="text/javascript">
	var gfv_count = '${fn:length(list)+1}';

	$(document).ready(function() {
		$("#list").on("click", function(e) { //목록으로 버튼
			e.preventDefault();
			fn_openFreeList();
		});

		$("#update").on("click", function(e) { //저장하기 버튼
			e.preventDefault();
			fn_updateFree();
		});

		$("#deleteCafeinfo").on("click", function(e) { //삭제하기 버튼
			e.preventDefault();
			fn_deleteFree();
		});

		$("#addFile").on("click", function(e) { //파일추가 버튼
			e.preventDefault();
			fn_addFile();
		});

		$("a[name^='delete']").on("click", function(e) { //파일추가 삭제 버튼
			e.preventDefault();
			fn_deleteFile($(this));
		});
	});

	function fn_openFreeList() {
		var comSubmit = new ComSubmit();
		comSubmit.setUrl("<c:url value='/free/FreefeList' />");
		comSubmit.submit();
	}

	function fn_updateFree() {
		var comSubmit = new ComSubmit("frm");
		comSubmit.setUrl("<c:url value='/free/updateFree' />");
		comSubmit.submit();
	}

	function fn_deleteFree() {
		var comSubmit = new ComSubmit();
		comSubmit.setUrl("<c:url value='/free/deleteFree' />");
		comSubmit.addParam("FR_IDX", $("#FR_IDX").val());
		comSubmit.submit();
	}

	function fn_addFile(){
		var str = "<p>" +
				"<input type='file' id='file_"+(gfv_count)+"' name='file_"+(gfv_count)+"'>"+
				"<a href='#this' class='btn' id='delete_"+(gfv_count)+"' name='delete_"+(gfv_count)+"'>삭제</a>" +
			"</p>";
		$("#fileDiv").append(str);
		$("#delete_"+(gfv_count++)).on("click", function(e){ 
			e.preventDefault();
			fn_deleteFile($(this));
		});
	}

	function fn_deleteFile(obj) {
		obj.parent().remove();
	}
</script>
</body>
</html>