import java.util.List;

public class Detector {
	private static final double PFA =Math.pow(10,-3);
	private final int N_TRIALS = 1000;
	private Signal s;
	private MethodDetection md;
	
	public Detector(Signal s,MethodDetection md) {
		this.s = s;
		this.md = md;
	}
	
	public double getProbabilityDetection() {
		List<Signal> dividedSignal = s.divideInto(N_TRIALS);
		int success = 0;
		for (Signal s : dividedSignal) {
			if(!this.md.isSpectrumHole(s)) {
				success++;
			}
		}
		return((double) success/(double) dividedSignal.size() * 100);
	}
	
}
