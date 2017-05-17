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

            <c:url var="post_url" value="/event/saveEvent" />
            <form:form modelAttribute="eventForm" role="form" method="post" action="${post_url}">
                <table class="table table-hover">
                    <tr id="event">
                        <td><label for="name">Name:</label></td>
                        <td><form:input path="name" id="name" type="text"/></td>
                        <td><form:errors path="name" class="alert alert-danger" /></td>
                    </tr>
                    <tr class="event">
                        <td><label for="startDate"><spring:message code="add.startdate" text="default text"></spring:message></label></td>
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
            <p><spring:message code="add.startdate" text="add.startdate"/></p>
            <a href="<c:url value='?lang=nl'/>">Nederlands</a>
        </div>
            <jsp:include page="partial/footer.jsp">
                <jsp:param name="title" value="addEvent" />
            </jsp:include>     
            
            
    </body>
</html>
