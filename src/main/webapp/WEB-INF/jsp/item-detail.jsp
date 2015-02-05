<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>

<h2>${user.name}details</h2>


<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Description</th>
		</tr>
	<tbody>
		<tr>
			<td>${item.id }</td>
			<td>${item.name }</td>
			<td>${item.description }</td>
		</tr>

	</tbody>
</table>