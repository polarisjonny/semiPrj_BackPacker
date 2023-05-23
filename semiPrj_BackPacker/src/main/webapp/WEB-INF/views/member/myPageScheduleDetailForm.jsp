<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이 페이지 스케줄 상세 페이지</title>
<style>

    #title {
        color: #94d2e6;
        font-weight: bold;
        margin-top: 8%;
    }
    
	#wrap{
		margin-top: 150px;
	}

	.scheduler{
		width: 400px;
		height: 290px;
		border: 1px solid #E7E6E6;
		box-shadow: 5px 5px 5px #878787;
	}
		
	
	.timetable{
		display: grid;
		grid-template-columns: 1fr 1fr 1fr;
		grid-row: 1fr 1fr;
		margin-top: 20px;
		justify-items: center;
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
	}

	
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<main>
		<div id="wrap">

			<div class="text">
				<h1 id="title">MY SCHEDULE</h1>
		
			</div>
		
			<div  id="scheduler-area">
				
				<div class="scheduler radious">
					<div id="trip-date">
						DAY1
						<br>
						2023-04-27
					</div>
		
					<div class="timetable">
						<div id="timetable1">
							<div><img  class="radious" width="90px" height="60px" src="" alt=""></div>
							<div id="place-time">
								곽지해수욕장
								<br>
								10:00~11:00
							</div>
						</div>
						<div id="timetable2">
							<div ><img  class="radious" width="90px" height="60px" src="" alt=""></div>
							<div id="place-time">
								곽지해수욕장
								<br>
								10:00~11:00
							</div>
						</div>
						<div id="timetable3">
							<div ><img  class="radious" width="90px" height="60px" src="" alt=""></div>
							<div id="place-time">
								곽지해수욕장
								<br>
								10:00~11:00
							</div>
						</div>
						<div id="timetable4">
							<div ><img  class="radious" width="90px" height="60px" src="" alt=""></div>
							<div id="place-time">
								곽지해수욕장
								<br>
								10:00~11:00
							</div>
						</div>
						<div id="timetable5">
							<div ><img  class="radious" width="90px" height="60px" src="" alt=""></div>
							<div id="place-time">
								곽지해수욕장
								<br>
								10:00~11:00
							</div>
						</div>
						<div class="not-schedule">
							<div>
								<i class="fa-solid fa-circle-info fa-lg" style="color: #878787;"></i>일정이 없습니다.
							</div>
						</div>
		
					</div>
					
				</div>
				<div class="scheduler radious">
					<div id="trip-date">
						DAY1
						<br>
						2023-04-27
					</div>
		
					<div class="timetable">
						<div id="timetable1">
							<div ><img  class="radious" width="90px" height="60px" src="" alt=""></div>
							<div id="place-time">
								곽지해수욕장
								<br>
								10:00~11:00
							</div>
						</div>
						<div id="timetable2">
							<div ><img  class="radious" width="90px" height="60px" src="" alt=""></div>
							<div id="place-time">
								곽지해수욕장
								<br>
								10:00~11:00
							</div>
						</div>
						<div id="timetable3">
							<div ><img  class="radious" width="90px" height="60px" src="" alt=""></div>
							<div id="place-time">
								곽지해수욕장
								<br>
								10:00~11:00
							</div>
						</div>
						<div id="timetable4">
							<div ><img  class="radious" width="90px" height="60px" src="" alt=""></div>
							<div id="place-time">
								곽지해수욕장
								<br>
								10:00~11:00
							</div>
						</div>
						<div id="timetable5">
							<div ><img  class="radious" width="90px" height="60px" src="" alt=""></div>
							<div id="place-time">
								곽지해수욕장
								<br>
								10:00~11:00
							</div>
						</div>
						<div class="not-schedule">
							<div>
								<i class="fa-solid fa-circle-info fa-lg" style="color: #878787;"></i>일정이 없습니다.
							</div>
						</div>
		
					</div>
					
				</div>
				<div class="scheduler radious">
					<div id="trip-date">
						DAY1
						<br>
						2023-04-27
					</div>
		
					<div class="timetable">
						<div id="timetable1">
							<div ><img  class="radious" width="90px" height="60px" src="" alt=""></div>
							<div id="place-time">
								곽지해수욕장
								<br>
								10:00~11:00
							</div>
						</div>
						<div id="timetable2">
							<div ><img  class="radious" width="90px" height="60px" src="" alt=""></div>
							<div id="place-time">
								곽지해수욕장
								<br>
								10:00~11:00
							</div>
						</div>
						<div id="timetable3">
							<div ><img  class="radious" width="90px" height="60px" src="" alt=""></div>
							<div id="place-time">
								곽지해수욕장
								<br>
								10:00~11:00
							</div>
						</div>
						<div id="timetable4">
							<div ><img  class="radious" width="90px" height="60px" src="" alt=""></div>
							<div id="place-time">
								곽지해수욕장
								<br>
								10:00~11:00
							</div>
						</div>
						<div id="timetable5">
							<div ><img  class="radious" width="90px" height="60px" src="" alt=""></div>
							<div id="place-time">
								곽지해수욕장
								<br>
								10:00~11:00
							</div>
						</div>
						<div class="not-schedule">
							<div>
								<i class="fa-solid fa-circle-info fa-lg" style="color: #878787;"></i>일정이 없습니다.
							</div>
						</div>
		
					</div>
					
				</div>
		
			</div>	
		</div>
		
		
	
	
		
	
		
	
	</main>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
	
</body>
</html>