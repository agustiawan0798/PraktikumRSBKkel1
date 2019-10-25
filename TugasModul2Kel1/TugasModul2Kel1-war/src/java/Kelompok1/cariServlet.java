/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kelompok1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MY-PC
 */
@WebServlet(name = "cariServlet", urlPatterns = {"/search"})
public class cariServlet extends HttpServlet {

    searchMahasiswaLocal cariMahasiswa = lookupcariMahasiswaLocal();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        request.setAttribute("status", "false");
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/search.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nama = request.getParameter("nama");
        String nim = request.getParameter("nim");
        cariMahasiswa.Data(nama, nim);
        
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String param = request.getParameter("param");
        String print = cariMahasiswa.search(param);
        
        if (print == "No") {
            request.setAttribute("show", "Mahasiswa tidak terdaftar");
        }
        else {
            request.setAttribute("show", print);
        }
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private searchMahasiswaLocal lookupcariMahasiswaLocal() {
        try {
            Context c = new InitialContext();
            return (searchMahasiswaLocal) c.lookup("java:global/TugasModul2Kel1/TugasModul2Kel1-ejb/searchMahasiswa!Kelompok1.searchMahasiswaLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
