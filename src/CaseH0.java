import java.util.LinkedList;
import java.util.List;

public class CaseH0 {
	
	private double pfa; // è la probabilità di falso allarme fissata per questo esercizio a 10^-2
	private double snr; // rapporto segnale rumore che per questo esercizio corrisponde a -13dB,-8dB,-5dB,+2dB
	private double soglia;
	private int signalSize;
	private int numeroProve;

	
	public CaseH0(double pfa,double snr,int signalSize) {
		this(pfa, snr, signalSize);
	}
	
	
	// Calcola la soglia in base all'energia del rumore generato con un certo SNR
	 
	public double calcolaSoglia() throws Exception{
		List<Double> energyList = this.calcolaEnergiaNoises();
		this.soglia = this.calcolaSoglia(energyList);
		return this.soglia;
	}
	
	//Crea una lista di energie per ogni singolo sengale rumore
	private List<Double> calcolaEnergiaNoises() {
		List<Double> energyList = new LinkedList<>();
		Noise casuale = new Noise(this.snr);
		double zParziale;
		for(int i=0; i< this.numeroProve;i++){
			zParziale =0;
			for (int j = 0; j < this.signalSize; j++){
				zParziale += casuale.modulo();
			}
			
			energyList.add(((double) 1/(double) this.signalSize)*zParziale);
		}
		return energyList;
	}
	
	// Calcola la soglia avendo come input una lista di potenze
	private double calcolaSoglia(List<Double> energies) throws Exception{
		double valorMedio = MathUtils.valorMedio(energies);
		double varianza = MathUtils.varianza(energies,valorMedio);
		double invErf = MathUtils.InvErf(1-(2*this.pfa));
		double eta = valorMedio + ( Math.sqrt(2*varianza) * invErf);

		return eta;
	}
}