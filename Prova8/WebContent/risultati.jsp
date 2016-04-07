<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,java.io.File"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
#Button {
	margin-right: 15%;
	margin-left: 15%;
	width: 70%;
	background: #ffffff;
	border-style: none;
	cursor: pointer;
}

#Button:hover {
	color: #CCC;
	background: #ffffff;
}


#box-1 {
	width: 100%;
	height: 7%;
	background: #00000f;
	position: fixed;
	top: 0%;
	right: 0%;
}

#box-2 {
	width: 100%;
	position: relative;
	top:20%;
	right: 0%;
}

#logo {
	height: 100%;
	width: 30%;
	position: relative;
	top: 0%;
	right: 5%;
}

#barraDiRicerca {
	height: 100%;
	width: 30%;
	position: relative;
	top: 0%;
	right: 5%;
}

#pulsanteDiRicerca {
	height: 100%;
	width: 30%;
	position: relative;
	top: 0%;
	right: 0%;
}
</style>
</head>
<body>
	<script src="codiceJS/index.js"></script>
	<DIV ALIGN="center" id='box-madre'>

				<div id='box-1'>
	
		<form onSubmit='return false' name='campoDiRicerca' id='box-1' action="ricerca.do" method="post">
				<font face="Times New Roman" size="6" color="GREEN"> <img
					id='logo' src="1.jpg"> <input id='barraDiRicerca'
					onSubmit='return false' type="search"
					value=<%=request.getSession().getAttribute("querySessione")%>
					name="query"> <%
 	String query = (String) request.getParameter("query");
 	session.setAttribute("query", query);
 %>

					<button id='pulsanteDiRicerca'
						onclick='SubmitSenzaSpazi(query.value)'>cerca</button>

				</font>
			<br>
		</form>
		
			</div>
			
	
		<%
			LinkedList<File> listaRisultati = (LinkedList<File>) request.getSession().getAttribute("risultati");
			if (listaRisultati == null)
				out.print("Nessun risultato trovato");
			else {
		%>

			
			<%
				for (File ris : listaRisultati) {
						//	String URL="file:/"+ris.getPath();//.substring(ris.getPath().indexOf("/Dati")+5);
						String URL = "http://localhost:3000/" + ris.getPath().substring(ris.getPath().indexOf("/Dati") + 5);
						URL = "" + URL.substring(0, URL.length());
						URL = URL.replaceAll("/", "/");
						URL = URL.replaceAll("/", "/");
						//http://localhost:3000/Alessandro_Cialfi/1471-2334-13-545.pdf
						//http://localhost:3000/Alessandro_Cialfi/1471-2334-13-545.pdf
						//URL=URL.replace(" ", "");
			%>

			<br>
			<%
				//		<button onclick='ApriNuovoUrl("<%=URL % >")'>
			%>
			<button id="Button" onClick="javascript:location.href='<%=URL%>'">
				<DIV ALIGN="left">
					<font face="Times New Roman" size="4" color="blue"> <%=ris.getName()%>
					</font> <br> <font face="Times New Roman" size="2" color="GREEN">
						&nbsp;&nbsp;&nbsp;&nbsp; <%=ris.getPath()%> <br>
					</font>
				</div>
			</button>

			<%
				}
			%>
		</div>
	<%
		}
	%>




</body>
</html>