<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
   <style type="text/css">

        .profileWrap{
           padding-top: 100px;
           width: 600px;
           height: 800px;
           margin: auto;
       }
       .profileTop{
          
           height: 10%;
           display: grid;
           grid-template-columns: 3fr 1fr;
           
           
       }
   
       #profileTopLeft{
       		font-size : 22px;
           grid-row: 1/3;
           text-align: left;
           color:  rgba(0, 174, 255, 0.438);
       }
       
     
   
       #profileTopRightUp{
           text-align: center;
           font-size: 24px;
           
   
       }
   
       #profileTopRightDown{
           display: grid;
           grid-template-columns: 1fr 1fr;
           text-align: center;
           font-size: 12px;
       }
   
       #profileTopRightUp button{
           background-color: rgba(255, 0, 0, 0.397);
           color: white;
           width: 135px;
           height: 30px;
           font-size: 15px;
           border: 0px;
           border-radius: 10px;
       }
       #profileTopRightDown button{
           border: 0px;
           background-color: rgba(0, 174, 255, 0.438);
           color: white;
           margin: auto;
           width: 65px;
           height: 20px;
           font-size: 9px;
           border-radius: 5px;
       }
   
   
   
   
       .profileMiddle{
           height: 40%;
          
           display: grid;
           grid-template-columns: 1fr 4fr;
           grid-template-rows: 1fr 7fr;
           
           
       }
       #profileMidLeft{
           padding: 10px;
           text-align: right;
           vertical-align: top;
           grid-row: 1/3;
       }
   
       #profileMidRightUp{
           display: grid;
           grid-template-columns: 9fr 4fr;
           grid-row: 1;
           text-align: left;
       }
       #profileMidRightUpDistance{
           font-size: 25px;
           color:  rgba(0, 174, 255, 0.438);
       }
       #profileMidRightUpKm{
           font-size: 18px;
           letter-spacing: 1px;
           color:  rgba(0, 174, 255, 0.438);
       }
       #profileMidRightDown{
          word-wrap: break-word;
         width: 320px;
         height: 200px;
           letter-spacing: 0.5px;
           overflow: auto;
           
   
       }
   
       .profileBottom{
           margin-left: 30px;
           height: 50%;
           
           
       }
       #more{
           
           margin: auto;
           width: 80px;
           border: 0px;
           font-size: 15px;
           border-radius: 10px;
           background-color: rgba(0, 174, 255, 0.438);
           color: white;
       }
       #profileBottomTitle{
           margin-left: 60px;
           font-size: 24px;
           letter-spacing: 1px;
           color:  rgba(0, 174, 255, 0.438);
       }
       .comentContent{
           font-size: 18px;
       }
       .dateIdNick{
          font-size : 12px;
         text-align: right;
          width : 100%;
         height: 50px
          
      }
        
       .imgInput{
           padding: 5px;
           width: 50px;
           text-align: right;
           vertical-align: top;
           cursor: pointer;
       }
         
         #reviewTable{
         height : 150px
         }
         .btnimg{
         cursor: pointer;
         	border: 0px;
         	cursor: pointer;
         }
   </style>
</head>

<body>
    <%@ include file="/WEB-INF/views/common/header.jsp" %>
    <div class="profileWrap">

        <div class="profileTop">
            <div id="profileTopLeft">
                ${selectMember.nick } 님의 프로필
    
            </div>
            
            <div id="profileTopRightUp">
              <button id="writeReview" onclick="writeReview()">
                후기 작성하기
              </button>    
            </div>
            <c:if test="${selectMember.memberNo eq loginMember.memberNo }">
            <div id="profileTopRightDown">
               
            </div>
            </c:if>
        </div>

        <div class="profileMiddle">
            <div id="profileMidLeft">
                 <img width="100px" height="100px" id="profile-border" src="${root}/static/img/temp_profile.png" alt="">
            </div>
            <div id="profileMidRightUp">
                <div id="profileMidRightUpDistance">
                    <b>
                        <img width="30px" height="30px" src="${root}/static/img/profile/airplane.jpg" alt=""> 이동한거리
                    </b>
                </div>
                <div id="profileMidRightUpKm">
                   <b>${selectMember.memberScore } KM</b> 
                </div>
            </div>
            
            <div id="profileMidRightDown">
               
                    ${ selectMember.introMessage}
                
            </div>

        </div>
        

        <div class="profileBottom">
            <div id="profileBottomTitle">
            <div hidden>${selectMember.memberNo}</div>
                <b>${selectMember.nick}님이 받은 평가</b>
                <button id="more">더보기</button>
            </div>
            <br>
            <div>
               <c:forEach items="${ selectMemberReviewlist }" var="reviewList" end="1">
                <table id="reviewTable">
                    <tr>
		                  <td hidden>
		                     ${reviewList.giverNo}
		                  </td>
                        <td class = "imgInput " rowspan="2"  >
                          
							<img width="50px" height="50px"  class="btnimg" src="${root}/static/img/profile/airplane.jpg" alt="" onclick="imgClick(event)">
                          

                        </td>
                        <td class="comentContent" >${reviewList.content}</td>
                    </tr>
                    <tr>
                        
            
                        <td class="dateIdNick">${reviewList.enrollDate} ${reviewList.giverId} ${reviewList.giverNick}</td>

                    </tr>
            
                </table>
                <br>
                
                </c:forEach>
                
         </div>
         </div>
            
           


       

    </div>
</body>
</html>


<script>
   function imgClick(e) {
      const no = e.target.parentNode.parentNode.children[0].innerText; //게시글 작성자 번호
      const width = 800;
      const height = 1000;
      const left = (screen.width / 2) - (width / 2);
      const top = 0;
      window.location.href ='${root}/click/profile?selectMemberNo='+no;
   }
   
   const more = document.querySelector("#more");
   more.addEventListener('click',function(e){
      const no1 = e.target.parentNode.children[0].innerText; //게시글 작성자 번호
            
      e.preventDefault();
        window.location.href ='${root}/click/profile/review/detail?selectMemberNo='+no1;
   })

   function writeReview() {
      
      
      window.location.href = '${root}/click/profile/review?selectMemberNo=${selectMember.memberNo}&loginMemberNo=${loginMember.memberNo}';
      
   }
   
  
   
   
</script>

<script type="text/javascript">
   
</script>