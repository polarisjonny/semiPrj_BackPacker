<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지 변경 페이지</title>
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

        #checkId {
            margin-left: 15%;
            border: none;
            color: white;
            background-color: #94d2e6;

        }

        #checkNick {
            margin-left: 15%;
            border: none;
            color: white;
            background-color: #94d2e6;
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
            border: 1px solid lightgray;
            border-left: none;
            border-right: none;
            border-top: none;
            width: 100%;
        }

        #nick {
            border: none;
            width: 50%;
            height: 70%;
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
    </style>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<main>
        <h1 id="joinTitle">개인정보 수정</h1>

    <form action="${pageContext.request.contextPath}/member/join" method="POST" onsubmit="return checkValidation();" enctype="multipart/form-data">
        <div id="join-area">
        
            <div id="first-area">
                <div class="input-style">
                    <input type="tel" name="phoneNumber" placeholder="핸드폰번호를 입력하세요">
                </div>
                <br>
                <div class="input-style">
                    <input type="address" name="address" placeholder="주소를 입력하세요">
                </div>
                <br>
            </div>
           
            <div id="second-area">
                <div id="name-area">
                    <span>나이</span>
                    <br>
                    <span>프로필 사진</span>
                </div>
                <div id="input-area">
                    <select name="age" id="age">
                        <option value="20">20대</option>
                        <option value="30">30대</option>
                        <option value="40">40대</option>
                        <option value="50">50대</option>
                    </select>
                    <br>
                </div>
    
                
                <input type="file" name="profileImage">
                
                    
                            
            </div>

            <div id="third-area">
                <div id="intro-title">자기소개를 작성해주세요</div>
                <br>
                <label>
                    <textarea style="resize: none;" name="introduce" id="introduce-message" cols="70" rows="20" placeholder="자기소개는 최대 4000자까지 작성 가능합니다." resize="none"></textarea>
                </label>
            
                <br>
                <br>
                <br>
                
                <input id="submit-btn" type="submit" value="수정하기">
            </div>
        </div>
    </form>
    </main>
    <%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>