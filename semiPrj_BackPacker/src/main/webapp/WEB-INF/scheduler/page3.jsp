<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>

.scheduler{
	width: 400px;
	height: 290px;
	border: 1px solid gray;
	
}
.timetable{
	display: grid;
	grid-template-columns: 1fr 1fr 1fr;
	grid-row: 1fr 1fr;
	margin-top: 20px;
	justify-items: center;
}
#trip-date {
    text-align: center; /* 가운데 정렬 */
    margin-top: 10px; /* 상단 여백 */
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
	margin: 0 auto;
	
}

#board{
	margin-top: 100px;
}

	
</style>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<main>
	<div class="text">
		<h1>일정표가 완성되었어요!</h1>
		<h6>완성된 일정표는 마이페이에 자동으로 저장되어 다시 볼 수 있습니다</h6>

	</div>

	<div align:center; id="scheduler-area">
		
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
				<div id="timetable6">
					<div class="text"><h6>저장된일정이없습니다</h6></div>
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
				<div id="timetable6">
					<div class="text"><h6>저장된일정이없습니다</h6></div>
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
				<div id="timetable6">
					<div class="text"><h6>저장된일정이없습니다</h6></div>
				</div>

			</div>
			
		</div>

	</div>	
	
	


	<div id="board" class="text">
		<div><h3>게시글 작성 할까요?</h3></div>
		
		<input type="checkbox" name="" id=""> 일정표를 참조하여 동행구하기
		<br><br>
		<input type="checkbox" name="" id=""> 일정표를 참조하여 프패커구하기
		<br><br>
		<input type="checkbox" name="" id=""> 일정표를 참조하여 백패커구하기

	</div>

	<div>
		<input type="text">
		




	</div>
	
	
	</main>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>

</body>
</html>