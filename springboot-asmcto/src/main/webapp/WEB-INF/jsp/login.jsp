<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
	String contextPath = request.getContextPath();
	String basePathUrl = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ contextPath + "/";
%>

<html>
<head>
<title>Login</title>
 <link href="<%=application.getContextPath() %>/rs/css/login/base.css" rel="stylesheet" type="text/css"/>
<link href="<%=application.getContextPath()%>/rs/css/login/login.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=application.getContextPath()%>/rs/js/plugins/jquery/jquery.min.js"></script>
<script type="text/javascript" src="<%=application.getContextPath()%>/rs/js/plugins/i18n/jquery.i18n.properties.min.js"></script>
<script type="text/javascript" src="<%=application.getContextPath()%>/rs/js/login/login.js"></script>
<script type="text/javascript" src="<%=application.getContextPath()%>/rs/js/common/spin_load.js"></script>
<script type="text/javascript" src="<%=application.getContextPath()%>/rs/js/common/utils.js"></script>
<script type="text/javascript">
	if (window != top) {
		top.location.href = location.href;
	}
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#checkCode").keydown(function(event) {
			if (event.which == 13) {
				login();
			}
		});
	});
</script>
<style type="text/css">

/*body{
   background-image:url(Login_files/body_background.png);
   background: #f1f1f1 none repeat scroll 0 0;
   background-position:10% -0%;
   background-repeat:no-repeat;
   }
    */

</style>

</head>
<body>
	<div class="layout">
		<div class="center">
			<div class="content">
				<div class="account-page-header">
					<h1>Welcome</h1>
					<p class="secure"></p>
					<img class="icon" src="rs/css/login/icon-lock-header-gray.JPG">
				</div>
				<div class="text_log">L10 CTO System</div>
				<form>
					<table>
						<tbody>
							<tr>
								<td>
									<!--<div class="label_text" style="text-align:left">Account</div>-->
									<input name="username" id="username" placeholder="Account"
									value="" size="30" maxlength="128" class="user_text"
									type="text">

								</td>
							</tr>
							<tr>
								<td>
									<!--<div class="label_text" style="text-align:left">Password</div>-->
									<input name="password" id="password" placeholder="Password"
									value="" class="user_text" type="password">
								</td>
							</tr>							
							<tr>
								<td>
									<div style="height:5px;"></div> <a href="javascript:;"
									onclick="login();">
										<button id="sign-in" class="button rect" type="button">
											<span> <span class="effect"></span> <span
												style="color:#FFF" class="label">Login </span>
											</span>
										</button>
								</a>
								</td>
							</tr>

						</tbody>
					</table>
				</form>
			</div>

		</div>
	</div>

</body>
</html>
