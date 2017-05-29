<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>


    <jsp:include page="partial/head.jsp">
        <jsp:param name="title" value="Overview" />
    </jsp:include>
    <body class="centered-wrapper">
        <div class="centered-content">

            <jsp:include page="partial/header.jsp">
                <jsp:param name="title" value="Overview" />
            </jsp:include> 
            <div>
                <h1>Event Overview</h1>
                <div class="table">
                    <table class="table table-hover table-bordered">
                        <thead>
                            <tr>
                                <th>Start Date</th>
                                <th>End Date</th>
                                <th>Name</th>
                                <th>ID</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="event" items="${events}">
                                <tr>
                                    <td><c:out value="${event.startDate}"/></td>
                                    <td><c:out value="${event.endDate}"/></td>
                                    <td><c:out value="${event.name}"/></td>
                                    <td><c:out value="${event.id}"/></td>
                                    <td class="imgTD"><a href="<c:url value="/event/edit/${event.id}.htm"/>"><img src="<c:url value="/static/images/Edit.png"/>"></a></td>
                                    <td class="imgTD"><a href="<c:url value="/event/deleteConfirm/${event.id}.htm"/>"><img src="<c:url value="/static/images/delete.png" />"></a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <a href="<c:url value="/event/addEventPage.htm"/>"><button id="button" type="button" class="btn btn-primary">New</button></a>
                </div>
            </div>          
        </div>
                <jsp:include page="partial/footer.jsp">
                <jsp:param name="title" value="Home" />
            </jsp:include>
    </body>
</html>