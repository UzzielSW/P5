<%-- 
    Document   : index
    Created on : May 7, 2010, 12:59:12 AM
    Author     : BALA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
      
    <%-- start web service invocation --%><hr/>
    <%
    try {
	com.webws.MyWebServiceService service = new com.webws.MyWebServiceService();
	com.webws.MyWebService port = service.getMyWebServicePort();
	 // TODO initialize WS operation arguments here
	java.lang.String name = "Bala Dhandayuthapani";
	// TODO process result here
	java.lang.String result = port.display(name);
	out.println("Result = "+result);
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>
    </body>
</html>
