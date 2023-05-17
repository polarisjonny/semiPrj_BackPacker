<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프패커 등록 페이지</title>
<style>
        #register-title {
        	margin-top: 5%;
            color: #94d2e6;
            text-align: center;
            font-weight: bold;
        }

        #law-area {
            margin: auto;
            border: 1px solid lightgray;
            width: 50%;
            height: 50%;
        }

        hr {
            border: lightgray 1px solid;
        }

        #check-area {
            width: 50%;
            height: 50%;
            margin: auto;
        }

        #file-area {
            margin: auto;
            width: 50%;
            height: 50%;
        }

        #id-card-title {
            margin: auto;
            width: 50%;
            height: 50%;
        }

        #register-submit-btn {
            float: center;
            text-align: center;
            width: 100%;
            height: 40px;
            border: none;
            color: white;
            background-color: #94d2e6;
            margin-bottom: 5%;
        }
    </style>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>

	 <main> 
    	<h1 id="register-title">프패커 등록</h1>

    <div id="law-area">
        <p>
            <p>백패커 주식회사 개인정보 처리 방침 </p>

            <hr>

            <p>백패커 주식회사(이하 "회사"라 함)는 개인정보보호법을 준수하며, </p>
            <p>관련 법령에 의거한 개인정보처리방침을 정하여 이용자 권익 보호에 최선을 다하고 있습니다.</p>

            <p>회사의 개인정보처리방침은 다음과 같은 내용을 담고 있습니다.</p>


            <p>
                1. 개인정보의 처리목적 및 수집항목
                2. 개인정보의 제3자 제공
                3. 개인정보 처리의 위탁
                4. 개인정보의 처리 및 보유기간
                5. 개인정보 파기절차 및 방법
                6. 정보주체의 권리·의무 및 그 행사방법
                7. 개인정보의 안전성 확보조치
                8. 개인정보 자동 수집 장치의 설치ㆍ
                운영 및 거부에 관한 사항
                9. 개인정보보호 책임자 및 연락처
                10. 기타
                11. 개인정보처리방침의 변경
                1. 개인정보의 처리목적 및 수집항목
                개인정보 처리의 위탁
                수집시점	처리목적	수집항목
            </p>
            

           <p> 제휴제안 접수 시	제휴제안 접수 및 처리결과 회신	회사명, 제안자명, 전화번호, 이메일 주소, 홈페이지 주소(제안에 필요한 경우), 팩스번호(제안에 필요한 경우)
            <p>기업윤리 상담센터 상담/신고하기 접수 시	기업윤리 상담센터의 상담/신고 접수 및 처리결과 회신	성명, 연락처, 이메일 주소, 처리결과 확인용 비밀번호 (익명 접수 시에는 비밀번호만 수집합니다.)
                파트너스 라인 작성 및 분쟁조정 신청 시	파트너스 라인 접수, 분쟁조정 신청 및 처리결과 회신	제안자명, 파트너(업체)명, 연락처, 이메일 주소</p>
                IR 미팅 접수 시	IR 미팅 신청에 따른 본인확인 및 원활한 의사소통 경로 확보	신청인 및 방문자(동행인)의 회사명, 이름, 직책, 이메일, 연락처
                서비스 이용과정이나 사업처리 과정에서 아래와 같은 정보들이 자동으로 생성되어 수집될 수 있습니다.</p>
            <p>회사는 홈페이지 웹문서를 통한 사용자 입력 방법으로 개인정보를 수집하며, 경우에 따라 출력된 형태의 종이문서 혹은 이메일로 일부 정보를 수집할 수도 있습니다.</p>
        </p>
    </div>
    <br>

    <br>
    <br>
    <br>
    <br>
    <h2 id="id-card-title">신분증 등록</h2>
    <br>
    <br>
    <form action="${pageContext.request.contextPath}/member/join/fpacker" method="post"  enctype="multipart/form-data">
        <div id="file-area">
            <input type="file" name="idCard">
            <br>
            <br>
            <br>
            <br>
            <input id="register-submit-btn" type="submit" value="등록하기">
        </div>
    </form>

   </main>
</body>
</html>