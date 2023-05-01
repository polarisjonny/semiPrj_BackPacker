<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
 	footer {
	  display: flex;
	  justify-content: space-around;
	  align-items: center;
	  background-color: #f8f8f8;
	  padding: 20px;
	}

	#logo {
	  display: flex;
	  align-items: center;
	}
	
	#logo img {
	  width: 180px;
	  height: 70px;
	  display: block;
	}
	
	div {
	  display: flex;
	  flex-direction: column;
	  align-items: flex-end;
	  margin-left: 20px;
	}
	
	.bold {
	  font-weight: bold;
	  margin-bottom: 5px;
	}
	
	.mini {
	  font-size: 12px;
	  color: #666;
	}
    

   


    

</style>
</head>
<body>

    <footer>

        <a id="logo" href="">
            <img width="10px" height="70px" src="${pageContext.request.contextPath}/static/img/logo/최종.png" >
        </a>

        <div>
            <div class="bold">소개</div>
            <div class="mini">백패커소개</div>
            <div class="mini">프패커소개</div>
        </div>
        <div>
            <div class="bold">파트너문의</div>
            <div class="mini">서울특별시 강남구 테헨란로 14길 6층</div>
        </div>
        <div id="as">
            <a class="bold" href="">문의사항</a>
            <div class="mini">공지사항/FAQ</div>
            <div class="mini">1:1문의하기</div>
        </div>


    </footer>



	

</body>
</html>