package net.didorenko.servlets;

import net.didorenko.beans.Book;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

/**
 * package: net.didorenko.servlets
 * project: Library
 * class:
 *
 * @author: Grigoriy Didorenko
 * @date: 17.10.2015
 */
public class ShowImage extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("image/jpeg");

        try (OutputStream out = response.getOutputStream()) {
            int index = Integer.valueOf(request.getParameter("index"));

            ArrayList<Book> list = (ArrayList<Book>) request.getSession(false).getAttribute("currentBookList");
            Book book = list.get(index);
            response.setContentLength(book.getImage().length);
            out.write(book.getImage());
        }
    }
}
