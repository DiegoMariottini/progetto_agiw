function SubmitSenzaSpazi(testo){
	var query=testo;
	while(query.charAt(0)==" "){
		var lunghezza=query.lenght;
		var queryModificata=query.substring(2,lunghezza);
		query=queryModificata;

	}

	if(query.charAt(0)==""){
		alert("Scrivi quello che mi vuoi chiedere");
	}else{	
		document.campoDiRicerca.submit();
	}
}
function SubmitSenzaSpazi2(){
	document.campoDiRicerca.query.value=document.campoDiRicerca.missPelling.value;
	//document.campoDiRicerca.submit();
}