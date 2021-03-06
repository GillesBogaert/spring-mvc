<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<header>
    <nav class="navbar navbar-default">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Gilles' Events</a>
        </div>
        <ul class="nav navbar-nav navbar-header">
            <li ${param.title eq 'Home' ? 'class="active"' : ''}><a href="<c:url value="/event/home"/>"><spring:message code="header.home"/></a></li>
            <li ${param.title eq 'Overview' ? 'class="active"' : ''}><a href="<c:url value="/event/eventOverview"/>"><spring:message code="header.overview"/></a></li>
            <li ${param.title eq 'addEvent' ? 'class="active"' : ''}><a href="<c:url value="/event/addEventPage"/>"><spring:message code="header.add"/></a></li>
            <li ${param.title eq 'addEvent' ? 'class="active"' : ''}><a href="<c:url value="/rest/resthome"/>"><spring:message code="header.rest"/></a></li>
                <c:if test="${pageContext.request.userPrincipal.name != null}">
                <li><spring:message code="header.loggedAs"/> ${pageContext.request.userPrincipal.name} <li>
                </c:if>
                <c:if test="${pageContext.request.userPrincipal.name != null}">
                <li>  <a href="<c:url value="/security/logout"/>"><spring:message code="header.logout"/></a></li>
                </c:if>




        </ul>

    </nav>
    <img src="<c:url value="/static/images/Hobbes2.jpg" />">

</header>