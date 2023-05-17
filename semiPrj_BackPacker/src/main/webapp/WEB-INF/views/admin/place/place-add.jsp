<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 부트스트랩 -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    
<!-- 제이쿼리 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<!-- 폰트어썸 cdn -->
<script src="https://kit.fontawesome.com/794ac64f16.js" crossorigin="anonymous"></script>
    <c:set var="root" value = "${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
    #edit-place-wrap{
        width: 450px;
         margin-top: 100px;
        margin-left: auto;
        margin-right: auto;
        height: 600px;
    }
    #edit-place-img{
        width: 450px;
        height: 200px;
        
    }
    #select-grid1{
        display: grid;
        grid-template-columns: 1fr 1fr 1fr;
        justify-content: center;
        
    }
    
    #place-info-grid{
        display: grid;
        grid-template-columns: 1fr 1fr;
        grid-template-rows: 1fr 1fr;
    }
    #placeIntro{
        width: 450px;
       
    }
    #plIntro{
        width: 450px;
        box-sizing: border-box;
         height :100px;
        resize: none;
    }
    .g1sl{
        background-color: rgb(149, 216, 247, 0.7);
        height: 30px;
        width: 150px;
        margin: auto;
        font-size: 1em;
        border: 0px;
        border-radius: 10px;
        text-align: center;
        justify-content: center;
    }
    #reimg{
        width: 450px;
        height: 200px;
    }
    .infotext{
    	margin:auto;
        width: 220px;
        box-sizing: border-box;
    }
    #edit-place-submit{
        width: 450px;
        height: 50px;
        border: 0px;
        background-color: rgb(149, 216, 247, 0.7);
        border-radius: 20px;
    }
   
</style>
<body>

	<%@ include file="/WEB-INF/views/common/header.jsp" %>
 <%@ include file="/WEB-INF/views/common/nav.jsp" %>
	<div id="edit-place-wrap">
        <div style="text-align:center;">
            <span ><h1>여행지 추가</h1></span>
        </div>
        <form action="${root}/admin/place/add" method="post" enctype="multipart/form-data">
        <div>
        	<input type="text" name = "placeName" placeholder="여행지 이름">
        </div>	
        	<label>
				대표사진
				 <input type="file" multiple="multiple" name="placeImage">
			</label>
				 <div id="edit-place-img">
				    	<img id="placeImg">
				 </div>
            
            <div id="select-grid1">
                
                <select class="g1sl" name="placeCategoryNo" id="placeSelect">
                    <option value="10">식음료</option>
                    <option value="20">관광</option>
                    <option value="30">체험</option>
                </select>
            
            
                <select class="g1sl" name="countryNo" id="countrySelect">
                    <option value="1">한국</option>
                    <option value="2">일본</option>
                    <option value="3">중국</option>
                </select>
            
            
                <select class="g1sl" name="locationNo" id="locationSelect">
                    <option value="301">베이징</option>
                    <option value="302">상하이(항주, 소주)</option>
                    <option value="303">사천</option>
                </select>
                
            </div>
            <div id="placeIntro">
            <textarea  id="plIntro"  name="placeIntroduce"></textarea>
            </div>
            <div id="place-info-grid">
                <div>
                    <input type="text" class="infotext"  id="time" name="placeTime">
                </div>
                <div>
                    <input type="text" class="infotext"  id="expense" name="placeExpense">
                </div>
                <div>
                    <input type="text" class="infotext"  id="lat" name="placeLat">
                </div>
                <div>
                    <input type="text" class="infotext"  id="lng" name="placeLng">
                </div>

            </div>
            <input type="submit" id="edit-place-submit" value="추가하기">
        </form>


    </div>
    
</body>
</html>
<script>
	
	
	const fileTag = document.querySelector("input[name=placeImage]")

	fileTag.addEventListener("change", function(){
    

    const placeImg = document.querySelector("#placeImg");

    if(fileTag.files.length > 0){

        const fr = new FileReader();

        fr.readAsDataURL(fileTag.files[0]);

        fr.addEventListener("load", function(event){
        	placeImg.src = event.target.result;
        	placeImg.width = "450";
        	placeImg.height = "200";
        });

        
        
    }else{
    	placeImg.src ="";
    }


});
	
</script>