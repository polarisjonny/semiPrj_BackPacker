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
  		margin-bottom:40px;
  	}
  	
  	 #wrap{
            width: 700px;
            height: 600px;
            display: grid;
            grid-template-rows: 2fr 1fr 1fr 3fr 1fr 200px;
            margin:auto;
        }
        
        #wrap-title{
        	font-size:2em;
        	font-weight:bold;
        	display:flex;
        	justify-content:center;
        	align-items:center;
        }
        #info-area{
            display: grid;
            grid-template-columns: 1fr 1fr;
            align-items: center;
            border-bottom: 1px solid lightgray;
        }
        
        #info-area > div{
        	font-size:16px;
        }
		
		#info-area > #date{
			margin-left:15px;
		}
		
        #category{
            display: flex;
            justify-content: center;
            align-items: center;
            font-size: 2em;
        }
        #main-title{
            display: flex;
            align-items: center;
            font-size: 1.3em;
            border-bottom: 1px solid lightgray;
        }
        #content-area{
            display: flex;
            border-bottom : 1px solid gray;
        }
        #content{
            margin: 10px;
            font-size:16px;

        }
        #answer{
            display: flex;
            align-items: center;
            font-size: 1.5em;
        }
        
        #answer-content{
        	border : 1px solid lightgray;
        }
  	
  		#help-btn{
  			width:30%;
  			display:flex;
  			justify-content:center;
  			align-items:center;
  			margin:auto;
  			margin-top:25px;
  		}
  		
  		#help-btn > span{
  			font-size: 1.4em;
  		}
  		
  		#help-btn > button{
  		border-radius: 10px;
        border: 1px solid #99ccff;
        background-color:  #99ccff;
        color:white;
        padding:10px;
        margin:0px 10px 10px;
  		}
  		
  		#help-btn i{
			font-size: 20px;
  		}

		  #insertAnswer{
			display:flex;
			justify-content:center;
			margin-top:20px;
		}
		
		#insertAnswer > button{
			border-radius: 10px;
	        border: 1px solid #99ccff;
	        background-color:  #99ccff;
	        color:white;
	        padding:10px;
		}

		textarea:focus , input:focus{
			outline: none;
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
	
		<div id="wrap">
        <div id="wrap-title">1:1문의</div>

        <div id="main-title">${vo.title}</div>
        
        <div id="info-area">
            <div id="writer">작성자 : ${vo.nick}</div>
            <div id="date">작성일시 : ${vo.enrollDate}</div>
        </div>

        <div id="content-area">
            <div id="content">${vo.content}</div>
        </div>

        <div id="answer">문의답변 ></div>

<textarea id ="answer-content" style="resize:none;" readonly>
${vo.answer}
</textarea>

    </div>
		
		<c:if test="${loginMember.id == 'ADMIN'}">
				<div id="insertAnswer">
				<button class="Answer">답변 등록</button>
				</div>
		</c:if>

		<c:if test="${loginMember.id != 'ADMIN'}">
			<div id="help-btn">
				<span>도움이 되었습니까?</span>
				<button id="frist" onclick="location.href='${root}/notice/inquiry'">
					<i class="bi bi-hand-thumbs-up-fill"></i>
				</button>
				
				<button id="secend" onclick="location.href='${root}/notice/inquiryWrite'">
					<i class="bi bi-hand-thumbs-down"></i>
				</button>
				
			</div>

		</c:if>


	
	</main>
	
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
		

	<script>

		const answer = document.querySelector('.Answer');
		answer.addEventListener('click' , function(params) {
			const no ='${vo.qnaNo}'
				const width = 800;
				const height = 1000;
				const left = (screen.width/2) - (width/2);
				const top = 0;
				window.open('${root}/notice/inquiryQnaAnswer?QnaNo='+no ,'', 'width=' + width + ', height=' + height + ', left=' + left + ', top=' + top )
		})

	</script>
</body>
</html>