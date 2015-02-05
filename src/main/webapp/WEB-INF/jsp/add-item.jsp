<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>

<form:form commandName="item" cssClass="form-horizontal">

	<c:if test="${param.success eq true }">
		<div class="alert alert-success">Item Succefully added</div>
	</c:if>



	<div class="form-group">
		<label for="name" class="col-sm-2 control-label">Name:</label>
		<div class="col-sm-10">
			<form:input path="name" cssClass="form-control" />
			<form:errors path="name" />
		</div>
	</div>

	<div class="form-group">
		<label for="description" class="col-sm-2 control-label">Description:</label>
		<div class="col-sm-10">
			<form:password path="description" cssClass="form-control" />
			<form:errors path="description" />
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-10">
			<input type="submit" value="Save" class="btn btn-lg btn-primary" />
		</div>
	</div>


</form:form>