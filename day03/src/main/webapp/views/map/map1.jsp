<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
    let map1 = {
        map:null,
        init: function() {
            this.makemap();
            $('#sbtn').click(()=>{
                this.goseoul();
            });
            $('#bbtn').click(()=>{
                this.gobusan();
            });
            $('#jbtn').click(()=>{
                this.gojeju();
            });
        },
        makemap:function(){
            let mapContainer = document.getElementById('map');// 지도를 표시할 div
            let mapOption = {
                center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
                level: 3 // 지도의 확대 레벨
            };

            this.map = new kakao.maps.Map(mapContainer, mapOption);
            let mapTypeControl = new kakao.maps.MapTypeControl();
            this.map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);
            let zoomControl = new kakao.maps.ZoomControl();
            this.map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);

            let markerPosition  = new kakao.maps.LatLng(33.450701, 126.570667);
            let marker = new kakao.maps.Marker({
                position: markerPosition
            });
            marker.setMap(this.map);
        },
        goseoul:function (){
            let moveLatLon = new kakao.maps.LatLng(37.553519, 126.980197);
            this.map.panTo(moveLatLon);
        },
        gobusan:function (){
            let moveLatLon = new kakao.maps.LatLng(35.172936, 129.174003);
            this.map.panTo(moveLatLon);
        },
        gojeju:function (){
            let moveLatLon = new kakao.maps.LatLng(33.265815, 126.556859);
            this.map.panTo(moveLatLon);
        }
    }
    $(function () {
        map1.init();
    });

</script>
<style>
    #map {
        width: 600px;
        height: 500px;
        border: 2px solid darkred;
    }
</style>
<div class="col-sm-10">
    <h2>Map1 Page</h2>
    <button id="sbtn">Seoul</button>
    <button id="bbtn">Busan</button>
    <button id="jbtn">Juju</button>
    <div id="map">
</div>