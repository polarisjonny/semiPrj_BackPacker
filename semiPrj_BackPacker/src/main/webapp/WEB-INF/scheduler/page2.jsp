<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
    #sidebarLeft {
        position: absolute;
        top: 0;
        left: 0;
        width: 20vw;
        height: 100vh;
        padding: 20px;
        background-color: #f8f8f8;
        border-left: 1px solid #ddd;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    #map{
        background-color: black;
        
        position: absolute;
        left: 50%;
        transform: translateX(-50%);
    }
    #sidebarRight {
        position: absolute;
        top: 0;
        right: 0;
        width: 20vw;
        height: 100vh;
        padding: 20px;
        background-color: #f8f8f8;
        border-left: 1px solid #ddd;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    #wrap{
        grid-template-rows: 1fr 2fr 1fr;
    
    }
    
</style>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<main>
	<div id="sidebarLeft">
        <div id="tripCountry">나라</div>
        <div id="tripLocation">지역</div>
        
        <input type="text" placeholder="여행기간을 선택해주세요" >
       
        <div id="tripDate">
            달력
        </div>
        

        <div id="tripDateplan">날짜</div>
        <div>여행지</div>

        <button> 일정저장 </button>


    </div>

    <div id="map">지도</div>

    <div id="sidebarRight">

        <input type="text" placeholder="여행지검색" name="placeName">

        <h1>추천장소</h1>

        <div id="placelist">
            <div>이미지</div>
            <div>여행지 이름</div>
        </div>

    </div>
	
	
	
	</main>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>

</body>
</html>