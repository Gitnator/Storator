<%-- 
    Document   : index
    Created on : 17/09/2014, 07:50:32
    Author     : 31300022
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Storator</title>
    </head>
    <body>
        <h1>Storator</h1>

        <!--     LOGIN       -->
        <form method="post" action="${pageContext.request.contextPath}/Login"/>
        Username: <input type="text" name="login"/>
        <br/>
        Password: <input type="password" name="password"/>
        <br/>
        <input type="checkbox" name="save"/> Salvar Login
        <br/>
        <input type="submit" value="Login"/>
    </form>
        <!--     LOGIN       -->       

</body>
</html>
