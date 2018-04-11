<%-- 
    Document   : seller_hp
    Created on : Mar 25, 2018, 10:48:32 PM
    Author     : arm_p
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Bootstrap Example</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
	<div class="container">
		<a class="navbar-brand" href="homepage.html">Used Car Market Online</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

		<div class="collapse navbar-collapse" id="navbarColor01">
			<ul class="navbar-nav ml-auto">
                            
                            <sql:setDataSource var="account_db"
                               driver="com.mysql.jdbc.Driver"
                               url="jdbc:mysql://localhost:3307/mysql?zeroDateTimeBehavior=convertToNull"
                               user="root"
                               password="root" />
                            <sql:query dataSource="${account_db}" var="account_db">
                                select * from account_db
                            </sql:query>
                            
                            <c:forEach var="first_name" items="${account_db.rows}">
                                    Welcome, ${first_name.first_name}<br>
                            </c:forEach>
                                                        				
				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
						Manage
					</a>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="">Profile</a>
						<a class="dropdown-item" href="#">Logout</a>
					</div>
				</li>
			</ul>
		</div>
</nav>
    </body>
</html>
