<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>과일입력</title>
</head>
<body>
	<form action="inputPro.jsp" method="post">
		과일이름:<input type="text" name="fruit_name"> <br>
		과일가격:<input type="number" name="price"> <br>
		과일수량:<input type="number"  name="quantity"><br>
		<input type="submit" value="입력">
	</form>
</body>
</html>