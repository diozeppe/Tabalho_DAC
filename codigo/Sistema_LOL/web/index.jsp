<%-- 
    Document   : index
    Created on : 05/09/2017, 17:36:27
    Author     : devlogic-2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <form action="ServletLogin">
                Usuário:<br/>
                <input name="nome" type="text" value=""><br/>
                Senha:<br/>
                <input name="senha" type="password" value=""><br/>
                <input type="submit" value="Entrar"><br/>
            </form>
        </div>
    </body>
</html>
