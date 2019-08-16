
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!-- beans.Questionをimportする -->
<%@ page import="beans.Question"%>

<html>
<head>
<title>結果</title>
</head>

<body bgcolor="skyblue">
	<br>

	<table border="1" width="100%">
		<tr>
			<td width="40%">
				<center>アンケート項目</center>
			</td>
			<td width="60%">
				<center>${Question.ank_text}</center>
			</td>
		</tr>
		<tr>
			<td width="40%">
				<center>アンケートの番号</center>
			</td>
			<td width="60%">
				<center>${Question.ank_num}</center>
			</td>
		</tr>
	</table>
	<br>
	<br>


	<br>
	<form action="./RegistAnswer" method="post">
		１～５で回答を入力(DBに登録)
		<br>
		<p>
			1<input type="radio" value="1" name="ans_point">
			2<input type="radio" value="2" name="ans_point">
			3<input type="radio" value="3" name="ans_point">
			4<input type="radio" value="4" name="ans_point">
			5<input type="radio" value="5" name="ans_point">
		</p>
		<br> その理由を入力（DBに登録）<input type="text" name="ans_reason"><br>
		あなたのユーザID（認証）<input type="text" name="user_id"><br>
		ユーザネーム（認証）<input type="text" name="user_name"><br>
		上記のアンケート番号を入力<input type="text" name="ank_num"><br> <input
			type="submit" name="OK">
	</form>
	<br>

</body>
</html>