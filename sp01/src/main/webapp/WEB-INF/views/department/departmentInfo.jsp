<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서 정보 조회</title>
</head>
<body>
	<form>
		<div>
			<label>department_id : <input type="number" name="departmentId" value="${departmentInfo.departmentId }"></label>
		</div>
		<div>
			<label>department_name : <input type="text" name="departmentName" value="${departmentInfo.departmentName }"></label>
		</div>
		<div>
			<label>manager_id : <input type="number" name="managerId" value="${departmentInfo.managerId }"></label>
		</div>
		<div>
			<label>location_id : <input type="number" name="locationId" value="${departmentInfo.locationId }"></label>
		</div>
		<div>
			<button type="button">수정</button>
			<button type="button">삭제</button>
			<button type="button" onclick="location.href='departmentList'">목록으로</button>
		</div>
	</form>
</body>
</html>