<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title></title>
	
	<c:import url="/WEB-INF/views/includes/header.jsp"></c:import>
</head>

<body class="d-flex flex-column h-100">
	<main class="flex-shrink-0">
		<c:import url="/WEB-INF/views/includes/nav.jsp"></c:import>
	
		<!-- Contents here! -->
		<h1>List</h1>
		<section class="col-10 m-auto">
			<table class="table">
				<thead>
					<tr>
						<th>상품번호</th>
						<th>상품명</th>
						<th>카테고리</th>
						<th>가격</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="p" items="${list}">
						<tr>
							<td>${p.productNumber}</td>
							<td><a href="./detail?productNumber=${ p.productNumber }">
							${p.name}</a></td>
							<td>${p.category}</td>
							<td>${p.price}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<c:if test="${ logined.admin eq true }">
				<div class="mb-3 d-flex justify-content-end">
					<a class="btn btn-primary" href="/product/add">추가</a>
				</div>
			</c:if>
			<!-- 페이징 -->
			<c:import url="/WEB-INF/views/includes/paging.jsp"></c:import>
			<!-- 페이징 -->
		</section>
		
	
	</main>
	<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>
</body>

</html>