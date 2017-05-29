<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>


    <jsp:include page="partial/head.jsp">
        <jsp:param name="title" value="Access Denied" />
    </jsp:include>
    <body class="centered-wrapper">
        <div class="centered-content">
            <jsp:include page="partial/header.jsp">
                <jsp:param name="title" value="Access Denied" />
            </jsp:include> 
            <div class = "text">
                <h1>Sorry <strong>${user}</strong> you are not authorized to access this page </h1>
                <p><a href="<c:url value="/security/logout" />">Logout</a> and try logging in with a different username/password combo</p>
            </div>
        </div>
            <jsp:include page="partial/footer.jsp">
                <jsp:param name="title" value="Home" />
            </jsp:include>
    </body>
    

</html>