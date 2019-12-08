<!DOCTYPE html>
<html>
<head>
<title>책정보를 입력하세요</title>
</head>
<body>
<h2>책정보 입력</h2>
<form:form modelAttribute="bookInfoDto" >
<div>책 이름을 입력하세요.</div>
<div><form:input path="bookName" /></div>
<div>발행일을 입력하세요.</div>
<div><form:input path="publishDate" /></div>
<div><input type="checkbox" name="bookType"  value="type1"/>type1</div>
<div><input type="checkbox" name="bookType"  value="type2"/>type2</div>
<div><input type="checkbox" name="bookType"  value="type3"/>type3</div>
<div><input type="checkbox" name="bookType"  value="type4"/>type4</div>
<div><form:button>전송</form:button></div>
</form:form>
</body>
</html>