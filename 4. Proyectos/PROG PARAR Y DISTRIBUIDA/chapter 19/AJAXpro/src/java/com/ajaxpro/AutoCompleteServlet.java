package com.ajaxpro;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

public class AutoCompleteServlet extends HttpServlet {
    
    private List names = new ArrayList();
    
    public void init(ServletConfig config) throws ServletException {
        names.add("Arun");
        names.add("Arun kumar");
        names.add("Arunachalam");
        names.add("Arunachalmm veerasamy");
        names.add("Aruna");
        names.add("Bala");
        names.add("Balu");
        names.add("Balan");
        names.add("Bani");
        names.add("Bala Dhandayuthapani");
        names.add("Bala Dhandayuthapani V.");
        names.add("Baalaa");
    }
    
    protected void doGet(HttpServletRequest request
                                                , HttpServletResponse response)
    throws ServletException, IOException {
        String prefix = request.getParameter("search");
        NameSearch service = NameSearch.getInstance(names);
        List matching = service.findNames(prefix);
        if (matching.size() > 0) {
            PrintWriter out = response.getWriter();

            response.setContentType("text/xml");
            response.setHeader("Cache-Control", "no-cache");

            out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            out.println("<ajax-response><response>");
            Iterator iter = matching.iterator();
            while(iter.hasNext()) {
                String name = (String) iter.next();
                out.println("<item>");
                out.println("<name>" + name + "</name>");
                out.println("<value>" + name + "</value>");
                out.println("</item>");
            }
            out.println("</response></ajax-response>");
            matching = null;
            service = null;
            out.close();
        }
        else {
            response.setStatus(HttpServletResponse.SC_NO_CONTENT);
        }
        
    }
    
    protected void doPost(HttpServletRequest request
                                                , HttpServletResponse response)
    throws ServletException, IOException {
        doGet(request, response);
    }
}
