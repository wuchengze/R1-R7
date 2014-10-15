<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

  
  <body>
    	书籍及作者详细信息 <br>
      <s:iterator id="rt" value="list1">  
 		<s:property value='rt' />
 			
	 </s:iterator>
	 	     <form action="index.jsp">
    	<input type="submit" value="home">
    </form>
  </body>
</html>
