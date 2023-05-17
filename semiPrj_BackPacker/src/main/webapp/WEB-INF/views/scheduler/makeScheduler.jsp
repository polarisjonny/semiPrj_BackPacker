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
		display: none;
		flex-direction: column;
		flex-shrink: 0;
		padding: 20px;
		width: 100%;
		margin-top: 20px
		
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
		font-size: 0.8em;
	}

	#sc-img {
		margin-right: 10px;
	}

	#area {
		margin-left: 10px;
	}

	.time>input{
		width:80px;
		height: 23px;
	}
	.scheduler-date{
		text-align: center;
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
	
	#tripDate>input[name='daterange']{
		width: 194px;
	}


	#modal-area{
		width: 100vw;
		height: 100vh;
		position: fixed;
		z-index: 9999;
		top: 0;
		background-color: rgba(0, 0, 0, 0.5);
		top: 50%;
		left: 50%;
		transform: translate(-50%, -50%);
		display: none;
  		justify-content: center;
 		align-items: center;
	}
	#box{
		width: 55vw;
  		height: 40vh;
		background-color: white;
		display: grid;
		grid-template-columns: 60% 35% 5% ;
	}
	#modal-in{
		display: flex;
		padding: 10px;
		justify-content: center;
		flex-direction: column;

	}
	#modal-btn{
		display: flex;
   		flex-direction: column;
	}
	#modal-btn>button{
		border: 0px;
    	background-color: white;

	}
	#modal-tro{
		display: flex;
    	flex-direction: column;
	}
	#modal-tro>div{
		border: 1px solid gray;
		border-radius: 5px;
		height: 100px;
		overflow: auto;
  		word-wrap: break-word;
		padding: 5px;
		color: darkblue;

	}

	#over{
		overflow: auto;
    	height: 400px;
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
			<div id="scheduler-area">
			<div id="over">

				<div id="scheduler-date-area" >
					

				</div>
					<div id="test"></div>

					<%-- 여행지을 가져 왔을때 생성 --%>

					<div id="placejson">
					

					</div>
					
						
					
					
				
			</div>
				
				<button class="btnn" >일정저장하기</button>
			</div>
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
				
				<c:forEach items="${placeList}" var="place">
					<div id="place">
						<img id="place-img" src="" alt="">
						<div id="p-place">${place.placeName}</div>
						<div id="p-area">
							<div id="p-introduce"><i class="bi bi-info-circle" ></i></div>
							<div id="p-pick"><i class="bi bi-plus-circle" data-placeno="${place.placeNo}" ></i></div>
						</div>
					</div>
					<div id="modal-area" class="modal-area">
						<div id="box">
							<div id="modal-img">
								<img src="" alt="">
							</div>
							<div id="modal-in">
								<div id="modal-name" style="padding-bottom: 10px; font-size: large;">
									${place.placeName}
								</div>
								<div id="modal-tro">
									여행지소개
									<div>
										${place.placeIntroduce}
									</div>
								</div>
							</div>
							<div id="modal-btn">
								<button id="close" class="close">X</button>
							</div>
				
						</div>
					</div>
				</c:forEach>
					<script>
						var openModals = document.querySelectorAll('.bi-info-circle');
						var closeModals = document.querySelectorAll('.close');
						var modals = document.querySelectorAll('.modal-area');

						openModals.forEach(function(openModal, index) {
							openModal.addEventListener('click', function() {
							modals[index].style.display = 'flex';
							});
						});

						closeModals.forEach(function(closeModal, index) {
							closeModal.addEventListener('click', function() {
							modals[index].style.display = 'none';
							});
						});

					</script>
				
	           
	        </div>
	
	    </div>
	</div>

	
	
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
	
	
	</main>
	
	
	
	    <script defer>
			var startDate;
			var endDate;
			var pick =true;
			var intro = document.querySelector('#intro');
			

			
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
					ddd.innerHTML+="<input name='starDt' type='hidden' value='"+start.format('YYYY-MM-DD')+"'>"
					ddd.innerHTML+="<input type='hidden' value=''>"
					ddd.innerHTML+="<input type='button' id='maketimetable'  value='일정표 생성하기'>";
					
					$('#intro').hide();
					
					startDate = start.format('YYYY-MM-DD');
					endDate = end.format('YYYY-MM-DD');

					console.log(startDate);
					
					$('#maketimetable').on('click',function(){
						setScheduler();
						$('#maketimetable').hide();
						$('#scheduler-area').show();
						getScheduler();
					})
				});
				
				
				$('.bi-plus-circle').on('click', function () {
					setTimeTable($(this).data('placeno'));
					getTimetable();

				});
	        });
			
			/////////////////////////////////////////////////////////////
			function setScheduler(){

				$.ajax({
					type:'post',
					url: '${root}/schedulermake/setScheduler',
					data: { 
						startDate: startDate,
						endDate: endDate
					},
					success : function(x) { 
					},
					error : function(error) { 
						console.log(error)
					}
				});

			};
			function getScheduler(){

				$.ajax({
					type:'post',
					url: '${root}/schedulermake/getScheduler',
					data: { 
						startDate: startDate,
						memberNo:'1'
					},
					success : function(data) { 
						console.log(data);

						const x = JSON.parse(data);
						console.log(x);

						const sdiv = document.querySelector("#scheduler-date-area");
						sdiv.innerHTML="";

						let str="";
						for(let i =1 ; i<=x[0].totalDay; i++){
							str+='<div><a class="scheduler-date" href="">이전날</a></div>'
							str+='<div class="scheduler-date" ><h4> DAY'+i+'</h4></div>'
							str+='<div><a class="scheduler-date" href="">다음날</a></div>'
						}
						sdiv.innerHTML+=str;

					},
					error : function(error) { 
						console.log(error)
					}
				});

			};


			///////////////////////////////////////////////////////////////
			
			function setTimeTable(placeno){
				$.ajax({
					type:'post',
					url: '${root}/schedulermake/setTimetable',
					data: { 
						placeNo: placeno,
						schedulerNo: '5',
						timetableDate: startDate, //받아와야함 +1+1
						timetableStartTime : startDate 
					},
					success : function(data) { 
						console.log(data);
						
					},
					error : function(error) { 
						console.log(error)
					}
				});
				
			};
			
			function getTimetable(){
				$.ajax({
					url: '/semi/schedulermake/getTimetable',
					type:'GET',
					data: { 
						schedulerNo:'5',
					},
					success : function(data) { 
						console.log(data);

						const x = JSON.parse(data);
						console.log(x);

						const pdiv = document.querySelector("#placejson");
						pdiv.innerHTML="";

						let str="";
						for(let i =0 ; i<x.length ; i++){
							str+='<div id="scheduler-place-area">';
							str+='<div id="scheduler-place">';
							str+='	<img id="sc-img" height="80px" width="80px" src="" alt="">';
							str+=	'<div id="area">';
								str+=		'<div class="place">장소명 : '+x[i].placeName+' </div>';
								str+=		'<div class="time">소요시간 : <input type="text" value="'+x[i].placeTime+'">분</div>';
								str+=	'<div class="class-time">시작시간 : <input type="time" value="10:00"></div>';
								str+=	'</div>';
								str+=	'<div id="delete"><i class="bi bi-trash"></i></div>';
								str+= '</div>';
								str+='</div>';
						}
						pdiv.innerHTML+=str;





					},
					error : function(error) { 
						console.log(error)
					}
				});

			};

			

			///////////////////////////////////////////////////
			// function plusScheduler(){
			// 	$.ajax({
			// 		type:'post',
			// 		url: '${root}/schedulermake/plusTimetable',
			// 		data: { 
			// 			schedulerNo: '1',
			// 			timetableDate: startDate, //받아와야함
			// 		},
			// 		success : function(data) { 
			// 			console.log(data);
						
			// 		},
			// 		error : function(error) { 
			// 			console.log(error)
			// 		}
			// 	});

			// }
		

			

	
	        let map;
	
	        function initMap() {
	        map = new google.maps.Map(document.getElementById("map"), {
	            center: { lat: 33.4996213, lng:126.5311884},
	            zoom: 10,
	        });
	        }
	
	        window.initMap = initMap;

			function makeplace(){

			}
	
	        </script>

</body>
</html>