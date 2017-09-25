<%-- 
    Document   : cadastrar_cliente
    Created on : 05/09/2017, 17:35:47
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
        <form action="ServletCadastro">
                Nome:<br/>
                <input name="nome" type="text" value=""><br/>
                
                CPF:<br/>
                <input name="cpf" type="text" value=""><br/>
                
                Telefone 1:<br/>
                <input name="telefone1" type="text" value=""><br/>
                
                Telefone 2(OPC):<br/>
                <input name="telefone2" type="text" value=""><br/>
                
                <input type="radio" name="sexo" value="m" checked>
                Masculino
                <input type="radio" name="sexo" value="f">
                Feminino<br/>
                
                Endereço:<br/>
                <input name="endereco" type="text" value=""><br/>
                
                Número:<br/>
                <input name="numero" type="text" value=""><br/>
                
                Complemento:<br/>
                <input name="complemento" type="text" value=""><br/>
                
                Email:<br/>
                <input name="email" type="text" value=""><br/>
                
                Senha:<br/>
                <input name="senha" type="password" value=""><br/>
                
                Confirmar Senha:<br/>
                <input name="confirmarsenha" type="password" value=""><br/>
                <br/>
                <input type="submit" value="Entrar"><br/>
            </form>
    </body>
</html>
