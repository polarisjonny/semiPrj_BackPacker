<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 일정 -->
<script defer type="text/javascript" src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js"></script>
<script defer type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
<script defer type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css" />
<script defer src="${pageContext.request.contextPath}/static/js/scheduler/makeScheduler.js"></script>
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
		
	}

	#scheduler-date-area{
		align-items: center;
		box-sizing: border-box;
		display: grid;

		width: 250px;
		
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
		border: 1px solid rgb(191, 186, 186);
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
		margin-top: -5px;
		overflow:auto;
		height:550px
	
	}
	#place{
		width: 300px;
		height: 90px;
		display: flex;
		align-items: center;
		border: 1px solid rgb(195, 191, 191);
		padding: 10px;
		border-radius: 10px;
		margin-top: 10px;
		box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
		position: relative;
	}
	#place-img{
		width: 100px;
		height: 80px;
		margin-right: 10px;
	}
	#placeName{
		display: flex;
		justify-content: center;
		padding: 20px;
	}
	
	
	#p-area {
		position: absolute;
		bottom: 0;
		right: 0;
		padding: 8px;
		display: flex;
		align-items: center;
	}

	#p-introduce {
		margin-right: 5px;
		
	}









	.btnn{
		width: 250px;
		height: 70px;
		padding: 5px;
		margin-top: 15px;
		border-radius: 10px;
		border: 0;
		background-color: rgb(225, 224, 224);
		font-size: 20px;
	}

	#tripDate{
		display: flex;
		align-items: center;
		justify-content: center;

	}

	#intro{
		position: relative;
	    top: 250px;
	    display: flex;
	    justify-content: center;
	}
	#in{
		display: grid;
		grid-template-rows: 1fr 1fr;
	}
	#in>input{
		width: 150px;
	}
	#po{
		position: relative;
		top: 10px;
	}
	#placeName>input{
		width: 150px;
	}
	#delete{
		display: inline-block;
		position: relative;
		top: 33px;
	}

	#test{
		color: rgba(148, 210, 230, 1);
		text-align: center;
		position: relative;
		top: 30px;
		font-weight: bold;
		font-size: 1.8em;
	}
	#test > button{
		border: 0px;
		background-color: rgba(148, 210, 230, 1);
		color: white;
		padding: 10px;
		border-radius: 5px;
		position: relative;
		top: 40px;
	}
	

    
  
    
</style>
<body>

	
	
	<main>
	
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	
		<div id="wrap">
	
	
	    <div id="sidebarLeft">
			
			<div id="tripDate">
				기간선택 : &nbsp; <input type="text" name="daterange" />
				<input type="hidden" name="startDate" >
				<input type="hidden" name="endDate" >
			</div>

			<div id="test">

			</div>
		
			<div id="intro">            <%-- 여행기간 설정하면 사라지도록 --%>
				여행기간을 설정하시오    
			</div>
		
	
			<%-- jstl 로 설정 날짜와 일정저장 버튼 생김--%>
			<c:if test="">
				<div id="scheduler-area">
	
					<div id="scheduler-date-area">
						<div><a class="scheduler-date" href="">이전날</a></div>
						<div class="scheduler-date" ><h4>2023.05.10 DAY 1</h4></div>
						<div><a class="scheduler-date" href="">다음날</a></div>
					</div>
					<div id="test"></div>
	
					  <%-- 여행지을 가져 왔을때 생성 --%>
						<div id="scheduler-place-area">
							<div id="scheduler-place">
								<img id="sc-img" height="80px" width="80px" src="" alt="">
								<div id="area">
									<div class="place">장소명 : 해운대</div>
									<div class="time">소요시간 : 90분</div>
									<div class="class-time">시작시간 : 11:00</div>
								</div>
								<div id="delete"><i class="bi bi-trash"></i></div>
							</div>
						</div>
					
					<button class="btnn" >일정저장하기</button>
				</div>
				
			</c:if>
		</div>
			
	
	    <div id="map"></div>
	
	    <div id="sidebarRight">
	
			<div id="placeName">
				<i id="po" class="fa-solid fa-magnifying-glass fa-sm" style="color: #8c8c8c;"></i>
				<input type="text" placeholder="여행지검색" name="placeName">
			</div>
	
			
	        <div id="place-list-area">
				
				<h4>여행지 장소 리스트</h4>
				
				<div id="place">
					<img id="place-img" src="" alt="">
						<div id="in">
							<div>사용자 지정 여행지</div>
							<input type="text" name="name" placeholder="장소이름">
							<input type="text" name="time" placeholder="소요시간">
						</div>
					<div id="p-area">
						<div id="p-pick"><i class="bi bi-plus-circle"></i></div>
					</div>
				</div>
				
				<c:forEach items="${placeList}" var="placeList">
					<div id="place">
						<img id="place-img" src="" alt="">
						<div id="p-place">${placeList.placeName}</div>
						<div id="p-area">
							<div id="p-introduce"><i class="bi bi-info-circle"></i></div>
							<div id="p-pick"><i class="bi bi-plus-circle"></i></div>
						</div>
					</div>
				</c:forEach>
				
	           
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
				
					const ddd = document.querySelector('#test');
					ddd.innerHTML=start.format('YYYY-MM-DD')+"~"+end.format('YYYY-MM-DD');
					ddd.innerHTML+="<form action=''>"
					ddd.innerHTML+="<input id='start' type='hidden' value='"+start.format('YYYY-MM-DD')+"'>"
					ddd.innerHTML+="<input is='end' type='hidden' value=''>"
					ddd.innerHTML+="<button type='submit'>일정표 생성하기</button></form>";

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

			function makeplace(){

			}
	
	        </script>

</body>
</html>