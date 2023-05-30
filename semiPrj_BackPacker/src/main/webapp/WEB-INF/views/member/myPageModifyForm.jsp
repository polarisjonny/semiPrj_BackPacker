
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지 수정</title>
<style>
      #joinTitle {
            text-align: center;
            color: #94d2e6;
            margin-top: 5%;
            font-weight: bold;
        }

        #join-area {
            border: 1px solid lightgray;
             margin: auto;
            width: 50%; /* 전체 폭 조정 */
            display: flex;
            justify-content: space-between;
            flex-wrap: wrap;
  
        }

       
        #first-area {
            display: flex;
            flex-direction: column;
            align-items: flex-start;
            flex-basis: 50%;
            margin-bottom: 20px;
            margin-left: 5%;
            margin-top: 5%;
        }

        #name-area {
            display: flex;
            flex-direction: column;
            margin-right: 10%;

        }


        #second-area {
            display: flex;
            flex-wrap: wrap;
            flex-basis: 30%;
            margin-bottom: 20px;
            margin-top: 5%;
            margin-right: 5%;
        }

        #input-area {
            display: flex;
            flex-direction: column;
        }

        #third-area {
            margin-top: 10%;
            flex-basis: 100%;
            display: flex;
            flex-direction: column;
            align-items: center;
            width: 100%;
        }

        .border-style {
            display: flex;
            align-items: center;
            margin-bottom: 10px;
            border: 1px solid lightgray;
            border-left: none;
            border-right: none;
            border-top: none;
        }




        input {
            border: none;
            width: 100%;
            height: 70%;
        }

        #id {
            border: none;
            width: 50%;
            height: 70%;
        }

        
        #idWarning {
            font-size: 12px;
        }

       .input-style {
    display: flex;
    align-items: center; /* Center the input and button vertically */
    justify-content: space-between; /* Add space between input and button */
    width: 100%;
    border: 1px solid lightgray;
    border-top: none;
    border-left: none;
    border-right: none;
}

#checkId,
#checkNick {
    border: none;
    color: white;
    background-color: #94d2e6;
    height: 70%; /* Adjust the height as needed */
    margin-left: 10px; /* Add space between input and button */
    padding: 5px 10px; /* Add padding to the button */
    text-align: center;
}
       

        #nick {
            border: none;
            width: 50%;
            height: 80%;
        }

        #message {
            font-size: 12px;
            color: gray;
        }
        
        #gender-area input {
            width: 15%;
        }

        #intro-title {
            color: gray;
            font-size: 30px;
        }

        #intro-message {
            font-size: 10px;
            color: gray;
        }


        #guide-message {
            color: gray;
            font-size: 12px;
        }

        #submit-btn {
            color: white;
            background-color: #94d2e6;
            width: 50%;
            height: 40px;
        }
        
        .test-style {
        	height: 30px;
        }
        
       #gender-area input[type="radio"] {
  width: 15px;
  height: 15px;
  margin-right: 5px;
  appearance: none;
  -webkit-appearance: none;
  -moz-appearance: none;
  border-radius: 50%;
  border: 2px solid lightgray;
}

#gender-area input[type="radio"]:checked {
  background-color: #94d2e6;
  border-color: #94d2e6;
}

#gender-area input[type="radio"]::before {
  content: '';
  display: block;
  width: 60%;
  height: 60%;
  margin: 20% auto;
  border-radius: 50%;
  background-color: #94d2e6;
  visibility: hidden;
}

#gender-area input[type="radio"]:checked::before {
  visibility: visible;
}
    	.label-age {
    		margin-top: 10px;
    	}
    	
    	#gender-box {
    		margin-top: 5px;
    	}
    	
    	#age-box {
    		margin-top: 10px;
    	}
    	
    	#file-input {
    		display: none;
    	}
    	
    	.button-text {
    		display: flex;
    align-items: center;
    justify-content: center;
    height: 100%;
    	}	
    	
    	
    	#profile-area {
    		cursor: pointer;
    	}
    </style>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	 <main>
        <h1 id="joinTitle">개인정보 수정</h1>

    <form action="${pageContext.request.contextPath}/member/modify/myPage" method="POST" enctype="multipart/form-data">
        <div id="join-area">
        
            <div id="first-area">
                <div class="input-style">
                    <input class="test-style" type="text" name="phoneNumber" value="${loginMember.phoneNumber}" placeholder="핸드폰번호를 입력하세요">
                </div>
                <br>
                <div class="input-style">
                	<input class="test-style" type="text" name="email" value="${loginMember.email}" placeholder="이메일을 입력하세요">
                </div>
                <br>
                <div class="input-style">
                    <input class="test-style" type="text" name="address" value="${loginMember.address}" placeholder="주소를 입력하세요">
                </div>
                <br>
            </div>
           
            <div id="second-area">
                <div id="name-area">
                    <span class="label-age">나이</span>
                    <br>
                    <label id="profile-area">
                    	프로필 사진
                    	<input id="file-input" type="file" name="profileImage">
                    </label>
                </div>
                <div id="input-area">
                    <select id="age-box" name="age" id="age">
                        <option value="20">20대</option>
                        <option value="30">30대</option>
                        <option value="40">40대</option>
                        <option value="50">50대</option>
                    </select>
                    <br>
                    <div id="preview-area">
                    	
                    </div>
                </div>
    
                
                    
                            
            </div>

            <div id="third-area">
                <div id="intro-title">자기소개를 작성해주세요</div>
                <br>
                <label>
                    <textarea style="resize: none;" name="introMessage" id="introduce-message" cols="70" rows="20" placeholder="자기소개는 최대 4000자까지 작성 가능합니다." resize="none" wrap="hard">${loginMember.introMessage}</textarea>
                </label>
            
                <br>
                <br>
                <br>
                <input id="submit-btn" type="submit" value="수정하기">
            </div>
        </div>
    </form>
    </main>


	<script>
		//사진 미리보기
		const fileTag = document.querySelector("input[type=file]");
		const previewArea = document.querySelector("#preview-area");
		fileTag.onchange = function(e){
			if(fileTag.files.length == 0) {
				previewArea.innerHTML = '';
				return;
			}
			
			const fr = new FileReader();
			
			fr.readAsDataURL(fileTag.files[0]);
			
			fr.onload = function(e) {
				const imgTag = document.createElement('img');
				imgTag.src = e.target.result;
				imgTag.alt = "미리보기 이미지 사진";
				imgTag.width = 100;
				imgTag.height = 100;
				imgTag.style.borderRadius = "50%";
				previewArea.appendChild(imgTag);
			}
		};
	</script>
	
	
	
</body>
</html>