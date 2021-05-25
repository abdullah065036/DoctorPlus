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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Contact</title>
        <SCRIPT language="JavaScript">
        function edit()
        {
        document.appointform.actionid.value="edit";
        document.appointform.submit();
        }
       
    </SCRIPT> 
    </head>
    <body>
    <font face="Book Antiqua">
    <hr>
    <h1>Edit Contact</h1>
    
    <%
       String name = (String)request.getParameter("name"); 
       String description = (String)request.getParameter("description");
       String date = (String)request.getParameter("date"); 
       String id = (String)request.getParameter("id");
    %>
     <br>
        
        <form name="appointform" action="controller" method="Post"> 
        <table>
            <tr><td>
                    Target Person:</td> 
                <td><input type = text name = "name" value = <%=name%> size="50"></td>
            </tr><tr>
                <td>Description:</td>
                <td><input type = text name = "description" value = <%=description%> size="50" ></td>
            </tr>
            <tr>
                <td>Date:</td>
                <td><input type = text name = "date" value = <%=date%> size="50"></td>
            </tr>
            
        </table>
        <br>          
        <input  type="hidden" name="id" value=<%=id%>>
        <input  type="hidden" name="actionid">            
        <input  type="hidden" name="pageid" value="appointinfo" >            
        
        <input type=button value="edit" name="btnedit" onclick="edit()">
        
    </font>
    </form>
    
    </body>
</html>