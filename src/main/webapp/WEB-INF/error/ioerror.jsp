<%@ page isErrorPage="true"%>
<%@ include file="/WEB-INF/include.jsp" %>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
<h1>Exception</h1>
<c:out value="${javax.servlet.error.exception_type}" />
<%=exception.getClass().getName() %>

</body>
</html>