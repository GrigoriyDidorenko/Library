package net.didorenko.servlets;

import net.didorenko.beans.Book;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * package: net.didorenko.servlets
 * project: Library
 * class:
 *
 * @author: Grigoriy Didorenko
 * @date: 17.10.2015
 */
public class ShowImage extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("image/jpeg");
        try (OutputStream out = response.getOutputStream()) {
            int index = Integer.valueOf(request.getParameter("index"));
            ArrayList<Book> list = (ArrayList<Book>)request.getSession(false).getAttribute("currentBookList");
            Book book = list.get(index);
            response.setContentLength(book.getImage().length);
            out.write(book.getImage());
        } catch (java.io.IOException ex){
            Logger.getLogger(ShowImage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
