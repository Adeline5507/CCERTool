<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
</head>
<body>
	<%
		String pList = (String)request.getAttribute("pList");
		
	%>
	
	
	
	<table id="projectTable" class="table table-condensed">
		<thead>
		  <tr>
	        <!--  <th><input type="checkbox" /></th> -->
	         <th>Project Name</th>
	         <!-- <th>Parse</th> -->
	      </tr>
		</thead>
	</table>
</body>
<script type="text/javascript">
		var json = eval(<%=pList%>);
		//alert("length:"+json.length);
		var numPerPage = 25;
		var begin = 1;
		var end = numPerPage;
		if(json.length<end){
			end = json.length;
		}
		currentPage =1;
		stuffTable();
		
		function next(){
			begin = end+1;
			end = end+numPerPage;
			if(json.length<end){
				end = json.length;
			}
			currentPage=currentPage+1;
			clearTable();
			stuffTable();
		}
		
		function previous(){
			end = begin -1;
			begin = begin-numPerPage;
			if(begin<=0){begin=1;end=numPerPage;}
			currentPage=currentPage-1;
			if(currentPage<1){currentPage=1;}
			clearTable();
			stuffTable();
		}
		
		function clearTable(){
			var table = document.getElementById("projectTable");
			var rowNum = table.rows.length;
			for(var i=1;i<rowNum;i++){
				 table.deleteRow(i);
				 rowNum=rowNum-1;
		         i=i-1;
			}
		}
		
		function stuffTable(){
			var table = document.getElementById("projectTable");
			/*var head = table.insertRow(0);
			 head.insertCell(0).innerHTML= '<input type="checkbox" />';
			head.insertCell(1).innerHTML="Project Name";
			head.insertCell(2).innerHTML="Parse"; */
			//alert("begin:"+begin+"end:"+end);
			var trbegin = 1;
			for(var i=begin;i<=end;i++){
				var tr = table.insertRow(trbegin);
				var project = json[i-1];
				/* var td = tr.insertCell(0);
				td.innerHTML = '<input type="checkbox" value='+project.PROJECT_ID+'/>'; */
				td = tr.insertCell(0);
				td.innerHTML = "<a href='javascript:showDocuments("+project.PROJECT_ID+")'>"+project.PROJECT_NAME+"</a>";
				/* td= tr.insertCell(1);
				td.innerHTML = "<a href='#'>s1</a>&nbsp;<a href='#'>s2</a>&nbsp;<a href='#'>s3</a>&nbsp;<a href='#'>s4</a>"; */
				trbegin++;
			}
			
			var foot = table.insertRow(trbegin);
			var totalStr = "total count:"+json.length;
			var currentStr = "&nbsp;&nbsp;&nbsp;&nbsp;Current Page:"+currentPage;
			foot.insertCell(0).innerHTML="<strong><a href='javascript:previous()'>previous</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href='javascript:next()'>next</a>&nbsp;&nbsp;&nbsp;&nbsp;"+totalStr+currentStr+"</strong>";
			//foot.insertCell(1).innerHTML="<a href='javascript:next()'>next</a>";
			//foot.insertCell(1).innerHTML="<strong>Current Page:"+currentPage+"</strong>";
		}
		
		function showDocuments(pid){
			//alert(pid);
			self.location.href = "/getProjectDocuments?projectId="+pid;
		}
	</script>

</html>