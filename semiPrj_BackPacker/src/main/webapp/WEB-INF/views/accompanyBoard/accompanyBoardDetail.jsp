<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	/* 맨위 이미지  */
	main {
		height: 100%;
	}
	main > img{
		width: 100%;
		height: 400px;
		object-fit: cover;
	}

	/* 영역나누기 */
	#main-box {
		display: grid;
		grid-template-columns: 1.15fr 3fr 0.9fr 1.15fr;
		
	}
	
	/* main-area의 내용물이 가득차면 main-box의 길이에도 영향을 미치는지 */
	#main-box > div {
		height: 100%;
	}
	/* 폰트 관련 */
	.bold-text {
		font-weight: 600;
	}
	.big-text {
		font-size: 1.3em;
	}
	
	.middle-text {
		text-align: center;
	}
	/* shedule관련 */
	#shedule-box {
		border-radius: 30px;
		margin: auto;
		width: 60%;
		height: 450px;
		border: 1px solid #E7E6E6;
		box-shadow: 5px 5px 5px #878787;
	}

	#img-area {
		display: grid;
		grid-template-columns: 1fr 1fr 1fr;
		grid-template-rows: 1fr 1fr;
	}

	#img-area  > div{
		padding: 5px;
		width: 100%;
		height: 180px;
	}
	.shedule >img {
		width: 100%;
		height: 70%;
	}
	.shedule {
		font-size: 15px;
	}
	.not-shedule {
		display: flex;
		flex-direction: column;
		justify-content: center;
		align-items: center;
		color: #878787;
	}
	.blank999 {
		height: 44px;
		width: 100%;
	}
	/* 제목관련 */
	#title {
		margin-top: 10px;
		font-size: 30px;
		font-weight: 700;
		margin-bottom: 10px;
	}
	#introduce-area {
		margin-bottom: 30px;
	}
	/* 일정표 */
	#shedule-table {
		margin-top: 50px;
		margin-bottom: 10px;
	}
	

	#shedule-area{
		text-align: center;
		margin-top: 30px;
		margin-bottom: 100px;
	}

	#shedule-area > div:nth-child(2){
		margin-top: 10px;
	}

	/* 프로필 구역 레이아웃 이하 */
	/* 프로필 박스 그리드 2개로 나누어서 프로필 영역 관리하기 */
	#profile-box {
		display: grid;
		grid-template-columns: 1fr 9fr;
	}
	#profile-area > img {
		width: 104px;
		height: 104px;
		border-radius: 70%;
	}

	#info-box {
		margin-left: 10px;
		display: grid;
		grid-template-rows: 0.7fr 2.5fr 1fr;

	}
	#id-area {
		display: flex;
		justify-content: space-between;
		align-items: end;
	}
	#name-area {
		font-size: 38px;
		font-weight: 700;
	}
	/* 작은버튼 */

	.s-btn {
		width: 48px;
		height: 30px;
		border: none;
		border-radius: 5px;
		vertical-align: bottom;

	}
	.btn-blue {
		background-color: #94D2E6;
	}
	.btn-red{
		background-color: #F59393;
	}
	/* text-area */
	#comment-area {
		width: 99%;
		resize: none;
	}

	#comment-write-area > input[type=button] {
		width: 100%;
		height: 100%;
		border-radius: 5px;
		border: none;
	}
	#comment-write-area {
		margin-top: 20px;
		display: grid;
		grid-template-columns: 0.7fr 6fr 0.8fr;
		place-items: center;
		margin-bottom: 30px;
	}
	#comment-text {
		font-size: 30px;
		font-weight: 800;
	}
	
	#comment-write-area > textarea {
		width: 100%;
		height: 100%;
		
	}
	textarea {
		border-radius: 5px;
	}
	/* 큰버튼2개 연달아있는 에어리어 */
	
/* 버튼에어리어 안에 버튼 */
	
	#top-area > button{
		width: 100%;
		height: 80px;
		border: none;
		border-radius: 10px;
		margin-bottom: 10px;
		margin-top: 5px;
		font-size: 1.3em;
		font-weight: 900;
		color: white;
	}
	/*맨위로 가기 a태그 맨밑으로 넣는작업*/
	#sub-area {
		display: flex;
		flex-direction: column;
		justify-content: space-between;
	}
	
	
	/* 가장큰 프로필 사진 */
	#profile-box {
	
		margin-bottom: 20px;
	}
	/* ------------------------- */
	/* 댓글 리스트 영역 시작*/
	.comment {
		display: grid;
		grid-template-columns : 0.7fr 6.8fr;
		
	}
	
	.list-profile {
		width: 60px;
		height: 60px;
		border-radius: 70%;
		cursor: pointer;
	}
	.profile{
			cursor: pointer;
	}
	
	.comment > div:first-child {
		display: flex;
		justify-content: center;
		align-items: flex-start;
	}
	
	.comment-list-id {
		font-size: 17px;
		font-weight: 1000;
		color: gray;
	}
	/* 댓글 리스트 영역 끝 */
	
	/*상단에 마진주기*/
	#main-area{
		margin-top: 30px
	}
	
	#sub-area {
		margin-top: 70px
	}
	.content-text {
		width: 100%;
		height: 300px;
		border: none;
		outline: none;
	}
	/*  댓글 삭제버튼 */
	.comment-del {
		font-size: 13px;
		border-radius: 5px;
		border: none;
	}
	#button-area > a {
		color :black;
		text-decoration: none;
	}
	/* 그레이색찐하게 */
	.btn-gray {
		background-color: #B7B7B7;
	}
</style>
</head>
<body>
	<div id="wrap">
		<%@ include file="/WEB-INF/views/common/header.jsp" %>
	
		<main>
 	        <img class="middle-img" src="${root}/static/img/accompany/${gbvo.mainImg}" alt="">
			<div id="main-box">
				<div id="blank1"></div>
				<div id="main-area">
					<div>조회수 : ${gbvo.hit}</div>
					<div id="title">${gbvo.title}</div>
					<c:if test="${gbvo.matchingState=='Y'}">
						<h2>매칭 마감된 글입니다. 수정과 댓글작성이 불가</h2>
					</c:if>
					<div id="introduce-area">
						<div class="bold-text">자기소개</div>						
						<textarea class="content-text" readonly style="resize: none;">${writerMember.introMessage}</textarea>
					</div>
					<div id="content-area">
						<div class="bold-text">게시글 내용</div>
						<textarea class="content-text" readonly style="resize: none;">${gbvo.content}</textarea>
						
					</div>
				
					<c:if test="${not empty timetableVo}">
							<div id="shedule-area">
							
							    <div class="bold-text big-text">일정표</div>
							    
								<div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
					    			<c:set var="firstTimetable" value="${timetableVo[0]}" />
									<c:set var="endValue" value="${firstTimetable.totalDate}" />
								<div class="carousel-inner">
									
											<c:forEach begin="1" end="${endValue}" var="index">
								            <c:if test="${index == 1}">
												<div class="carousel-item active">
											</c:if>
											<c:if test="${index != 1}">
												<div class="carousel-item">
											</c:if>
								            <!-- 이미지 대신 shedule박스 넣기 -->
												<div id="shedule-box" class="d-block">
													<div class="big-text bold-text middle-text">DAY${index}</div>
													<div class="middle-text">2023-04-27(화)</div>
													<div id="img-area">
													
														<c:forEach items="${timetableVo}" var="item">
															<c:if test="${index == item.timetableDate}">
																<c:if test="${item.placeNo=='1'}">
																	<div class="shedule">
																		<img src="${root}/static/img/place/${item.placeImage}" alt="">
																		<div class="bold-text">${item.bespokePlace}</div>
																		<div class="content-text">시작시간 : ${item.timetableStartTime}</div>
																	</div>
																</c:if>
																<c:if test="${item.placeNo!='1'}">
																	<div class="shedule">
																		<img src="${root}/static/img/place/${item.placeImage}" alt="">
																		<div class="bold-text">${item.placeName}</div>
																		<div class="content-text">시작시간 : ${item.timetableStartTime}</div>
																	</div>
																</c:if>

															</c:if>
														</c:forEach>
														
													</div>
								                    
								                </div>
								                <!-- shedule박스끝  -->
								            </div>	
										</c:forEach>
									</div>
									<button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
										<span class="carousel-control-prev-icon" aria-hidden="true"></span>
										<span class="visually-hidden">Previous</span>
									</button>
									<button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
										<span class="carousel-control-next-icon" aria-hidden="true"></span>
										<span class="visually-hidden">Next</span>
									</button>
								</div>



						
							     </div>
					</c:if>
					
					
					
					
					<div id="profile-box">
						 <input type="hidden" value="${writerMember.memberNo}">
						 <div id="profile-area" class="profile" onclick="goProfile(${writerMember.memberNo})">
						 	<c:if test="${not empty writerMember.profileImage}">
								<img class="imgToProfileWindow" src="${root}/static/img/member/profile/${writerMember.profileImage}" alt="">
						 	</c:if>
						 	<c:if test="${empty writerMember.profileImage}">
								<img class="imgToProfileWindow" src="${root}/static/img/member/profile/profile_default.jpg" alt="">
						 	</c:if>
						 </div>
						 <div id="info-box">
							<div id="blank-98"></div>
							<div id="id-area">
								<div id="name-area">${writerMember.nick}(${writerMember.id})</div>
								<div id="btn-area">
									<button class="s-btn btn-blue modify-btn">수정</button>
									<button class="s-btn btn-red" type="button" onclick="location.href='${root}/accompany/del?no=${gbvo.guideBoardNo}'">삭제</button>
									<script>
										const sBtn = document.querySelectorAll(".s-btn");
										if('${loginMember.memberNo}'!='${writerMember.memberNo}'){
											sBtn[0].style.display = 'none';
											sBtn[1].style.display = 'none';
											if('${loginMember.id}'=='ADMIN'){
												sBtn[0].style.display = 'none';
												sBtn[1].style.display = 'inline-block';
											}
										}
									</script>
								</div>
							</div>
							<div id="info-area">
								<i class="fa-solid fa-circle-info" style="color: #94D2E6;"></i>
								프로필을 눌러 거리점수와 후기들을 확인하세요
							</div>
						 </div>
					</div>
					<div id="comment-write-area">
						<div id="comment-text">댓글</div>
						<textarea name="comment" style="resize: none;" placeholder="댓글은 50자 이내로 작성해주세요. &#10;상대방을 비방하는 댓글은 자제해주세요."></textarea>
						<input type="button" value="댓글작성" onclick="writeComment();">
					</div>
					<div id="comment-list-area">
					</div>
				</div>
				
				<div id="sub-area">
					<div id="top-area">
						<div>
							<i class="fa-solid fa-circle-info fa-lg" style="color: #94D2E6;"></i>프로필을 눌러 거리점수를 확인하세요
						</div>
						<button class="btn-blue " id="openChat" onclick="openNewChatByUsersNo(${gbvo.guideBoardNo},${writerMember.memberNo},${loginMember.memberNo})">동행신청하기</button>
						<button class="btn-red report-btn disable-btn">게시글신고하기</button>
						<c:if test="${gbvo.matchingState=='O' && writerMember.memberNo==loginMember.memberNo}">
							<button class="btn-gray" type="button" onclick="location.href='${root}/accompany/finish?no=${gbvo.guideBoardNo}'">게시글 마감하기</button>
						</c:if>
						<script>
							const disableBtn = document.querySelectorAll(".disable-btn");
							const MemberId= '${loginMember.id}'; 
							const writerMember ='${writerMember.memberNo}';
							const memberNo = '${loginMember.memberNo}'
							console.log(writerMember);
							console.log(MemberId);
							if('${loginMember == null}' == 'true'){				
									disableBtn[0].disabled = true;

							}else {
								if(writerMember==memberNo||MemberId=="ADMIN"){
									disableBtn[0].disabled = true;	
									
								}else {
									disableBtn[0].disabled = false;
								}
							}
							
						</script>
					</div>
					<div id="botton-area">
						<a href="${root}/accompany/list?page=1">목록으로 돌아가기</a>
					</div>
				</div>
				<div id="blank2"></div>
			</div>
		</main>

		<%@ include file="/WEB-INF/views/common/footer.jsp" %>
	</div>
</body>
</html>

<script>

		
	

		function openNewChatByUsersNo(g,m,l){
			 const windowFeatures = `
				    width=370,
				    height=600,
				    left=(screen.width / 2) - 275,
				    top=0,
				    toolbar=no,
				    location=no,
				    status=no,
				    menubar=no,
				    resizable=no`;
				if(m==l){
					alert("내가쓴글은 채팅창 안됩니다")
				}else{
					
			 	const newWindow = window.open('${root}/chat/room/open?guideBoardNo='+g+'&writerNo='+m +'&type=new'+'&loginMemberNo='+l , '', windowFeatures);
				}
	        	
	    }
		
		
		
		
		loadComment();
		//댓글작성
		function writeComment(){
			const comment = document.querySelector("textarea[name=comment]").value;
			$.ajax({
				url : "${root}/accompany/reply/write",
				type : "POST",
				data : {
					accomNo : '${gbvo.guideBoardNo}',
					content : comment ,
				},
				success: (x)=>{
					console.log(x);
					if(x == 'ok'){
						alert("댓글작성 성공!");
						document.querySelector("textarea[name=comment]").value='';
						loadComment();
					}else if (x=='no'){
						alert("매칭마감됨. 댓글작성불가");
					}else if (x=='empty'){
						alert("내용을 입력해주세요.");
					}else {
						alert('댓글작성실패...');
					}
				},
				error: ()=>{
					console.log("댓글작성실패...");
				} ,
			});
		}
	

		//댓글삭제
		function delComment(guideReplyNo){
			$.ajax({
				url: "${root}/accompany/reply/delete",
				type: "post",
				data : {
					replyNo : guideReplyNo,
					boardNo : '${gbvo.guideBoardNo}'
				},
				success : (x)=>{
					if(x=='ok'){
						alert('댓글삭제성공!');
						loadComment();
					}else if(x=='finished'){
						alert('마감된 글입니다. 댓글 삭제 불가합니다.');
					}else {
						alert('댓글작성실패...');
					}
				},
				error: ()=>{
					console.log("댓글작성실패...통신에러");
				},
			});
		}
		
		//댓글불러오기
		
		
		//다 가져와서 비저블리티를 기본적으로 안보이게 수정
		function loadComment(){
			$.ajax({
				url : '${root}/accompany/reply/list',
				type: "GET" ,
				data : {
					accomNo : '${gbvo.guideBoardNo}'
				},
				success : function(data){
					const x  = JSON.parse(data);
					console.log(x);
					const commentArea = document.querySelector("#comment-list-area");
					commentArea.innerHTML="";
					let str = "";
					for(let i=0; i<x.length; i++){
						str+='<div class="comment">';

						if(x[i].profile==null||x[i].profile==""){
							str+='<div><img class="list-profile" src="${root}/static/img/member/profile/profile_default.jpg" alt="" onclick="goProfile('+x[i].writerNo+')"></div>';
						}else {
							str+='<div><img class="list-profile" src="${root}/static/img/member/profile/'+x[i].profile+'" alt="" onclick="goProfile('+x[i].writerNo+')"></div>';
						}
						str+='<div class="comment-list-text"><input type="hidden" value="'+x[i].guideBoardNo+'">';
						str+='<div class="comment-list-id">'+x[i].nick+'</div>';
						str+='<div class="comment-list-content">'+x[i].content+'</div>';
						str+='<div class="comment-list-day">'+x[i].enrollDate;
						if('${loginMember.memberNo}'==x[i].writerNo){
							str+='<button class="comment-del" onclick="delComment('+x[i].guideReplyNo+');">삭제</button>'
						}
						str+='</div>';
						str+='</div>';
						str+='</div>';
					}
					commentArea.innerHTML+=str;
				},
				error : function(e){
					console.log(e);
				},

			});
		}
		let modifyBtn = document.querySelector('.modify-btn');
		modifyBtn.addEventListener('click',f01);
		
		function f01(){
			
			const no = '${gbvo.guideBoardNo}'
			const width =800;
			const height=1000;
			const left = (screen.width/2)-(width/2);
			const top = 0;
			if('${gbvo.matchingState}' != 'Y'){
				window.open('${root}/accompany/modify?boardNo='+no,'', 'width=' + width + ', height=' + height + ', left=' + left + ', top=' + top);
				
			}else {
				alert('마감된 글입니다. 수정이 불가합니다.');
			}
			
			
		}
		
		let reportBtn = document.querySelector('.report-btn');
		reportBtn.addEventListener('click',function(){
			const no = '${gbvo.guideBoardNo}'
			const width =800;
			const height=1000;
			const left = (screen.width/2)-(width/2);
			const top = 0;
			window.open('${root}/accompany/report?boardNo='+no,'', 'width=' + width + ', height=' + height + ', left=' + left + ', top=' + top);
		});

</script>