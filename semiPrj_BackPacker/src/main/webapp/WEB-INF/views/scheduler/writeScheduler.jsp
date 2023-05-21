<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		height: 300px;
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
	
</style>
<body>

	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	
	<main>
		<div id="wrap">

			<div class="text">
				<h1>일정표가 완성되었어요!</h1>
				<h6>완성된 일정표는 마이페이에 자동으로 저장되어 다시 볼 수 있습니다</h6>
		
			</div>

			

			<div  id="scheduler-area">

			<c:set var="firstTimetable" value="${timetableVo[0]}" />
			<c:set var="endValue" value="${firstTimetable.totalDate}" />

			<c:forEach begin="1" end="${endValue}" var="index">
				
					
					<div class="scheduler radious">
						<div id="trip-date">
							DAY${index}   
						</div>
			
						<div class="timetable">
							<c:forEach  items="${timetableVo}" var="item" >
								<c:if test="${index == item.timetableDate}">
									<div id="timetable1">
										<div ><img  class="radious" width="90px" height="60px" src="" alt=""></div>
										<div id="place-time">
											${item.placeNo}
											<br>
											10:00~11:00
										</div>
									</div>
								</c:if>


							</c:forEach>
							
							
							<div class="not-schedule">
								<div>
									<i class="fa-solid fa-circle-info fa-lg" style="color: #878787;"></i>일정이 없습니다.
								</div>
							</div>
			
						</div>
						
						
						
					</div>	
				</c:forEach>
				
			</div>

		
		</div>
		
		
	
	
		<div id="board" class="text">

			<form action="/semi/schedulerwrite" method="post">
				<div><h2>게시글 작성 할까요?</h2></div>
				<input type="hidden" name="schedulerNo" value="${firstTimetable.schedulerNo}">
				
				<div id="check">
	
					<select name="category" id="select">
						<option value="3">일정표를 참조하여 동행구하기</option>
						<option value="2">일정표를 참조하여 프패커구하기</option>
						<option value="1">일정표를 참조하여 백패커구하기</option>
					</select>
	
				</div>

				<div>
					<input type="text" id="title" name="title" placeholder="제목을 20자 이내로 적어주세요.">
				</div>
				<div id="file-area">
					<label id="infoLabel" for="imgFile" name="f"><div id="ment">썸네일 올리기</div></label>
					<input type="file" id="imgFile">

				</div>
	
				<div>
					<h3 style="padding:20px">
						게시글 내용을 작성해주세요
					</h3>
				</div>

				<div>
					<textarea name="content" id="" cols="70" rows="20" 
					placeholder=
					"1.구할 동행인원
					
					

2.어떤 동행을 찾고있나요?



3.어떤 여행을 원하시나요?



(1000자 이내)"
					></textarea>

				</div>
		
				<button id="btnstyle" type="submit">작성하기</button>

			</form>
		</div>
	
		
	
	</main>
	
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>

</body>
</html>