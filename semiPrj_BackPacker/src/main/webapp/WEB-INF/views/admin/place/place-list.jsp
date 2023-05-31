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
        width: 800px;
        margin-top: 100px;
        margin-left:auto;
        margin-right:auto;
        height: 800px;
    }
    #place-list-title{
        margin: auto;
        text-align: center;
        color: rgb(179, 233, 247);
    }
    #search-place-list{
    	
    	
    
      
    }
    .search {
	    position: relative;
	    width: 800px;
	    display : grid;
        grid-template-columns: 1fr 1fr 1fr;  
        justify-content: center;
        align-items: center;
    }

    #input1 {
    margin-left: 50px;
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
    left: 560px;
    
    margin: 0;
    }
    #page-area{
        display: flex;
        justify-content: space-evenly;
    }
    
    .place-btn{
    	border: 0px;
    	
    }
    #place-list-table {
    width: 800px;
    height : 80px;
    border-collapse: collapse;
    border-spacing: 10px;
    text-align: center;
    font-size: 18px;
    }

   #place-list-table th{
    
    border-bottom: 1px solid black;
    }
    #place-list-table td{
    padding-top: 10px;
     padding-bottom: 10px;
    border-bottom: 1px solid black;
    }
    #opt{
    	width : 150px;
    }
  	#editbtn{
  		border : 0px;
  	}
  	#deletebtn{
  		border : 0px;
  	}
</style>
</head>
<body>
 <%@ include file="/WEB-INF/views/common/nav.jsp" %>
	<div id="place-list-wrap">
        <div id="place-list-title"><h1>여행지 목록</h1></div>
        <br>
        
   
              
                    

        <div id="search-place-list">
            <form class="search" action="${root}/admin/place/list" method="get">
				 <input type="hidden" value="1" name="page">
				<div style="justify-content: space-between;">
        			<button class="place-btn"> <a href="${root}/admin/place/add">추가</a></button>
        		</div>
        		<div>
	        		<select name="searchType" id="opt" style="margin-right: 0px;" >
	                        <option value="countryCategory">국가</option>
	                        <option value="locationCategory" >지역</option>
	                        <option value="placeCategory" >카테고리</option>
	                        <option value="name" >여행지 이름</option>
	                        
	                  </select>
                  </div>
                  <div>
	                <input type="text" id="input1" name = "searchValue" value = "${searchVo.searchValue}" placeholder="검색어 입력">
	                <input type="image" id="img1" src="https://s3.ap-northeast-2.amazonaws.com/cdn.wecode.co.kr/icon/search.png" alt="Submit" />
                </div>
                 
            </form>
            
        </div>
        <br>
        
        <div id="place-list">
            <table id="place-list-table">
             <thead>
                    <tr>
                        <th>여행지 번호</th>
                        <th>국가</th>
                        <th>지역</th>
                        <th>카테고리</th>
                        <th>여행지 이름</th>
                        <th>수정하기</th>
                        <th>삭제하기</th>
                   </tr>
            </thead>
         	<tbody>
           	 		<c:forEach items="${voList}" var="vo">
	           	 		<tr>
			                <td>${vo.placeNo}</td>
			                <td>  ${vo.countryCategory}</td>
			                <td>${vo.locationCategory} </td>
			                <td> ${vo.placeCategory} </td>
			                <td> ${vo.placeName}</td>
			                <td> <button onclick="editbtn(${vo.placeNo})" >수정</button></td>
			                <td> <button onclick="deletebtn(${vo.placeNo})">삭제</button></td>
		                </tr>
	                
            	   </c:forEach>
               </tbody>
               

            </table>
            <br><br>
            <div id="page-area">
                <c:if test="${ pv.currentPage > 1 }">
                   <a class="btn btn-outline-info" href="${pageContext.request.contextPath}/admin/place/list?page=${pv.currentPage-1}&searchType=${searchVo.searchType}&searchValue=${searchVo.searchValue}">이전</a>
                </c:if>
                <c:forEach begin="${pv.startPage}" end="${pv.endPage}" var="i">
                   <a class="btn btn-outline-info" href="${pageContext.request.contextPath}/admin/place/list?page=${i}&searchType=${searchVo.searchType}&searchValue=${searchVo.searchValue}">${i}</a>
                </c:forEach>
                <c:if test="${ pv.currentPage < pv.maxPage }">
                   <a class="btn btn-outline-info" href="${pageContext.request.contextPath}/admin/place/list?page=${pv.currentPage+1}&searchType=${searchVo.searchType}&searchValue=${searchVo.searchValue}">다음</a>
                </c:if>
             </div>
        </div>
        
    </div>
</body>
</html>
<script>
		function deletebtn(e){
		
		    if (confirm("정말로 삭제하시겠습니까?")) {
		    	
		    	const no = e;
		    	window.location.href = "${root}/admin/place/delete?placeNo="+no;
			}
		};


		function editbtn(e){
			const no = e;
	    	window.location.href="${root}/admin/place/edit?placeNo="+no;
			
		}

		const openModals = document.querySelectorAll('.bi-info-circle');
		const closeModals = document.querySelectorAll('.close');
		const modals = document.querySelectorAll('.modal-area');
		
		openModals.forEach(function(openModal, index) {
			openModal.addEventListener('click', function() {
			modals[index].style.display = 'flex';
			});
		});
		
		closeModals.forEach(function(closeModal, index) {
			closeModal.addEventListener('click', function() {
			modals[index].style.display = 'none';
			});
		});


		const searchType = '${searchVo.searchType}';
		const searchValue = '${searchVo.searchValue}';
		
		const searchValueSelectTag = document.querySelector("select[name='searchValue']");
		const searchValueInputTag = document.querySelector("input[name='searchValue']");
		
		
		if( searchType.length > 1){
			initSearchType();
		};
		
		function initSearchType(){
		    const x = document.querySelector('select > option[value="' + searchType + '"]');
			x.selected = true;
		
		}
		
		
		

</script>