package reviewingDSAndAlgs;

public class AirportAlgs {





	// Performing a basic linear search to find airport code
	public static String findAirportCode(String toFind, Airport[] airports) {
		int index = 0;
		while(index < airports.length){
			Airport a = airports[index];
			if(toFind.equals(a.getCity())) {
				return a.getCode();
			}
			index++;
		}
		
		return "NOT FOUND";
	}
}