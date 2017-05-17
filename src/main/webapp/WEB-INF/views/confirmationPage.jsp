<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <jsp:include page="partial/head.jsp">
        <jsp:param name="title" value="addEvent" />
    </jsp:include>
    <body class="centered-wrapper">
        <div class="centered-content">

            <jsp:include page="partial/header.jsp">
                <jsp:param name="title" value="addEvent" />
            </jsp:include>   

            <h2>Are you sure you want to deleted event with ID : ${event.id} ? </p>
                <a href="<c:url value="/event/delete/${event.id}.htm"/>"><button class="btn btn-large btn-primary" data-toggle="confirmation">Yes</button></a>
                <a href="<c:url value="/event/eventOverview.htm"/>"><button class="btn btn-large btn-danger" data-toggle="confirmation">No</button></a>



                </body>
                </html>
