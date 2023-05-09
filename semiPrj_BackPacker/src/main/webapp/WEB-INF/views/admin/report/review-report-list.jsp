<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    font-size: 18px;
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
<%@ include file="/WEB-INF/views/common/header.jsp" %>
 <%@ include file="/WEB-INF/views/common/nav.jsp" %>
<body>


   	 <div id="wrapt">
        <h1 id="th1">누적 신고 게시글 관리 페이지</h1>
        <hr>
        <div id="board1">
            <h2>후기 게시판 신고 목록</h2>
            <table id="acbtable">
                <!-- <thead>
                    <tr>
                        <th></th>
                        <th>글 제목</th>
                        <th>작성자 id</th>
                        <th>작성일시</th>
                        <th>신고수</th>
                    </tr>
                </thead> -->
                <tbody>
                    <tr>
                        <td>후기게시판vo.글번호</td>
                        <td>후기게시판vo.제목</td>
                        <td>후기게시판vo.작성자</td>
                        <td>후기게시판vo.작성일시</td>
                        <td>신고수</td>

                    </tr>
                   <tr>
                        <td>후기게시판vo.글번호</td>
                        <td>후기게시판vo.제목</td>
                        <td>후기게시판vo.작성자</td>
                        <td>후기게시판vo.작성일시</td>
                        <td>신고수</td>

                    </tr>
                    <tr>
                        <td>후기게시판vo.글번호</td>
                        <td>후기게시판vo.제목</td>
                        <td>후기게시판vo.작성자</td>
                        <td>후기게시판vo.작성일시</td>
                        <td>신고수</td>

                    </tr>
                    <tr>
                        <td>후기게시판vo.글번호</td>
                        <td>후기게시판vo.제목</td>
                        <td>후기게시판vo.작성자</td>
                        <td>후기게시판vo.작성일시</td>
                        <td>신고수</td>

                    </tr>
                    <tr>
                        <td>후기게시판vo.글번호</td>
                        <td>후기게시판vo.제목</td>
                        <td>후기게시판vo.작성자</td>
                        <td>후기게시판vo.작성일시</td>
                        <td>신고수</td>

                    </tr>
                    <tr>
                        <td>후기게시판vo.글번호</td>
                        <td>후기게시판vo.제목</td>
                        <td>후기게시판vo.작성자</td>
                        <td>후기게시판vo.작성일시</td>
                        <td>신고수</td>

                    </tr>
                    <tr>
                        <td>후기게시판vo.글번호</td>
                        <td>후기게시판vo.제목</td>
                        <td>후기게시판vo.작성자</td>
                        <td>후기게시판vo.작성일시</td>
                        <td>신고수</td>

                    </tr>
                    <tr>
                        <td>후기게시판vo.글번호</td>
                        <td>후기게시판vo.제목</td>
                        <td>후기게시판vo.작성자</td>
                        <td>후기게시판vo.작성일시</td>
                        <td>신고수</td>

                    </tr>
                    <tr>
                        <td>후기게시판vo.글번호</td>
                        <td>후기게시판vo.제목</td>
                        <td>후기게시판vo.작성자</td>
                        <td>후기게시판vo.작성일시</td>
                        <td>신고수</td>

                    </tr>
                    <tr>
                        <td>후기게시판vo.글번호</td>
                        <td>후기게시판vo.제목</td>
                        <td>후기게시판vo.작성자</td>
                        <td>후기게시판vo.작성일시</td>
                        <td>신고수</td>

                    </tr>
                    <tr>
                        <td>후기게시판vo.글번호</td>
                        <td>후기게시판vo.제목</td>
                        <td>후기게시판vo.작성자</td>
                        <td>후기게시판vo.작성일시</td>
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