<%@ page import="java.io.*, java.util.*,javax.servlet.http.HttpSession, com.mycompany.dto.*" %>

<html>
    <head>
        <title>Address Book</title>
        
    </head>
    <body>
    <body>
        <font face="Book Antiqua">
        <hr>
        <h1>Search Results</h1>
        <hr>
        
        <br>
            
                <table border=0 width="90%">
                <tr >
                    <b>
                        <font color="#000080">
                            <td><font color="#000080"><b>Name</b></font></td>
                            <td><font color="#000080"><b>Address</b></font></td>                        
                        </font>
                    </b>
                </tr>
                            <%
            ResponseDto r = (ResponseDto)session.getAttribute("contacts");
            ArrayList results = r.getData();
           
            if(results.size()>0) {
                for(int i=0; i<results.size(); i++) {
                    PersonDto  p = (PersonDto)(results.get(i));
                    out.print(
                            "<tr>" +
                            "<td>" +
                            p.getName() + 
                            "</td>" +
                            "<td>" +
                            p.getAddress() + 
                            "</td>" );
                            String actionid="del";
                            String pageid="personinfo";
                            
                            %>
                            <td>
                            <a href = "edit.jsp?id=<%=p.getId()%>&name=<%=p.getName()%>&address=<%=p.getAddress()%>">edit</a>
                            <a href = "controller?id=<%=p.getId()%>&name=<%=p.getName()%>&address=<%=p.getAddress()%>&actionid=<%=actionid%>&pageid=<%=pageid%>">delete</a>
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
