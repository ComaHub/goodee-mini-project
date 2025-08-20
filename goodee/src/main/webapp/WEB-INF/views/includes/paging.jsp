<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div>
	<form:form modelAttribute="paging" method="get">
		<div class="mb-3 d-flex justify-content-center">
			<form:input path="keyword" class="form-control w-50"/>
			<form:button class="btn btn-primary">검색</form:button>
		</div>
		<div class="pagination justify-content-center">
			<form:hidden path="nowPage"/>
			<ul class="pagination">
				<c:if test="${ paging.prev }">
					<li class="page-item">
						<button class="page-link" data-now-page="${ paging.pageBarStart - 1 }">
							&laquo;
						</button>
					</li>
				</c:if>
				<c:forEach var="i" begin="${ paging.pageBarStart }" end="${ paging.pageBarEnd }">
					<li class="page-item <c:if test='${ i eq paging.nowPage }'>active</c:if>">
						<button class="page-link" data-now-page="${ i }" type="button">${ i }</button>
					</li>
				</c:forEach>
				<c:if test="${ paging.next }">
					<li class="page-item">
						<button class="page-link" data-now-page="${ paging.pageBarEnd + 1 }">
							&raquo;
						</button>
					</li>
				</c:if>
			</ul>
		</div>
	</form:form>
</div>
<script type="text/javascript" src="/js/common/paging.js"></script>