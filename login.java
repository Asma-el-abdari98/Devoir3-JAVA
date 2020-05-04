
   //Création d’une Servlet "login.java" pour valider le nom d'utilisateur
et mot de passe à partir de la base de données.

package logbean;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class login extends HttpServlet{


private static final long serialVersionUID = 1L;
public void doPost(HttpServletRequest request,
HttpServletResponse response)
 throws
ServletException,IOException{
 response.setContentType("text/html");

 System.out.println("MySQL Connect Example.");
 Connection conn = null;
 String USER="";
 String PASS="";
 String strQuery= "";
 Statement st=null;
 ResultSet rs=null;
 HttpSession session = request.getSession(true);
 try {
 Class.forName("com.mysql.jdbc.Driver");
 conn =
DriverManager.getConnection("jdbc:mysql://localhost/user_regis
ter" ,"root","smi6");
 if(request.getParameter("uName2")!=null &&
 request.getParameter("uName2")!="" && request.getParameter("pWord2")!=null &&
 request.getParameter("pWord2")!="")
 {
 USER= request.getParameter("uName2").toString();
 PASS= request.getParameter("pWord2").toString();

strQuery="select * from userregister where username='"+ USER
+"' and password='" + PASS +"'";
 System.out.println(strQuery);
 st = conn.createStatement();
 rs = st.executeQuery(strQuery);
 int count=0;

 while(rs.next())
 {
 session.setAttribute("username",rs.getString(2));
 count++;
 }
 if(count>0)
 {
 response.sendRedirect("welcome.jsp");
 }
 else
 {
 response.sendRedirect("login.html");
 }
 }
 else
 {
 response.sendRedirect("login.html");
 }

 conn.close();

 } catch (Exception e) {
 e.printStackTrace();
 }
 }
}
