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

            <c:url var="post_url"  value="/event/edit/saveEvent.htm" />
            <form:form commandName="event" role="form" id="eventForm" method="post" action="${post_url}">
                <table class="table table-hover">
                    <tr id="event">
                        <td><label for="name">Name:</label></td>
                        <td><form:input path="name" id="name" type="text"/></td>
                        <td><form:errors path="name" class="alert alert-danger" /></td>
                    </tr>
                    <tr class="event">
                        <td><label for="startDate">Start Date:</label></td>
                        <td><form:input path="startDate" id="startDate" type="text"/></td>
                        <td><form:errors path="startDate" class="alert alert-danger" /></td>
                    </tr>
                    <tr class="event">
                        <td><label for="endDate">End Date:</label>
                        <td><form:input path="endDate" id="endDate" type="text"/></td>
                        <td><form:errors  class="alert alert-danger" path="endDate"/></td>

                    </tr>
                    <td><td><input id="save" type="submit" value="Submit"></td>
                </table>
            </form:form>
        </div>
    </body>
</html>
