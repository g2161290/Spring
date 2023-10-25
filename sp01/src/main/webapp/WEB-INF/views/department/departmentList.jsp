<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 부서 조회</title>
<style>
	table, th, td {
		border: 1px solid black;
	}
</style>
</head>
<body>
	<button type="button" onclick="location.href='departmentInsert'">등록</button>
	<table>
		<thead>
			<tr>
				<th>NO.</th>
				<th>department_id</th>
				<th>department_name</th>
				<th>manager_id</th>
				<th>location_id</th>
			</tr> 
		</thead>
		<tbody>
			<c:forEach var="Info" items="${departmentList }" varStatus="sts">
			<tr onclick="location.href='departmentInfo?departmentId=${Info.departmentId}'">
				<td>${sts.count }</td>
				<td>${Info.departmentId }</td>
				<td>${Info.departmentName }</td>
				<td>${Info.managerId }</td>
				<td>${Info.locationId }</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>