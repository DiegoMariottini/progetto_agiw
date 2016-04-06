<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,java.io.File"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
#Button { width: 100%; background: #ffffff; border-style: none; cursor: pointer; }
#Button:hover { color: #CCC; background: #ffffff; }
</style>
</head>
<body>
<script src="codiceJS/index.js"></script>

<DIV ALIGN="center">
		<form onSubmit='return false' name='campoDiRicerca' id='campoDiRicerca' action="ricerca.do" method="post">
			<font face="Times New Roman" size="6" color="GREEN"> ARTEMIDE
			
			
			<input onSubmit='return false' type="search" value=<%=request.getSession().getAttribute("querySessione")%> name="query" size="40%">
<% 
	String query=(String) request.getParameter("query"); 
	session.setAttribute("query", query); 
%>

			<button onclick='SubmitSenzaSpazi(query.value)'>
				cerca
			</button>
			
			</font>
		</form>
	</div>
<%
	LinkedList<File> listaRisultati = (LinkedList<File>)request.getSession().getAttribute("risultati");
	if(listaRisultati==null)
		out.print("Nessun risultato trovato");
	else{
%>

<div id="risultati">

<% 
for(File ris : listaRisultati){
%>

		<br> <a id="Button" href="<% 
		
		String pathUrl=ris.getPath();
		pathUrl= pathUrl.substring(pathUrl.indexOf("Dati"));
		out.print("http://localhost:8080/Prova8/"+pathUrl);
			
		
		%>">
			<button id="Button">

				<DIV ALIGN="left">
					<font face="Times New Roman" size="4" color="blue"> 
					<%=ris.getName() %>
					</font>
					<font face="Times New Roman" size="2" color="GREEN">
							&nbsp;&nbsp;&nbsp;&nbsp; <%=ris.getPath() %> <br>
					</font>
				</div>

			</button>
		</a>


		<%
}
%>
</div>
<%
}
%>
 



</body>
</html>