<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기 페이지</title>
<style>
        #findPassword-title {
            color: #94d2e6;
            text-align: center;
            margin-top : 10%;
            margin-bottom: 3%;
            font-weight: bold;
        }

        #findPassword-area {
            width: 30%;
            margin: auto;
        }

        #id-area, #phone-area, #email-area {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 1em;
        }

        #id, #phone, #email {
            border:none;
            width: 100%;
            margin-left: 1em;
        }

        #id {
            border-left: 10%;
        }

        
        #span-id {
            margin-right: 1em;
            width: 20%;
            text-align: right;
        }

        #span-phone {
            margin-left: 2.4em;
            width: 20%;
            text-align:left;
        }

        #span-email {
            margin-right: 1em;
            width: 20%;
            text-align: right;
        }

        .border-style {
            border: 1px solid lightgray;
            border-left:none;
            border-right:none;
            border-top:none;
            width: 60%;
        }
        
        #submit-btn {
            text-align: center;
            background-color: #94d2e6;
            color: white;
            border: none;
            width: 15%;
            height: 30px;
            margin-left: auto;
            margin-top: 3%;
            display: block;
        }

        #check-password-area {
            text-align: center;
        }

        
        
    </style>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	 <main>
        <h1 id="findPassword-title">비밀번호 찾기</h1> 
    <form action="${pageContext.request.contextPath}/member/findPassword}">
        <div id="findPassword-area">
            <div id="id-area">
                <span id="span-id">아이디</span>
                <div class="border-style">
                    <input name="name" id="id" type="text" placeholder="아이디를 입력하세요">
                </div>
            </div>
            <div id="phone-area">
                <span id="span-phone">핸드폰 번호</span>
                <div class="border-style">
                    <input name="phoneNumber" id="phone" type="tel" placeholder="핸드폰 번호를 입력하세요">
                </div>
            </div>
            <div id="email-area">
                <span id="span-email">이메일</span>
                <div class="border-style">
                    <input type="email" id="email" placeholder="이메일을 입력하세요">
                </div>
            </div>

            <br>
            <input id="submit-btn" type="submit" value="찾기">
        </div>
        <br>
        <br>
        <br>
        <br>
        <br>
        <div id="check-password-area">
            <div>jonny님의 비밀번호는 susu1234 입니다.</div>
        </div>
    </form>
    </main>
    
    
</body>
</html>