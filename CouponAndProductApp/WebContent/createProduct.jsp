<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create product</title>
</head>
<body>
	<h1>Create Coupon</h1>

	<form action="products" method="post">


		<pre>


Name : <input type="text" name="name" />

Description : <input type="text" name="description" />
price: <input type="text" name="price" />

Coupon Code: <input type="text" name="couponCode" />
<input type="submit" value="save">

</pre>

	</form>

</body>
</html>