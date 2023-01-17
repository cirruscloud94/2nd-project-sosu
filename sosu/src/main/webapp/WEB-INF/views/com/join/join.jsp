<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원가입</h1>

<div class="container">
   <form action="/join" method="post" id="join-form">
      
      <div>이름</div><input type="text" name="M_NAME">
      
      <div>닉네임</div><input type="text" name="M_NICKNAME">
      
      <div>이메일(아이디)</div><input type="text" name="M_EMAIL">
      
      <div>비밀번호</div><input type="password" name="M_PW">
      
      <div>비밀번호 확인</div><input type="password" name="M_PW2">
      
      <div>휴대전화</div><input type="text" name="M_PHONE">
      
      <div>주민등록번호</div>
      <input type="text" name="M_JUMIN" maxlength="6">
      <input type="password" name="M_GENDER" maxlength="1">
      
      <div>질문</div>
      <select name="M_QUE">
         <option value="1">기억에 남는 추억의 장소는?</option>
         <option value="2">자신이 세번째로 존경하는 인물은?</option>
         <option value="3">내가 좋아하는 캐릭터는?</option>
         <option value="4">다시 태어나면 되고 싶은 것은?</option>
         <option value="5">초등학교 때 기억에 남는 짝꿍 이름은?</option>
         <option value="6">인상깊게 읽은 책 이름은?</option>
      </select>
      <input type="text" name="M_ANS">
      
      
      <input type="submit" value="회원가입">
      
   </form>
</div>


</body>
</html>