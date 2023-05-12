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
    #wrapt{
        width: 800px;
        margin-top: 100px;
        margin-left: auto;
        margin-right: auto;
    }
    #thi{
        text-align: center;
    }
    #acbtable {
    width: 800px;
    border-collapse: collapse;
    border-spacing: 10px;
    text-align: center;
    font-size: 16px;
    }

    #acbtable th{
    
    border-bottom: 1px solid black;
    }
    #acbtable td{
    padding-top: 10px; padding-bottom: 10px;
    border-bottom: 1px solid black;
    }

    #page-area-acb{
      width : 300px;
      margin: auto;
      display: flex;
      justify-content: space-evenly; 
}
</style>
</head>
<body>


   	 <div id="wrapt">
<%@ include file="/WEB-INF/views/common/header.jsp" %>
 <%@ include file="/WEB-INF/views/common/nav.jsp" %>
        <h1 id="th1">누적 신고 게시글 관리 페이지</h1>
        <hr>
        <div id="board1">
            <h2>프패커 게시판 신고 목록</h2>
            <table id="acbtable">
                 <thead>
                    <tr>
                        <th></th>
                        <th>글 제목</th>
                        <th>작성자 id</th>
                        <th>작성일시</th>
                        <th>신고수</th>
                    </tr>
                </thead> 
                <tbody>
                    <tr>
                        <td>프패커게시판vo.글번호</td>
                        <td>프패커게시판vo.제목</td>
                        <td>프패커게시판vo.작성자</td>
                        <td>프패커게시판vo.작성일시</td>
                        <td>신고수</td>

                    </tr>
                    <tr>
                        <td>프패커게시판vo.글번호</td>
                        <td>프패커게시판vo.제목</td>
                        <td>프패커게시판vo.작성자</td>
                        <td>프패커게시판vo.작성일시</td>
                        <td>신고수</td>

                    </tr>
                    <tr>
                        <td>프패커게시판vo.글번호</td>
                        <td>프패커게시판vo.제목</td>
                        <td>프패커게시판vo.작성자</td>
                        <td>프패커게시판vo.작성일시</td>
                        <td>신고수</td>

                    </tr>
                    <tr>
                        <td>프패커게시판vo.글번호</td>
                        <td>프패커게시판vo.제목</td>
                        <td>프패커게시판vo.작성자</td>
                        <td>프패커게시판vo.작성일시</td>
                        <td>신고수</td>

                    </tr>
                    <tr>
                        <td>프패커게시판vo.글번호</td>
                        <td>프패커게시판vo.제목</td>
                        <td>프패커게시판vo.작성자</td>
                        <td>프패커게시판vo.작성일시</td>
                        <td>신고수</td>

                    </tr>
                    <tr>
                        <td>프패커게시판vo.글번호</td>
                        <td>프패커게시판vo.제목</td>
                        <td>프패커게시판vo.작성자</td>
                        <td>프패커게시판vo.작성일시</td>
                        <td>신고수</td>

                    </tr>
                    <tr>
                        <td>프패커게시판vo.글번호</td>
                        <td>프패커게시판vo.제목</td>
                        <td>프패커게시판vo.작성자</td>
                        <td>프패커게시판vo.작성일시</td>
                        <td>신고수</td>

                    </tr>
                    <tr>
                        <td>프패커게시판vo.글번호</td>
                        <td>프패커게시판vo.제목</td>
                        <td>프패커게시판vo.작성자</td>
                        <td>프패커게시판vo.작성일시</td>
                        <td>신고수</td>

                    </tr>
                    <tr>
                        <td>프패커게시판vo.글번호</td>
                        <td>프패커게시판vo.제목</td>
                        <td>프패커게시판vo.작성자</td>
                        <td>프패커게시판vo.작성일시</td>
                        <td>신고수</td>

                    </tr>
                    <tr>
                        <td>프패커게시판vo.글번호</td>
                        <td>프패커게시판vo.제목</td>
                        <td>프패커게시판vo.작성자</td>
                        <td>프패커게시판vo.작성일시</td>
                        <td>신고수</td>

                    </tr>
                    <tr>
                        <td>프패커게시판vo.글번호</td>
                        <td>프패커게시판vo.제목</td>
                        <td>프패커게시판vo.작성자</td>
                        <td>프패커게시판vo.작성일시</td>
                        <td>신고수</td>

                    </tr>
                    

                </tbody>
            </table>
            <br><br>
            <div id="page-area-acb">
            
               <a class="btn btn-primary" href="${pageContext.request.contextPath}/신고게시글페이지/list?page=${pv.currentPage-1}">이전</a>
            
            
               <a class="btn btn-primary" href="${pageContext.request.contextPath}/신고게시글페이지/list?page=${i}">1</a>
                    <a class="btn btn-primary" href="${pageContext.request.contextPath}/신고게시글페이지/list?page=${i}">2</a>
                    <a class="btn btn-primary" href="${pageContext.request.contextPath}/신고게시글페이지/list?page=${i}">3</a>
                    <a class="btn btn-primary" href="${pageContext.request.contextPath}/신고게시글페이지/list?page=${i}">4</a>
                    <a class="btn btn-primary" href="${pageContext.request.contextPath}/신고게시글페이지/list?page=${i}">5</a>
                 

                    
            
            
               <a class="btn btn-primary" href="${pageContext.request.contextPath}/notice/list?page=${pv.currentPage+1}">다음</a>
            
         </div>
        </div>
    </div>
</body>

</body>
</html>
<script>
   const tbody = document.querySelector("tbody");
   tbody.addEventListener("click" , function(e){
      const no = e.target.parentNode.children[0].innerText;
      location.href = "${pageContext.request.contextPath}/프페커,동행게시판/detail?no=" + no;
   });
</script>