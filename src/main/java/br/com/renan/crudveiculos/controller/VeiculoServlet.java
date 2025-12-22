package br.com.renan.crudveiculos.controller;

import br.com.renan.crudveiculos.model.Veiculo;
import br.com.renan.crudveiculos.service.VeiculoService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/veiculos")
public class VeiculoServlet extends HttpServlet {

    private VeiculoService service = new VeiculoService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Veiculo> veiculos = service.listarTodos();
        request.setAttribute("veiculos", veiculos);

        request.getRequestDispatcher("/veiculos.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String marca = request.getParameter("marca");
        String modelo = request.getParameter("modelo");
        String anoStr = request.getParameter("ano");
        String precoStr = request.getParameter("preco");

        if (marca != null && modelo != null && anoStr != null && precoStr != null &&
                !marca.isBlank() && !modelo.isBlank() && !anoStr.isBlank() && !precoStr.isBlank()) {

            int ano = Integer.parseInt(anoStr);
            double preco = Double.parseDouble(precoStr);

            Veiculo veiculo = new Veiculo(marca, modelo, ano, preco);
            service.cadastrarVeiculo(veiculo);
        }

        // pós-cadastro
        response.sendRedirect(request.getContextPath() + "/veiculos");
    }
}