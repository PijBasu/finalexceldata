<%
    String body =(String) request.getAttribute("body");
    if(body==null){ body="body.jsp";}

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            textArea{
                resize: none;
            }
            
        </style>
    </head>
    <body>
        
        <table border="1" width="100%">
            <tr>
                <td height="150">
                    <jsp:include page="header.jsp"/>
                </td>
            </tr>
            
            <tr>
                <td height="400">
                    <jsp:include page="<%=body%>"/>
                </td>
            </tr>
            <tr>
                <td height="60">
                    <jsp:include page="footer.jsp"/>
                </td>
            </tr>
        </table>
    </body>
</html>
