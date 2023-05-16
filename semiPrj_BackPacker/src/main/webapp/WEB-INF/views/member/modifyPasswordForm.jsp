<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
<meta charset="UTF-8">
<title>비밀번호 변경 페이지</title>
<style>
        #changePassword-title {
            color: #94d2e6;
            text-align: center;
            margin-top : 10%;
            margin-bottom: 3%;
            font-weight: bold;
        }

        #changePassword-area {
           
            width: 30%;
            margin: auto;
        }

        #password-area {
            display: flex;
            justify-content: space-evenly;
        }

        #password-again-area {
            display: flex;
            justify-content: space-evenly;

        }

        #password, #passwordAgain {
            border:none;
            width: 100%;
        }

        #password {
            border-left: 10%;
        }

        #span-password {
            margin-right: 10%;
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

        
    </style>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>

	<main>
		<h1 id="changePassword-title">비밀번호 변경</h1> 
    <form action="${pageContext.request.contextPath}/member/modify/password" method="POST">
        <div id="changePassword-area">
             <div id="password-area">
                <span id="span-password" >비밀번호</span>
                <div class="border-style">
                    <input id="password" name="changePassword" type="password" placeholder="바꿀 비밀번호를 입력하세요" name="password">
                </div>
               
             </div>
             <br>
             <br>
             <div id="password-again-area">
                <span>비밀번호 확인</span>
                <div class="border-style">
                    <input name="passwordAgain" name="changePasswordAgain" id="passwordAgain" type="password" placeholder="한번 더 입력하세요">
                </div>
                
             </div>
             <br>
             <br>

             <input id="submit-btn" onclick="return checkPassword();" type="submit" value="변경">
        </div>    
    </form>
	</main>
	
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
	
	<script type="text/javascript">
		function checkPassword() {
			const changePassword = document.querySelector("#password").value;
			const changePasswordAgain = document.querySelector("#passwordAgain").value;
			
			if(changePassword != changePasswordAgain) {
				Swal.fire({
					  title: '비밀번호가 일치해야 합니다.',
					  icon: 'warning',
					  confirmButtonColor: '#94d2e6',
					  confirmButtonText: '확인'
					});
				return false;
			}
			
			return true;
		}
	</script>
</body>
</html>