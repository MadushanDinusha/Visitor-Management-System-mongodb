<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Madushan
  Date: 8/11/2019
  Time: 8:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800" rel="stylesheet">
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/resources/fonts/font-awesome-4.3.0/css/font-awesome.min.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/jquery.custom-scrollbar.css"/>">
    <link href="https://fonts.googleapis.com/css?family=Raleway:300i,400,700" rel="stylesheet">
    <script type="text/javascript" src="<c:url value="/resources/js/jquery-3.3.1.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery.custom-scrollbar.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/common-js.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/javascript/visitor.js"/>"></script>
</head>
<body>
<div class="container">

    <form id="uploadForm" name="uploadForm" method="post" enctype="multipart/form-data">
        <h1>This is a sample form</h1>
        <div class="form-group">
            <label >Visitor Name</label>
            <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"
                   placeholder="Enter name">
            <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
        </div>
        <div class="form-group">
            <label >ID</label>
            <input type="text" class="form-control" id="exampleInputPassword1" placeholder="id">
        </div>
        <button type="button" class="btn btn-primary" onclick="addVisitor()">Submit</button>
    </form>
</div>
</body>
</html>
