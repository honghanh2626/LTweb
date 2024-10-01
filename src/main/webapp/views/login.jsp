<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Login</title>
<style>
body {
	font-family: "Times New Roman", Times, serif;
	background-color: white;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
	margin: 0;
	color: #000000;
}

.section {
	display: flex;
	justify-content: center;
	align-items: center;
	width: 100%;
	height: 100vh;
	background-size: cover;
	background-position: center;
}

.login-box {
	position: relative;
	width: 400px;
	height: 450px;
	background: #7ca1ff;
	border: 2px solid rgba(255, 255, 255, .5);
	border-radius: 20px;
	display: flex;
	justify-content: center;
	align-items: center;
}

h2 {
	font-size: 2em;
	color: #fff;
	text-align: center;
}

.input-box {
	position: relative;
	width: 310px;
	margin: 30px 0;
	border-bottom: 2px solid #fff;
}

.input-box input:focus ~label, .input-box input:valid ~label {
	top: -5px;
}

.input-box label {
	position: absolute;
	top: 50%;
	left: 5px;
	transform: traslate(-50%);
	font-size: 1em;
	color: white;
	pointer-events: none;
}

.input-box input {
	width: 100%;
	height: 50px;
	background: transparent;
	border: none;
	outline: none;
	font-size: 1em;
	color: white;
	padding: 0 35px 0 5px;
}

.input-box .icon {
	position: absolute;
	right: 8px;
	color: white;
	font-size: 1.2em;
	line-height: 80px;
}

.remember-forgot {
	margin: -15px 0 15px;
	font-size: .9em;
	color: #fff;
	display: flex;
	justify-content: space-between;
}

.remember-fotgot label input {
	margin-right: 3px;
}

.remember-forgot a {
	color: #fff;
	text-decoration: none;
}

.remember-forgot a:hover {
	text-decoration: underline;
}

button {
	width: 100%;
	height: 40px;
	background: #fff;
	border: none;
	outline: none;
	border-radius: 40px;
	cursor: pointer;
	font-size: 1em;
	color: black;
	font-weight: 500;
}

.register-link {
	font-size: .9em;
	color: #fff;
	text-align: center;
	margin: 25px 0 10px;
}

.register-link p a {
	color: #fff;
	text-decoration: none;
	font-weight: 600;
}

.register-link p a hover {
	text-decoration: underline;
}

input:-webkit-autofill, input:-webkit-autofill:hover, input:-webkit-autofill:focus,
	input:-webkit-autofill:active {
	-webkit-background-clip: text;
	-webkit-text-fill-color: white !important;
	box-shadow: inset 0 0 20px 20px transparent;
}
</style>
</head>

<body>
	<div class="login-box">
		<form action="LoginController" method="post">
			<c:if test="${alert !=null}">
				<h3 class="alert alertdanger">${alert}</h3>
			</c:if>

			<h2>Đăng nhập</h2>
			<div class="input-box">
				<span class="icon"> <ion-icon name="username"></ion-icon>
				</span> <input type="text" name="username" required> <label>Username</label>
			</div>
			<div class="input-box">
				<span class="icon"> <ion-icon name="lock-closed"></ion-icon>
				</span> <input type="password" name="password" required> <label>Mật
					khẩu</label>
			</div>
			<div class="remember-forgot">
				<label><input type="checkbox" name="remember">Lưu
					mật khẩu</label> <a href="verify.jsp">Quên mật khẩu?</a>
			</div>
			<button>Đăng nhập</button>
			<div class="register-link">
				<p>
					Chưa có tài khoản? <a href="views/register.jsp">Tạo tài khoản mới</a>
				</p>
			</div>
		</form>
	</div>
	<script type="module"
		src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
	<script nomodule
		src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
</body>
</html>
