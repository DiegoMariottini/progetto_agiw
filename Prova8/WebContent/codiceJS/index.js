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
//		queryModificata=EliminaSpaziFinali(query);
//		query=RiduciSpaziDaDueAUno(queryModificata);
		document.campoDiRicerca.submit();
	}
}

function SubmitSenzaSpazi2(testo){
	//var nuova=EliminaSpaziFinali(testo);
	document.campoDiRicerca.query.value=nuova;
	//document.campoDiRicerca.submit();
}

function EliminaSpaziFinali(query){
	var i=query.lenght()-1;
	var c=0;
	while(query.charAt(i)==" "){
		i--;
		c++;
	}
	var queryModificata=query.substring(1,query.lenght()-c);
	query=queryModificata;
	return query;
}
function RiduciSpaziDaDueAUno(testo){
	
}
