<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
    #container {
        width: 900px;
        height: 500px;
        border: 1px solid rebeccapurple;
    }
</style>
<script>
    let chart2 = {
        init:function() {
            this.getdata(2024);
            $('input[type=button]').click(()=>{
                let year = $('#year').val();
                this.getdata(year);
            });
        },
        getdata:function(year) {
            $.ajax({
                url:'/charts/chart2',
                data:{year:year},
                success:(datas)=>{
                    // console.log(result);
                    this.display(year, datas);
                }
            })
        },
        display:function(year, datas) {
            Highcharts.chart('container', {
                chart: {
                    type: 'area'
                },
                accessibility: {
                    description: '년도별 월별 남녀 평균 매출'
                },
                title: {
                    text: year+'년도 월별 남녀 평균 매출'
                },
                subtitle: {
                    text: 'Source: <a href="https://fas.org/issues/nuclear-weapons/status-world-nuclear-forces/" ' +
                        'target="_blank">FAS</a>'
                },
                xAxis: {
                    categories: ['1', '2', '3', '4', '5', '6',
                        '7', '8', '9', '10', '11', '12'],
                    accessibility: {
                        rangeDescription: 'Range: January to December.'
                    }
                },
                yAxis: {
                    title: {
                        text: '월별 매출'
                    }
                },
                tooltip: {
                    pointFormat: '{series.name} had stockpiled <b>{point.y:,.0f}</b><br/>' +
                        'warheads in {point.x}'
                },
                plotOptions: {
                    area: {
                        pointStart: 0,
                        marker: {
                            enabled: false,
                            symbol: 'circle',
                            radius: 2,
                            states: {
                                hover: {
                                    enabled: true
                                }
                            }
                        }
                    }
                },
                series: datas
            });
        }
    };
    $(function (){
        chart2.init();
    })
</script>
<div class="col-sm-10">
    <h2>Chart2 Page</h2>
    <div id="container"></div>
    <form>
        <label for="year">Language</label>
        <select name="years" id="year">
            <option value="2020">2020</option>
            <option value="2021">2021</option>
            <option value="2022">2022</option>
            <option value="2023">2023</option>
            <option value="2024">2024</option>
        </select>
        <input type="button" value="조회" />
    </form>
</div>