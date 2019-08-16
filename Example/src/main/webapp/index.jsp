<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
アンケート項目かユーザ情報を登録できるよ。

<form action="./RegistInfo" method="post">
任意のアンケート番号<input type="text" name="ank_num"><br>
アンケート項目<input type="text" name="ank_text"><br>
<input type="submit" name="OK">
</form>
<br>

<form action="./RegistUser" method="post">
任意のユーザID<input type="text" name="user_id"><br>
任意のユーザネーム<input type="text" name="user_name"><br>
<input type="submit" name="OK">
</form>
<br>

アンケートにはここから回答できる！↓<br>
<a href= "/Example/SearchInfo">アンケートに回答するッ！ </a>
<br>
<br>
<br>回答状況はここから見ることができる！↓<br>
<a href= "/Example/SearchAnswer">アンケートの回答状況を見るッ！ </a>
</body>
</html>