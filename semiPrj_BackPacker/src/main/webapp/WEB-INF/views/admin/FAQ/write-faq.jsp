<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#faq-main{
		margin-top: 66px;
		padding: 0px;
		width:100vw;
		height: 1100px; 
	}
	
	#faq-mainImg-area{
		position:relative;
	}
	
	#faq-mainImg-area > img{
		width:100vw;
		height:400px;
	}

	#faq-mainImg-text{
		position:absolute;
		top:30%;
		left:60%;
	}
	
	#faq-mainImg-text > #img-text{
		font-size:2.5em;
	}
	
	.faq-input-area > input{
        border-radius: 25px;
        width:280px;
        height:30px;
		border : 1px solid lightgray;
		padding-left:45px;
		margin-top:20px;
	}
	
	.faq-input-area{
		position:relative;
	}
	
	.faq-input-area > i{
  		position: absolute;
		top :9px;
		left: 20px;
		z-index: 1;
  	}
  	
  	#faq-mainImg-area{
  		margin-bottom:50px;
  	}

	#faq-main-content-title{
  		display:flex;
  		justify-content:center;
  		align-items:center;
		font-size: 4em;
		font-weight: bold;
		margin-bottom:20px;
	}
	
	#faq-category-area{
	 border-radius: 20px;
        background-color: #B9eeff;
        border-color:#B9eeff;
        width: 150px;
        height:40px;
        text-align:center;
        font-size:18px;
        margin-bottom:20px;
	}
	
	#faq-main-content{
		display:flex;
		align-items:center;
		justify-content:space-evenly;
		flex-wrap:wrap;
	}
	
	
	#faq-input-area > input {
		width:110%;
		border: none;
		font-size:25px;
		border-bottom:1px solid lightgray;
		padding:10px;
	}
	
	#faq-input-area > textarea{
		width:110%;
		border: 1px solid lightgray;
		font-size:25px;
		margin-top:20px;
		border-radius:9px;
		height:300px;
		padding:10px;
	}
	
	#faq-input-area > textarea:focus , #faq-input-area > input:focus{
		outline:none;
	}
	
	#faq-submit-input{
		display:flex;
		justify-content:center;
		align-items:center;
	}
	
	#faq-submit-input>input{
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

	
		<main id="faq-main">
		
		<div id="faq-mainImg-area">
		
			<img alt="" src="${root}/static/img/inquiry/inquiry-main.jpg">
				
		</div>
		
		<div id="faq-main-content-title"> FAQ등록하기</div>

			<div id="faq-main-content">
				<form action="" method="post">
					<div id="faq-input-area">
						<input type="text" name="title" placeholder="제목을 작성해주세요.">
						<br>
						<input type="text" name="writerNo" value="${loginMember.memberNo}" hidden>
						<textarea name="content" style="resize:none;" placeholder="내용을 작성해주세요."></textarea>
					</div>
					
					<div id="faq-submit-input">
						<input type="submit" value="FAQ 등록하기">
					</div>
					
				</form>
			
			</div>	
		
		</main>
		
	

</body>
</html>