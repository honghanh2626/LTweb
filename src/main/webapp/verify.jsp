<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quên mật khẩu</title>
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

.forgot-password-box {
	position: relative;
	width: 400px;
	height: 300px;
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
	transform: translateY(-50%);
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

.login-link {
	font-size: .9em;
	color: #fff;
	text-align: center;
	margin: 25px 0 10px;
}

.login-link p a {
	color: #fff;
	text-decoration: none;
	font-weight: 600;
}

.login-link p a:hover {
	text-decoration: underline;
}
</style>
</head>
<body>
	<div class="forgot-password-box">
		<form action="">
			<h2>Quên Mật Khẩu</h2>
			<div class="input-box">
				<span class="icon"> <ion-icon name="mail-open-outline"></ion-icon>
				</span> <input type="email" required> <label>Email</label>
			</div>
			<button type="submit">Gửi yêu cầu</button>
			<div class="login-link">
				<p>
					Nhớ lại mật khẩu? <a href="login.html">Đăng nhập</a>
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