<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<style>
 	footer {
        margin: 0px;
        padding: 0px;
        width: 100%;
        height: 300px;
    }

    .footer-box{
       
        height: 200px;
        margin-top: 80px;
        display: flex;
        justify-content: space-between;
    }

   .bold {
        font-size: 24px;
   }

   .footer-area {
        width: 550px;
        display: flex;
        justify-content: space-between;
   }
 

   .first {
    display: flex;

   }
   .first > div:first-child{
    width: 120px;
   }

   .end {
    display: flex;
   }

   .end > div:last-child{
    width: 120px;
   }

   a {
    text-decoration: none;
    color: black;
   }
   .mini , .mini>a{
        margin-top: 10px;
        font-size: 15px;
        color: #8F8F8F
   }
   .area1 {
    text-align: right;
   }
   .area2 {
    text-align: right;
   }

   .area3{
    text-align: right;
   }

   .hr-style {
    	margin: auto;
     	width: 95vw;
   }

   footer > div:first-child{
        height: 30px;
   }
</style>


<footer>
    <div></div>
    <hr class="hr-style">
    
    <div class="footer-box">
        <div class="first">
            <div></div>
            <div class="logo-area">
                <a id="logo" href="">
                    <img height="60px" src="${pageContext.request.contextPath}/static/img/logo/b_logo.png">
                </a>
            </div>
        </div>
       
    
        
        <div class="end">
            <div class="footer-area">
                <div class="area1">
                    <div class="bold"><a href="#">소개</a></div>
                    <div class="mini"><a href="#">백패커소개</a></div>
                    <div class="mini"><a href="#">프패커소개</a></div>
                </div>
                <div class="area2">
                    <div class="bold">파트너문의</div>
                    <div class="mini">서울특별시 강남구 테헨란로 14길 6층</div>
                </div>
                <div class="area3">
                    <div class="bold"><a href="#">문의사항</a></div>
                    <div class="mini"><a href="#">공지사항/FAQ</a></div>
                    <div class="mini"><a href="#">1:1문의하기</a></div>
                </div>
            </div>
            <div></div>
        </div>
    </div>
   

</footer>
