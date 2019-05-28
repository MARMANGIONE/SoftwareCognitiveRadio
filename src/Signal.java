import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class Signal {
  public int length;
  public double[] reale;
  public double[] immaginaria;
  
  public Signal(int length) {
	  this.length = length;
	  this.reale = new double[length];
	  this.immaginaria = new double[length];
  }
  
  public Signal(double[] reale, double[] immaginaria) {
	  this.reale= new double[length];
	  this.immaginaria = new double[length];
  }
   
  public Signal(List<Double> signalReale, List<Double> signalImmaginario) {
	// TODO Auto-generated constructor stub
}

public List<Double> getRealValues() {
		return DoubleStream.of(this.reale).mapToObj(Double::valueOf).collect(Collectors.toList());
	}
  
  public List<Double> getImmValues() {
		return DoubleStream.of(this.immaginaria).mapToObj(Double::valueOf).collect(Collectors.toList());
	}
   public double energy(){
		return SignalProcessor.energy(this);
	}
   
   public List<Signal> divideInto(int num) {
		List<Signal> dividedSignal= new LinkedList<>();
		for(int i =0; i< this.size(); i+= num){
			dividedSignal.add(new Signal(Arrays.copyOfRange(this.reale, i, i+num -1 ),Arrays.copyOfRange(this.immaginaria, i, i+num -1)));
		}
		return dividedSignal;
	}



public int size() {
	 return this.immaginaria.length;
}

}