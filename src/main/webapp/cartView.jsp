<%@page import="com.demo.model.ProductModel"%>
<%@page import="com.demo.model.ItemModel"%>
<%@page import="com.demo.model.ShoppingCartModel"%>
<%@page import="com.demo.model.ProductModel"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" isELIgnored="false"%>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
	<h4><a href="./shopping-cart">Shopping Cart</a></h4>
	<h4>
		<a href="./product-catalog?category=b">Book Catalog</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="./product-catalog?category=f">Flower Catalog</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="./product-catalog?category=t">Toy Catalog</a>
	</h4>
	<hr/>
	<table>
	   <tr>
	       <th>ID</th>
	       <th>Name</th>
	       <th>Description</th>
	       <th>Price</th>
	       <th>Quantity</th>
	       <th>Total</th>
	       <th>Action</th>
	   </tr>
	   <c:forEach items="${shoppingCart.items}" var="item">
	   <tr>
	           <td><c:out value="${item.id}"/></td>
	           <td><c:out value="${item.name}"/></td>
	           <td><c:out value="${item.desc}"/></td>
	           <td><c:out value="${item.price}"/></td>
	           <td><c:out value="${item.quantity}"/></td>
	           <td><c:out value="${item.total}"/></td>
	           <td>
	           		<form action="./shopping-cart" method="GET">
	           			<input type="hidden" name="pid" value="${item.id}">
	           			<input type="text" name="quantity">
	           			<input type="hidden" name="action" value="remove">
	           			<input type="submit" value="Remove to cart">
	           		</form>
	           </td>
	       </tr>
	   </c:forEach>
	</table>
	<h4>Total Items: <c:out value="${shoppingCart.totalItems}"/></h4>
	<h4>Grand Total: <c:out value="${shoppingCart.grandTotal}"/></h4>
</body>
</html>
