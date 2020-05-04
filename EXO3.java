



 
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




  

  //Créer une page Web "welcome.jsp" pour afficher un message après le
login de l'utilisateur avec succès.

<HTML>
<HEAD><TITLE>Welcome</TITLE></HEAD> 
<BODY>
<br><br><br><br>
<table align="center" style="border:1px solid #000000;">
<%
if(session.getAttribute("username")!=null &&
session.getAttribute("username")!="")
{
String user = session.getAttribute("username").toString();
%>
<tr><td align="center"><h1>Welcome <b><%=
user%></b></h1></td></tr>
<%
}
%>
</table>
</body>
</html>