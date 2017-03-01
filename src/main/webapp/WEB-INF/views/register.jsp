<%@include file="/WEB-INF/views/template/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Le's Cleaning Service Center</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

<!-- Latest Jquery -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" type="text/javascript">
</script>
<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js">
</script>

</head>
<body>
	<div class="container">
		<div class="row">
			<h1>Register</h1>
		</div>
		<c:url value="/register" var="loginVar"/>
		<form id="appointment-form" action="${loginVar}" method="POST">
			
			<div class="form-group">
				<label for="make">First Name</label>
				<input name="firstName" class="form-control" />
			</div>
			<div class="form-group">
				<label for="make">Last Name</label>
				<input name="lastName" class="form-control" />
			</div>
			<div class="form-group">
				<label for="make">Email</label>
				<input name="customerEmail" class="form-control" />
			</div>
			<div class="form-group">
				<label for="make">Username</label>
				<input name="username" class="form-control" />
			</div>
			<div class="form-group">
				<label for="model">Password</label>
				<input type="password" name="password" class="form-control" />
			</div>

		<h3>Shipping Address</h3>
        <div class="form-group">
            <label for="make">Street Name</label>
            <input name="shippingAddress.streetName" class="form-Control"/>
        </div>
        <div class="form-group">
            <label for="make">Apartment Number</label>
            <input name="shippingAddress.apartmentNumber" class="form-Control"/>
        </div>
        <div class="form-group">
            <label for="make">City</label>
            <input name="shippingAddress.city" class="form-Control"/>
        </div>
        <div class="form-group">
            <label for="make">State</label>
            <input name="shippingAddress.state" class="form-Control"/>
        </div>
        <div class="form-group">
            <label for="make">Country</label>
            <input name="shippingAddress.country" class="form-Control"/>
        </div>
        <div class="form-group">
            <label for="make">Zipcode</label>
            <input name="shippingAddress.zipCode" class="form-Control"/>
        </div>

        <h3>Billing Address</h3>
        <div class="form-group">
            <label for="make">Street Name</label>
            <input name="billingAddress.streetName" class="form-Control"/>
        </div>
        <div class="form-group">
            <label for="make">Apartment Number</label>
            <input name="billingAddress.apartmentNumber" class="form-Control"/>
        </div>
        <div class="form-group">
            <label for="make">City</label>
            <input name="billingAddress.city" class="form-Control"/>
        </div>
        <div class="form-group">
            <label for="make">State</label>
            <input name="billingAddress.state" class="form-Control"/>
        </div>
        <div class="form-group">
            <label for="make">Country</label>
            <input name="billingAddress.country" class="form-Control"/>
        </div>
        <div class="form-group">
            <label for="make">Zipcode</label>
            <input name="billingAddress.zipCode" class="form-Control"/>
        </div>
        <br><br>
        <sec:csrfInput/>

			<button type="submit" id="btn-save" class="btn btn-primary">Login</button>
			<a href="<c:url value="/" />" class="btn btn-default">Cancel</a>
		</form>
	</div>

        <%@include file="/WEB-INF/views/template/footer.jsp" %>
