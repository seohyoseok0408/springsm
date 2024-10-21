<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="col-sm-10">

    <h2>Cust get Page</h2>
    <h5>Title description, Sep 2, 2017</h5>
    <table class="table" id="cdata">
        <thead class="thead-dark">
        <tr>
            <th>Id</th>
            <th>pwd</th>
            <th>name</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="cust" items="${custs}">
            <tr>
                <td><a href="/cust/detail?id=${cust.custId}">${cust.custId}</a></td>
                <td>${cust.custPwd}</td>
                <td>${cust.custName}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>