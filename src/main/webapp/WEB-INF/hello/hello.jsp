<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head> 
    <title>Getting Started: Handling Form Submission</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
    <h5>hello ${name}</h5>
	<h1>Form</h1>
    <form action="#" th:action="@{/greet}" th:object="${greeting}" method="post">
    	<p>Id:&nbsp;&nbsp;<input type="text" name="id" th:field="*{id}" /></p>
        <p>Message: <input type="text" name="content" th:field="*{content}" /></p>
        <p style="display:none">Name: <input type="text" name="name" value="${name}" th:field="*{name}"></p>
        <p><input type="submit" value="Submit" /> <input type="reset" value="Reset" /></p>
    </form>
</body>
</html>
