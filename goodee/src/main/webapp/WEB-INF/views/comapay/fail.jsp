<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>결제 실패</title>
	
	<c:import url="/WEB-INF/views/includes/header.jsp"></c:import>
</head>

<body class="d-flex flex-column h-100">
	<main class="flex-shrink-0">
		<c:import url="/WEB-INF/views/includes/nav.jsp"></c:import>
	
		<!-- Contents here! -->
		<section class="col-4 offset-4 mb-5">
			<div class="text-center mt-5">
	      <h2 class="fw-bolder">결제 요청</h2>
	      <p class="lead fw-normal text-muted mb-5">Lorem ipsum, dolor sit amet consectetur adipisicing elit. Eaque fugit ratione dicta mollitia. Officiis ad.</p>
      </div>
      
      <div class="text-center mt-5">
      	<h2><span class="material-symbols-outlined" style="font-size: 30px; color: red;">warning</span></h2>
      	<h3 style="color: red;">결제 요청에 실패했습니다.</h3>
      </div>
      
      <div class="col-8 offset-2 mt-5">
      	<table class="table table-borderless text-center">
      		<tr>
      			<td class="col-4" valign="middle"><b>오류 코드</b></td>
      			<td class="col-8" valign="middle">${ requestScope.code }</td>
      		</tr>
      		
      		<tr>
      			<td class="col-4" valign="middle"><b>오류 내용</b></td>
      			<td class="col-8" valign="middle">${ requestScope.message }</td>
      		</tr>
      	</table>
      </div>
      
      <div class="text-center mt-5">
      	<a href="/cart/list" class="btn btn-primary">장바구니로 이동하기</a>
      </div>
		</section>
	
	</main>
	<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>
</body>

</html>