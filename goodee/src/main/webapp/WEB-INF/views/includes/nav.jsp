<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container px-5">
    <a class="navbar-brand" href="/">Animal Shelter</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
        <li class="nav-item"><a class="nav-link" href="/">Home</a></li>
        <li class="nav-item"><a class="nav-link" href="/animal/list">Animal</a></li>
        <li class="nav-item"><a class="nav-link" href="/product/list">Product</a></li>
        <c:if test="${ not empty sessionScope.logined }">
        	<li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" id="navbarDropdownBlog" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">My Page</a>
            <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdownBlog">
              <li><a class="dropdown-item" href="/account/detail">My Info</a></li>
              <li><a class="dropdown-item" href="/account/order">My Order</a></li>
              <li><a class="dropdown-item" href="/cart/list">My Cart</a></li>
              <li><a class="dropdown-item" href="/like/list">Liked Product</a></li>
              <c:if test="${ logined.admin eq true }">
              	<li><a class="dropdown-item" href="/account/list">Member List</a></li>
              </c:if>
            </ul>
          </li>
        	<li class="nav-item"><a class="nav-link" href="/account/logout">Log Out</a></li>
        </c:if>
        <c:if test="${ empty sessionScope.logined }">
        	<li class="nav-item"><a class="nav-link" href="/account/login">Log In</a></li>
        	<li class="nav-item"><a class="nav-link" href="/account/join">Register</a></li>
        </c:if>
      </ul>
    </div>
  </div>
</nav>