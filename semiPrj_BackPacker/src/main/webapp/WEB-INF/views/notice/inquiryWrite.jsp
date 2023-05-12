<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	main{
		margin-top: 66px;
		padding: 0px;
		width:100vw;
		height: 1100px; 
	}
	
	#mainImg-area{
		position:relative;
	}
	
	#mainImg-area > img{
		width:100vw;
		height:400px;
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
		font-size: 4em;
		font-weight: bold;
		margin-bottom:20px;
	}
	
	#category-area{
	 border-radius: 20px;
        background-color: #B9eeff;
        border-color:#B9eeff;
        width: 150px;
        height:40px;
        text-align:center;
        font-size:18px;
        margin-bottom:20px;
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
        border: 1px solid #99ccff;
        background-color:  #99ccff;
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
				<span class="input-area">
		               	<i class="fa-solid fa-magnifying-glass fa-sm" style="color: #8c8c8c;"></i>
		               	<input type="text" placeholder="여행지로 검색">
	               </span>
			</div>
		
		</div>
		
		<div id="main-content-title"> 문의 작성</div>

			<div id="main-content">
				<form action="" method="post">
					
					<select id="category-area">
						<option value="">1:1 문의</option>
						<option value="">서비스 문의</option>
					</select>

					<div id="input-area">
						<input type="text" name="title" placeholder="제목을 작성해주세요.">
						<input type="email" name="email" placeholder="추가 답변이 발생하면 답변받을 이메일을 작성해주세요.">
						<textarea name="content" style="resize:none;" placeholder="내용을 작성해주세요."></textarea>
					</div>
					
					<div id="submit-input">
						<input type="submit" value="문의 제출하기">
					</div>
					
				</form>
			
			</div>
		
		</main>
		
		<%@ include file="/WEB-INF/views/common/footer.jsp" %>
	

</body>
</html>