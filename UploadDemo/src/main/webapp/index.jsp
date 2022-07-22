<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!</h2>
<h3>springmvc文件上传</h3>
<form action="file/fileupload" method="post" enctype="multipart/form-data">
    选择文件：<input type="file" name="upload"/></br>
    <input type="submit" value="上传文件"/>
</form>
</body>
</html>
