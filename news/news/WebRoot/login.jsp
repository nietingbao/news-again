<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <meta http-equiv="Content-Type" content="text/html; charset=GBK" />
<title>新闻发布系统</title>
<style type="text/css">

<!--
*{margin:0px;padding:0px;}
#in{font-size:26px;}
.top{width:100%; height:60px; background-color:#0066FF;}
.foot{background-image:url(/prj03/picture/sy.jpg); background-repeat:no-repeat; height:642px; width:100%; position:relative;background-size:100% 100%;}
.top .topp{height: 44px;margin-top:12px;margin-left:10px;padding-left:100px;float: left;overflow: hidden;font-size: 26px;}
*#in1{height:35px; font-size:24px; width:220px;}
.foot .title{ position:absolute; top:110px; right:300px;font-size:36px; }
.foot .foot-in{width:380px; height:280px; border-style:dashed; border-width:1px; border-color:#999999; float:right;
position:absolute; bottom:190px; right:180px;  }
.foot .foot-in .foot-inp{ padding-top:40px; padding-left:30px;}
.foot .foot-in .foot-inp .btn1{margin-left:50px; width:75px; height:35px; background-color:#00CCCC; float: left;border-width:1px; border-style:solid; border-color:#FFFFFF; cursor:pointer;}
.foot .foot-in .foot-inp .btn1 .btn1p{padding-left:10px; padding-top:4px;font-size: 26px;}
.foot .foot-in .foot-inp .btn2{margin-right:60px;  width:75px; height:35px; float:right;  background-color:#00CCCC; border-width:1px; border-style:solid; border-color:#FFFFFF; cursor:pointer;}
.foot .foot-in .foot-inp .btn2 .btn2p{padding-left:10px; padding-top:4px;font-size: 26px;}
.foot .foot-in .foot-inp .btn1:hover{width:80px; height:38px; background-color:#0099FF;}
.foot .foot-in .foot-inp .btn2:hover{width:80px; height:38px; background-color:#0099FF;}
.foot .foot-in .foot-inp .btn1 .btn1p:hover{font-size:30px;}
.foot .foot-in .foot-inp .btn2 .btn2p:hover{font-size:30px;}

-->


</style>

<script type="text/javascript">  
   function fsubmit(obj){
obj.submit();
}


</script>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	

  </head>
  <body>

<div class="top">
      <div class="topp">
       新闻发布系统
      </div>
</div>

<div class="foot">
    <div class="title">
	个人中心登陆
	</div>
    <div class="foot-in">
	<div class="foot-inp">
	<form name="form1" action="servlet/UserServlet" method="post" id="in">
	        昵称：<input name="username" type="text" maxlength="20" id="in1" />
		<br />
		<br />
		     密码：<input name="password" type="password" maxlength="15"  id="in1"/>
		<br />
        <br />
		<br />
		<div class="btn1" onclick="window.location.href='register.jsp';return false"><div class="btn1p">注册</div></div>
		<div class="btn2" onclick="javascript:fsubmit(document.form1);"><div class="btn2p" onclick="func()">登陆</div></div>
		</form>
		
	
	</div>
	</div>
</div>
	<script type="text/javascript">
		function func(){
			var sUserName = document.form1.username.value;
      		var sPassword = document.form1.password.value;
     			 if( sUserName=="" )
     				 {
    				   alert("please input username!");
      					 return false;
     				 }
		   		  if( sPassword=="" )
     				 {
     				  alert("please input password!");
    				   return false;
    				  }
					}
	</script>
  </body>
</html>
