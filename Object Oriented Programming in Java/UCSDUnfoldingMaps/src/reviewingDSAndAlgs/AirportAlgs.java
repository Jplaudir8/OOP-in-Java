package reviewingDSAndAlgs;

public class AirportAlgs {





	//toFind is a city name
	public static String findAirportCode(String toFind, Airport[] airports) {
		int i = 0;
		while(i < airports.length){
			if(airports[i].equals(toFind)) {
				return airports[i].getCode();
			}
			i++;
		}
		
		return "NOT FOUND";
	}
}