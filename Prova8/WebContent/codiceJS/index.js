function SubmitSenzaSpazi(testo){
	var query=testo;
	if(query.charAt(0)==""){
		alert("Scrivi quello che mi vuoi chiedere")
	}else{
	
	if(query.charAt(0)==" "){
		alert("Elimina gli spazi iniziali")
	
	
	}else{
		document.campoDiRicerca.submit();
	}
	}
}