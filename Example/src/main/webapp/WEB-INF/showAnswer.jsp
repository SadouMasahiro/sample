
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!-- beans.Questionをimportする -->
<%@ page import= "beans.Answer" %>
<%@ page import= "beans.Question" %>

<html>
<head><title>結果</title></head>

<body bgcolor="skyblue">
<br>

<table border="1" width="100%">
	<tr>
		<td width = "40%"> <center>アンケート番号</center> </td>
		<td width = "60%"> <center>${Answer.ank_num} </center> </td>
	</tr>
	<tr>
		<td width = "40%"> <center>アンケート項目</center> </td>
		<td width = "60%"> <center>${Question.ank_text} </center> </td>
	</tr>
	<tr>
		<td width = "40%"> <center>ユーザID</center> </td>
		<td width = "60%"> <center>${Answer.user_id} </center> </td>
	</tr>
	<tr>
		<td width = "40%"> <center>アンケートの5段階評価</center> </td>
		<td width = "60%"> <center>${Answer.ans_point} </center> </td>
	</tr>
	<tr>
		<td width = "40%"> <center>理由</center> </td>
		<td width = "60%"> <center>${Answer.ans_reason} </center> </td>
	</tr>
</table>
<br>
<br>
<a href="./index.jsp">トップに戻る</a>


<br>

</body>
</html>