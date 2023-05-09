<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
   #wrapAdMem{
       margin: auto;
       width: 800px;
   }
   #search{
       display: flex;
      
       
       justify-content: space-between;
   }
   #selopt{
       background-color: rgba(0, 102, 255, 0.411);
       border-radius: 15px;
   }
   #searchValue{
       background-color: rgba(0, 102, 255, 0.411);
       border-radius: 1px;
   }
   #adMemTable table {
       width: 800px;
       border-collapse: collapse;
       border-spacing: 0;
       text-align: center;
       font-size: 26px;
   }
   #adMemTable th{
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
</style>
</head>
<script>
    $(document).ready(function() {
        $('form#stForm').on('submit', function(e){
            e.preventDefault();
            var status = $('#selectMemberStatus').val();
            var memberNo = $(this).closest('tr').find('td:first').text();
            $.ajax({
                type: 'POST',
                url: '${root}/admin/member/edit/status',
                data: {
                    status: status,
                    memberNo: memberNo
                },
                success: (x)=>{
            console.log(x);
            if(x == 'ok'){
               alert(" 상태 변경 성공!");
               document.querySelector("select[name=memberStatus]").value = '';
               // loadComment();
            }else{
               alert("상태 변경 실패...");
            }
         } ,
         error : (x)=>{
            console.log(x);
         } ,
            });
        });
    });


    // function loadComment(){
   //    const replyListArea = document.querySelector("#reply-list-area");
      
   //    $.ajax({
   //       url : '${root}/notice/reply/list' ,
   //       type : "GET" ,
   //       data : {
   //          noticeNo : '${vo.no}'
   //       } ,
   //       success : function(data){
   //          console.log(data);
   //          //JSON 형태로 받아서, 화면에 보여주기
   //          const x = JSON.parse(data);
   //          console.log(x);
   //          const tbody = document.querySelector('#reply-list-area tbody');
   //          tbody.innerHTML = "";
   //          let str = "";
   //          for(let i = 0; i < x.length; i++){
   //             str += '<tr>';
   //             str += '<td>' + x[i].content + '</td>';
   //             str += '<td>' + x[i].writerNo + '</td>';
   //             str += '<td>' + x[i].enrollDate + '</td>';
   //             str += '</tr>';
   //          }
   //          tbody.innerHTML += str;
   //       } ,
   //       error : function(e){
   //          console.log(e);
   //       } ,
   //    });
   // }
    </script>
<body>
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
                    <c:forEach items="${ adminMemberVoList }" var="adminMemberVo" >
                    <tr>
                        <td>${adminMemberVo.memberNo}</td>
                        <td>${adminMemberVo.name}</td>
                        <td>${adminMemberVo.id}</td>
                        <td>${adminMemberVo.enrollDate}</td>
                        <td> ${adminMemberVo.memberStatus}</td>
                       
                      
                            <form id= "stForm" action="" method="post">
                                <select name="memberStatus" id="selectMemberStatus">
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                </select>
                                <button type="submit">변경</button>
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
<!-- 
    <script>
   const tbody = document.querySelector("tbody");
   tbody.addEventListener("click" , function(e){
      const no = e.target.parentNode.children[0].innerText;
      location.href = "${pageContext.request.contextPath}/member/상태변경?no=" + no;
   });
</script>
 -->
