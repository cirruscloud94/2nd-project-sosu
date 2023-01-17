<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원 정보</h1>

<div class="container">
	<div>
	<!-- 공통 정보 -->
	닉네임 : ${mypageInfo[0][0].M_NICKNAME}<br>
	이메일 : ${mypageInfo[0][0].M_EMAIL}<br>
	별점(소수) : ${mypageInfo[1][0].STARFLOAT}<br>
	별점(정수) : ${mypageInfo[2][0].STARINT}<br>
	<br><br>
	
	
	</div>
	내가 개설한 모임 개수 : ${fn:length(mypageInfo[3])}<br>
	<c:forEach begin="0" end="${fn:length(mypageInfo[3])}" items="${mypageInfo[3]}" var="mypage">
		모임리스트 : ${mypage.MO_TITLE}
		모임상세지역 : ${mypage.MO_DETAILREGION }
		모임상세카테고리 : ${mypage.MO_DETAILCATEGORY }
		모임비용 : ${mypage.MO_COST }
		모임최대인원 : ${mypage.MO_MAXPEOPLE }
		<br>
	</c:forEach>
	<hr>
	
	<%-- 내가 참여한 모임 개수 : ${fn:length(mypageInfo[4]}<br>
	<c:forEach begin="0" end="${fn:length(mypageInfo[4])}" items="${mypageInfo[4]}" var="mypage">
		모임리스트 : ${mypage.MO_TITLE}
		모임상세지역 : ${mypage.MO_DETAILREGION }
		모임상세카테고리 : ${mypage.MO_DETAILCATEGORY }
		모임비용 : ${mypage.MO_COST }
		모임최대인원 : ${mypage.MO_MAXPEOPLE }
		<br>
	</c:forEach>
	<hr> --%>
	
	
	
	
	
	
	
	
	
	<%-- 모임개수 : ${fn:length(moimlist)}<br>
	<c:forEach begin="0" end="${fn:length(moimlist)}" items="${moimlist}" var="moim">
	
		모임리스트 : ${moim.MO_TITLE}
		모임상세지역 : ${moim.MO_DETAILREGION }
		모임상세카테고리 : ${moim.MO_DETAILCATEGORY }
		모임비용 : ${moim.MO_COST }
		모임최대인원 : ${moim.MO_MAXPEOPLE }
		<br>
	</c:forEach>  --%>
	

	<%-- div class="container">
	<p>닉네임 :${ }  </p>
	<p>이메일(아이디) : ${ }</p>
	<p>평점(소수1자리) : ${ }</p>
	
	<section id="1">
	<div>(el태그개수) : 개설한 모임</div>
	<div class="col-lg-3">
		<c:forEach begin="0" end="${fn:length}" items="" var="">
		<p>세부 지역 : ${ }</p>
		<p>모임제목 : ${ }</p>
		<p>인원수 : [${ } / ${ }명]</p>
		<p>세부 카테고리 : #${ }</p>
		<p>참가비용 : ${ }원</p>
		</c:forEach>
	</div>
	</section>
	<!-- 개설한 모임 -->
	<section id="2">
		<div class="col-lg-3">
		
		</div>
	</section>
	
	<!-- 개설한 모임 -->
	<section id="3">
		<div class="col-lg-3">
		
		</div>
	</section>
	
	<!-- 개설한 모임 -->
	<section id="4">
		<div class="col-lg-3">
		
		</div>
	</section>
 --%>

</div>

</body>
</html>