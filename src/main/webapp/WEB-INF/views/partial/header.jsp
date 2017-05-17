
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<header>
    <nav class="navbar navbar-default">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Gilles' Events</a>
        </div>
        <ul class="nav navbar-nav navbar-header">
            <li ${param.title eq 'Home' ? 'class="active"' : ''}><a href="<c:url value="/event/home"/>">Home</a></li>
            <li ${param.title eq 'Overview' ? 'class="active"' : ''}><a href="<c:url value="/event/eventOverview"/>">Event Overview</a></li>
            <li ${param.title eq 'addEvent' ? 'class="active"' : ''}><a href="<c:url value="/event/addEventPage"/>">Add an Event</a></li>
                <c:if test="${pageContext.request.userPrincipal.name != null}">
                <li>Logged in as ${pageContext.request.userPrincipal.name} <li>
                </c:if>
                <c:if test="${pageContext.request.userPrincipal.name != null}">
                <li>  <a href="<c:url value="/security/logout"/>">Logout</a></li>
                </c:if>




        </ul>

    </nav>
    <img src="<c:url value="/static/images/Hobbes2.jpg" />">

</header>