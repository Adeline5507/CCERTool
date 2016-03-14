<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
</head>
<body>
	<div style="text-align:center;padding-top:200px;">
		<form id="searchForm" action="/getProjects">
			<strong>项目名称：</strong><input type="text" size="60" name="projectName"/>
			<input type="submit" value="查询""> 
		</form>
		<div class="text-info">可以模糊查询，不填写的话查询所有中国项目</div>
	</div>
</body>

<script type="text/javascript">
	function doSearch(){
		
	}
</script>
</html>