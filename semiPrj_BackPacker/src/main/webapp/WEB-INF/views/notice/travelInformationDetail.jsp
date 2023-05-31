<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<!-- alert창 꾸미기 -->
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
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
		width:100%;
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
		border-radius : 70%;
	}
	
	#review-btn{
		display : flex;
		align-items: center;
		justify-content:center;
	}
	
	#review-btn > button{
		border-radius: 10px;
        border: 1px solid #94d2e6;
        background-color:  #94d2e6;
        color:white;
        padding:10px;
        margin:0px 10px 10px;
	}

	.note-editor{
		margin: auto;
	}
	
</style>
</head>
<body>

		<%@ include file="/WEB-INF/views/common/header.jsp" %>
	
		<main>
		
		<c:if test="${empty vo.changeName }">
			<div id="mainReviewImg">
			<img src="${root}/static/img/travelInformation/travelInfoMain.jpg">
			</div>
		</c:if>
		
		<c:if test="${not empty vo.changeName }">
			<div id="mainReviewImg">
			<img src="${root}/static/img/travelInformation/${vo.changeName}">
			</div>
		</c:if>

			
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
			
					<textarea id="summernote" style="resize:none;">${vo.content}</textarea>
				
			</div>
			
			<div id="review-btn">
				<c:if test="${loginMember.id == 'ADMIN' }">
					<button onclick="del();">삭제하기</button>
				</c:if>
					<button onclick="history.back();">목록으로</button>
			</div>
		
<!-- 썸머노트 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
		</main>
	
		<%@ include file="/WEB-INF/views/common/footer.jsp" %>
		

		<script>

			$('#summernote').summernote({
	    	  placeholder: 'Hello stand alone ui',
	    	  tabsize: 2,
	    	  height: 800,
			  width: 800,
	    	  callbacks : {
	            } ,
	    	  toolbar: [
	    	    
	    	  ]
	    	});

			function del(params) {
				
				const result = confirm('게시글을 삭제할까요 ?')

				if(result){
					location.href = "${root}/notice/informationDelete?infoNo="+'${vo.infoNo}'
					Swal.fire({
						title : '게시글을 삭제하였습니다.',
						icon: 'success',
						text: '',
					})
				}

			}

		</script>

</body>
</html>