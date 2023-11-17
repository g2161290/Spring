<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
</head>
<body>
	<form action="boardInsert" method="post" name="insertForm">
		<table>
			<tr>
				<th>제목</th>
				<td><input type=text name="title"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type=text name="writer"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="contents"></textarea></td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td><input type="text" name="image"></td>
			</tr>
		</table>
		<button type="submit">등록</button>
	</form>
	<script>
		document.querySelector('form[name="insertForm"]')
						.addEventListener('submit', boardInsertHandler);

		function boardInsertHandler(e){
			e.preventDefault(); //일시적으로 막음

			let title = document.getElementsByName('title')[0]
			let writer = document.getElementsByName('writer')[0]

			if(title.value == ''){
				alert('제목이 입력되지 않았습니다. 확인해주시기 바랍니다.')
				title.focus();
				return;
			}
			if(writer.value == ''){
				alert('작성자가 입력되지 않았습니다. 확인해주시기 바랍니다.')
				writer.focus();
				return;
			}
			insertForm.submit();
		}
	</script>
</body>
</html>