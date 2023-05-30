<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>

<!-- 폰트어썸 -->
<script src="https://kit.fontawesome.com/794ac64f16.js" crossorigin="anonymous"></script>

<!-- 으음.썸머노트 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<style >
	*{
		margin: 0px;
		padding: 0px;
	}
	#wrap {
		margin : auto;
		width : 800px;
		height: 100px;
		display: flex;
		flex-direction: column;
		align-items: center;
		
	}
	#big-txt {
		margin-top: 15px;
		font-size: 1.4em;
		width: 600px;
		text-align: left;
		font-weight: 700;
	}
	#input-area {
		margin-top: 15px;
	}

	#input-area > input{
		width: 600px;
		border: none;
		border-bottom: 1px solid black;
		outline: none;
		font-size: 16px;
		
	}
	

	
	#btn {
		width: 600px;
	}

	#btn > input {
		float: right ;
		font-size: 17px;
	}
	#left {
		float: left;
	}
</style>
</head>
<body>

	<div id="wrap">
			<input type="hidden" name="no" value="${vo.infoNo}">
			<div id="big-txt">
			제목 수정하기
			</div>
			<div id="input-area">
			<input type="text" name="title" value="${vo.title}">
			</div>
			<div id="big-txt">
			내용 수정하기
			</div>
			<div>
			<textarea id="summernote" name="content" style="resize:none;">${vo.content}</textarea>
			</div>
			<div id="btn">
				<div id="left"><i class="fa-solid fa-circle-info fa-lg" style="color: #94D2E6;"></i>자기소개는 마이페이지에서 변경할 수 있습니다.</div>
				<input type="submit" class="edit-btn"  value="수정하기">
			</div>
		</div>

		<script>
		
		$('#summernote').summernote({
	    	  placeholder: 'Hello stand alone ui',
	    	  tabsize: 2,
	    	  height: 450,
	    	  callbacks : {
	              onImageUpload : f01
	            } ,
	    	  toolbar: [
	    	    ['style', ['style']],
	    	    ['font', ['bold', 'underline', 'clear']],
	    	    ['color', ['color']],
	    	    ['para', ['ul', 'ol', 'paragraph']],
	    	    ['table', ['table']],
	    	    ['insert', ['link', 'picture', 'video']],
	    	    ['view', ['fullscreen', 'codeview', 'help']]
	    	  ]
	    	});
		 //파일업로드 발생 시 동작
        function f01(fileList){

          const fd = new FormData();
          for(let file of fileList){
            fd.append("f" , file);
          }

          $.ajax({
            url : '${root}/upload' ,
            type : 'post' ,
            data : fd ,
            processData : false ,
            contentType : false ,
            dataType : 'json' ,
			success: function(changeNameList) {
			console.log(changeNameList);
			for (let changeName of changeNameList) {
				const imageUrl = '${root}/static/img/travelReview/' + changeName;
				$('<img>').on('load', function() {
				$(this).attr('width', '300'); // Set the desired width
				$(this).attr('height', '200'); // Set the desired height
				$('#summernote').summernote('insertNode', this);
				}).attr('src', imageUrl);
			}
			},
            error : function(error){
              console.log(error);
            } ,
          });

        }
		
			const editBtn = document.querySelector('.edit-btn');

			editBtn.addEventListener('click' , function() {
				const infoNo = document.querySelector('input[name=no]').value;
				const title = document.querySelector('input[name=title]').value;
				const content = document.querySelector('textarea').value;
				
				$.ajax({
					url :'${root}/notice/reviewEdit',
					type :'post',
					data : {
						title : title,
						infoNo : infoNo,
						content : content,
					},
					success : function (x) {
						if(x=='ok'){
							window.opener.parent.location.reload();
							alert('수정완료되었습니다.')
							setTimeout(() => {
								window.close();
							}, 1000);
						}else{
							alert('수정실패하였습니다.')
						setTimeout(() => {
							window.close();
						}, 1000);
						}
					},
					error : function(e) {
						alert(e+"관리자에게 문의하세요.")
						setTimeout(() => {
							window.close();
						}, 1000);
					},
					
				});
				
			})

		</script>


</body>
</html>