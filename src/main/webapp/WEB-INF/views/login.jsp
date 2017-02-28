<%@include file="/WEB-INF/views/template/header.jsp"%>
Login with Username and Password
<div class="container-wrapper">
	<div class="login-container">
		<div id="login-box">

			<h2>Login with Username and Password</h2>

			<c:if test="${not empty msg}">
				<div class="msg">${msg}</div>
			</c:if>

			<c:url value="/login" var="loginVar" />
			<form id="appointment-form" action="${loginVar}" method="POST">
				<div class="form-group">
					<label for="make">Username</label> <input name="custom_username"
						class="form-control" />
				</div>
				<div class="form-group">
					<label for="model">Password</label> <input type="password"
						name="custom_password" class="form-control" />
				</div>
				<sec:csrfInput />
				<c:if test="${param.error != null}">
					<p>Invalid username and password.</p>
				</c:if>
				<c:if test="${param.logout != null}">
					<p>You just logged out successfully.</p>
				</c:if>
				<button type="submit" id="btn-save" class="btn btn-primary">Login</button>
			</form>

		</div>
	</div>
</div>

<%@include file="/WEB-INF/views/template/footer.jsp"%>
