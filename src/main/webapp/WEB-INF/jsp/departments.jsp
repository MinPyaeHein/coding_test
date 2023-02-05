
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <c:forEach var="at" items="${departments}" varStatus="s">
		<h1>${at.dep_name}</h1>	
</c:forEach>
</body>
</html>