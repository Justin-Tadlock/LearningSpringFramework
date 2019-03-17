<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="learning.springframework.util.Mappings" %>

<html>
<head><title>Todo List</title></head>
<body>
    <h1>Items on your Todo list</h1>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Todo Items</h2></caption>

            <tr>
                <th>Title</th>
                <th>Deadline</th>
                <th>Delete</th>
            </tr>

            <c:forEach var="item" items="${todoData.items}">

                <c:url var="deleteUrl" value="${Mappings.DELETE_ITEM}">
                    <c:param name="id" value="${item.id}" />
                </c:url>

                <tr>
                    <td><c:out value="${item.title}" /></td>
                    <td><c:out value="${item.deadline}" /></td>
                    <td><a href="${deleteUrl}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
        <c:url var="addUrl" value="${Mappings.ADD_ITEM}" />
        <a href="${addUrl}">New Item</a>
    </div>
</body>
</html>