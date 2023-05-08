<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	#wrap{
		display: grid;
		height: 100vh;
		grid-template-columns: 1fr 2fr 1fr;
		position: relative;
		top: 66px;
	}


    #sidebarLeft {
        
		padding: 20px;
        background-color: #f8f8f8;
        border: 1px solid #ddd;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

	#scheduler-area{
		align-items: center;
		box-sizing: border-box;
		display: flex;
		flex-direction: column;
		flex-shrink: 0;
		padding: 20px;
		width: 100%;
		margin-top: 50px;
	}

	#scheduler-date-area{
		align-items: center;
		box-sizing: border-box;
		display: grid;
		
		grid-template-columns: 1.3fr 4fr 1.3fr;
		justify-items: center;
	}

	#scheduler-place-area {
		display: flex;
		align-items: center;
	}

	#scheduler-place {
		display: flex;
		align-items: center;
		border: 1px solid black;
		padding: 10px;
		border-radius: 10px;
		margin-top: 20px;
		box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	}

	#sc-img {
		margin-right: 10px;
	}

	#area {
		margin-left: 10px;
	}








    
    #sidebarRight {

		padding: 20px;
        background-color: #f8f8f8;
        border: 1px solid #ddd;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        
    }

	#place-list-area{
		align-items: center;
		box-sizing: border-box;
		display: flex;
		flex-direction: column;
		flex-shrink: 0;
		padding: 10px;
		width: 100%;
	
	}
	#place{
		width: 100%;
		height: 80px;
		display: flex;
		align-items: center;
		border: 1px solid black;
		padding: 10px;
		border-radius: 10px;
		margin-top: 10px;
		box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	}
	#place-img{
		width: 100px;
		height: 80px;
		margin-right: 10px;
	}

	input[name="placeName"]{
		margin: 35px;
	}


    
  
    
</style>
<body>

	
	
	<main>
	
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	
		<div id="wrap">
	
	
	    <div id="sidebarLeft">
	
	        <div id="tripDate">
	           기간선택 : <input type="text" name="daterange" value="" />
	        </div>
	
	        <div id="scheduler-area">

				<div id="scheduler-date-area">
					<div><a class="scheduler-date" href="">이전날</a></div>
					<div class="scheduler-date" >2023.05.17 DAY 1</div>
					<div><a class="scheduler-date" href="">다음날</a></div>
				</div>

				<div id="scheduler-place-area">
					<div id="scheduler-place">
						<img id="sc-img" height="80px" width="80px" src="" alt="">
						<div id="area">
							<div class="place">장소명 : 해운대</div>
							<div class="time">소요시간 : 90분</div>
							<div class="class-time">시작시간 : 11:00</div>
						</div>
					</div>
				</div>

				<div id="scheduler-place-area">
					<div id="scheduler-place">
						<img id="sc-img" height="80px" width="80px" src="" alt="">
						<div id="area">
							<div class="place">장소명 : 해운대</div>
							<div class="time">소요시간 : 90분</div>
							<div class="class-time">시작시간 : 11:00</div>
						</div>
					</div>
				</div>


			</div>
	
	
	
	
	    </div>
	
	    <div id="map"></div>
	
	    <div id="sidebarRight">
	
	        <input type="text" placeholder="여행지검색" name="placeName">
	
			
	        <div id="place-list-area">
				
				<h4>여행지 장소 리스트</h4>
				
				<div id="place">
					<img id="place-img" src="" alt="">
					<div id="p-area">
						<div id="p-place">해운데</div>
						<div id="p-introduce">i</div>
						<div id="p-pick">+</div>
					</div>

				</div>
				<div id="place">
					<img id="place-img" src="" alt="">
					<div id="p-area">
						<div id="p-place">해운데</div>
						<div id="p-introduce">i</div>
						<div id="p-pick">+</div>
					</div>

				</div>
				<div id="place">
					<img id="place-img" src="" alt="">
					<div id="p-area">
						<div id="p-place">해운데</div>
						<div id="p-introduce">i</div>
						<div id="p-pick">+</div>
					</div>

				</div>
				<div id="place">
					<img id="place-img" src="" alt="">
					<div id="p-area">
						<div id="p-place">해운데</div>
						<div id="p-introduce">i</div>
						<div id="p-pick">+</div>
					</div>

				</div>
	           
	        </div>
	
	    </div>
	</div>
	
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
	
	
	</main>
	
	
	
	    <script defer>
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

</body>
</html>