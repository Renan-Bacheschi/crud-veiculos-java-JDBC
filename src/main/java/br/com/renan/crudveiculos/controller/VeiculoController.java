package br.com.renan.crudveiculos.controller;

import br.com.renan.crudveiculos.dao.VeiculoDAOImpl;
import br.com.renan.crudveiculos.model.Veiculo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/veiculos")
public class VeiculoController extends HttpServlet {

    private final VeiculoDAOImpl dao = new VeiculoDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setAttribute("lista", dao.listarTodos());
        req.getRequestDispatcher("lista.jsp").forward(req, resp);
    }
}