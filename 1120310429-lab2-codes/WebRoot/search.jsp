<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!-- hello jsp -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

  <body>
    This is search page. <br>
    <form action="search.action" method ="post">
    	请输入需要查询的作者:	<input name="search_name" type="text" >
    	<input type="submit" value="查询"><br>
    </form>
  
    
    <form action="index.jsp">
    	<input type="submit" value="home">
    </form>
  </body>
</html>
