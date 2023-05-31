<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이 페이지 스케줄 리스트 페이지</title>
<style>
		#title {
			margin-top: 10%;
			color: #94d2e6;
			font-weight: bold;
		}

        #wrap {
            display: grid;
            grid-template-columns: 2fr 5fr 2fr;

        }


        .schedule-area-img {
            width: 100%;
            height: 300px;
            box-sizing: border-box;
        }

        .schedule-area-style {
            border: 1px solid black;
        }

        #first-schedule-area, #second-schedule-area, #third-schedule-area {
            
            width: 100%;
            height: 300px;
            display: grid;
            grid-template-columns: 1fr 1fr;
            margin-bottom: 10%;
            cursor: pointer;
        }

        #second-area {
            margin-left: 20%;
            display: flex;
            flex-direction: column;
            justify-content: space-around;
        }
        
        .blue-text {
            color: #94d2e6;
            font-size: 15px;
        }

        .normal-text {
            font-size: 20px;
        }
    </style>

</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	 <div id="wrap">
        <div id="blank-one"></div>
        <div id="main-box">
            <h1 id="title">저장한 일정 다시보기</h1>
            <hr>
            <br>
<%--             <c:forEach items="${scheduleMap}" var="map">
            	<div class="schedule-area-style" id="first-schedule-area">
            	
                <div id="first-area">
                    <img class="schedule-area-img" src="${root}/img/place/airplane.jpg" alt="여행지 사진">
                </div>
                <div id="second-area">
                    <div id="place">
                        <div class="blue-text">여행지</div>
                        <div class="normal-text">${map.countryName}</div>
                    </div>

                    <div id="">
                        <div class="blue-text">여행 일정</div>
                        <div class="normal-text">${map.startDate - map.endDate}</div>
                    </div>
                </div>
            </div>
            </c:forEach>
 --%>            
			<c:if test="${not empty scheduleMap}">
				<c:forEach items="${scheduleMap}" var="entry">
                <div class="schedule-area-style" id="first-schedule-area">
                    <div id="first-area" onclick="location.href='${root}/member/myPage/schedule/detail?schedulerNo='+${entry.value.schedulerNo}">
                        <img class="schedule-area-img" src="${root}/static/img/place/airplane.jpg" alt="여행지 사진">
                    </div>
                    <div id="second-area">
                        <div id="place">
                            <div class="blue-text">여행지</div>
                            <div class="normal-text">${entry.value.countryName}</div>
                        </div>
                        <div>
                            <div class="blue-text">여행 일정</div>
                            <div class="normal-text">${entry.value.startDate} ~ ${entry.value.endDate}</div>
                        </div>
                    </div>
                </div>
            </c:forEach>
			</c:if>
			
			<c:if test="${empty scheduleMap}">
				<div style="height: 60vh; display: flex; flex-direction: column;">
				</div>
			</c:if>
			 
			
			
            <!-- <div class="schedule-area-style"  id="second-schedule-area">
                <div id="first-area">
                    <img class="schedule-area-img" src="/paris.jfif" alt="여행지 사진">
                </div>
                <div id="second-area">
                    <div id="place">
                        <div class="blue-text">여행지</div>
                        <div class="normal-text">오사카</div>
                    </div>

                    <div id="">
                        <div class="blue-text">여행 일정</div>
                        <div class="normal-text">2023.04.20 - 2023.04.23</div>
                    </div>

                    <div>
                        <div class="blue-text">여행 경비</div>
                        <div class="normal-text">250,000</div>
                    </div>
                </div>
                
            </div>
 -->
           <!--  <div class="schedule-area-style"  id="third-schedule-area">
                <div id="first-area">
                    <img class="schedule-area-img" src="/paris.jfif" alt="여행지 사진">
                </div>
                <div id="second-area">
                    <div id="place">
                        <div class="blue-text">여행지</div>
                        <div class="normal-text">오사카</div>
                    </div>

                    <div id="">
                        <div class="blue-text">여행 일정</div>
                        <div class="normal-text">2023.04.20 - 2023.04.23</div>
                    </div>

                    <div>
                        <div class="blue-text">여행 경비</div>
                        <div class="normal-text">250,000</div>
                    </div>
                </div>
            </div> -->
            
            
        </div>
        <div id="blank-two"></div>
    </div>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>