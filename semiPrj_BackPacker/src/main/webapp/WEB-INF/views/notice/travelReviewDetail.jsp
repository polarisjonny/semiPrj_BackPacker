<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
		overflow-x :hidden;	
	}
    * {
        margin: 0px;
        padding: 0px;
    }
	main {
		width: 100vw;
		margin-top: 66px;
	}
	
	#mainReviewImg > img{
		width:100vw;
		height:300px;
	}
	
	#notice-title > div{
		text-align:center;
		font-size: 1.8em;
	}
	
	#notice-write{
		display:flex;
		justify-content : space-between;
		margin-bottom:10px;
		
	}
	
	#notice-writer{
		display:flex;
		margin-left:185px;
		align-items:flex-end;
	}
	
	#date-hit{
		display:flex;
		margin-right:185px;
		align-items:flex-end;
	}
	
	.hr{
		margin:auto;
		width:75vw;
	}
	
	#notice-content-area{
		height:900px;
		width:100%;
		text-align:center;
	}
	
	#notice-content{
		font-size:1.2em;
		line-height:40px;
		white-space: pre-wrap;
		margin-right:200px;
	}
	
	#notice-content > img{
		width:100%;
		height:200px;
	}
	
	#profile-img{
		border-radius: 70%;
	}
	
	#buttons{
		display : flex;
		align-items:center;
		justify-content: space-around;
	}
	
	#review-btn > button{
		border-radius: 10px;
        border: 1px solid #99ccff;
        background-color:  #99ccff;
        color:white;
        padding:10px;
        margin:0px 10px 10px;
	}
	
	span > button {
		border-radius: 10px;
        border: 1px solid #99ccff;
        background-color:  #99ccff;
        color:white;
        padding:10px;
        margin:0px 10px 10px;
	}
	
	#reply-area{
		display:grid;
		grid-template-columns: 5fr 1fr;
		margin : auto;
		width:63%;
		margin-bottom:20px;
		margin-top: 20px;
	}
	
	#reply-area button{
		border-radius: 10px;
		border:1px solid #99ccff;
		background-color:  #99ccff;
        color:white;
        margin:0px 10px 0px;
	}
	
	#reply-area textarea{
		border-radius: 7px;
		border:1px solid lightgray;
	}
	
	.comment {
		font-size: 15px;
		display: grid;
		grid-template-columns : 0.7fr 6.8fr;
	}
	
	.comment-list-id {
		font-weight: 1000;
		color: gray;
	}

	#comment-list-area{
		margin-right: 10px;
		position: relative;
		left: 18%;
		margin-bottom: 20px;
		width: 500px;
	}

	
	.list-profile {
		width: 50px;
		height: 50px;
		border-radius: 70%;
		margin-right: 20px;
	}

	.comment-del{
		border-radius: 7px;
		border:1px solid #99ccff;
		background-color:  #99ccff;
		color: white;
		
	}

	
</style>
</head>
<body>

		<%@ include file="/WEB-INF/views/common/header.jsp" %>
	    
		<main>
		
		<c:if test="${empty vo.changeName}">
			<div id="mainReviewImg">
			<img src="${root}/static/img/travelReview/travelReviewMain.jpg">
			</div>
		</c:if>
		
	<c:if test="${not empty vo.changeName }">
		<div id="mainReviewImg">
			<img src="${root}/static/img/travelReview/${vo.changeName}">
		</div>
	</c:if>
			<input type="hidden" name="infoNo" value="${vo.infoNo }">
			<br>
			<br>
			<div id="notice-title">
				<div>${vo.title}</div> <!-- 게시글 제목 -->
			</div>
			
			<br>
			
			<div id="notice-write">
				<div id="notice-writer">
					<c:if test="${empty vo.profileImage }">
					<img width="50px" height="50px" id="profile-img" src="${root}/static/img/member/profile/profile_default.jpg">
					</c:if>
					
					<c:if test="${not empty vo.profileImage}">
						<img width="50px" height="50px" id="profile-img" src="${root}/static/img/member/profile/${vo.profileImage}">
					</c:if>
					<div>&nbsp;&nbsp;&nbsp;&nbsp;${vo.writerNick}</div>
				</div>
				
				<div id="date-hit">
					<div>날짜 : ${vo.enrollDate }</div>
					<div>&nbsp;&nbsp;&nbsp;&nbsp;조회수 : ${vo.hit }</div>
				</div>
			</div>
			
			<hr class="hr">
			
			<br>
			
			<div id="notice-content-area">
			
				${vo.content}
			</div>
			
			
			
			<div id="buttons">
				
				<c:if test="${loginMember.id == 'ADMIN' || loginMember.id == vo.writerId}">
					<span id="review-btn">
						<button class="edit-btn">수정하기</button>
						<button onclick="reviewDelete();">삭제하기</button>
						
					</span>
					
					
				</c:if>
				
				<span>
					<c:if test="${not empty loginMember }">
						<button class="report-btn disable-btn">신고하기</button>
					</c:if>
					<button onclick="history.back();">목록으로</button>
				</span>
			</div>
			
			<div id="reply-area">
				
				<c:if test="${not empty loginMember}">
					
					<textarea name="content" style="resize:none;" placeholder="댓글은 50자 이내로 작성해주세요"></textarea>
					<button onclick="writeReply();">댓글작성</button>
				</c:if>
				
			</div>

			<div id="comment-list-area">

			</div>
			
			<%@ include file="/WEB-INF/views/common/footer.jsp" %>
		</main>

		<script>

			//후기삭제
			function reviewDelete(params) {
				const result = confirm('게시글을 삭제 할까요?');

				if(!result){
					return;
				}

				location.href='${root}/notice/reviewDelete?infoNo='+'${vo.infoNo}';

			}

			//신고하기
			const report = document.querySelector('.report-btn');
			report.addEventListener('click' , function(params) {
				const no = '${vo.infoNo}'
				const width = 800;
				const height = 1000;
				const left = (screen.width/2) - (width/2);
				const top = 0;
				window.open('${root}/notice/report?infoNo='+no ,'', 'width=' + width + ', height=' + height + ', left=' + left + ', top=' + top )
			});
			
			//자기자신이 신고못하게
			const disableBtn = document.querySelector(".disable-btn");
			if('${loginMember.memberNo}' == '${vo.writerNo}'){
				disableBtn.disabled = true;
			}

			

			//댓글 작성
			function writeReply(params) {
				const content = document.querySelector('textarea[name=content]').value;
				$.ajax({

					url : '${root}/notice/replyWrite',
					type : 'post',
					data : {
						infoNo : '${vo.infoNo}',
						content : content,
					},
					success : function (x) {
						if(x=='ok'){
							alert('댓글 작성이 완료되었습니다.');
							document.querySelector('textarea[name=content]').value = '';
							loadComment();
						}
					},
					error : function (e) {
						alert(e+"댓글 작성 실패");
					},
				});

			}

			// const replyList = document.querySelector('#replyList');
			// replyList.addEventListener('click' , function (params) {
			// 	const no ='${vo.infoNo}'
			// 	const width = 800;
			// 	const height = 1000;
			// 	const left = (screen.width/2) - (width/2);
			// 	const top = 0;
			// 	window.open('${root}/notice/replyList?infoNo='+no ,'', 'width=' + width + ', height=' + height + ', left=' + left + ', top=' + top )

				
			// });

			

			//댓글 보여주기
			function loadComment(){
			$.ajax({
				url : '${root}/notice/replyList',
				type: "GET" ,
				data : {
					infoNo : '${vo.infoNo}'
				},
				success : function(data){
					const x  = JSON.parse(data);
					const commentArea = document.querySelector("#comment-list-area");
					commentArea.innerHTML = "";
					let str = "";
					for(let i=0; i<x.length; i++){
						str+='<div class="comment">';
						if(x[i].profileImage == null){
							str+='<div><img class="list-profile" src="${root}/static/img/member/profile/profile_default.jpg" alt=""></div>';
						}else{
							str+='<div><img class="list-profile" src="${root}/static/img/member/profile/'+x[i].profileImage+'" alt=""></div>';
						}
						str+='<div class="comment-list-text"><input type="hidden" value="'+x[i].infoNo+'">';
						str+='<div class="comment-list-id">'+x[i].writerNick+'</div>';
						str+='<div class="comment-list-content">'+x[i].content+'</div>';
						str+='<div class="comment-list-day">'+x[i].enrollDate;
						if('${loginMember.memberNo}'==x[i].writerNo){
							str+='<button class="comment-del" onclick="delComment('+x[i].replyNo+');">삭제</button>'
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

		loadComment();
		//댓글삭제
		function delComment(replyNo) {
			const result = confirm('댓글을 삭제할까요?');

			if(result){
				$.ajax({
					url : '${root}/notice/delete',
					type : 'post',
					data : {
						replyNo : replyNo
					},
					success : function (data) {
						
						if(data == 'ok'){
							alert('삭제되었습니다.')
							loadComment();
						}
					},
					error : function (e) {
						alert(e+'댓글삭제 실패');
					},
	
				});

			};
			
		}
			
			//게시글 수정
			const editBtn = document.querySelector('.edit-btn');
			editBtn.addEventListener('click' , function (params) {
				const no ='${vo.infoNo}'
				const width = 800;
				const height = 1000;
				const left = (screen.width/2) - (width/2);
				const top = 0;
				window.open('${root}/notice/reviewEdit?infoNo='+no ,'', 'width=' + width + ', height=' + height + ', left=' + left + ', top=' + top )
				
			});
		

		</script>
	
		

</body>
</html>