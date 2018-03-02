/**
 * Created by w0102840 on 2016/2/22.
 */
/********************************************************************************************/
function login(){
	var username = $("#username").val();
	var password = $("#password").val();

	if(username==null||username==""){
		alert("请输入账号");
		return ;
	}
	if(password==null||password==""){
		alert("请输入密码");
		return ;
	}
	
	var url = "login/entry";
	var spin = new Spinobj("_spin");
	spin.show();
	$.ajax({
		"type": "post",
		"url" : url,
		"data":	{
			   	 "username":username,
			   	 "password":password,
			   	 "time":+new Date().getTime()
		   		},
		"success": function(response) {
			if (response=='success')  {			
				window.location.href = "index";
			}else {
				alert(response);
			}
			spin.hide();
		},
		"error": function(response) {
			spin.hide();
			alert("登录失败！");
		}
	}); 
	
}