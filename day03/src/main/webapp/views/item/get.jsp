<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<style>
    #item_img{
        width: 80px;
    }
</style>

<div class="col-sm-10">
    <h2>Item get Page</h2>
    <h5>Title description, Sep 2, 2017</h5>
    <table class="table" id="cdata">
        <thead class="thead-dark">
        <tr>
            <th>Id</th>
            <th>name</th>
            <th>price</th>
            <th>imgname</th>
            <th>regdate</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${items}">
            <tr>
                <td>${item.id}</td>
                <td>${item.name}</td>
                <td><fmt:formatNumber type="number" pattern="###.###$" value="${item.price}"/></td>
                <td><img id="item_img" src="<c:url value="/img"/>/${item.imgname}"/></td>
                <td>${item.regdate}</td>
                
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>