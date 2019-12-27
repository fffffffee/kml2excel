<%--
  Created by IntelliJ IDEA.
  User: ldx
  Date: 2019/12/27
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>KML文件上传</title>
</head>
<body>
    <h1>文件上传实例</h1>
    <form method="post" action="/UploadServlet" enctype="multipart/form-data">
        选择一个文件：
        <input type="file" name="uploadFile" />
        <br/>
        <br/>
        <input type="submit" value="上传" />
    </form>
</body>
</html>
