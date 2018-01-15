<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="random" class="java.util.Random" scope="application" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Отправка сообщения</title>
</head>
<body>
<form:form method="POST">
    <table>
        <tr>
            <td>Message:</td>
            <td><input type = "text" name = "message" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Sent Message" />
            </td>
        </tr>
    </table>

</form:form>
</body>
</html>
