<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<h1>자유게시판 </h1>

<table style="border:1px solid #ccc">
	<colgroup>
		<col width="10%"/>
		<col width="*"/>
		<col width="40%"/>
	</colgroup>
	<thead>
		<tr>
			<th scope="col">자유게시판번호</th>
			<th scope="col">제목</th>
			<th scope="col">등록날짜</th>
		</tr>
	</thead>
	<tbody>
		<c:choose>
			<c:when test="${fn:length(list) > 0}">
				<c:forEach items="${list }" var="row">
					<tr>
						
						<td>${row.FR_IDX }</td>
						<td class="FR_TITLE">
						<a href="#this" name="FR_TITLE">${row.FR_TITLE }</a>
						<input type="hidden" id="FR_IDX" value="${row.FR_IDX }">
						</td>
						<td>${row.FR_IDX }</td>
						<td>${row.FR_CONTENT }</td>
						<td>${row.RE_MOD_YN}</td>
						<td>${row.FR_REGDATE}</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="3">조회된 결과가 없습니다.</td>
				</tr>
			</c:otherwise>
		</c:choose>
		
	</tbody>
</table>

<div id="b_div" style='float: left;'>
<a href="#this" class="btn" id="caferegbtn">카페등록</a>
</div>
		

<script type="text/javascript">

$(function(){
	var aaa = ${fn:length(list) > 0};
	if(aaa){
		document.getElementById("b_div").style.display = "none";
	}else{//조건 1이 아닐떄
        document.getElementById("b_div").style.display = "";
	}
})


$(document).ready(function(){
	$("#caferegbtn").on("click", function(e){	
		e.preventDefault();
		fn_gotoCaferegPage();
	});
	
	$("a[name='cafe_name']").on("click", function(e){	//카페이름 누르면 상세정보 조회
		e.preventDefault();
		fn_openCafeinfoDetail($(this));   //$this는 jQuery객체를 뜻하는데 여기서는 게시글 제목인 <a>태그를 의미한다.
	});
	
});


function fn_gotoCaferegPage(){
	var comSubmit = new ComSubmit();
	comSubmit.setUrl("<c:url value='/owner/openCafeWrite'/>");
	comSubmit.submit();
}

function fn_openCafeinfoDetail(obj){
	var comSubmit = new ComSubmit();
	comSubmit.setUrl("<c:url value='/owner/openCafeinfoDetail'/>");
	comSubmit.addParam("CAFE_IDX", obj.parent().find("#CAFE_IDX").val());
	comSubmit.submit();
}

	
</script>

</body>
</html>