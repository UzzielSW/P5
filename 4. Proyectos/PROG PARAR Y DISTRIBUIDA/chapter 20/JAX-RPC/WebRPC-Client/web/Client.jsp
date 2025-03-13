<%-- 
    Document   : Client
    Created on : May 6, 2010, 10:40:20 PM
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
        <h1>Hello World!</h1>

    <%-- start web service invocation --%><hr/>
    <%
    try {
	com.jaxrpc.JaxRPCImpleService service = new com.jaxrpc.JaxRPCImpleService();
	com.jaxrpc.JaxRPCImple port = service.getJaxRPCImplePort();
	 // TODO initialize WS operation arguments here
	java.lang.String arg0 = "Bala";
	// TODO process result here
	java.lang.String result = port.display(arg0);
	out.println("Result = "+result);
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>
    </body>
</html>
