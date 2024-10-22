
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="col-sm-2">

    <h3>Cust</h3>
    <ul class="nav nav-pills flex-column">
        <li class="nav-item">
            <a class="nav-link" href="<c:url value="/cust/add"/> ">add</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="<c:url value="/cust/get"/>">get</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="<c:url value="/cust/getpage"/>">page</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="<c:url value="/cust/search"/>">search</a>
        </li>
    </ul>
    <hr class="d-sm-none">
</div>
