<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ page import="java.io.*, java.util.*,javax.servlet.http.HttpSession, com.mycompany.dto.*" %>
<%--
The taglib directive below imports the JSTL library. If you uncomment it,
you must also add the JSTL library to the project. The Add Library... action
on Libraries node in Projects view can be used to add the JSTL 1.1 library.
--%>
<%--
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
--%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>Appointments</title>
        
    </head>
    <body>
    <body>
        <font face="Book Antiqua">
        <hr>
        <h1>Appointments</h1>
        <hr>
        
        <br>
            
                <table border=0 width="90%">
                <tr >
                    <b>
                        <font color="#000080">
                            <td><font color="#000080"><b>Name</b></font></td>
                            <td><font color="#000080"><b>Description</b></font></td>  
                            <td><font color="#000080"><b>Date</b></font></td>
                           
                         </font>
                    </b>
                </tr>
                            <%
            ResponseDto r = (ResponseDto)session.getAttribute("appoints");
            ArrayList results = r.getData();
           
            if(results.size()>0) {
                for(int i=0; i<results.size(); i++) {
                    AppointDto  p = (AppointDto)(results.get(i));
                    out.print(
                            "<tr>" +
                            "<td>" +
                            p.getName() + 
                            "</td>" +
                            "<td>" +
                            p.getDescription() + 
                            "</td>" +
                            "<td>" +
                            p.getDate() + 
                            "</td>");
                            String actionid="del";
                            String pageid="appointinfo";
                          %>
                          <td>
                            <a href = "update.jsp?id=<%=p.getId()%>&name=<%=p.getName()%>&description=<%=p.getDescription()%>&date=<%=p.getDate()%>">edit</a>
                             <a href = "controller?id=<%=p.getId()%>&name=<%=p.getName()%>&description=<%=p.getDescription()%>&date=<%=p.getDate()%>&actionid=<%=actionid%>&pageid=<%=pageid%>">delete</a>
                        </td>
                            
                            <% out.print(
                            "</tr>"
                            );
                }
            } else {
                out.println(com.mycompany.utility.Constants.REC_NOT_FOUND);
            }
            %>
        
        </table>
        <hr>
        <br>
        <a href="home.jsp">Home</a>
    </body>
</html>
