<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Address Book</title>
    <SCRIPT language="JavaScript">
    function add()
    {
    document.personform.actionid.value="add";
    document.personform.submit();
    }
    function search()
    {
    document.personform.actionid.value="search";
    document.personform.submit();
    }
    function show()
    {
    document.personform.actionid.value="show";
    document.personform.submit();
    }
    
    </SCRIPT> 
</head>
<body>
    
    <font face="Book Antiqua">
        <hr>
        <h1>Address Book</h1>
        <hr>
        
        <br>
        
        <form name="personform" action="controller" method="Post"> 
        <table>
            <tr><td>
                Name: 
                <td><input type = text name = "name" size="50"></td>
            </tr><tr>
                <td>Address:</td>
                <td><input type = text name = "address" size="50"></td>
            </tr>
        </table>
        <br> 
        <input  type="hidden" name="id" value="null"> 
        <input  type="hidden" name="actionid">            
        <input  type="hidden" name="pageid" value="personinfo">            
        
        <input type=button value="search" name="btnsearch" onclick="search()">
        <input type=button value="appoint" name="btnappoint" onclick="show()">
        <input type=button value="save" name="btnsave" onclick="add()">
        
    </font>
    </form>
    
</body>
</html>
