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
        top: 10px;
    }

    .place-location {
        background-color: #f8f8f8;
        border: 1px solid #ddd;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        
    
        text-align: center;
    }

    #country-pick{
        

        width: 700px;
        height: 80px;

        justify-content: center;
        align-items: center;

        display: grid;
        grid-template-columns: repeat(5, 1fr);
        grid-gap: 30px;
        padding: 50px;

        position: relative;
        bottom: 50px;
        top: 10px;

        text-align: center;
    }

    .country{
        width: 100px;
        height: 40px;

        display: flex;
        justify-content: center;
        align-items: center;
        font-size: 1.5em;
        
    }
    #place-location-area img{
        width: 200px;
        height: 180px;
        transition: background-color 0.3s ease;

    }
    


</style>
<script defer>
    function changeBackgroundColor(element){
        element.style.backgroundColor = "rgb(68, 170, 203)";
        element.style.color = "white";
    }
    function restoreBackgroundColor(element){
        element.style.backgroundColor = "white";
        element.style.color = "black";
    }

    function enlargeImage(element) {
        element.style.transform = "scale(1.2)";
    }

    function resetImageSize(element) {
        element.style.transform = "scale(1)";
    }  
</script>
<body>

	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<main>
	
		<div id="wrap">
        
        <div id="intro">
            <h1>어디로 여행을 떠나시나요?</h1>
            <h5>여행지를 골라주세요</h5>
        </div>


        <div id="country-pick">
            <div class="country" onmouseover="changeBackgroundColor(this)" onmouseout="restoreBackgroundColor(this)">한국</div>
            <div class="country"onmouseover="changeBackgroundColor(this)" onmouseout="restoreBackgroundColor(this)">일본</div>
            <div class="country"onmouseover="changeBackgroundColor(this)" onmouseout="restoreBackgroundColor(this)">중국</div>
            <div class="country"onmouseover="changeBackgroundColor(this)" onmouseout="restoreBackgroundColor(this)">싱가폴</div>
            <div class="country"onmouseover="changeBackgroundColor(this)" onmouseout="restoreBackgroundColor(this)">필리핀</div>
        </div>


        <div id="place-location-area">
            <div id="place-location"onmouseover="enlargeImage(this)" onmouseout="resetImageSize(this)">
                <a href="">
                    <div>JEJU</div>
                    <div class="place-location">
                            <img src="" alt="">
                    </div>
                </a>
            </div>
            
            <div id="place-location" onmouseover="enlargeImage(this)" onmouseout="resetImageSize(this)">
                <a href="">
                    <div>SEOUL</div>
                    <div class="place-location">
                        <img src="" alt="">
                    </div>
                </a>
                
            </div>
            
            <div id="place-location"onmouseover="enlargeImage(this)" onmouseout="resetImageSize(this)">
                <a href="">
                    <div>BUSAN</div>
                    <div class="place-location">
                        <img src="" alt="">
                    </div>
                </a>
            </div>

            <div id="place-location"onmouseover="enlargeImage(this)" onmouseout="resetImageSize(this)">
               <a href="">
                   <div>GANGWON</div>
                   <div class="place-location">
                       <img src="" alt="">
                   </div>
               </a>
            </div>

            <div id="place-location"onmouseover="enlargeImage(this)" onmouseout="resetImageSize(this)">
                <a href="">
                    <div>YEOSU</div>
                    <div class="place-location">
                        <img src="" alt="">
                    </div>
                </a>
            </div>

            <div id="place-location"onmouseover="enlargeImage(this)" onmouseout="resetImageSize(this)">
                <a href="">
                    <div>INCHEON</div>
                    <div class="place-location">
                        <img src="" alt="">
                    </div>
                </a>
            </div>


        </div>
		
	
	
	</main>
	
	
	
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>




</body>
</html>