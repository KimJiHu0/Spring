<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>InsertForm</title>

<script type="text/javascript">

var msg = '${msg}';
if(msg != ''){
	alert(msg);
}

</script>

</head>
<body>
	<h1>insertForm</h1>
	
	<form action="insertres.do" method="post">
		<table>
			<tr>
				<th>NAME</th>
				<td><input type="text" name="myname"/></td>
			</tr>
			<tr>
				<th>TITLE</th>
				<td><input type="text" name="mytitle"/></td>
			</tr>
			<tr>
				<th>CONTENT</th>
				<td>
					<textarea rows="10" cols="60" name="mycontent"></textarea>
				</td>
			</tr>
			<tr>
				<td	colspan="4" align = "right">
					<input type="submit" value="OK"/>
					<input type="button" value="Back" onclick="location.href='list.do'"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>