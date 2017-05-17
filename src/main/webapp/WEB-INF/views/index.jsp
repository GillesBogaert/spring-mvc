<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>


    <jsp:include page="partial/head.jsp">
        <jsp:param name="title" value="Home" />
    </jsp:include>
    <body class="centered-wrapper">
        <div class="centered-content">
            <jsp:include page="partial/header.jsp">
                <jsp:param name="title" value="Home" />
            </jsp:include> 
            <div class = "text">
                <h1>Welcome to the home page</h1>
                <p> This is a website dedicated to keeping track of Gilles' Events</p>
            </div>
        </div>
    </body>

</html>