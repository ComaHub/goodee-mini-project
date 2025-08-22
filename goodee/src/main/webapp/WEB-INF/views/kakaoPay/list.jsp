<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>결제 내역</title>

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
						<h2 class="fw-bolder">결제 내역</h2>
					</div>
				</div>
			</div>
		</div>

		<section class="col-8 offset-2">
			<span id="content"></span>
		</section>


	</main>
	<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>
	<script src="/js/payment/kakaopay-list.js"></script>
</body>

</html>