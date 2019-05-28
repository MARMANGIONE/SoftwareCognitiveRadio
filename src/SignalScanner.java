import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SignalScanner {
		public static Signal loadFromFile(File f){
			try {
				Scanner s = new Scanner(new FileInputStream(f));
				s.useDelimiter("\n");
				List<Double> signalReale = new LinkedList<>();
				List<Double> signalImmaginario = new LinkedList<>();
				String[] data;
				while(s.hasNext()){
					data = s.next().split("\t");
					signalReale.add(new Double(data[0]).doubleValue());
					signalImmaginario.add(new Double(data[1]).doubleValue());
				}
				s.close();
				return new Signal(signalReale,signalImmaginario);
			} catch (FileNotFoundException e) {
				return null;
			}
		}

		

		public static boolean saveOnFile(Signal in, File file){
			try {
				FileOutputStream fop = new FileOutputStream(file);
				if (!file.exists()) {
					file.createNewFile();
				}
				
				for(double a: in.getRealValues()){
					for(double b: in.getImmValues()){
						byte[] data = (b + "\t" + a + "\n").getBytes();
					fop.write(data);
					fop.flush();
				}
				}
				
				fop.close();
				
				return true;
			} catch (IOException e) {
				return false;
			}
		}
		}

	


