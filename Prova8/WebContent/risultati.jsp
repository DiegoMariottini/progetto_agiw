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
	top: 0%;
	right: 0%;
}

#box-2 {
	width: 7%;
	position: relative;
	top:20%;
	right: 0%;
}

#logo {
	height: 7%;
	width: 30%;
	position: fixed;
	top: 0%;
	right: 66%;
}

#barraDiRicerca {
	height: 7%;
	width: 30%;
	position: fixed;
	top: 0%;
	right: 35%;
}

#pulsanteDiRicerca {
	height: 7%;
	width: 30%;
	position: fixed;
	top: 0%;
	right: 4%;
}
</style>
</head>
<body>
	<script src="codiceJS/index.js"></script>
	<DIV ALIGN="center">

	
		<form id='campoDiRicerca' onSubmit='return false' name='campoDiRicerca' action="ricerca.do" method="post">
				<font face="Times New Roman" size="6" color="GREEN"> 
				
				<input  onSubmit='return false' type="search" value='<%=request.getSession().getAttribute("querySessione")%>' name="query" id='query'> 
				
				<%
	//			session.setAttribute("querySessione", request.getSession().getAttribute("querySessione"));
 	String query = (String) request.getParameter("query");
 	session.setAttribute("query", query);
 %>
			<button onclick='SubmitSenzaSpazi(query.value)'>cerca</button>
	<br>
						<%
						String consiglio=(String) request.getSession().getAttribute("misspelling");
						if(consiglio!=null) {
							 %>

								<input type="button" name='missPelling' onclick='SubmitSenzaSpazi2("<%=consiglio %>")' value='<%=consiglio %>'>
									
									<%
							
							
						}
						%>


		
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
	
	<%
		}
	%>



<% //BottoneNext %>
		<form action="ricercaAfter.do" method="post">
		<input type="submit">
	</form>

</body>
</html>