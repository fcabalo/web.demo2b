<%@page import="com.demo.model.ProductModel"%>
<%@page import="java.util.List"%>
<%@ page language="java" isELIgnored="false"%>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
	<h4>
		<a href="./product-catalog?category=b">Book Catalog</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="./product-catalog?category=f">Flower Catalog</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="./product-catalog?category=t">Toy Catalog</a>
	</h4>
	<hr/>
	<%! String category = ""; %>
	<% category = (String)request.getAttribute("category"); %>
	<% if(category != null){%>	
	<% if((category.equals("b") || category.equals("f") || category.equals("t"))){ %>
	<table>
	   <tr>
	       <th>ID</th>
	       <th>Name</th>
	       <th>Description</th>
	       <%if(category.equals("b")){%>
	       		<th>Author Id</th>
	       	<%} %>
	       <th>Price</th>
	       <th></th>
	   </tr>
	   <%
	    List<ProductModel> products = (List<ProductModel>) request.getAttribute("products");
	    for(ProductModel product: products) {
	   %>
	        <tr>
	           <td><%= product.getId() %></td>
	           <td><%= product.getName() %></td>
	           <td><%= product.getDesc() %></td>
	           <%if(category.equals("b")){%>
	           		<td><%= product.getAuthId() %></td>
	           <%} %>
	           <td><%= product.getPrice() %></td>
	           <td>
	           		<form action="./shopping-cart" method="GET">
	           			<input type="hidden" name="pid" value="<%= product.getId() %>">
	           			<input type="hidden" name="name" value="<%= product.getName() %>">
	           			<input type="hidden" name="desc" value="<%= product.getDesc() %>">
	           			<input type="hidden" name="price" value="<%= product.getPrice() %>">
	           			<input type="hidden" name="action" value="add">
	           			<input type="submit" value="Add to cart">
	           		</form>
	           </td>
	       </tr>
	   <%
	    }
	   %>
	</table>
	<% } %>
	<% } %>
</body>
</html>
