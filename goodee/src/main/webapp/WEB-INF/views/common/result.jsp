<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
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

	</main>
	<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>
	<script>
			const message = "${ requestScope.resultMsg }";
			const icon = "${ requestScope.resultIcon }";
			const url = "${ requestScope.url }";
		
			Swal.fire({
			  text: message,
			  icon: icon,
			  showCancelButton: false,
			  confirmButtonColor: "#3085d6",
			  cancelButtonColor: "#d33",
			  confirmButtonText: "확인"
			}).then((result) => {
			  if (url != null && url != "") {
			    location.href = url;
			  } else {
					history.back();
			  }
			});
		</script>
</body>

</html>