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
    let chart4 = {
        init:function() {
            this.getdata(); // 데이터를 가져오는 함수 호출
        },
        getdata:function() {
            // Ajax로 서버에서 로그 데이터를 받아옴
            $.ajax({
                url: "/iot/power/logs",
                method: "GET",
                success: function(data) {
                    chart4.display(data); // 받아온 데이터를 차트에 전달
                },
                error: function(err) {
                    console.log("Failed to fetch logs: ", err);
                }
            });
        },
        display:function(logData) {
            // 로그 데이터를 파싱하여 차트에 사용할 형식으로 변환
            const parsedData = logData.map(log => {
                const parts = log.split(", ");
                return {
                    x: new Date(parts[0]).getTime(), // 로그 시간
                    y: parseFloat(parts[1]) // 로그 값
                };
            });

            // 차트를 초기화하고, 이전의 임의의 데이터 생성 부분을 대체
            Highcharts.chart('container', {
                chart: {
                    type: 'spline',
                    events: {
                        load: function () {
                            const series = this.series[0];
                            setInterval(function () {
                                if (parsedData.length > 0) {
                                    const point = parsedData.shift(); // 파싱한 데이터 중 하나씩 차트에 추가
                                    series.addPoint([point.x, point.y], true, true);
                                }
                            }, 2000); // 2초 간격으로 데이터 추가
                        }
                    }
                },
                time: {
                    useUTC: false
                },
                title: {
                    text: 'Live Power Data from Logs'
                },
                accessibility: {
                    announceNewData: {
                        enabled: true,
                        minAnnounceInterval: 15000,
                        announcementFormatter: function (allSeries, newSeries, newPoint) {
                            if (newPoint) {
                                return 'New point added. Value: ' + newPoint.y;
                            }
                            return false;
                        }
                    }
                },
                xAxis: {
                    type: 'datetime',
                    tickPixelInterval: 150
                },
                yAxis: {
                    title: {
                        text: 'Power Value'
                    }
                },
                tooltip: {
                    headerFormat: '<b>{series.name}</b><br/>',
                    pointFormat: '{point.x:%Y-%m-%d %H:%M:%S}<br/>{point.y:.2f}'
                },
                legend: {
                    enabled: false
                },
                exporting: {
                    enabled: false
                },
                series: [{
                    name: 'Power Data',
                    lineWidth: 2,
                    color: Highcharts.getOptions().colors[2],
                    data: parsedData.slice(0, 20) // 로그 데이터 중 처음 20개를 초기 데이터로 설정
                }]
            });
        }
    };

    $(function (){
        chart4.init();
    });
</script>

<div class="col-sm-10">
    <h2>Chart4 Page</h2>
    <figure class="highcharts-figure">
        <div id="container"></div>
        <p class="highcharts-description">
            Chart showing data updating every second, with old data being removed.
        </p>
    </figure>
</div>
