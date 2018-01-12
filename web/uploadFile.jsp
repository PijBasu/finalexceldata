
<!--<body style="background-image: url(img/bg1.jpg); background-repeat: no-repeat;">-->
<center>  
    
    <h1>Upload Excel Sheet</h1><br/>
    <form action="UploadExcelServlet" method="post" enctype="multipart/form-data">
        <table style="border-style: groove; width: 30%;">
            <tr>
                <td height="50">Browse file : </td>
                <td><input type="file" id="file" name="file1" required/></td>
            </tr>
            <tr>
                <td colspan="2" height="50"><input type="submit" value="Upload"/></td>
            </tr>
            <tr>
                <td colspan="2">${requestScope.msg}</td>
            </tr>
        </table>
    </form>
</center>
</body>