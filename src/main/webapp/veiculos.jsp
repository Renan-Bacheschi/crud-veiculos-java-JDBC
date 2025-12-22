<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="br.com.renan.crudveiculos.model.Veiculo" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Cadastro de Veículos</title>
    <style>
        body { font-family: Arial, sans-serif; max-width: 900px; margin: 20px auto; }
        h1 { margin-bottom: 10px; }
        table { border-collapse: collapse; width: 100%; margin-top: 15px; }
        th, td { border: 1px solid #ccc; padding: 6px 10px; text-align: left; }
        th { background-color: #f3f3f3; }
        form { margin-top: 20px; display: flex; gap: 10px; flex-wrap: wrap; }
        input[type="text"], input[type="number"] { padding: 4px 6px; }
        button { padding: 5px 12px; cursor: pointer; }
    </style>
</head>
<body>

<h1>Cadastro de Veículos</h1>

<h2>Veículos cadastrados</h2>

<table>
    <tr>
        <th>ID</th>
        <th>Marca</th>
        <th>Modelo</th>
        <th>Ano</th>
        <th>Preço</th>
    </tr>
    <%
    List<Veiculo> veiculos = (List<Veiculo>) request.getAttribute("veiculos");
    if (veiculos != null && !veiculos.isEmpty()) {
    for (Veiculo v : veiculos) {
    %>
    <tr>
        <td><%= v.getId() %></td>
        <td><%= v.getMarca() %></td>
        <td><%= v.getModelo() %></td>
        <td><%= v.getAno() %></td>
        <td>R$ <%= String.format("%.2f", v.getPreco()) %></td>
    </tr>
    <%
    }
    } else {
    %>
    <tr>
        <td colspan="5">Nenhum veículo cadastrado.</td>
    </tr>
    <%
    }
    %>
</table>

<h2>Novo veículo</h2>

<form method="post" action="veiculos">
    <input type="text" name="marca" placeholder="Marca">
    <input type="text" name="modelo" placeholder="Modelo">
    <input type="number" name="ano" placeholder="Ano">
    <input type="number" step="0.01" name="preco" placeholder="Preço">
    <button type="submit">Cadastrar</button>
</form>

</body>
</html>