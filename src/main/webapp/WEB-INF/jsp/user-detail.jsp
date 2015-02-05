<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>

<h2>${user.name}  details</h2>


<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Email</th>
		</tr>
	<tbody>
		<tr>
			<td>${user.id }</td>
			<td>${user.name }</td>
			<td>${user.email }</td>
		</tr>

	</tbody>
</table>