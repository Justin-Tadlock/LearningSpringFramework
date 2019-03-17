<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="learning.springframework.util.Mappings" %>

<html>
<head><title>Todo List</title></head>
<body>
    <h1>Items on your Todo list</h1>
    <div align="center">
        <c:url var="itemsLink" value="${Mappings.ITEMS}" />
        <h2><a href="${itemsLink}">Show Todo Items</a></h2>
    </div>
</body>
</html>