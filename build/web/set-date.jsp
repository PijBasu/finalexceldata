  <form action="FrontController" method="post">
        <table align="center" style="border-style: groove; width: 30%;">
            <tr>
                <td height="50">Interview date :  </td>
                <td><input type="text" name="ivDate" required/></td>
            </tr>
            <tr>
                <td colspan="2" height="50">
                    <input type="hidden" name="f" value="interview"/>
                    <input type="submit" value="Set"/>
                </td>
            </tr>
        </table>
    </form>