<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
ユーザIDと見たいアンケート番号を入れてくれ！<br>
<form action="./SearchAnswer" method="post">

ユーザID<input type="text" name="user_id"><br>
アンケート番号<input type="text" name="ank_num"><br>

<input type="submit" name="OK">
</form>
</body>
</html>
