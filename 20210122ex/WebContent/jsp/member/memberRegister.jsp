<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>입력한 회원 정보를 보여주는 페이지</h1>
이름 : ${param.name }<br/>
아이디 : ${param.id }<br/>
취미 : ${paramValues.hobbys[0] } ${paramValues.hobbys[1] }
	  ${paramValues.hobbys[2] } ${paramValues.hobbys[3] }
	  ${paramValues.hobbys[4] } ${paramValues.hobbys[5] }<br/>
성별 : ${param.gender }<br/>
전화번호 : ${param.tel }<br/>
돌아올 메세지 : ${param.name }${msg }
</body>
</html>