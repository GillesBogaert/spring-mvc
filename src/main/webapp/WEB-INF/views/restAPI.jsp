<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
    <jsp:include page="partial/head.jsp">
        <jsp:param name="title" value="API" />
    </jsp:include>
    <body onload="start()" class="centered-wrapper">
        <div class="centered-content">
            <jsp:include page="partial/header.jsp">
                <jsp:param name="title" value="API" />
            </jsp:include> 
            <div class = "text">
                <h1><spring:message code="api.welcome"/></h1>
                <p><spring:message code="api.welcomeMessage"/></p>
            </div>
            
            <div id="restOverview">
                <h2>This is the Overview using rest</h2>
                <div id="showQuote"></div>
                <div id="showData"></div>
        </div>
            <jsp:include page="partial/footer.jsp">
                <jsp:param name="title" value="API"/>
            </jsp:include> 
        </div>
    </body>

</html>