<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
  
<%  
    String path = request.getContextPath();  
    String basePath = request.getScheme() + "://"  
            + request.getServerName() + ":" + request.getServerPort()  
            + path + "/";  
%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<base href="<%=basePath%>" />  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>  
<title>userInfo</title>  

	<script type="text/javascript">  
	    $.ajax({  
	        type : "get",  
	        url : "user/showInfos.htmls",  
	        dataType : "json",  
	        success : function(data) {  
	            $(data).each(  
	                    function(i, user) {  
	                        var p = "<p>username:" + user.uname + " test__ unumber:"  
	                                + user.unumber + " test__   uregister:"  
	                                + user.uRegisterTime + "</p>";  
	                        $("#show_all_user").append(p);  
	                    });  
	        },  
	        async : true  
	    });  
	</script>  
	
</head>  

<body>  
    name_disp: ${userInfo.uname}   
    <br/>  
    ajax all user:  
    <div id="show_all_user"></div>  
 

</body> 
</html>