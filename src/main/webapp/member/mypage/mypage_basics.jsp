<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>
<layout:main title="마이페이지">
<form method="post" action="<c:url value="/mypage/basics" />" target="ifrmProcess">

아이디 <input type="text" disabled name="idRe" value="${member.id}">
이름 <input type="text" name="nameRe" value="${member.name}">
별명 <input type="text" name="fakeNameRe" value="${member.fakeName}">
이메일 <input type="email" name="emailRe" value="${member.email}">
전화번호 <input type="number" name="mobileRe" value="${member.mobile}">
주소 <input type="text" name="addressRe" value="${member.address}">


<button type="reset">다시하기</button>
<button type="submit">수정하기</button>
<button ><a href="<c:url value="/member/mypage/mypage.jsp"/>">돌아가기</a></button>
</form>
</layout:main>