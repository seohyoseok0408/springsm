<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="col-sm-10">

    <h2>Car Info Page</h2>
    <h5>Title description, Sep 2, 2017</h5>
    <table class="table" id="cdata">
        <thead class="thead-dark">
        <tr>
            <th>CarId</th>
            <th>CarModel</th>
            <th>CarPrice</th>
            <th>ImageName</th>
            <th>RegDate</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="car" items="${cars}">
            <tr>
                <td><a href="/car/detail?id=${car.carId}">${car.carId}</a></td>
                <td>${car.carModel}</td>
                <td>${car.carPrice}</td>
                <td>${car.imgName}</td>
                <td>${car.regDate}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>