<!DOCTYPE html>
<html>
<head>
<title>Book Input Result</title>
</head>
<body>
<div>책아이디 : <c:out value="${bookInfoDto.bookID}" /></div>
<div>책이름 : <c:out value="${bookInfoDto.bookName}" /></div>
<div>발행일 : <c:out value="${bookInfoDto.publishDate}" /></div>
<div>발행일 : <fmt:formatDate value="${bookInfoDto.publishDate}" pattern="yyyyMMddHHmmss"/></div>
<c:forEach var="booktype" items="${bookInfoDto.bookType}" >
<c:out value="${booktype}" /><br>
</c:forEach>
<br>
<a href="<c:url value='form' />" >입력화면으로 이동</a>
</body>
</html>