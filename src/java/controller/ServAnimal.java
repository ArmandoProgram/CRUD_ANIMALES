/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import configuration.ConnectionBD;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.AnimalModel;

/**
 * @author arman
 */
@WebServlet(
        name = "Animal", 
        description = "Representa las operaciones de un CRUD para los Animales",
        urlPatterns = {"/listar_animal", "/registrar_animal", "/borrar_animal", "/actualizar_animal"})
public class ServAnimal extends HttpServlet { // Extiende HttpServlet
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
            ConnectionBD conexion = new ConnectionBD();

        // Obtener los parámetros del formulario
        String color = request.getParameter("txt_color");
        String especie = request.getParameter("txt_especie");
        String tipo_Animal = request.getParameter("txt_tipo_animal");
        String tipo_Alimento = request.getParameter("txt_tipo_alimento");
        String peso = request.getParameter("txt_peso");
        String habitad = request.getParameter("txt_habitad");
        String altura = request.getParameter("txt_altura");

        try {
            // Crear la consulta SQL para insertar el animal
            String sql = "INSERT INTO animales (color, especie, tipo_Animal, tipo_Alimento, peso, habitad, altura) VALUES (?, ?, ?, ?, ?, ?, ?)";
            conn = conexion.getConnectionBD();
            ps = conn.prepareStatement(sql);
            ps.setString(1, color);
            ps.setString(2, especie);
            ps.setString(3, tipo_Animal);
            ps.setString(4, tipo_Alimento);
            ps.setDouble(5, Double.parseDouble(peso));
            ps.setString(6, habitad);
            ps.setString(7, altura);

            // Ejecutar la consulta
            int filasInsertadas = ps.executeUpdate();
            if (filasInsertadas > 0) {
                // Si se insertó correctamente
                request.setAttribute("mensaje", "Animal registrado con éxito!");
            } else {
                request.setAttribute("mensaje", "Error al registrar el animal.");
            }
            request.getRequestDispatcher("/resultado.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("mensaje", "Ocurrió un error: " + e.getMessage());
            request.getRequestDispatcher("/resultado.jsp").forward(request, response);
        } finally {
            // Cerrar los recursos
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
            ConnectionBD conexion = new ConnectionBD();

        ArrayList<AnimalModel> listaAnimales = new ArrayList<>();
        String sql = "SELECT color, id, especie, tipo_Animal, tipo_Alimento, peso, habitad, altura FROM animales";
        try {
            conn = conexion.getConnectionBD();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            // Itera sobre los resultados y crea objetos AnimalModel
            while (rs.next()) {
                AnimalModel animal = new AnimalModel();
                animal.setColor(rs.getString("color"));
                animal.setEspecie(rs.getString("especie"));
                animal.setTipoAnimal(rs.getString("tipo_Animal"));
                animal.setTipoAlimento(rs.getString("tipo_Alimento"));
                animal.setPeso(rs.getDouble("peso"));
                animal.setHabitad(rs.getString("habitad"));
                animal.setId(rs.getInt("id"));
                animal.setAltura(rs.getString("altura"));
                listaAnimales.add(animal);
            }
            // Pasa la lista de animales al JSP
            request.setAttribute("animales", listaAnimales);
            request.getRequestDispatcher("/vistas/mostrar_animales.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al obtener los animales");
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            ConnectionBD conexion = new ConnectionBD();

        String idStr = request.getParameter("id");
        if (idStr == null || idStr.trim().isEmpty()) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST); // Invalid request
            return;
        }

        String sql = "DELETE FROM animales WHERE id = ?";
        try {
            conn = conexion.getConnectionBD();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(idStr)); // Cambiado de double a int para id

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                response.setStatus(HttpServletResponse.SC_OK); // Eliminación exitosa
            } else {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND); // No se encontró el animal
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR); // Error del servidor
        } finally {
            try{
             if (ps != null) {
                ps.close();
            }
            if (conn != null && !conn.isClosed()){  
                conn.close();
            }
        }
            catch (Exception e){
                   e.printStackTrace();
                    }
        }
    }
}
