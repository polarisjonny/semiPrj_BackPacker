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
	
	#mainImg-area{
		position:relative;
	}
	
	#mainImg-area > img{
		width:100vw;
		height:300px;
	}

	#mainImg-text{
		position:absolute;
		top:30%;
		left:60%;
	}
	
	#mainImg-text > #img-text{
		font-size:2.5em;
	}
	
	.input-area > input{
        border-radius: 25px;
        width:280px;
        height:30px;
		border : 1px solid lightgray;
		padding-left:45px;
		margin-top:20px;
	}
	
	.input-area{
		position:relative;
	}
	
	.input-area > i{
  		position: absolute;
		top :9px;
		left: 20px;
		z-index: 1;
  	}
  	
  	#mainImg-area{
  		margin-bottom:50px;
  	}

	#main-content-title{
  		display:flex;
  		justify-content:center;
  		align-items:center;
		font-size: 2.5em;
		font-weight: bold;
		margin-bottom:20px;
	}
	
	#category-area{
	 border-radius: 20px;
        background-color: #94d2e6;
        border-color:#94d2e6;
        width: 150px;
        height:40px;
        text-align:center;
        font-size:18px;
        margin-bottom:20px;
		color: white;
	}
	
	#main-content{
		display:flex;
		align-items:center;
		justify-content:space-evenly;
		flex-wrap:wrap;
	}
	
	
	#input-area > input {
		width:110%;
		border: none;
		font-size:25px;
		border-bottom:1px solid lightgray;
		padding:10px;
	}
	
	#input-area > textarea{
		width:110%;
		border: 1px solid lightgray;
		font-size:25px;
		margin-top:20px;
		border-radius:9px;
		height:300px;
		padding:10px;
	}
	
	#input-area > textarea:focus , #input-area > input:focus{
		outline:none;
	}
	
	#submit-input{
		display:flex;
		justify-content:center;
		align-items:center;
	}
	
	#submit-input>input{
		border-radius: 10px;
        border: 1px solid #94d2e6;
        background-color:  #94d2e6;
        color:white;
        padding:15px;
        font-size:18px;
        margin-top:20px;
	}
	
  	
  	
</style>
</head>
<body>

		<%@ include file="/WEB-INF/views/common/header.jsp" %>
	
		<main>
		
		<div id="mainImg-area">
		
			<img alt="" src="${root}/static/img/inquiry/inquiry-main.jpg">
			
			<div id="mainImg-text">
				<div id="img-text">무엇을 도와드릴까요?</div>
				<!-- <span class="input-area">
		               	<i class="fa-solid fa-magnifying-glass fa-sm" style="color: #8c8c8c;"></i>
		               	<input type="text" placeholder="여행지로 검색">
	               </span> -->
			</div>
		
		</div>
		
		<div id="main-content-title"> 문의 작성</div>

			<div id="main-content">
				<form name="sub1" action="${root}/notice/inquiryWrite" method="post">
					
					<select id="category-area" name="categoryType">
						<option value="QNA">1:1 문의</option>
						<option value="service">서비스 문의</option>
					</select>

					<div id="input-area">
						<input type="text" name="title" placeholder="제목을 30자 이하로 작성해주세요." maxlength="30">
						<input type="email" name="email" placeholder="추가 답변이 발생하면 답변받을 이메일을 작성해주세요.">
						<textarea name="content" style="resize:none;" placeholder="내용을 작성해주세요."></textarea>
					</div>
					
					<div id="submit-input">
						<input type="button" value="문의 제출하기" onclick="send();">
					</div>
					
				</form>
			
			</div>
		
			<%@ include file="/WEB-INF/views/common/footer.jsp" %>
		</main>

		<script>

			function send(params) {
				if(document.querySelector('input[name=title]').value == ""){
					Swal.fire({
					title : '문의 등록을 실패하였습니다.',
					icon: 'warning',
					text: '제목을 입력해주세요',
				})
					return false;
				}else{
					document.querySelector('form[name=sub1]').submit();
					Swal.fire({
					title : '문의 등록을 성공하였습니다.',
					icon: 'success',
					text: '',
				})
				}

			}

		</script>
		

</body>
</html>