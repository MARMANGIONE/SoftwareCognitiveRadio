public class EnergyDetection implements MethodDetection{
	private CaseH0 h0;
	private CaseH1 h1;
	private double soglia;
	private boolean sogliaCalcolata = false;

	
	public EnergyDetection(double snr, double pfa, int noiseSize){
		this.h0 = new CaseH0(pfa, snr, noiseSize); 
		this.h1 = new CaseH1(); 
	}

	//Calcola la soglia di una trasmissione utilizzando l'ipotesi h0
	public double getEta() throws Exception {
		if (!this.sogliaCalcolata){
			this.soglia= this.h0.calcolaSoglia();
			this.sogliaCalcolata = true;
		}
		return soglia;
	}

	// verifica se c'è uno specrtum hole
	@Override
	public boolean isSpectrumHole(Signal signal) {
		if (!this.sogliaCalcolata){
			try {
				this.getEta();
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
		return this.h1.isSpectrumHole(this.soglia,signal);
	}
}
