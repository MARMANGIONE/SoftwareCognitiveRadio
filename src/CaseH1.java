// la classe determina la probabilit� di detection di un segnale avendo la lista di segnali su cui eseguire calcoli 

public class CaseH1 {
//Metodo che dato una soglia (calcolata nell'ipotesi h0) e un segnale verifica se nel segnale � presente uno spectrum hole 
// se non c'� l'utente primario altrimenti restituisce false
	public boolean isSpectrumHole(double soglia, Signal signal) {
		double en =signal.energy();
		return en<soglia; 
		
	}

	
	
}