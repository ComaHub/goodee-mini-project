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
		<section>
			<table class="table">
				<thead>
					<tr>
						<th>아이디</th>
						<th>이름</th>
						<th>이메일</th>
						<th>전화번호</th>
						<th>우편번호</th>
						<th>주소</th>
						<th>상세주소</th>
						<th>권한</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="a" items="${list}">
						<tr>
							<td>${ a.id }</td>
							<td>${ a.name }</td>
							<td>${ a.email }</td>
							<td>${ a.phone }</td>
							<td>${ a.postcode }</td>
							<td>${ a.address }</td>
							<td>${ a.addressDetail }</td>
							<td><select class="auth" data-number="${ a.number }">
								<option ${ a.admin == true ? 'selected' : '' }>TRUE</option>
								<option ${ a.admin == false ? 'selected' : '' }>FALSE</option>
							</select></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</section>
		
	
	</main>
	<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>
	<script type="text/javascript" src="/js/account/list.js"></script>
</body>

</html>