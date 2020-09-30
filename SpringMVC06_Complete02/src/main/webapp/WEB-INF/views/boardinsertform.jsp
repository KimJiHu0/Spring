<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- include libraries(jQuery, bootstrap) -->
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> 

<!-- include summernote css/js-->
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.js"></script>
<script type="text/javascript">

	$(document).ready(function(){
		$('#summernote').summernote({
			placeholder : 'Writer Content',
			height : 300,
			width : 750,
			lang : 'ko-KR',
			toolbar : [
				['Font Style', ['fontname']],
				['style', ['bold', 'italic', 'underline']],
				['font', ['strikethrough']],
				['fontsize', ['fontsize']],
				['color', ['color']],
				['para', ['paragraph']],
				['height', ['height']],
				['Insert', ['picture']],
				['Insert', ['link']],
				['Misc', ['fullscreen']]
			]
		});
	});

</script>

</head>
<body>

	<h1>insertForm</h1>
	
	<form action = "insertres.do" method="post">
	<table border="1">
		<tr>
			<th>TITLE</th>
			<td>
				<input type="text" placeholder="Writer Title" name="boardtitle"/>
			</td>
		</tr>
		<tr>
			<th>NAME</th>
			<td>
				<input type="text" placeholder="Writer Name" name="boardname"/>
			</td>
		</tr>
		<tr>
			<th>CONTENT</th>
			<td id="summernote"></td>
		</tr>
		<tr>
			<td colspan="3" align=right"">
				<input type="submit" value="작성완료"/>
				<input type="button" value="뒤로" onclick="location.href='list.do'"/>
			</td>
		</tr>
	</table>
	
	</form>

</body>
</html>