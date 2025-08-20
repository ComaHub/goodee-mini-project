<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>굿즈</title>
	
	<c:import url="/WEB-INF/views/includes/header.jsp"></c:import>
</head>

<body class="d-flex flex-column h-100">
	<main class="flex-shrink-0">
		<c:import url="/WEB-INF/views/includes/nav.jsp"></c:import>
	
		<!-- Contents here! -->
		<h2>Detail</h2>
		<section class="col-10 m-auto">
			<p>상품 번호: ${productDTO.productNumber}</p>
			<p>상품명: ${productDTO.name}</p>
			<p>카테고리: ${productDTO.category}</p>
			<p>가격: ${productDTO.price}</p>
			<a href="./update?productNumber=${ productDTO.productNumber }">수정</a>
		</section>
	
	
	</main>
	<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>
</body>

</html>