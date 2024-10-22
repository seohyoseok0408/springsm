<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="col-sm-10">
    <h2>Cust page Page</h2>
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
        <c:forEach var="c" items="${cpage.getList()}">
            <tr>
                <td><a href="/cust/detail?id=${c.custId}">${c.custId}</a></td>
                <td>${c.custPwd}</td>
                <td>${c.custName}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <jsp:include page="../nav.jsp"/>
</div>