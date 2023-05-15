<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <style>
         .profileStarWrap{
            margin-top: 100px;
            margin-left: auto;
            margin-right : auto;
            width: 600px;
            height: 800px;
        }
        #profileStarTop{
        	display : grid;
            margin: auto;
            width: 300px;
            height: 110px;
            text-align: left;
            grid-template-columns: 1fr 1fr;
            justify-content: center;
            align-items: center;
           
           
        }
        #profileStarForm{
            
            width: 100%;
            height: 80%;
        }
        #profileText{
        	text-align: center;
            margin: auto;
       }
        .star-rating {
            margin: auto;
            display: flex;
            flex-direction: row-reverse;
            font-size: 2.25rem;
            line-height: 2.5rem;
            justify-content: space-around;
            padding: 0 0.2em;
            text-align: center;
            width: 5em;
            
        }

        .star-rating input {
            display: none;
        }

        .star-rating label {
            
            
            -webkit-text-fill-color: transparent; /* Will override color (regardless of order) */
            -webkit-text-stroke-width: 2.3px;
            -webkit-text-stroke-color: #2b2a29;
            cursor: pointer;
        }

        .star-rating :checked ~ label {
            -webkit-text-fill-color: gold;
        }

        .star-rating label:hover,
        .star-rating label:hover ~ label {
            -webkit-text-fill-color: #fff58c;
        }
        #inputTitle{
            text-align: center;
        }

       
        #sendReivewBtn{
            margin-left: 150px;
            text-align: center;
            background-color:  rgba(0, 174, 255, 0.438);
            color: white;
            border: 0px;
            border-radius: 5px;
            width: 300px;
            height: 50px;
            font-size: 25px;
            
        }
        .tArea{
            margin: auto;
            width: 300px;
            height: 150px;
            resize: none;
        }
         .profile-border{
         border-radius : 50px;
         }
      .gcon{
      	text-align: center;
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
    <div class="profileStarWrap">
        <div id="profileStarTop">
            
        		<div class="gcon">${crv.chattingUserNick} </div>
        		<div class="gcon"> ${crv.chattingUser2Nick} </div>
       			<div class="gcon">
       				<div hidden > ${loginMember.memberNo}</div>
       				<img width="100px" height="100px"  class="btnimg profile-border" src="${root}/static/img/member/profile/${loginMember.profileImage}" onclick="imgClick(event)">
       			</div>
       		
       			<div class="gcon">
       				<div hidden > ${selectMember.memberNo}</div>
       				<img width="100px" height="100px"  class="btnimg profile-border" src="${root}/static/img/member/profile/${selectMember.profileImage}" onclick="imgClick(event)">
       			</div>
	        	
	        	
	       
        </div>
        <br>
        <div id="profileText">
        	${crv.chattingUserNick}님 ${crv.chattingUser2Nick}님과의 여행은 어떠셨나요?
	       
	        	
        </div>
        <br>
        <div id="profileStarForm">
            <form action="${pageContext.request.contextPath}/click/profile/review"  method="post">
                <div class="star-rating space-x-4 mx-auto">
                    <input type="radio" id="5-stars" name="rating" value="5" v-model="ratings"/>
                    <label for="5-stars" class="star pr-4">★</label>
                    <input type="radio" id="4-stars" name="rating" value="4" v-model="ratings"/>
                    <label for="4-stars" class="star">★</label>
                    <input type="radio" id="3-stars" name="rating" value="3" v-model="ratings"/>
                    <label for="3-stars" class="star">★</label>
                    <input type="radio" id="2-stars" name="rating" value="2" v-model="ratings"/>
                    <label for="2-stars" class="star">★</label>
                    <input type="radio" id="1-star" name="rating" value="1" v-model="ratings" />
                    <label for="1-star" class="star">★</label>
                </div>
                <br>
                <div id="inputTitle">
                    <b>여행 후기를 작성해 주세요</b>
                </div>
                <div class="tArea">
                    <textarea name="reviewContent" class="tArea"  ></textarea>
                     <input type="hidden" name="selectMemberNo" value="${selectMember.memberNo}">
                  <input type="hidden" name="loginMemberNo" value="${loginMember.memberNo}">
                       <input type="hidden" name="chattingRoomNo" value="${crv.chattingRoomNo}">
                </div>
                <br>
                <div id="btnDiv">
                    <button id="sendReivewBtn" type="submit">후기 보내기</button>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
<script>
   function imgClick(e) {
      const no = e.target.parentNode.children[0].innerText; //게시글 작성자 번호
      const width = 800;
      const height = 1000;
      const left = (screen.width / 2) - (width / 2);
      const top = 0;
      window.location.href ='${root}/click/profile?selectMemberNo='+no;
   }
   
 </script>