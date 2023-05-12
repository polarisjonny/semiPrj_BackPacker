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
            <div id="search-area">
            <form action="${root}/admin/member" method="get"">
                <input type="hidden" value="1" name="page">
                    <select name="searchType" id="opt" >
                        <option value="memberName" >이름</option>
                        <option value="memberId" >아이디</option>
                        <option value="memberNick" >닉네임</option>
                        <option value="memberStatus">회원상태</option>
                        <option value="memberScore">최소점수</option>
                        
                    </select>
                    
               
                    <input class = "searchValueElem " id="searchValue" type = "text" name = "searchValue" value = "${searchVo.searchValue}" placeholder="검색할 내용">
                    
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
                    <th>닉네임</th>
                    <th>가입날짜</th>
                    <th>회원점수</th>
                    <th>회원상태</th>
                    
                    <th>상태 수정하기</th>
                </thead>
                <tbody>
                    <c:forEach items="${ adminMemberVoList }" var="adminMemberVoList" >
                    <tr>
                        <td>${adminMemberVoList.memberNo}</td>
                        <td>${adminMemberVoList.name}</td>
                        <td>${adminMemberVoList.id}</td>
                        <td>${adminMemberVoList.nick}</td>
                        <td>${adminMemberVoList.enrollDate}</td>
                        <td>${adminMemberVoList.memberScore}</td>
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
