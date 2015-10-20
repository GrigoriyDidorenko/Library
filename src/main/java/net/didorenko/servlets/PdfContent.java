package net.didorenko.servlets;

import net.didorenko.beans.Book;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * package: net.didorenko.servlets
 * project: Library
 * class:
 *
 * @author: Grigoriy Didorenko
 * @date: 20.10.2015
 */
public class PdfContent extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/pdf");
        try(OutputStream outputStream = response.getOutputStream()){
            int index = Integer.valueOf(request.getParameter("index"));

            HashMap sessionMap = (HashMap)getServletContext().getAttribute("sessionMap");

            HttpSession session = (HttpSession)sessionMap.get(request.getParameter("session_id"));

            ArrayList<Book> list = (ArrayList<Book>)session.getAttribute("currentBookList");
                    Book book = list.get(index);
            book.fillPdfContent();
            response.setContentLength(book.getContent().length);
            outputStream.write(book.getContent());
        }
    }
}
