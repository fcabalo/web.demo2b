<%@page import="com.demo.model.ProductModel"%>
<%@page import="com.demo.model.ItemModel"%>
<%@page import="com.demo.model.ShoppingCartModel"%>
<%@page import="com.demo.model.ProductModel"%>
<%@page import="java.util.List"%>
<%@ page language="java" isELIgnored="false"%>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
	<h4>Shopping Cart</h4>
	<h4><a href="./product-catalog">Back to Catalog</a></h4>
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
	   <%
	    ShoppingCartModel sc = (ShoppingCartModel)session.getAttribute("shoppingCart");
	    List<ItemModel> items = sc.getItems();
	    for(ItemModel item: items) {
	   %>
	        <tr>
	           <td><%= item.getId() %></td>
	           <td><%= item.getName() %></td>
	           <td><%= item.getDesc() %></td>
	           <td><%= item.getPrice() %></td>
	           <td><%= item.getQuantity() %></td>
	           <td><%= item.getTotal() %></td>
	           <td>
	           		<form action="./shopping-cart" method="GET">
	           			<input type="hidden" name="pid" value="<%= item.getId() %>">
	           			<input type="hidden" name="action" value="remove">
	           			<input type="submit" value="Remove to cart">
	           		</form>
	           </td>
	       </tr>
	   <%
	    }
	   %>
	</table>
	<h4>Total Items: <%= sc.getTotalItems() %></h4>
	<h4>Grand Total: <%= sc.getGrandTotal() %></h4>
</body>
</html>
