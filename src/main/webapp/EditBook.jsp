<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Book</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
<%@include file="css/EditBook.css"%>
</style>
</head>
<body>
	<form action="edited" method="post" class="edit-form">
		<h4 style="font-weight: bold;">Please Enter Product Details</h4>
		<div class="form-group row mb-2">
			<label class="col-sm-1 col-form-label">Book Code</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" placeholder="" name="code"
					required="required" readonly="readonly" value=${id}>
			</div>
		</div>
		<div class="form-group row mb-2">
			<label class="col-sm-1 col-form-label">Book Name</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" placeholder="" name="name"
					required="required">
			</div>
		</div>
		<div class="form-group row mb-2">
			<label class="col-sm-1 col-form-label">Author</label>
			<div class="col-sm-10">
				<select name="author" class="form-control" required="required">
					<option value="None">Select Author</option>
  					<option value="Chetan Bhagat">Chetan Bhagat</option>
  					<option value="James Clear">James Clear</option>
  					<option value="Robin Sharma">Robin Sharma</option>
				</select>
			</div>
		</div>
		<div class="form-group row mb-2">
			<label class="col-sm-1 col-form-label">Date Added</label>
			<div class="col-sm-10">
				<input type="date" class="form-control" placeholder=""
					name="date" readonly="readonly" value=${date}>
			</div>
		</div>

		<input type="submit" class="btn btn-primary" name="sub"></input>

	</form>


</body>
</html>