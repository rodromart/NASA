<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Rodrigo Curiosity Rover Implementation</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
</head>


<script type="text/javascript">

	function send(){
		var initpos = $("#x").val()+","+$("#y").val()+","+$("#o").val();
		var commands = $("#commands").val();
		var request = "commands="+ initpos+" "+commands; 
		$.ajax({
		    url : '/nasa/send',
		    data :request, 
		    type : 'GET',
		    dataType : 'text',
		 
		    success : function(json) {
		        $('<h1/>').text(json).appendTo('body');
		        $('<div class="content"/>')
		            .html(json.html).appendTo('body');
		    },
		 
		    error : function(jqXHR, status, error) {
		        alert('Comunication problems with Mars.....');
		    }
		});	}
</script>
<body>
 
	<center>
		<h2>Hello Curiosity</h2>
		<h3>
			Set initial position <input id="x"><input id="y"><input id="o">
			Set commands <input id="commands">
			<button onclick="javascript:send()"></button>
		</h3>
	</center>
</body>
</html>