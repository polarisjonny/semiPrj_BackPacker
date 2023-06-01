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
    .ja-area ,.ch-area,.si-area,.pi-area{display: none;}
 
    .pointer{
        cursor: pointer;
    }
    


</style>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
<body>

	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<main>
	
		<div id="wrap">
        
        <div id="intro">
            <h1>어디로 여행을 떠나시나요?</h1>
            <h5>여행지를 골라주세요</h5>
        </div>

        
        <div id="country-pick">
            <div class="country pointer" id="ko" onmouseover="changeBackgroundColor(this)" onmouseout="restoreBackgroundColor(this)" >
                한국
            </div>
            <div class="country pointer" id="ja" onmouseover="changeBackgroundColor(this)" onmouseout="restoreBackgroundColor(this)" >
                일본
            </div>
            <div class="country pointer" id="ch" onmouseover="changeBackgroundColor(this)" onmouseout="restoreBackgroundColor(this)" >
                중국
            </div>
            <div class="country pointer" id="si" onmouseover="changeBackgroundColor(this)" onmouseout="restoreBackgroundColor(this)" >
                싱가폴
            </div>
            <div class="country noReady pointer" id="pi" onmouseover="changeBackgroundColor(this)" onmouseout="restoreBackgroundColor(this)" >
                필리핀
            </div>
        </div>


        <div id="place-location-area">
            
            <!--                    한국시작                           -->
            <div id="place-location-ko" class="ko-area" onmouseover="enlargeImage(this)" onmouseout="resetImageSize(this)">
                <a  href="/semi/schedulermake?countryNo=1&locationNo=101">
                    <div>JEJU</div>
                    <div class="place-location">
                            <img src="${root}/static/img/location/jeju000.jpg" alt="">
                    </div>
                </a>
            </div>
            
            <div id="place-location-ko" class="ko-area noReady" onmouseover="enlargeImage(this)" onmouseout="resetImageSize(this)">
                <!-- <a href=""> -->
                    <div>SEOUL</div>
                    <div class="place-location">
                        <img src="${root}/static/img/location/seoul000.jpg" alt="">
                    </div>
                </a>
                
            </div>
            
            <div id="place-location-ko" class="ko-area noReady" onmouseover="enlargeImage(this)" onmouseout="resetImageSize(this)">
                <!-- <a href=""> -->
                    <div>BUSAN</div>
                    <div class="place-location">
                        <img src="${root}/static/img/location/busan000.jpg" alt="">
                    </div>
                </a>
            </div>

            <div id="place-location-ko" class="ko-area noReady" onmouseover="enlargeImage(this)" onmouseout="resetImageSize(this)">
               <!-- <a href=""> -->
                   <div>GANGWON</div>
                   <div class="place-location">
                       <img src="${root}/static/img/location/ganwon000.jpg" alt="">
                   </div>
               </a>
            </div>

            <div id="place-location-ko" class="ko-area noReady" onmouseover="enlargeImage(this)" onmouseout="resetImageSize(this)">
                <!-- <a href=""> -->
                    <div>YEOSU</div>
                    <div class="place-location">
                        <img src="${root}/static/img/location/yeosu000.jpg" alt="">
                    </div>
                </a>
            </div>

            <div id="place-location-ko" class="ko-area noReady" onmouseover="enlargeImage(this)" onmouseout="resetImageSize(this)">
                <!-- <a href=""> -->
                    <div>INCHEON</div>
                    <div class="place-location">
                        <img src="${root}/static/img/location/incheon000.jpg" alt="">
                    </div>
                </a>
            </div>
            <!--                    한국 끝                           -->





            
            <!--                    일본 시작                           -->
            <div id="place-location-ko" class="ja-area" onmouseover="enlargeImage(this)" onmouseout="resetImageSize(this)">
                <a  href="/semi/schedulermake?countryNo=2&locationNo=201">
                    <div>OSAKA</div>
                    <div class="place-location">
                            <img src="${root}/static/img/location/osaka.jpg" alt="">
                    </div>
                </a>
            </div>
            
            <div id="place-location-ko" class="ja-area noReady" onmouseover="enlargeImage(this)" onmouseout="resetImageSize(this)">
                <!-- <a href=""> -->
                    <div>TOKYO</div>
                    <div class="place-location">
                        <img src="${root}/static/img/location/dokyo.jpg" alt="">
                    </div>
                </a>
                
            </div>
            
            <div id="place-location-ko" class="ja-area noReady" onmouseover="enlargeImage(this)" onmouseout="resetImageSize(this)">
                <!-- <a href=""> -->
                    <div>HIROSHIMA</div>
                    <div class="place-location">
                        <img src="${root}/static/img/location/히로시마.jpg" alt="">
                    </div>
                </a>
            </div>

            <div id="place-location-ko" class="ja-area noReady" onmouseover="enlargeImage(this)" onmouseout="resetImageSize(this)">
               <!-- <a href=""> -->
                   <div>SAPPORO</div>
                   <div class="place-location">
                       <img src="${root}/static/img/location/삿포로.jpg" alt="">
                   </div>
               </a>
            </div>

            <div id="place-location-ko" class="ja-area noReady" onmouseover="enlargeImage(this)" onmouseout="resetImageSize(this)">
                <!-- <a href=""> -->
                    <div>NAGOYA</div>
                    <div class="place-location">
                        <img src="${root}/static/img/location/나고야.jpg" alt="">
                    </div>
                </a>
            </div>

            <div id="place-location-ko" class="ja-area noReady" onmouseover="enlargeImage(this)" onmouseout="resetImageSize(this)">
                <!-- <a href=""> -->
                    <div>YOKOHAMA</div>
                    <div class="place-location">
                        <img src="${root}/static/img/location/요코하마.jpg" alt="">
                    </div>
                </a>
            </div>
            <!--                    일본 끝                           -->








            <!--                    중국 시작                           -->
            <div id="place-location-ko" class="ch-area" onmouseover="enlargeImage(this)" onmouseout="resetImageSize(this)">
                <a  href="/semi/schedulermake?countryNo=3&locationNo=301">
                    <div>BEIJING</div>
                    <div class="place-location">
                            <img src="${root}/static/img/location/베이징.jpg" alt="">
                    </div>
                </a>
            </div>
            
            <div id="place-location-ko" class="ch-area" onmouseover="enlargeImage(this)" onmouseout="resetImageSize(this)">
                <a href="/semi/schedulermake?countryNo=3&locationNo=302">
                    <div>SHANGHAI</div>
                    <div class="place-location">
                        <img src="${root}/static/img/location/상하이.jpg" alt="">
                    </div>
                </a>
                
            </div>
            
            <div id="place-location-ko" class="ch-area" onmouseover="enlargeImage(this)" onmouseout="resetImageSize(this)">
                <a href="">
                    <div>GUANZHOU</div>
                    <div class="place-location">
                        <img src="${root}/static/img/location/광저우.jpg" alt="">
                    </div>
                </a>
            </div>

            <div id="place-location-ko" class="ch-area" onmouseover="enlargeImage(this)" onmouseout="resetImageSize(this)">
               <a href="">
                   <div>CHONGQING</div>
                   <div class="place-location">
                       <img src="${root}/static/img/location/청진.jpg" alt="">
                   </div>
               </a>
            </div>

            <div id="place-location-ko" class="ch-area" onmouseover="enlargeImage(this)" onmouseout="resetImageSize(this)">
                <a href="">
                    <div>HARBIN</div>
                    <div class="place-location">
                        <img src="${root}/static/img/location/하얼빈.jpg" alt="">
                    </div>
                </a>
            </div>

            <div id="place-location-ko" class="ch-area" onmouseover="enlargeImage(this)" onmouseout="resetImageSize(this)">
                <a href="">
                    <div>TIANJIN</div>
                    <div class="place-location">
                        <img src="${root}/static/img/location/톈진.jpg" alt="">
                    </div>
                </a>
            </div>
            <!--                    중국 끝                           -->







            <!--                    싱가폴 시작                           -->
            <div id="place-location-ko" class="si-area" onmouseover="enlargeImage(this)" onmouseout="resetImageSize(this)">
                <a  href="/semi/schedulermake?countryNo=4&locationNo=401">
                    <div>SINGAPORE</div>
                    <div class="place-location">
                            <img src="${root}/static/img/location/싱가폴.jpg" alt="">
                    </div>
                </a>
            </div>
            
            <div id="place-location-ko" class="si-area noReady" onmouseover="enlargeImage(this)" onmouseout="resetImageSize(this)">
                <a href="">
                    <div>준비중</div>
                    <div class="place-location">
                        <img src="${root}/static/img/location/레디.png" alt="">
                    </div>
                </a>
                
            </div>
            
            <div id="place-location-ko" class="si-area noReady" onmouseover="enlargeImage(this)" onmouseout="resetImageSize(this)">
                <a href="">
                    <div>준비중</div>
                    <div class="place-location">
                        <img src="${root}/static/img/location/레디.png" alt="">
                    </div>
                </a>
            </div>

            <div id="place-location-ko" class="si-area noReady" onmouseover="enlargeImage(this)" onmouseout="resetImageSize(this)">
               <a href="">
                   <div>준비중</div>
                   <div class="place-location">
                       <img src="${root}/static/img/location/레디.png" alt="">
                   </div>
               </a>
            </div>

            <div id="place-location-ko" class="si-area noReady" onmouseover="enlargeImage(this)" onmouseout="resetImageSize(this)">
                <a href="">
                    <div>준비중</div>
                    <div class="place-location">
                        <img src="${root}/static/img/location/레디.png" alt="">
                    </div>
                </a>
            </div>

            <div id="place-location-ko" class="si-area noReady " onmouseover="enlargeImage(this)" onmouseout="resetImageSize(this)">
                <a href="">
                    <div>준비중</div>
                    <div class="place-location">
                        <img src="${root}/static/img/location/레디.png" alt="">
                    </div>
                </a>
            </div>
            <!--                    싱가폴 끝                           -->









            <!--                    필리핀 시작                           -->
            <div id="place-location-ko" class="pi-area" onmouseover="enlargeImage(this)" onmouseout="resetImageSize(this)">
                <a  href="/semi/schedulermake?countryNo=1&locationNo=101">
                    <div>JEJU</div>
                    <div class="place-location">
                            <img src="${root}/static/img/jeju000.jpg" alt="">
                    </div>
                </a>
            </div>
            
            <div id="place-location-ko" class="pi-area" onmouseover="enlargeImage(this)" onmouseout="resetImageSize(this)">
                <a href="">
                    <div>1</div>
                    <div class="place-location">
                        <img src="${root}/static/img/seoul000.jpg" alt="">
                    </div>
                </a>
                
            </div>
            
            <div id="place-location-ko" class="pi-area" onmouseover="enlargeImage(this)" onmouseout="resetImageSize(this)">
                <a href="">
                    <div>BUSAN</div>
                    <div class="place-location">
                        <img src="${root}/static/img/busan000.jpg" alt="">
                    </div>
                </a>
            </div>

            <div id="place-location-ko" class="pi-area" onmouseover="enlargeImage(this)" onmouseout="resetImageSize(this)">
               <a href="">
                   <div>GANGWON</div>
                   <div class="place-location">
                       <img src="${root}/static/img/ganwon000.jpg" alt="">
                   </div>
               </a>
            </div>

            <div id="place-location-ko" class="pi-area" onmouseover="enlargeImage(this)" onmouseout="resetImageSize(this)">
                <a href="">
                    <div>YEOSU</div>
                    <div class="place-location">
                        <img src="${root}/static/img/yeosu000.jpg" alt="">
                    </div>
                </a>
            </div>

            <div id="place-location-ko" class="pi-area" onmouseover="enlargeImage(this)" onmouseout="resetImageSize(this)">
                <a href="">
                    <div>INCHEON</div>
                    <div class="place-location">
                        <img src="${root}/static/img/incheon000.jpg" alt="">
                    </div>
                </a>
            </div>
            <!--                    필리핀 끝                           -->


        
        </div>
        </div>
        
	
	
	</main>
	
	
	
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>

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
    
        //a태그로 submit
        function submitForm() {
            document.getElementById('myForm').submit();
        }


        var ko = document.querySelector("#ko");
        var ja = document.querySelector("#ja");
        var ch = document.querySelector("#ch");
        var si = document.querySelector("#si");
        var pi = document.querySelector("#pi");
    
        var koArea = document.querySelectorAll(".ko-area");
        var jaArea = document.querySelectorAll(".ja-area");
        var chArea = document.querySelectorAll(".ch-area");
        var siArea = document.querySelectorAll(".si-area");
        var piArea = document.querySelectorAll(".pi-area");
    
        ja.addEventListener("click",function(){
            for (var i = 0; i < koArea.length; i++) {
                koArea[i].style.display = "none";
                chArea[i].style.display = "none";
                piArea[i].style.display = "none";
                siArea[i].style.display = "none";
            }
            for (var j = 0; j < jaArea.length; j++) {
                jaArea[j].style.display = "block";
            }
        })
        ko.addEventListener("click",function(){
            for (var i = 0; i < koArea.length; i++) {
                jaArea[i].style.display = "none";
                chArea[i].style.display = "none";
                piArea[i].style.display = "none";
                siArea[i].style.display = "none";
            }
            for (var j = 0; j < jaArea.length; j++) {
                koArea[j].style.display = "block";
            }
        })

        
        ch.addEventListener("click",function(){
            for (var i = 0; i < koArea.length; i++) {
                koArea[i].style.display = "none";
                jaArea[i].style.display = "none";
                piArea[i].style.display = "none";
                siArea[i].style.display = "none";
            }
            for (var j = 0; j < jaArea.length; j++) {
                chArea[j].style.display = "block";
            }
        })

    
        si.addEventListener("click",function(){
            for (var i = 0; i < koArea.length; i++) {
                koArea[i].style.display = "none";
                chArea[i].style.display = "none";
                piArea[i].style.display = "none";
                jaArea[i].style.display = "none";
            }
            for (var j = 0; j < jaArea.length; j++) {
                siArea[j].style.display = "block";
            }
        })
        
        $().ready(function () {
            $(".noReady").click(function () {
                Swal.fire({
                    icon: 'error',
                    text: '아직 준비중입니다 조만간 업로드하겠습니다',
                });
            });
        });
    
    

    
    
    
    
    
    
       
    </script>


</body>
</html>