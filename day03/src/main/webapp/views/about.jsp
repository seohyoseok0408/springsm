<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
    let about = {
        init: function() {
            this.map1();
            this.map2();
        },
        map1:function(){
            let mapContainer = document.getElementById('map1');// 지도를 표시할 div
            let mapOption = {
                    center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
                    level: 3 // 지도의 확대 레벨
                };

            let map = new kakao.maps.Map(mapContainer, mapOption);
            let mapTypeControl = new kakao.maps.MapTypeControl();
            map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);
            let zoomControl = new kakao.maps.ZoomControl();
            map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);

            let markerPosition  = new kakao.maps.LatLng(33.450701, 126.570667);
            let marker = new kakao.maps.Marker({
                position: markerPosition
            });
            marker.setMap(map);

        },
        map2:function(){
            let mapContainer = document.getElementById('map2');// 지도를 표시할 div
            let mapOption = {
                center: new kakao.maps.LatLng(36.799943, 127.074402), // 지도의 중심좌표
                level: 3 // 지도의 확대 레벨
            };

            let map = new kakao.maps.Map(mapContainer, mapOption);
            let mapTypeControl = new kakao.maps.MapTypeControl();
            map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);
            let zoomControl = new kakao.maps.ZoomControl();
            map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);

            let markerPosition  = new kakao.maps.LatLng(36.799943, 127.074402);
            let marker = new kakao.maps.Marker({
                position: markerPosition
            });
            marker.setMap(map);

        }
    }
    $(function () {
        about.init();
    });

</script>
<style>
    #map1 {
        width: 100%;
        height: 300px;
        border: 1px solid indianred;
        margin-right: 10px;
    }
    #map2 {
        width: 100%;
        height: 300px;
        border: 1px solid indianred;
    }
</style>
<div class="col-sm-10">
    <h2>About Page</h2>
    <div class="row">
        <div class="col-sm-6">
            <div id="map1"></div>
        </div>
        <div class="col-sm-6">
            <div id="map2"></div>
        </div>
    </div>

</div>