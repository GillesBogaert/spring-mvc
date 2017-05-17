<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

    <jsp:include page="partial/head.jsp">
        <jsp:param name="title" value="Home" />
    </jsp:include>

    <body class="centered-wrapper">
        <div class="centered-content">
            <jsp:include page="partial/header.jsp">
                <jsp:param name="title" value="Login" />
            </jsp:include> 

            <div class = "text">
                <h1>Welcome to the Login page</h1>
                <p> Enter your login details here to gain access to the various tabs</p>
                <div id="mainWrapper">
                    <div class="login-container">
                        <div class="login-card">

                            <div class="login-form">
                                <c:url var="loginUrl" value="/security/login" />
                                <form action="${loginUrl}" method="post" class="form-horizontal">
                                    <c:if test="${param.error != null}">
                                        <div class="alert alert-danger">
                                            <p>Invalid username and password.</p>
                                        </div>
                                    </c:if>
                                    <c:if test="${param.logout != null}">
                                        <div class="alert alert-success">
                                            <p>You have been logged out successfully.</p>
                                        </div>
                                    </c:if>
                                    <div class="input-group input-sm">
                                        <label class="input-group-addon" for="username"><i class="fa fa-user"></i></label>
                                        <input type="text" class="form-control" id="username" name="ssoId" placeholder="Enter Username" required>
                                    </div>
                                    <div class="input-group input-sm">
                                        <label class="input-group-addon" for="password"><i class="fa fa-lock"></i></label> 
                                        <input type="password" class="form-control" id="password" name="password" placeholder="Enter Password" required>
                                    </div>
                                    <input type="hidden" name="${_csrf.parameterName}" 	value="${_csrf.token}" />

                                    <div class="form-actions">
                                        <input type="submit"
                                               class="btn btn-block btn-primary btn-default" value="Log in">
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>