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
		object-fit: none;
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
		margin-top: 30px
	}
	.content-text {
		width: 100%;
		height: 300px;
		border: none;
		outline: none;
	}
</style>
</head>
<body>
	<div id="wrap">
		<%@ include file="/WEB-INF/views/common/header.jsp" %>
	
		<main>
 	        <img class="middle-img" src="${root}/static/img/accompany/${gbvo.mainImg}" alt="">
			<%-- <img src="${root}/static/img/main_big_img.jpg" alt=""> --%>
			<div id="main-box">
				<div id="blank1"></div>
				<div id="main-area">
					<div id="title">${gbvo.title}</div>
					<div id="introduce-area">
						<div class="bold-text">자기소개</div>						
						<textarea class="content-text" readonly style="resize: none;">${writerMember.introMessage}</textarea>
					</div>
					<div id="content-area">
						<div class="bold-text">게시글 내용</div>
						<textarea class="content-text" readonly style="resize: none;">${gbvo.content}</textarea>
						
					</div>
				
					<c:if test="${not empty tvo}">
					<div id="shedule-area">
						<div class="bold-text big-text">일정표</div>
						<div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="true">
							<div class="carousel-indicators">
							  <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
							  <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
							  <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
							</div>
							<div class="carousel-inner">
							  <div class="carousel-item active">
								<!-- 이미지 대신 shedule박스 넣기 -->
								<div id="shedule-box" class="d-block">
									<div class="big-text bold-text middle-text">DAY1</div>
									<div class="middle-text">2023-04-27(화)</div>
									<div id="img-area">
										<div class="shedule">
											<img src="${root}/static/img/shedule.jpg" alt="">
											<div class="bold-text">하남벛꽃축제</div>
											<div class="content-text">10:00~11:00</div>
										</div>
					 					<div class="shedule">
											<img src="${root}/static/img/shedule.jpg" alt="">
											<div class="bold-text">하남벛꽃축제</div>
											<div class="content-text">10:00~11:00</div>
										</div>
										<div class="shedule">
											<img src="${root}/static/img/shedule.jpg" alt="">
											<div class="bold-text">하남벛꽃축제</div>
											<div class="content-text">10:00~11:00</div>
										</div>
										<div class="shedule">
											<img src="${root}/static/img/shedule.jpg" alt="">
											<div class="bold-text">하남벛꽃축제</div>
											<div class="content-text">10:00~11:00</div>
										</div>
										<div class="shedule">
											<img src="${root}/static/img/shedule.jpg" alt="">
											<div class="bold-text">하남벛꽃축제</div>
											<div class="content-text">10:00~11:00</div>
										</div>
										<!-- 없을때는 아래와 같이 만듦 -->
										<div class="not-shedule">
											<div>
												<i class="fa-solid fa-circle-info fa-lg" style="color: #878787;"></i>일정이 없습니다.
											</div>
											<div class="blank999"></div>
										</div>
									</div>
									<!-- shedule박스끝  -->
								</div>	
							  </div>
							  <div class="carousel-item">
									<!-- 이미지 대신 shedule박스 넣기 -->
									<div id="shedule-box" class="d-block">
										<div class="big-text bold-text middle-text">DAY2</div>
										<div class="middle-text">2023-04-27(화)</div>
										<div id="img-area">
											<div class="shedule">
												<img src="${root}/static/img/shedule.jpg" alt="">
												<div class="bold-text">하남벛꽃축제</div>
												<div class="content-text">10:00~11:00</div>
											</div>
											<div class="shedule">
												<img src="${root}/static/img/shedule.jpg" alt="">
												<div class="bold-text">하남벛꽃축제</div>
												<div class="content-text">10:00~11:00</div>
											</div>
											<div class="shedule">
												<img src="${root}/static/img/shedule.jpg" alt="">
												<div class="bold-text">하남벛꽃축제</div>
												<div class="content-text">10:00~11:00</div>
											</div>
											<div class="shedule">
												<img src="${root}/static/img/shedule.jpg" alt="">
												<div class="bold-text">하남벛꽃축제</div>
												<div class="content-text">10:00~11:00</div>
											</div>
											<div class="shedule">
												<img src="${root}/static/img/shedule.jpg" alt="">
												<div class="bold-text">하남벛꽃축제</div>
												<div class="content-text">10:00~11:00</div>
											</div>
											<!-- 없을때는 아래와 같이 만듦 -->
											<div class="not-shedule">
												<div>
													<i class="fa-solid fa-circle-info fa-lg" style="color: #878787;"></i>일정이 없습니다.
												</div>
												<div class="blank999"></div>
											</div>
										</div>
										<!-- shedule박스끝  -->
									</div>
							  </div>
							  <div class="carousel-item">
									<!-- 이미지 대신 shedule박스 넣기 -->
									<div id="shedule-box" class="d-block">
										<div class="big-text bold-text middle-text">DAY3</div>
										<div class="middle-text">2023-04-27(화)</div>
										<div id="img-area">
											<div class="shedule">
												<img src="${root}/static/img/shedule.jpg" alt="">
												<div class="bold-text">하남벛꽃축제</div>
												<div class="content-text">10:00~11:00</div>
											</div>
											<div class="shedule">
												<img src="${root}/static/img/shedule.jpg" alt="">
												<div class="bold-text">하남벛꽃축제</div>
												<div class="content-text">10:00~11:00</div>
											</div>
											<div class="shedule">
												<img src="${root}/static/img/shedule.jpg" alt="">
												<div class="bold-text">하남벛꽃축제</div>
												<div class="content-text">10:00~11:00</div>
											</div>
											<div class="shedule">
												<img src="${root}/static/img/shedule.jpg" alt="">
												<div class="bold-text">하남벛꽃축제</div>
												<div class="content-text">10:00~11:00</div>
											</div>
											<div class="shedule">
												<img src="${root}/static/img/shedule.jpg" alt="">
												<div class="bold-text">하남벛꽃축제</div>
												<div class="content-text">10:00~11:00</div>
											</div>
											<!-- 없을때는 아래와 같이 만듦 -->
											<div class="not-shedule">
												<div>
													<i class="fa-solid fa-circle-info fa-lg" style="color: #878787;"></i>일정이 없습니다.
												</div>
												<div class="blank999"></div>
											</div>
										</div>
										<!-- shedule박스끝  -->
									</div>
							  </div>
							</div>
							<button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
							  <span class="carousel-control-prev-icon" aria-hidden="true"></span>
							  <span class="visually-hidden">Previous</span>
							</button>
							<button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
							  <span class="carousel-control-next-icon" aria-hidden="true"></span>
							  <span class="visually-hidden">Next</span>
							</button>
						  </div>
					</div>
					</c:if>
					<div id="profile-box">
						 <div id="profile-area" class="profile">
							<img src="${root}/static/img/member/profile/${writerMember.profileImage}" alt="">
						 </div>
						 <div id="info-box">
							<div id="blank-98"></div>
							<div id="id-area">
								<div id="name-area">${writerMember.nick}(${writerMember.id})</div>
								<div id="btn-area">
									<button class="s-btn btn-blue">수정</button>
									<button class="s-btn btn-red">삭제</button>
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
						<button class="btn-blue">동행신청하기</button>
						<button class="btn-red">게시글신고하기</button>
					</div>
					<div id="bottom-area">
						<a href="#">▲맨위로 올라가기</a>
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
					}else {
						alert('댓글작성실패...');
					}
				},
				error: ()=>{
					console.log("댓글작성실패...");
				} ,
			});
		}



		function loadComment(){
			$.ajax({
				url : '${root}/accompany/reply/list',
				type: "GET" ,
				data : {
					accomNo : '${gbvo.guideBoardNo}'
				},
				success : function(data){
					const x  = JSON.parse(data);
					const commentArea = document.querySelector("#comment-list-area");
					commentArea.innerHTML="";
					let str = "";
					for(let i=0; i<x.length; i++){
						str+='<div class="comment">';
						str+='<div><img class="list-profile" src="${root}/static/img/member/profile/'+x[i].profile+'" alt=""></div>';
						str+='<div class="comment-list-text">';
						str+='<div class="comment-list-id">'+x[i].nick+'</div>';
						str+='<div class="comment-list-content">'+x[i].content+'</div>';
						str+='<div class="comment-list-day">'+x[i].enrollDate+'</div>'; 
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
	
		loadComment();
	
</script>