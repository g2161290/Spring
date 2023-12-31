<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <div class="container">
    <header class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
      <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-body-emphasis text-decoration-none">
        <svg class="bi me-2" width="40" height="32"><use xlink:href="#bootstrap"/></svg>
        <span class="fs-4">Simple header</span>
      </a>

      <ul class="nav nav-pills">
        <li class="nav-item"><a href="${pageContext.request.contextPath }/" class="nav-link active" aria-current="page">Home</a></li>
        <li class="nav-item"><a href="${pageContext.request.contextPath }/empList" class="nav-link">전체사원조회</a></li>
        <li class="nav-item"><a href="${pageContext.request.contextPath }/empInsert" class="nav-link">사원정보등록</a></li>
        <li class="nav-item"><a href="${pageContext.request.contextPath }/boardList" class="nav-link">익명게시판조회</a></li>
        <li class="nav-item"><a href="${pageContext.request.contextPath }/boardInsert" class="nav-link">익명게시글등록</a></li>
      </ul>
    </header>
  </div>
</body>
</html>