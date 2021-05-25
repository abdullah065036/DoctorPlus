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
        <title>Appointment Diary</title>
        <SCRIPT language="JavaScript">
        function add()
        {
        document.appointform.actionid.value="add";
        document.appointform.submit();
        }
        function view()
        {
        document.appointform.actionid.value="view";
        document.appointform.submit();
        }
        </SCRIPT>
    </head>
    <body>
    <body>
        <font face="Book Antiqua">
        <hr>
        <h1>Appointment Page  </h1>
        <hr>
        
        <br>
            
         <form name="appointform" action="controller" method="Post"> 
            <table>
                <tr><td>
                    Appointed Person: 
                    <td><input type = text name = "name" size="50"></td>
                </tr><tr>
                    <td> Appointment Description:</td>
                    <td><input type = text name = "description" size="50"></td>
                </tr>
                <tr>
                    <td> Appointment Date:</td>
                    <td><input type = text name = "date" size="50"></td>
                </tr>
            </table>
            <input  type="hidden" name="id" value="null">
            <input  type="hidden" name="actionid">            
            <input  type="hidden" name="pageid" value="appointinfo">  
             <input type=button value="search" name="btnsearch" onclick="view()">
            <input type=button value="Add" name="btnadd" onclick="add()">
        </form>
        <br>
        <a href="home.jsp">Home</a>
    </body>
</html>
