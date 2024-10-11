<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
    let ajax2 = {
        init: function () {
            setInterval(()=>{this.getData();}, 5000);
        },
        getData: function () {
            $.ajax({
                'url': '<c:url value="/getranktitle"/>',
                dataType: "json"
            }).done((resp) => {
                console.log("인기순위 조회 완료")
                this.display(resp);
            });
        },
        display: function (datas) {
            console.log(datas);
            let result = '';
            $(datas).each(function (index, data) {
                result += '<tr>';
                result += '<td>' + data.no + '</td>';
                result += '<td>' + data.desc + '</td>';
                result += '</tr>';
            });
            $('#rdata > tbody').html(result);
        }
    };
    $(function (){
        ajax2.init();
    })
</script>
<div class="col-sm-10">
    <h2>Ajax2 Page</h2>
    <h5>실시간 인기순위</h5>
    <table class="table" id="rdata">
        <thead class="thead-dark">
        <tr>
            <th>Rank</th>
            <th>Title</th>
        </tr>
        </thead>
        <tbody>

        </tbody>
    </table>
</div>