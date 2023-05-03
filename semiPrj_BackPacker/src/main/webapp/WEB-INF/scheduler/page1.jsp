<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
    #wrap {
    display: flex;
    flex-direction: column;
    align-items: center;
    }

    #intro {
    text-align: center;
    margin-top: 100px;
    }

    #place-location-area {
    display: grid;
    grid-template-columns: repeat(3, 1fr);
    grid-template-rows: repeat(2, 1fr);
    grid-gap: 50px;
    margin-top: 50px;
    position: relative;
    bottom: 70px;
    }

    #place-location {
    background-color: #f8f8f8;
    border: 1px solid #ddd;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    padding: 50px;
    text-align: center;
    }

    #country-pick{
        

        width: 700px;
        height: 80px;

        align-items: center;

        display: grid;
        grid-template-columns: repeat(5, 1fr);
        grid-gap: 50px;
        padding: 50px;

        position: relative;
        bottom: 50px;
    }

    .country{
        border: 1px solid rgb(68, 170, 203);
    }
    


</style>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<main>
	<div id="wrap">
        
        <div id="intro">
            <h1>어디로 여행을 떠나시나요?</h1>
            <h5>여행지를 골라주세요</h5>
        </div>


        <div id="country-pick">
            <div class="country">한국</div>
            <div class="country">일본</div>
            <div class="country">중국</div>
            <div class="country">싱가폴</div>
            <div class="country">필리핀</div>
        </div>


        <div id="place-location-area">
            <div id="place-location">
                <div>제주도</div>
                <div>제주도사진</div>
            </div>
            
            <div id="place-location">
                <div>제주도</div>
                <div>제주도사진</div>
            </div>
            
            <div id="place-location">
                <div>제주도</div>
                <div>제주도사진</div>
            </div>

            <div id="place-location">
                <div>제주도</div>
                <div>제주도사진</div>
            </div>

            <div id="place-location">
                <div>제주도</div>
                <div>제주도사진</div>
            </div>

            <div id="place-location">
                <div>제주도</div>
                <div>제주도사진</div>
            </div>

        </div>

    </div>
	
	
	</main>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>

</body>
</html>