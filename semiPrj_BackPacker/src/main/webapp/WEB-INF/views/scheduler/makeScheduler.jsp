<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
<script async
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCeCCPwGX5gzSzh6lXqgoGIy_bGEmX1S1E&callback=initMap"
    defer>
</script>
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css" />
</head>
<style>

    #sidebarLeft {
        position: absolute;
        top: 0;
        left: 0;
        width: 25vw;
        height: 100vh;
        padding: 20px;
        background-color: #f8f8f8;
        border: 1px solid #ddd;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        z-index: 5;
    }
    #map{
        background-color: black;
        height: 100%;
        width: 49vw;
        position: absolute;
        top: 0;
        left: 52%;
        transform: translateX(-50%);
    }
    #sidebarRight {
        position: absolute;
        top: 0;
        right: 0;
        width: 20vw;
        height: 100vh;
        padding: 20px;
        background-color: #f8f8f8;
        border: 1px solid #ddd;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        z-index: 5;
    }

    #scheduler-date{
        padding: 10px;
        top: 20px;
        display: grid;
        grid-template-columns: 1fr 4fr 1fr;
        text-align: center;
    }

    #place{
        display: flex;
        border: 2px solid black;
        padding: 8px;
        width: 100%;
    }
    .place-name{
        display: inline-block;
    }
  
    
</style>
<body>

	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	
	<main>
		<div id="wrap">
	
	
	    <div id="sidebarLeft">
	
	        <div id="tripDate">
	           기간선택 : <input type="text" name="daterange" value="" />
	        </div>
	
	        <div id="scheduler">
	
	            <div id="scheduler-date">
	                <div id="x-date"> 이전날 </div>
	                <div id="date"> 2023 05.17  DAY1 </div>
	                <div id="next-date"> 다음날 </div>
	            </div>
	            
	            <div id="place">
	                <div>
	                    <img src="" width="52px" height="52px">
	                    <div class="place-name">장소명</div>
	                    <div>소요시간</div>
	                    <div>시작시간</div>
	                </div>
	            </div>
	            
	            <button> 일정저장 </button>
	        </div>
	
	
	
	
	    </div>
	
	    <div id="map"></div>
	
	    <div id="sidebarRight">
	
	        <input type="text" placeholder="여행지검색" name="placeName">
	
	        <h1>추천장소</h1>
	
	        <div id="placelist">
	            <div>이미지</div>
	            <div>여행지 이름</div>
	        </div>
	
	    </div>
	</div>
	
	    <script>
	        $(function() {
	          $('input[name="daterange"]').daterangepicker({
	            opens: 'left',
	            locale: {
	                format: 'YYYY-MM-DD',
	                daysOfWeek: ['일', '월', '화', '수', '목', '금', '토'],
	                monthNames:['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
	                cancelLabel:'취소',
	                applyLabel:'적용하기'
	            }
	          }, function(start, end, label) {
	            console.log(start.format('YYYY-MM-DD'));
	            console.log(end.format('YYYY-MM-DD'));
	
	          });
	        });
	
	
	        let map;
	
	        function initMap() {
	        map = new google.maps.Map(document.getElementById("map"), {
	            center: { lat: 33.25108891517714, lng:126.62252603069803 },
	            zoom: 15,
	        });
	        }
	
	        window.initMap = initMap;
	
	        </script>
	
	</main>
	
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
	

</body>
</html>