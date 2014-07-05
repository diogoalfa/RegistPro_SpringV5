<%--
  Created by IntelliJ IDEA.
  User: macbookpro
  Date: 04-07-14
  Time: 19:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Contacto</title>
</head>
<body>

<form action="/guardarContacto" method="post">
    <table>
        <tr>
            <td>Nombre :</td><td><input type="text" name="nombre"/></td>
        </tr>
        <tr>
            <td>Correo :</td><td><input type="text" name="correo"/></td>
        </tr>
        <tr>
            <td>Telefono :</td><td><input type="text" name="telefono"/></td>
        </tr>
        <tr>
            <td></td><td><button type="">Guardar</button></td>
        </tr>
    </table>
</form>
<br/><br/>
        <c:if test="${!empty contactos}">
            <h2>Mostrar Contacto !</h2>
            <table>
                <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Correo</th>
                    <th>Telefono</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${contactos}" var="contacto">
                    <tr>
                        <td>${contacto.nombre}</td>
                        <td>${contacto.correo}</td>
                        <td>${contacto.telefono}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:if>


</body>
</html>
