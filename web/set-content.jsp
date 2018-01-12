<form action="FrontController" method="post">
    <table width="50%" align="center" valign="top" style="border-style: groove;">
        <tr>
            <td height="50" align="center">
                <font size="8" color="blue">
                    Email content
                </font>
            </td>
        </tr>
        <tr>
            <td style="padding: 0px; border-spacing: 0px; margin: 0px;">
                <textarea name="subject" placeholder="Type subject of your email" style="width: 99%; height: 50px;"><%=request.getAttribute("sub")%></textarea>
            </td>
        </tr>
        <tr>
            <td>
                <textarea name="emailBody" placeholder="Type body of your email" style="width: 99%; height: 150px;"><%=request.getAttribute("emailbody")%></textarea>
            </td>
        </tr>
        
        <tr>
            <td>
                <textarea name="signature" placeholder="Type signature of your email" style="width: 99%; height: 60px;"></textarea>
            </td>
        </tr>
        <tr>
            <td>
                <input type="hidden" name="f" value="interview"/>
                <input type="submit" value="Set" style="width: 200px; height: 30px; background-color: green; font-size: 25px; border: 0px;"/>
            </td>
        </tr>
    </table>
</form>
