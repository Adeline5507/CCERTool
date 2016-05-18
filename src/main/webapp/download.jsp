<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>下载结果</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">


</head>
<%
	String res = (String)request.getAttribute("result");
%>
<body>
	
	<div id="showResult"  style="text-align:left;padding-top:20px;background-color: #f5f5f5;border: 1px solid #ccc;color: #333;padding: 9.5px;">
			<%
				String[] resLines = res.split(",");
				for(String resl:resLines){
					out.println(resl);
					out.println("<br/>");
				}
			%>
			
			<br/>
			<a href="/getPddFileList">点此查看并解析</a>
			<br/>
			<a href="javascript:doManuldownload()">点此手动下载</a>
	</div>
	<!-- <div id="progressText">
		
	</div -->
	
	<iframe id="downloadResult"> 
		
	</iframe>
	
	<script type="text/javascript">
		/* function doManuldownload(){
			document.getElementById("downloadResult").src = "/manualDownload";
		} */
		
		function doManuldownload(){
			var downloadResultDoc = document.getElementById("downloadResult").contentWindow.document; 
			//var resContainer = document.getElementById("progressText");
			//downloadResultDoc.write("Loading...");
			var xhr = new window.XMLHttpRequest();
			if(!window.XMLHttpRequest){
			try {
				xhr = new window.ActiveXObject("Microsoft.XMLHTTP");
			} catch(e) {}
			}
			xhr.open("get","/manualDownload");
			var oldSize=0;
			xhr.onreadystatechange = function(){
				 if(xhr.readyState > 2){
					var tmpText = xhr.responseText.substring(oldSize);
					oldSize = xhr.responseText.length;
					if(tmpText.length > 0 ){
						downloadResultDoc.write(tmpText);
						downloadResultDoc.write("<br/>");
					} 
				} 
				 if(xhr.readyState==4){
					downloadResultDoc.writeln("执行完毕");
				} 
			}
			xhr.send(null); 
		}
		
		 document.getElementById("downloadResult").width = document.body.clientWidth;
		document.getElementById("downloadResult").height = (window.screen.height-500)+"px";  
</script>
</body>


</html>