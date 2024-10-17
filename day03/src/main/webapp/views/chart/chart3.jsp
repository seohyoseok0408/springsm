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
  let chart3 = {
    init:function() {
      setInterval(()=>{
        this.getdata();
      }, 2000);
    },
    getdata:function() {
      $.ajax({
        url:'/charts/chart3',
        success:(datas)=>{
          // console.log(datas);
          this.display(datas);
        }
      })
    },
    display:function(datas) {
      Highcharts.chart('container', {
        chart: {
          type: 'line'
        },
        title: {
          text: 'Monthly Average Temperature'
        },
        subtitle: {
          text: 'Source: ' +
                  '<a href="https://en.wikipedia.org/wiki/List_of_cities_by_average_temperature" ' +
                  'target="_blank">Wikipedia.com</a>'
        },
        xAxis: {
          categories: datas.x
        },
        yAxis: {
          title: {
            text: 'Electrical energy (kWh)'
          }
        },
        plotOptions: {
          line: {
            dataLabels: {
              enabled: true
            },
            enableMouseTracking: false
          }
        },
        series: datas.result
      });
    }
  };
  $(function (){
    chart3.init();
  })
</script>
<div class="col-sm-10">
  <h2>Chart3 Page</h2>
  <div id="container"></div>
</div>