<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.demo.model.ProductModel"%>
<%@ page language="java" isELIgnored="false"%>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
	<h4><a href="${pageContext. request. contextPath}/shopping-cart">Shopping Cart</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="${pageContext. request. contextPath}/addToyView.jsp">Add Toy</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	</h4>
	<h4>
		<a href="${pageContext. request. contextPath}/product-catalog?category=b">Book Catalog</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="${pageContext. request. contextPath}/product-catalog?category=f">Flower Catalog</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="${pageContext. request. contextPath}/product-catalog?category=t">Toy Catalog</a>
	</h4>
	<hr/>
	<c:choose>
	<c:when test="${empty category}">
	       	</c:when>
	       	<c:otherwise>
			<table>
	   <tr>
	       <th>ID</th>
	       <th>Name</th>
	       <th>Description</th>
	       <c:if test="${category.equals('b')}">
	       		<th>Author Id</th>
	       	</c:if>
	       <th>Price</th>
	       <th></th>
	   </tr>
	   <c:forEach items="${products}" var="product">
	   <tr>
	           <td><c:out value="${product.id}"/></td>
	           <td><c:out value="${product.name}"/></td>
	           <td><c:out value="${product.desc}"/></td>
	           <c:if test="${category.equals('b')}">
	           		<td><c:out value="${product.authId}"/></td>
	           </c:if>
	           <td><c:out value="${product.price}"/></td>
	           <td>
	           		<form action="./shopping-cart" method="GET">
	           			<input type="hidden" name="pid" value="${product.id}">
	           			<input type="hidden" name="name" value="${product.name}">
	           			<input type="hidden" name="desc" value="${product.desc}">
	           			<input type="hidden" name="price" value="${product.price}">
	           			<select name="quantity">
	           				<c:forEach begin="1" end="10" var="index">
	           					<option value="${index}"><c:out value="${index}"/></option>
	           				</c:forEach>
	           			</select>
	           			<input type="hidden" name="action" value="add">
	           			<input type="submit" value="Add to cart">
	           		</form>
	           </td>
	       </tr>
	   </c:forEach>
	   
	        
	   
	</table>
	</c:otherwise>
	</c:choose>
</body>
</html>
