<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 정보 수정</title>
</head>
<body>
	<form name="updateForm">
		<table>
			<tr>
				<th>번호</th>
				<td><input type=text name="bno" value="${BoardInfo.bno }" readonly></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type=text name="title" value="${BoardInfo.title }"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type=text name="writer" value="${BoardInfo.writer }"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="contents">${BoardInfo.contents }</textarea></td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td><input type="text" name="image" value="${BoardInfo.image }"></td>
			</tr>
		</table>
		<button type="button">저장</button>
		<button type="button" onclick="location.href='boardInfo?bno=${BoardInfo.bno }'">취소</button>
	</form>
	<script>
		document.querySelector('form > button:nth-of-type(1)')
						.addEventListener('click', boardUpdateAjax);

		function boardUpdateAjax(e){
			let info = getBoardInfo();

			fetch('boardUpdate',{
				method : 'post',
				headers : {
					'content-type' : 'application/json'
				},
				body : JSON.stringify(info)
			})
			.then(response => response.json())
			.then(result => {
				console.log(result)
			})
			.catch(err => console.log(err))
		}

		function getBoardInfo(){
			let formTag = document.getElementsByName('updateForm')[0];

			let formData = new FormData(formTag);

			let objData={}
			formData.forEach((value, key) => {
				objData[key] = value;
			})

			return objData;
		}
	</script>
</body>
</html>