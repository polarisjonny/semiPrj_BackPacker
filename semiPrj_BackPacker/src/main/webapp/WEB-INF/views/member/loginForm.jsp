<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<style>
       
        #logo-area {
            text-align: center;
            margin-top: 10%;
            margin-bottom: 5%;
        }
        
        #logo-area > #logo {
            width: 15%;
            height: 80px;
        }

        #login-area {
            width: 30%;
            margin: auto;
        }

        #login-area > #check-area {
            display: flex;
            justify-content: space-between;
        }
        
        .border-style {
            border: 1px solid lightgray;
            border-left: none;
            border-right: none;
            border-top: none;
            width: 100%;
            opacity: 70%;
            height: 60%;
        }

        

   

  label {
    font-size: 12px;
  }

  #login-btn {
    width: 100%;
    height: 50px;
    text-align: center;
    color: black;
    background-color: #94d2e6;
    border: none;
    
  }

  #next-area {
    display: flex;
    justify-content: space-between;
   
  }

  #next-area > a {
    color: black;
    text-decoration: none;
    font-size: smaller;
  }
    
  #join-btn {
    flex-basis: 60%;
  }

  #id-btn {
    flex-basis: 20%;
  }

  #password-btn {
    flex-basis: 20%;
  }






    </style>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	
	<main>
      <div id="logo-area">
        <img id="logo" src="${pageContext.request.contextPath}/static/img/logo/b_logo.png" alt="로고 사진">
    </div>

    <form action="${pageContext.request.contextPath}/member/login}">
        <div id="login-area">
            <input name="id" class="border-style" type="text" placeholder="아이디를 입력하세요">
            <br>
            <br>
            <input name="password" class="border-style" type="password" placeholder="비밀번호를 입력하세요">
            <div id="check-area">
                <label><input id="saveId" type="checkbox" name="saveId" value="saveId">아이디 저장</label>
                <label><input id="isGuide" type="checkbox" name="isGuide" value="isGuide">프패커로 로그인</label>
            </div>
            <br>
            <br>
            <input id="login-btn" type="submit" value="로그인">


            <div id="next-area" class="next-area">
                <a id="join-btn" href="${pageContext.request.contextPath}/member/join">회원가입</a>
                <a id="id-btn" href="${pageContext.request.contextPath}/member/findId">아이디 찾기</a>
                <a id="password-btn" href="${pageContext.request.contextPath}/member/findPassword">비밀번호 찾기</a>
            </div>

        </div>


    </form>
    </main>
</body>
</html>