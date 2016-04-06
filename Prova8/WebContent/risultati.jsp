<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
	LinkedList<String> listaRisultati = (LinkedList<String>)request.getSession().getAttribute("risultati");
	if(listaRisultati==null)
		out.print("Nessun risultato trovato");
	else{
%>

<div id="risultati">

<% 
for(String ris : listaRisultati){
%>

<br>
<DIV ALIGN="left">
	<font face="Times New Roman" size="3">
		<dfn><a href=<%=ris %>><%=ris %></a>
		</dfn></font>
	</DIV>	
	
	
<%
}
%>
</div>
<%
}
%>
 



</body>
</html>