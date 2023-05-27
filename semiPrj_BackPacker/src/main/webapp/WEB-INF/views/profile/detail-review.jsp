<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 제이쿼리 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<!-- 프로필 버튼 관련 부트스트랩 -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">

<!-- 폰트어썸 cdn -->
<script src="https://kit.fontawesome.com/794ac64f16.js" crossorigin="anonymous"></script>

<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
   .detail{
   		width : 660px;
     	 margin-top: 100px;
   }
      #page-area{
      width : 500px;
      margin: auto;
      display: flex;
      justify-content: space-evenly; 
   }
   

      .comentContent{
   		    padding-left: 20px;
    		vertical-align: baseline;
           font-size: 18px;
      }
      .dateIdNick{
         font-size : 12px;
      text-align: right;
         width : 100%;
      
         
   }
       
      .imgInput{
          padding: 5px;
          width: 50px;
          text-align: right;
          vertical-align: top;
          cursor: pointer;
      }
      #detailTitle{
         padding :20px;
         font-size: 25px;
      }
      #detailWrap{
         padding:  50px;
      }
      #detailWrap tr{
      height : 50px;
      }
      
       .profile-border{
         border-radius : 50px;
         }
</style>
</head>

<body>
   <div class="detail">
        <div id="detailTitle">
            <div hidden>${selectMemberDetail.memberNo}</div>
            <b>${selectMemberDetail.nick}님이 받은 평가</b>
        </div>
        <br>
        <div id="detailWrap">
            
            <table id="reviewTable">
            <c:forEach items="${ selectMemberReviewlistDetail }" var="reviewListDetail" >
                <tr>
                    <td hidden>
                        ${reviewListDetail.giverNo}
                    </td>
                    <td class = "imgInput " rowspan="2">
                    	<c:if test="${not empty reviewListDetail.giverProfile}">
                              <img  width="40px" height="40px"  class="btnimg profile-border"src="${root}/static/img/member/profile/${reviewListDetail.giverProfile}" alt="" onclick="imgClick(event)">
		                               
       					</c:if>
       					<c:if test="${empty reviewListDetail.giverProfile}">
       						 <img  width="40px" height="40px"  class="btnimg profile-border" src="${root}/static/img/member/profile/profile_default.jpg" alt="" onclick="imgClick(event)">
       					</c:if>
                    </td>
                    <td class="comentContent" >${reviewListDetail.content}</td>
                </tr>
                <tr>
                    
        
                    <td class="dateIdNick">${reviewListDetail.enrollDate} ${reviewListDetail.giverId} ${reviewListDetail.giverNick}</td>

                </tr>
                
              </c:forEach>
            </table>
            <br>

            
            
            <div id="page-area">
            <c:if test="${ pv.currentPage > 1 }">
               <a class="btn btn-outline-info" href="${pageContext.request.contextPath}/click/profile/review/detail?selectMemberNo=${selectMemberDetail.memberNo}&page=${pv.currentPage-1}">이전</a>
            </c:if>
            <c:forEach begin="${pv.startPage}" end="${pv.endPage}" var="i">
               <a class="btn btn-outline-info" href="${pageContext.request.contextPath}/click/profile/review/detail?selectMemberNo=${selectMemberDetail.memberNo}&page=${i}">${i}</a>
            </c:forEach>
            <c:if test="${ pv.currentPage < pv.maxPage }">
               <a class="btn btn-outline-info" href="${pageContext.request.contextPath}/click/profile/review/detail?selectMemberNo=${selectMemberDetail.memberNo}&page=${pv.currentPage+1}">다음</a>
            </c:if>
         </div>
        </div>
     </div>
</body>
</html>
<script type="text/javascript">
function imgClick(e) {
     const no = e.target.parentNode.parentNode.children[0].innerText; //게시글 작성자 번호
     const width = 800;
     const height = 1000;
     const left = (screen.width / 2) - (width / 2);
     const top = 0;
     window.open('${root}/click/profile?selectMemberNo='+no, '', 'width=' + width + ', height=' + height + ', left=' + left + ', top=' + top);
   }
</script>