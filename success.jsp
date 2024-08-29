<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>S.U.C.C.E.S.S</title>
</head>
<body>
<%@ page import ="java.sql.*" %>
<%@ page import ="javax.sql.*" %>
<%
	int id=Integer.parseInt(request.getParameter("id"));
	String pswd=request.getParameter("pwd");
	String country=request.getParameter("country");
	String aadhar=request.getParameter("aadhar");
	String locality=request.getParameter("area");
	String street=request.getParameter("street");
	String pemail=request.getParameter("pemail");
	String pno=request.getParameter("pno");
	String state=request.getParameter("state");
	String name=request.getParameter("name");
	
	Class.forName("com.mysql.cj.jdbc.Driver");
java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_database","root","admin"); 
Statement st= con.createStatement(); 
if(id==1)
st.executeUpdate("insert into patients_info values ('"+name+"','"+pemail+"',"+pno+",'"+street+"','"+locality+"', '"+aadhar+"','"+state+"','"+country+"','"+pswd+"')"); 
else{
	pswd=request.getParameter("pwd");
	String spe=request.getParameter("spe");

	st.executeUpdate("insert into doc_info values ('"+name+"','"+spe+"','"+pswd+"')");	
}
%>
<br><br>
<b><center>Success</center></b><br>

<center><a href="index.jsp">Home</a></center>

</body>
</html>