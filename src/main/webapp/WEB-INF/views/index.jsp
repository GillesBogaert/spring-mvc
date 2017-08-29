<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>


    <jsp:include page="partial/head.jsp">
        <jsp:param name="title" value="Home" />
    </jsp:include>
    <body class="centered-wrapper">      s
        <div class="centered-content">
            <jsp:include page="partial/header.jsp">
                <jsp:param name="title" value="Home" />
            </jsp:include> 
            <div class = "text">
                <h1><spring:message code="index.welcome"/></h1>
                <p><spring:message code="index.welcomeMessage"/></p>

            </div>
        </div>
            <jsp:include page="partial/footer.jsp">
                <jsp:param name="title" value="Home"/>
            </jsp:include> 
    </body>

</html>