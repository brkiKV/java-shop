<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/taglib.jsp"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>

<security:authorize access="hasRole('ROLE_ADMIN')">
	<div>
		<a href="<spring:url value="/add-item.html" />"
			class="btn btn-primary"> New item </a>
	</div>
</security:authorize>
<table class="table  table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${items}" var="item">
			<tr>
				<td>${item.id }</td>
				<td><a href="<spring:url value="/items/${item.id}.html" />">
						${item.name} </a></td>

				<td><a href="<spring:url value="/items/add/${item.id}.html" />"
					class="btn btn-primary"> Add to cart </a></td>

				<td><a
					href="<spring:url value="/items/remove/${item.id}.html" />"
					class="btn btn-danger"> Remove </a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>