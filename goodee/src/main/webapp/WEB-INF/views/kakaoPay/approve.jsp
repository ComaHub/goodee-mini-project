<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>K페이</title>

<link href="/css/account/detail.css" rel="stylesheet">
<c:import url="/WEB-INF/views/includes/header.jsp"></c:import>
</head>

<body class="d-flex flex-column h-100">
	<main class="flex-shrink-0">
		<c:import url="/WEB-INF/views/includes/nav.jsp"></c:import>

		<!-- Contents here! -->
		<div class="container px-5 my-5">
			<div class="row gx-5 justify-content-center">
				<div class="col-8">
					<div class="text-center">
						<h1>결제 완료</h1>
					</div>
				</div>
			</div>
		</div>
		
		<section class="col-8 offset-2">
			<table class="table text-center">
				<thead>
					<tr>
						<th>결제 번호</th>
						<th>주문명</th>
						<th>결제 금액</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${ res.tid }</td>
						<td>${ res.item_name }</td>
						<td>${ res.amount.total }</td>
					</tr>
				</tbody>
			</table>
		</section>

	</main>
	<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>
	<script type="text/javascript" src="/js/account/detail.js"></script>
</body>

</html>