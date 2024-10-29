<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
    let center = {
        init: function () {
            $.ajax({
                url: '<c:url value="/wh"/>',
                success: (result) => {
                    let text = result.response.body.items.item[0].wfSv;
                    $('#wh').text(text);
                }
            });
        }
    };
    $(function () {
        center.init();
    });
</script>
<div class="col-sm-10">

    <p id="wh"></p>
    <p>Some text..</p>
    <p>Sunt in culpa qui officia deserunt mollit anim id est laborum consectetur adipiscing elit, sed do eiusmod tempor
        incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco.</p>
</div>