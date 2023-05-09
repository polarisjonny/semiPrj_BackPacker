<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    #editProfileTotalWrap{
        
        margin-top: 80px;
        margin-left: auto;
         margin-right: auto; 
    }
    #editProfileWrap{
    
    width : 650px;
       height:350px;
       margin:auto;
        display: grid;
       
         grid-template-rows: 1fr 1fr;
        grid-gap: 10px;
    }
  
    #editTitle{
       padding-top : 20px ;
       color : rgba(0, 174, 255, 0.9);
       font-size:large;
       text-align: center;
    
    }
    #editIntro{
       padding-top : 20px ;
       color : rgba(0, 174, 255, 0.9);
       font-size:large;
       text-align: center;
    }
    #profileImage{
         width: 300px;
       background-color: rgba(0, 174, 255, 0.9);
       color : white;
       border : 0px;
       border-radius: 5px;
    }
    #profileTextArea{
         margin-left: auto;
         margin-right: auto; 
   }
   #introMessage{
         resize: none;
         width: 300px;
         height:250px;
   }
   #editSubmit{
      margin: auto;
      width: 100px;
      height: 50px;
      background-color: rgba(0, 174, 255, 0.5);
      color : white;
      border: 0px;
      border-radius: 5px;
   }
   #editSubmitDiv{
      text-align: center;
      margin: auto;
   }
</style>
</head>
<body>

<%@ include file="/WEB-INF/views/common/header.jsp" %>
<div id="editProfileTotalWrap">
   <form action="${pageContext.request.contextPath}/click/profile/edit/intMsg" method="post">
          
         <div id="editProfileWrap">
        
         <div id="editIntro">
            <b>자기소개 수정</b>         
         </div>
           <div id="profileTextArea">
               <textarea name="introMessage" id="introMessage">${loginMember.introMessage}</textarea>
           </div>
         </div>
      <div id="editSubmitDiv">
          <input id="editSubmit" type="submit" value="변경">
      </div>
   </form>
   
</div>  
 
</body>
</html>
<script>
   
</script>