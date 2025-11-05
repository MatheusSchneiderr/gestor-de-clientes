<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h2>Contact Form</h2>
<form action="ManCliente" method="post">
    <label>Nome:</label><br>
    <input type="text" name="nome" required><br><br>
    
    <label>Cpf:</label><br>
    <input type="text" name="cpf" required><br><br>
    
    <label>Rg:</label><br>
    <input type="text" name="rg" required><br><br>

    <label>Email:</label><br>
    <input type="email" name="email" required><br><br>   
    
    <label>Telefone:</label><br>
    <input type="tel" name="telefone" required><br><br>   

    <button type="submit">Send</button>
</form>