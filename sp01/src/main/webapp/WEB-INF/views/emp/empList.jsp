<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 사원 조회</title>
<style>
	table, th, td {
		border: 1px solid black;
	}
</style>
</head>
<body>
	<button type="button" onclick="location.href='empInsert'">등록</button>
	<table>
		<thead>
			<tr>
				<th>NO.</th>
				<th>employee_id</th>
				<th>first_name</th>
				<th>last_name</th>
				<th>email</th>
				<th>hire_date</th>
				<th>job_id</th>
				<th>salary</th>
			</tr> 
		</thead>
		<tbody>
			<c:forEach var="emp" items="${empList }" varStatus="sts">
			<tr onclick="location.href='empInfo?employeeId=${emp.employeeId}'">
				<td>${sts.count }</td>
				<td>${emp.employeeId }</td>
				<td>${emp.firstName }</td>
				<td>${emp.lastName }</td>
				<td>${emp.email }</td>
				<td>
					<fmt:formatDate value="${emp.hireDate }" pattern="yyyy년MM월dd일"/>
				</td>
				<td>${emp.jobId }</td>
				<td>${emp.salary }</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>