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
		width:100%;
		height: 1100px; 
	}

    #mainImg-area{
       position: realtive;
    }
	
	#mainImg-area > #mainImg{
		width:100%;
		height:400px;
		margin:0;
	}

    #mainImg-area > #mainContent{
        font-weight: bold;
        font-size: 2em;
        color: whitesmoke;
        position:absolute;
        text-align:center;
    }
    
    
    
  
</style>
</head>
<body>

	<%@ include file="/WEB-INF/views/common/header.jsp" %>

    
    
    <main>
    
   

		<div id="mainImg-area">
	        <img id="mainImg" src="${root}/static/img/travelReview/travelReviewMain.jpg" alt="메인 이미지">
	        <div id="mainContent">백팩커들의 솔직한 여행 이야기</div>
		</div>
		

        <div id="review-search-area">
            <form action="${root}/notice/travelReview">
                <select name="search-type">
                        <option value="title">제목</option>
                        <option value="writer">작성자</option>
                        <option value="category">카테고리</option>
                </select>

            </form>
        </div>
		
   
    
    </main>
    
    
    
    
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
	

	

</body>
</html>