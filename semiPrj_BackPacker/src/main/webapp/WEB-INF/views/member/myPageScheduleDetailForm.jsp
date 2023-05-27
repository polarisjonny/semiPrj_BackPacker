
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
		margin-top: 150px;
	}

	.scheduler{
		width: 400px;
		height: 320px;
		border: 1px solid #E7E6E6;
		box-shadow: 5px 5px 5px #878787;
	}
		
	
	.timetable{
		display: grid;
		grid-template-columns: 1fr 1fr 1fr;
		grid-template-rows: 1fr 1fr;
		margin-top: 20px;
		justify-items: center;
		height: 250px;
		overflow: auto;
	}
	
	
	#trip-date {
	    text-align: center;
	    margin-top: 10px; 
	}
	.radious{
		border-radius: 20px;
	}
	.text{
		text-align: center;
		margin-top: 20px;
	}
	#scheduler-area{
		grid-gap: 15px;
		width: 800px;
		display: grid;
		grid-template-columns: 1fr 1fr ;
		grid-template-rows: auto;
		margin: auto;
		margin-top: 40px;
	}
	
	#board{
		margin-top: 100px;
	}
	#check{
		padding: 30px;
	}
	.not-schedule{
		position: relative;
    	margin: auto;
	}
	#btnstyle{
		border: 0px;
		background-color: rgba(154, 218, 239, 1);
		width: 150px;
		height: 53px;
		border-radius: 10px;
		color: white;
		position: relative;
		top: 20px;
		font-size: 20px;
	}

	#title{
		padding: 5px;
		border: 1px solid #979797;
		border-radius: 5px;
		width: 550px;
		height: 35px;
	}

	textarea{
		padding: 5px;
		border: 1px solid #979797;
		border-radius: 5px;
		width: 550px;
	}
	#select{
		border:0px;
		background:rgba(148, 210, 230, 1);
		color:white;
		height: 30px;
    	border-radius: 3px;
	}

	#infoLabel{
		cursor: pointer;
		font-size:1.4em;
		cursor: pointer;
		font-size: 1.4em;
		border: 1px solid gray;
		width: 550px;
		background-color: darkgray;
		height: 200px;
		margin-top: 30px;
		margin-left: 80px;
    	border-radius: 5px;
	}
	
	#imgFile{
		visibility: hidden;
		width:80px;
	}
	#ment{
		position: relative;
    	top: 79px;
	}
	#timetable1{
		width: 90px;
		height: 132px;
	}
	#dd{
		text-align: center;
		font-size: xx-large;
		font-style: italic;
		color: rgba(148, 210, 230, 1);
		font-weight: bold;
	}
	
</style>
<body>

	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	
	<main>
		<div id="wrap">
			<c:set var="firstTimetable" value="${timetableVo[0]}" />
			<c:set var="endValue" value="${firstTimetable.totalDate}" />

			
			<div id="dd" >
				${firstTimetable.startDate} ~ ${firstTimetable.endDate}
			</div>

			

			<div  id="scheduler-area">

			

			<c:forEach begin="1" end="${endValue}" var="index">
				
					
					<div class="scheduler radious">
						<div id="trip-date" style="font-weight: bold; font-size: 1.3em;">
							DAY${index}   
						</div>
			
						<div class="timetable">
							<c:forEach  items="${timetableVo}" var="item" >
								<c:if test="${index == item.timetableDate}">

									<c:if test="${item.placeNo=='1'}">
										<div id="timetable1">
											<div ><img  class="radious" width="90px" height="60px" src="${root}/static/img/place/${item.placeImage}" ></div>
											<div id="place-time" style="font-weight: bold;">
												${item.bespokePlace}
												<br>
												<div style="font-size: 0.5em;">시작시간 : ${item.timetableStartTime}</div>											
											</div>
										</div>
									</c:if>

									<c:if test="${item.placeNo !='1'}">
										<div id="timetable1">
											<div ><img  class="radious" width="90px" height="60px" src="${root}/static/img/place/${item.placeImage}" ></div>
											<div id="place-time" style="font-weight: bold;">
												${item.placeName}
												<br>
												<div style="font-size: 0.5em;">시작시간 : ${item.timetableStartTime}</div>											
											</div>
										</div>
									</c:if>
								</c:if>
							</c:forEach>
							
							
							<div class="not-schedule">
								<div>
									<i class="fa-solid fa-circle-info fa-lg" style="color: #878787;"></i>일정 없음.
								</div>
							</div>
			
						</div>
						
						
						
					</div>	
				</c:forEach>
				
			</div>

		
		</div>
		
		
	
	
		

				
	</main>
	
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>

</body>
</html>