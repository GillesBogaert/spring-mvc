<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>


    <jsp:include page="partial/head.jsp">
        <jsp:param name="title" value="Docs" />
    </jsp:include>
    <body class="centered-wrapper">
        <div class="centered-content">
            <jsp:include page="partial/header.jsp">
                <jsp:param name="title" value="Home" />
            </jsp:include> 
            <div class = "text">
                
                <h1>Documentation</h1>
                
                <h2>Find Event</h2>
                <p>To find a Event us the link http://193.191.187.14:10068/spring-mvc/event/rest/getevent/(Your ID here)<br>
                    For example : http://193.191.187.14:10068/spring-mvc/event/rest/getevent/ee1c0512-5cbd-4bc4-b913-4997b2b60549<br>
                    Will respond with a NOT_FOUND Status if not found and OK Status if found.
                  </p> 
                  <h2>Delete Event</h2>
                  <p>To delete an event : http://193.191.187.14:10068/spring-mvc/rest/deleteevent/(Your ID here)<br>
                  If no event found NOT_FOUND status will be returned. If sucess a NO_CONTENT status will be returned.</p>
                  <h2>Add Event</h2>
                  <p>To add an event : http://193.191.187.14:10068/spring-mvc/rest/createevent<br>
                  If event exists, CONFLICT Status will be returned. If success, CREATED Status will be returned</p>
                  <h2>Update Event</h2>
                  <p>To update an event : http://193.191.187.14:10068/spring-mvc/rest/updateevent/(Your ID here)<br>
                  If event doesnt exist, returns NOT_FOUND STATUS. If successfully updated OK STATUS returned</p>
                  
            </div>
        </div>
            <jsp:include page="partial/footer.jsp">
                <jsp:param name="title" value="Home"/>
            </jsp:include> 
    </body>

</html>