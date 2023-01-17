<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script defer type="text/javascript" src="/resources/js/login.js"></script>
<title>Insert title here</title>
</head>
<body>
<div class="container">

<form action="/login" method="post" id="login">

   <div>이메일</div><input type="text" name="M_EMAIL"  id="m_email">
   <div>비밀번호</div><input type="password" name="M_PW"  id="m_pw">
   
   <input type="submit" value="로그인" id="loginform"> <br/>
   
   <a href="/findidform">아이디찾기</a>
   <a href="/findpwform">비밀번호 찾기</a>
</form>


</div>

</body>
</html>