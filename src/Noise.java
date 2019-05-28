import java.util.Random;

public class Noise {
 private double snr;
 private double pot_rumore;
 private double[] parteReale;
 private double[] parteImmaginaria;
 private int length;
 
//crea 1000 sequenze rumorose fatte di parte reale e parte immaginaria
		public Noise(double snr){
			Random campione = null;
			this.snr = snr;
			Double snr_linearizzato = Math.pow(10, (this.snr/10));
			this.pot_rumore = (1/snr_linearizzato);
			this.length = length;
			this.parteReale= new double[length];
			for (int i = 0; i < this.length; i++) {
			campione = new Random();
			parteReale[i] = campione.nextGaussian()* Math.sqrt(pot_rumore/2);
			this.parteImmaginaria= new double[length];
			for(int j = 0; j < this.length; j++) {
		    campione = new Random();
			parteImmaginaria[j] = campione.nextGaussian() * Math.sqrt(pot_rumore/2);
			}
			}

	}

		public double modulo () {
			double modulo = 0;
			
			for (int i=0; i<this.length; i++) {
				modulo = Math.sqrt(Math.pow(this.parteReale[i], 2) + Math.pow(this.parteImmaginaria[i], 2));
			}
			return modulo;
		}
		
		
	
}
