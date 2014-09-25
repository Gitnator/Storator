/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mackenzie.storator.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 31300022
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Login</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Login at " + request.getContextPath() + "</h1>");

            String login = request.getParameter("login");
            String pass = request.getParameter("password");
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md5.digest(pass.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String snhCripto = number.toString(16);
            while (snhCripto.length() < 32) {
                snhCripto += "0";
            }
            out.println("<p>Login: " + (String) request.getParameter("login") + "</p>");
            out.println("<p>Senha: " + snhCripto + "</p>");

            if (request.getParameterValues("save") != null) {
                response.addCookie(new Cookie("login", login));
                response.addCookie(new Cookie("password", snhCripto));
                Cookie[] cookies = request.getCookies();
                if (cookies != null) {
                    out.print("Cookie salvo com sucesso <br/>");

                    for (int i = 0; i < cookies.length; i++) {
                        if ((cookies[i].getValue().equals(login))) {
                            for (int j = 0; j < cookies.length; j++) {
                                if (cookies[j].getValue().equals(snhCripto)) {
                                    out.print("Login pelos cookies realizado com sucesso <br/>");

                                    if (cookies[i].getName().equals("login")) {
                                        out.print("<br/>Cookie Login: " + cookies[i].getValue() + "<br/>");
                                    }
                                    if (cookies[j].getName().equals("password")) {
                                        out.print("Cookie Senha: " + cookies[j].getValue() + "<br/>");
                                    }
                                }
                            }
                        }
                    }
                }
            }
            HttpSession session = request.getSession();
            out.print("Session Id: " + session.getId());
            out.print("<br/>");
            out.print("Session Creation time: " + new Date(session.getCreationTime()));
            out.print("<br/>");
            out.print("Session Last Accessed Time: " + new Date(session.getLastAccessedTime()));
            out.print("<br/>");

            out.println("</body>");
            out.println("</html>");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
