  
  //Création d’une page Web "loginbean.jsp" pour définir les paramètres
(le set) en utilisant JSP Bean et les transmettre (forward) à la page
Servlet.


<%@ page import="java.sql.*,java.util.*,java.io.*" %>
<HTML>
 <HEAD><TITLE>DataBase Search</TITLE></HEAD>
<BODY>
<jsp:useBean id="db" scope="request"
class="logbean.LoginBean" >
 <jsp:setProperty name="db" property="userName"
param="uName1" />
 <jsp:setProperty name="db" property="passWord"
param="pWord1" />
</jsp:useBean>
<jsp:forward page="/login_url">
<jsp:param name="uName2" value="<% = db.getUserName()%>" />
 <jsp:param name="pWord2" value="<% = db.getPassWord()%>"
/>
</jsp:forward>
</body>
</html>