<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% String ename=(String)request.getAttribute("name");
 String dname=(String)request.getAttribute("dname");
 int employeeid=(int)session.getAttribute("id");
 %>
 employee name:<%=ename %><br/>
department name:<%=dname %><br/><br/>
  <form action="update"method="get">
<input type="hidden" name="id" value="<%=employeeid%>"/>
employee salary:<input type=text name="salary"/><br/>
employee hiring date:<input type="text" name="date" placeholder="dd/mm/yyyy"/><br/>
<input type="submit" value="update"/>
</form>


</body>
</html>