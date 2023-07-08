/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.model.UserDAO;
import sample.model.UserDTO;
import sample.model.UserError;

/**
 *
 * @author ASUS
 */
public class CreateController extends HttpServlet {

    private static final String ERROR = "create.jsp";
    private static final String SUCCESS = "login.html";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        boolean checkValidation = true;
        UserError userError = new UserError();
        UserDAO dao = new UserDAO();
        try {
            String userID = request.getParameter("userID");
            String fullName = request.getParameter("fullName");
            String roleID = request.getParameter("roleID");
            String password = request.getParameter("password");
            String confirm = request.getParameter("confirm");
//            boolean checkDuplicate = dao.checkDuplicate(userID);
//            if(checkDuplicate){
//                userError.setUserIDError("UserID existed!");
//                checkValidation = false;
//            }
            if (userID.length() < 2 || userID.length() > 10) {
                userError.setUserIDError("UserID must be in [2,10]");
            }
            if (fullName.length() < 5 || userID.length() > 20) {
                userError.setFullNameError("FullName must be in [5,20]");
                checkValidation = false;
            }
            if (!password.equals(confirm)) {
                userError.setConfirmError("Password does not match");
                checkValidation = false;
            }
            if (checkValidation) {
                UserDTO user = new UserDTO(userID, fullName, roleID, password);
//                boolean checkInsert = dao.insert(user);
                boolean checkInsert = dao.insertv2(user);
                if (checkInsert) {
                    url = SUCCESS;
                }
                else{
                    userError.setError("Unknown error");
                    request.setAttribute("USER_ERROR", userError);
                } 
            }
            else{
                request.setAttribute("USER_ERROR", userError);
            }
        } catch (Exception e) {
            log("Error at CreateController " + e.toString());
            if(e.toString().contains("duplicate")){
                userError.setError("Duplicate user ID");
            }
        } finally {
            request.setAttribute("USER_ERROR", userError);
            request.getRequestDispatcher(url).forward(request, response);
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