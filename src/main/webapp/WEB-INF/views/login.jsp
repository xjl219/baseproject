<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>企名汇-首页</title>
<script type="text/javascript" src="/js/jquery.pack.js"></script>
<script type="text/javascript" src="/js/jquery.SuperSlide.js"></script>
<script type="text/javascript" >  
  
/*==============================================  
*   refreash the captcha to general new picture  
*==============================================*/   
function refreshCaptcha() {     
    $('#captchaImg' ).hide().attr(     
    'src' ,     
    '<c:url value="/jcaptcha.jpg"/>'  +  '?'  + Math.floor(Math.random() *  100 )).fadeIn();     
}  
</script>  
</head>
<body>
<div class="bj">
	<div class="login">
    	<div class="hd">
        </div>
        <div class="bd">
        	<div>
            	<div class="l-box"><img src="/images/logo.png"  onclick="window.location='/'"/><a href="/register">注 册</a></div>
            	<form id="lform" action="/j_spring_security_check" method="post">
                <div class="l-kj">
           
              
                  	<div class="add_yzm"><c:if test="${sessionScope.error ne null}"><img src="/images/icon_close.gif" />${sessionScope.error}</c:if></div>
                	<p><em></em><input type="text"  name="j_username"  placeholder="请输入用户名" /></p>
                    <p class="l-k-p2"><em></em><input type="text"  name="j_password"  placeholder="请输入密码" /></p>
                    <p class="l-k-p3"><em></em><input type="text"  name="j_captcha"  placeholder="验证码" /><a href="#"><img id="captchaImg"   onclick="refreshCaptcha()" src="/jcaptcha.jpg" /></a></p>
                    <p class="l-k-p1"><span><input type="checkbox" />下次免登录</span><a href="javascript:lform.submit()" " class="l-k-btn">立即登录</a></p>
              
              
                </div>
                </form>
            </div> 
           
        </div>
    </div>
</div>
<script type="text/javascript">jQuery(".login").slide();</script>
</body>
</html>
