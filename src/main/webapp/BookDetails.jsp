<%@page import="com.nagarro.advancedJava.dao.BookDetailsDao"%>
<%@page import="org.springframework.web.bind.annotation.PostMapping"%>
<%@page import="java.util.List"%>
<%@page import="org.springframework.http.ResponseEntity"%>
<%@page import="com.nagarro.advancedJava.domain.BookDetails"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.Objects"%>
<%@page import="org.springframework.web.client.RestTemplate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>Book Details</title>

</head>
<style>
.butt {
	width: fit-content;
}
<%@include file="css/BookDetails.css"%>
</style>
<body>

	<div class="header">
		<div class="add-button">
			<form action="addbook" method="post">
				<input type="submit" value="Add a book" class="btn btn-primary"></input>
			</form>
		</div>
		
		<div>
			<h2>Books Listing</h2>
		</div>
		
		<div class="logout-button">
		
			<h3>Welcome ${username}</h3>
			
			<form action="logout" method="get">
				<input type="submit" value="Logout" class="btn btn-danger"></input>
			</form>
		</div>
	</div>

	

	<table class="w3-table-all">
		<thead>
			<tr class="w3-green">
				<th>Book Code</th>
				<th>Book Name</th>
				<th>Author</th>
				<th>Date Added</th>
				<th>Actions</th>
			</tr>
		</thead>
		<%
		try {
			BookDetailsDao bookDetailsDao = new BookDetailsDao();
			bookDetailsDao.display();
			List<BookDetails> books = bookDetailsDao.getBooks();

			for (BookDetails b : books) {
		%>
		<tr>
			<td><%=b.getCode()%></td>
			<td><%=b.getName()%></td>
			<td><%=b.getAuthor()%></td>
			<td><%=b.getDate()%></td>
			<td>
				<div class="row">
					<div class="col-lg-6 butt">
						<form action="edit" method="post">
							<input type="hidden" value=<%=b.getCode()%> name="id"></input> <input
								type="hidden" value=<%=b.getDate()%> name="date"></input> <input
								type="submit" class="btn btn-primary mb-3" value="Edit"></input>
						</form>
					</div>
					<div class="col-lg-6 butt">
						<form action="delete" method="post">
							<input type="hidden" value=<%=b.getCode()%> name="id"></input> <input
								type="submit" class="btn btn-danger" value="Delete"></input>
						</form>
					</div>
				</div>
			</td>
		</tr>
		<%
		}
		} catch (Exception e) {
		e.printStackTrace();
		}
		%>
	</table>
</body>
</html>