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

	#comment-write-area > button {
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
</style>
</head>
<body>
	<div id="wrap">
		<%@ include file="/WEB-INF/views/common/header.jsp" %>
	
		<main>
			<img src="${root}/static/img/main_big_img.jpg" alt="">
			<div id="main-box">
				<div id="blank1"></div>
				<div id="main-area">
					<div id="title">오르비스 같이 여행가실 동행한명 구해요.</div>
					<div id="introduce-area">
						<div class="bold-text">자기소개</div>
						<div class="content-text">
							저는 엘나스에 거주하고 있는 김밥이 좋더라입니다. 면허있구요 엘나스행 비행기표 있습니다. <br>
							저는 피아노를 전공했구요.. 프패커랑 가이드게시판 으음.. 모르겠습니다.. <br>
							안녕하세요. 여행다니는걸 🥰좋아하는 20대 여성입니다. 저는 차 운전하는거 좋아합니다. <br>
 							일본어 잘하구요.👌 일본에서 3년간 유학했던 유학생입니다. <br>

							저는 코골이 이갈이에 예민하구용 <br>
							벌레 잘 못잡습니다. 벌레는 살려둬야죠.. 🤣  <br>
							유럽쪽에 여행 많이 다녀보고 싶어요. <br>
							저는 사진찍는걸 좋아합니다. <br>

							예술공연 보러가는 것도 좋아해요 오케스트라 공연 보고싶어요 <br>

							술은 잘 못먹습니다 ㅠㅠ 주량은 소주 반잔 맥주 한병입니다!! <br>
						</div>
					</div>
					<div id="content-area">
						<div class="bold-text">게시글 내용</div>
						<div class="content-text">
							오르비스로 여행가실 30대 여성분 구합니다. 저도 여자구요, 저는 오르비스에 거주한적이 있어서 <br> 
							해당 지역의 언어 잘 합니다. 면허도 있구요 코콜이 안하시는분만 동행 신청하기를 눌러주세요 
						</div>
					</div>
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
					<div id="profile-box">
						 <div id="profile-area" class="profile">
							<img src="${root}/static/img/temp_profile.png" alt="">
						 </div>
						 <div id="info-box">
							<div id="blank-98"></div>
							<div id="id-area">
								<div id="name-area">김민규(manku07)</div>
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
						<textarea name="commentWrite" id="comment-area" cols="20" rows="2" placeholder="댓글은 50자 이내로 작성해주세요. &#10;상대방을 비방하는 댓글은 자제해주세요."></textarea>
						<button>댓글작성</button>
					</div>
					<div id="comment-list-area">
						<div class="comment">
							<div><img class="list-profile" src="${root}/static/img/profile2.jpg" alt=""></div>
							<div class="comment-list-text">
								<div class="comment-list-id">두둥탁</div>
								<div class="comment-list-content">ㅋㅋㅋㅋ라라라라ㅏ라라라라ㅏ라라라ㅏ라라라ㅏ랄와라라라라라라라라ㅏ라랄길어져라얍!ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋsidsidsid냥냥봍쿠라~ 스즈메의 문단속~ 바카나이떼~ ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ</div>
								<div class="comment-list-day">2023-04-25 13:00:03</div> 
							</div>
						</div>
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