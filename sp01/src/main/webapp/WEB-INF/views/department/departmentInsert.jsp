<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서 정보 등록</title>
</head>
<body>
	<form action="departmentInsert" method="post">
		<div>
			<label>department_id : <input type="number" name="departmentId"></label>
		</div>
		<div>
			<label>department_name : <input type="text" name="departmentName"></label>
		</div>
		<div>
			<label>manager_id : <input type="number" name="managerId"></label>
		</div>
		<div>
			<label>location_id : <input type="number" name="locationId"></label>
		</div>
		<div>
			<button type="submit">등록</button>
			<button type="button" onclick="location.href='departmentList'">목록으로</button>
		</div>
	</form>
</body>
</html>