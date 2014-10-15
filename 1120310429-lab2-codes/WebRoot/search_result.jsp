<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

  <body>
    作品名称 <br>
 	
	<%List<String> IB = (List<String>) request.getAttribute("List");
	System.out.println(IB.get(1));
	for(int i=0;i<IB.size();i++){
	 %>
	 
	 	<a href ="search_1.action?name=<%=IB.get(i)%>" >	<%=IB.get(i) %> </a> <br>
	 	
	 <%} %>
     <form action="index.jsp">
    	<input type="submit" value="home">
    </form>
  </body>
</html>
