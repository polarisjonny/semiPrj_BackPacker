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
    #add-place-wrap{
        width: 450px;
         margin-top: 100px;
        margin-left: auto;
        margin-right: auto;
        height: 600px;
    }
    #add-place-img{
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
   
    .none,
   .ko,
   	.jp,
   	.ch,
   	.si,
   	.ph,
   	.vi{
   		display : none;
   	}
   	.active{
		display : block;
	}
</style>
<body>

	<%@ include file="/WEB-INF/views/common/header.jsp" %>
 <%@ include file="/WEB-INF/views/common/nav.jsp" %>
	<div id="add-place-wrap">
        <div style="text-align:center;">
            <span ><h1>여행지 추가</h1></span>
        </div>
        <form action="${root}/admin/place/add" method="post" enctype="multipart/form-data">
        <div>
        	<input type="text" name="placeName" placeholder="여행지 이름">
        </div>	
        	<label>
				대표사진
				 <input type="file" multiple="multiple" name="placeImage" value="/app/static/img/temp_profile.png">
			</label>
				 <div id="add-place-img">
				    	<img id="placeImg" >
				 </div>
            
            <div id="select-grid1">
                
                <select class="g1sl" name="placeCategoryNo" id="placeSelect">
                    <option value="10"selected>식음료</option>
                    <option value="20">관광</option>
                    <option value="30">체험</option>
                </select>
            
            
                <select class="g1sl" name="countryNo" id="countrySelect">
                   <option value="1" selected>한국</option>
                    <option value="2">일본</option>
                    <option value="3">중국</option>
                    <option value="4">싱가폴</option>
                    <option value="5">필리핀</option>
                    <option value="6">베트남</option>
                </select>
            
            	<div class = "none active">
            		<select class="g1sl" name="locationNo" id="locationSelect" >
                		<option value="101" selected>제주도</option>
	                    <option value="102">102</option>
	                    <option value="103">103</option>
	                    <option value="104">104</option>
	                    
                		<option value="201" selected>오사카</option>
	                    <option value="202">훗카이도</option>
	                    <option value="203">도쿄</option>
	                    <option value="204">교토</option>
	                    
                		<option value="301" selected >베이징</option>
	                    <option value="302">상하이(항주, 소주)</option>
	                    <option value="303">사천</option>
	                    <option value="304">운남</option>
	                    
                		<option value="401" selected >싱가폴</option>
	                
                		<option value="501" selected >세부</option>
                		<option value="502"  >보라카이</option>
                		<option value="503"  >보홀</option>
                		<option value="504"  >마닐라</option>
	                
                		<option value="601" selected >베트남</option>
                    
                </select>
            	</div>
               	<div class = "ko">
            		<select class="g1sl" name="locationNo" id="locationSelect">
                		<option value="101" selected>제주도</option>
	                    <option value="102">102</option>
	                    <option value="103">103</option>
	                    <option value="104">104</option>
	               
                    
                	</select>
            	</div>
            	  	<div class = "jp">
            		<select class="g1sl" name="locationNo" id="locationSelect" >
              
	                    
                		<option value="201" selected>오사카</option>
	                    <option value="202">훗카이도</option>
	                    <option value="203">도쿄</option>
	                    <option value="204">교토</option>
	                
                    
                </select>
            	</div>
            	  	<div class = "ch">
            		<select class="g1sl" name="locationNo" id="locationSelect" >
                		
	                    
                		<option value="301" selected >베이징</option>
	                    <option value="302">상하이(항주, 소주)</option>
	                    <option value="303">사천</option>
	                    <option value="304">운남</option>
	                    
                	
                    
                </select>
            	</div>
            	  	<div class = "si">
            		<select class="g1sl" name="locationNo" id="locationSelect">
                		
	                    
                		<option value="401" selected >싱가폴</option>
	                
                		
                    
                </select>
            	</div>
            	  	<div class = "ph">
            		<select class="g1sl" name="locationNo" id="locationSelect">
                		
	                
                		<option value="501" selected >세부</option>
                		<option value="502"  >보라카이</option>
                		<option value="503"  >보홀</option>
                		<option value="504"  >마닐라</option>
	                
                    
                </select>
            	</div>
            	  	<div class = "vi">
            		<select class="g1sl" name="locationNo" id="locationSelect">
                			                
                		<option value="601" selected >베트남</option>
                    
                </select>
            	</div>
                
            </div>
            <div id="placeIntro">
            <textarea  id="plIntro"  name="placeIntroduce"  placeholder="상세 정보 : " ></textarea>
            </div>
            <div id="place-info-grid">
                <div>
                    <input type="text" class="infotext"  id="time" name="placeTime" placeholder="소요시간 : ">
                </div>
                <div>
                    <input type="text" class="infotext"  id="expense" name="placeExpense" placeholder="비용 : " >
                </div>
                <div>
                    <input type="text" class="infotext"  id="lat" name="placeLat" placeholder="위도 : " >
                </div>
                <div>
                    <input type="text" class="infotext"  id="lng" name="placeLng" placeholder="경도 : " >
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
	
	 const countrySelect = document.querySelector('#countrySelect');
		const locationSelect = document.querySelector('#locationSelect');

			countrySelect.addEventListener('change', function() {
				
			const selectedValue = countrySelect.value;
			const none = document.querySelector('.none');
			const ko = document.querySelector('.ko');
			const jp = document.querySelector('.jp');
			const ch = document.querySelector('.ch');
			const si = document.querySelector('.si');
			const ph = document.querySelector('.ph');
			const vi = document.querySelector('.vi');
			ko.classList.remove('active');
			jp.classList.remove('active');
			ch.classList.remove('active');
			si.classList.remove('active');
			ph.classList.remove('active');
			vi.classList.remove('active');
			
			// 선택된 값에 따라 locationSelect의 옵션을 변경
			if (selectedValue === '1') {
				none.classList.remove('active');
				ko.classList.add('active');
				locationSelect.value = '101';
			} else if (selectedValue === '2') {
				none.classList.remove('active');
				jp.classList.add('active');
				locationSelect.value = '201';
			} else if (selectedValue === '3') {
				none.classList.remove('active');
				ch.classList.add('active');
				locationSelect.value = '301';
			} else if (selectedValue === '4') {
				none.classList.remove('active');
				si.classList.add('active');
				locationSelect.value = '401';
			} else if (selectedValue === '5') {
				none.classList.remove('active');
				ph.classList.add('active');
				locationSelect.value = '501';
			} else if (selectedValue === '6') {
				none.classList.remove('active');
				vi.classList.add('active');
				locationSelect.value = '601';
			}
		});
	
</script>