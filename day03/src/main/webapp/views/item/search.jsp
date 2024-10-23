<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="col-sm-10">

    <h2>Item Search Page</h2>
    <form action="/item/findimpl" method="get">
        <div class="form-group">
            <div class="row">
                <div class="col-sm-2">
                    <h3>Search</h3>
                </div>
                <div class="col-sm-3">
                    <select class="form-control" name="keyword">
                        <option value="name"
                                <c:if test="${search.keyword == 'name'}">selected</c:if>
                        >NAME
                        </option>
                    </select>
                </div>
                <div class="col-sm-4">
                    <input type="text" class="form-control" name="search"
                    <c:if test="${search.search != null}">
                           value="${search.search}"
                    </c:if>
                    >
                </div>
                <div class="col-sm-3">
                    <button type="submit" class="btn btn-primary">Search</button>
                </div>
            </div>
        </div>
    </form>
    <table class="table" id="idata">
        <thead class="thead-dark">
        <tr>
            <th>Name</th>
            <th>Date</th>
            <th>Price</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="i" items="${cpage.getList()}">
            <tr>
                <td><a href="/item/detail?id=${i.itemId}">${i.itemName}</a></td>
                <td>
                    <fmt:parseDate value="${i.regDate}"
                                   pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both" />
                    <fmt:formatDate pattern="yyyy년 MM월 dd일 HH시 mm분" value="${ parsedDateTime }" />
                </td>
                <td>
                    <fmt:formatNumber type="number" pattern="###,###원" value="${i.itemPrice}" /></td>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <c:if test="${cpage.getSize() != null}">
        <jsp:include page="../searchnav.jsp"/>
    </c:if>
</div>