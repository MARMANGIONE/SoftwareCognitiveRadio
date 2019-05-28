
public class SignalProcessor {
	
	public static double energy(Signal s){
		int n = s.size();
		double zParziale =0;
	for(double r : s.getRealValues()){
			for(double i: s.getImmValues()) {
			zParziale += Math.pow(Math.sqrt(Math.pow(r, 2) + Math.pow(i, 2)), 2);
		}
	}
		return ((double)1/(double)n)*zParziale; 
	}
   }

