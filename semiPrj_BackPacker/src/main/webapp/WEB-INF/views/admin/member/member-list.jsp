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
<style>
   #wrapAdMem{
      margin-top: 100px;
       margin-left: auto;
      margin-right: auto;
       width: 800px;
   }
   #search{
       display: flex;
      
       
       justify-content: space-between;
   }
 
   #selopt{
       background-color: rgba(0, 102, 255, 0.211);
       border-radius: 15px;
   }
   #searchValue{
       background-color: rgba(0, 102, 255, 0.211);
       border-radius: 1px;
   }
   #adMemTable table {
       width: 800px;
       border-collapse: collapse;
       border-spacing: 0;
       text-align: center;
       font-size: 16px;
   }
   #adMemTable th{
   		text-align: center;
       border: 1px solid black;
   }
   #adMemTable td{
       border: 1px solid black;
   }
   
   #page-area{
         width : 300px;
         margin: auto;
         display: flex;
         justify-content: space-evenly; 
   }
   #subbtnstForm{
   		height: 20px;
   		border: 1px solid gray;
   		font-size: 15px;
   }
</style>
</head>

<body>
   <%@ include file="/WEB-INF/views/common/header.jsp" %>
   <%@ include file="/WEB-INF/views/common/nav.jsp" %>
    <div id="wrapAdMem">
        <h1>회원 관리 페이지</h1>
        <hr>
        <div id="search">

            <div>

                회원상태 : 1은 정상 , 2는 경고 , 3은 정지
            </div>
            <div>
            <form action="${root}/admin/member" method="post"">
                <input type="hidden" name="page" value="1">
                <select name="searchType" id="selopt">
                    <option value="memberName">회원 이름</option>
                    <option value="memberId">회원 아이디</option>
                    <option value="memberStatus">회원 상태</option>
                </select>
                <input type="text" name="searchValue" id="searchValue">
                <input type="submit" value="검색">
            </form>
            </div>
        </div>
        <br>
        <div id="adMemTable">
            <table>
                <thead>
                    <th>회원번호</th>
                    <th>이름</th>
                    <th>아이디</th>
                    <th>가입날짜</th>
                    <th>회원상태</th>
                    <th>수정하기</th>
                </thead>
                <tbody>
                    <c:forEach items="${ adminMemberVoList }" var="adminMemberVoList" >
                    <tr>
                        <td>${adminMemberVoList.memberNo}</td>
                        <td>${adminMemberVoList.name}</td>
                        <td>${adminMemberVoList.id}</td>
                        <td>${adminMemberVoList.enrollDate}</td>
                        <td> ${adminMemberVoList.memberStatus}</td>
                       
                      <td>
                            <form id= "stForm" action="${root}/admin/member/edit/status" method="post">
                            <input type="text" value="${adminMemberVoList.memberNo}" name="memberNo" hidden>
                                <select name="memberStatus" id="selectMemberStatus">
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                </select>
                                <input type="submit"  id="subbtnstForm" value="변경">
                                
                            </form>
                        </td>

                    </tr>
                 
                </c:forEach>
                </tbody>

            </table>
            <br><br>
            <div id="page-area">
               <c:if test="${pv.currentPage > 1}">
                  <a class="btn btn-primary btn-sm" href="${root}/admin/member?page=${pv.currentPage - 1}&searchType=${searchVo.searchType}&searchValue=${searchVo.searchValue}">이전</a>
               </c:if>
                  <c:forEach begin="${pv.startPage}" end="${pv.endPage}" step="1" var="i">
                     <c:if test="${pv.currentPage != i}">
                        <a class="btn btn-primary btn-sm" href="${root}/admin/member?page=${i}&searchType=${searchVo.searchType}&searchValue=${searchVo.searchValue}">${i}</a>
                     </c:if>
                     <c:if test="${pv.currentPage == i}">
                        <a class="btn btn-primary btn-sm">${i}</a>
                     </c:if>
                  </c:forEach>
               <c:if test="${pv.currentPage < pv.maxPage}">
                  <a class="btn btn-primary btn-sm" href="${root}/admin/member?page=${pv.currentPage + 1}&searchType=${searchVo.searchType}&searchValue=${searchVo.searchValue}">다음</a>
               </c:if>
            </div>
        </div>
    </div>
   
</body>
</html>
<script>
    //    $(document).ready(function() {
    //       $('form#stForm').on('submit', function(e){
    //          var memberNo1 = $(this).closest('tr').find('td:first').text();
    //             e.preventDefault();
    //             var status = $('#selectMemberStatus').val();
    //          var memberNo = e.target.parentNode.children[0].innerText;
    //          console.log(memberNo);
    //          console.log(status);
    //          console.log(memberNo1);
    //             $.ajax({
    //                 type: 'POST',
    //                 url: '${root}/admin/member/edit/status',
    //                 data: {
    //                     status: status,
    //                     memberNo: memberNo
    //                 },
    //                 success: (x)=>{
    //             console.log(x);
    //             if(x == 'ok'){
    //                alert(" 상태 변경 성공!");
    //                document.querySelector("select[name=memberStatus]").value = '';
    //                // loadComment();
    //             }else{
    //                alert("상태 변경 실패...");
    //             }
    //          } ,
    //          error : (x)=>{
    //             console.log(x);
    //          } ,
    //             });
    //         });
    //     });
    // let changeStatus;
    // changeStatus= document.querySelector('.changeStatus');
    // changeStatus.addEventListener('click', function(e) {
    //         let memberNo = ""; // 멤버 번호를 저장할 변수
    //         let tdElement = "";
    //         tdElement = $(event.target).closest('tr').find('td:first'); // 클릭한 버튼이 속한 행에서 첫 번째 td 요소 선택
      
    //         if (tdElement) {
    //              memberNo = tdElement.innerText; // td 요소의 텍스트 가져오기
    //         }
          
    //       $.ajax({
    //          url : '${root}/admin/member/edit/status' ,
    //          type : "GET" ,
    //          data : {
    //             memberNo : memberNo
    //          } ,
    //          success : function(x){
                
    //             console.log(x);
               
    //          } ,
    //          error : function(e){
    //             console.log(e);
    //          } ,
    //       });
    //    });
    // </script>
<!-- 
    <script>
   const tbody = document.querySelector("tbody");
   tbody.addEventListener("click" , function(e){
      const no = e.target.parentNode.children[0].innerText;
      location.href = "${pageContext.request.contextPath}/member/상태변경?no=" + no;
   });
</script>
 -->