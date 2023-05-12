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
    #place-list-wrap{
        width: 400px;
        margin-top: 100px;
        margin-left:auto;
        margin-right:auto;
        height: 600px;
    }
    #place-list-title{
        margin: auto;
        text-align: center;
        color: rgb(179, 233, 247);
    }
    #search-place-list{
        text-align: right;
    }
    .search {
    position: relative;
    width: 300px;
    }

    #input1 {
    margin-left: 180px;
    width: 70%;
    border: 1px solid #bbb;
    border-radius: 8px;
    padding: 10px 12px;
    font-size: 14px;
    }

    #img1 {
    position : absolute;
    width: 17px;
    top: 14px;
    left: 350px;
    
    margin: 0;
    }
    #page-area{
        display: flex;
        justify-content: space-evenly;
    }
</style>
</head>
<body>
 <%@ include file="/WEB-INF/views/common/nav.jsp" %>
	<div id="place-list-wrap">
        <div id="place-list-title"><h1>여행지 목록</h1></div>
   
        <div class="search" id="search-place-list">
            <form action="" method="get">

                <input type="text" id="input1" name="search" placeholder="검색어 입력">
                <input type="image" id="img1" src="https://s3.ap-northeast-2.amazonaws.com/cdn.wecode.co.kr/icon/search.png" alt="Submit" />
            </form>
            
        </div>
        <br>
        
        <div id="place-list">
            <table id="place-list-table">
                <tr>
                    <span>[일본]</span><span>[오사카]</span><span>[도톤보리]</span>
                </tr>
                <hr>
                <tr>
                    <span>[일본]</span><span>[교토]</span><span>[도톤보리]</span>
                </tr>
                <hr>
                <tr>
                    <span>[일본]</span><span>[교토]</span><span>[도톤보리]</span>
                </tr>
                <hr>
                <tr>
                    <span>[일본]</span><span>[교토]</span><span>[도톤보리]</span>
                </tr>
                <hr>
                <tr>
                    <span>[일본]</span><span>[교토]</span><span>[도톤보리]</span>
                </tr>
                <hr>
                <tr>
                    <span>[일본]</span><span>[교토]</span><span>[도톤보리]</span>
                </tr>
                <hr>
                <tr>
                    <span>[일본]</span><span>[교토]</span><span>[도톤보리]</span>
                </tr>
                <hr>
               

            </table>
            <div id="page-area">
                <c:if test="${ pv.currentPage > 1 }">
                   <a class="btn btn-outline-info" href="${pageContext.request.contextPath}/?page=${pv.currentPage-1}">이전</a>
                </c:if>
                <c:forEach begin="${pv.startPage}" end="${pv.endPage}" var="i">
                   <a class="btn btn-outline-info" href="${pageContext.request.contextPath}/?page=${i}">${i}</a>
                </c:forEach>
                <c:if test="${ pv.currentPage < pv.maxPage }">
                   <a class="btn btn-outline-info" href="${pageContext.request.contextPath}/?page=${pv.currentPage+1}">다음</a>
                </c:if>
             </div>
        </div>
        
    </div>
</body>
</html>