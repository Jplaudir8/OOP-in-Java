package module3;

import java.util.HashMap;
import java.util.Map;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.utils.MapUtils;
import processing.core.PApplet;

public class LifeExpectancyVisualizer extends PApplet{

	UnfoldingMap map;
	
	/**
	 * Helper method. Build map from String to Floats which will contain the countryID's to average life expectancy value.
	 */
	private Map<String, Float> loadLifeExpectancyFromCSV(){
		Map<String, Float> lifeExpMap = new HashMap<String, Float>();
		
		return lifeExpMap; 
	}
	
	public void setup() {
		size(800, 600, OPENGL);
		map = new UnfoldingMap(this, 50, 50, 700 ,500, new Google.GoogleMapProvider());
		MapUtils.createDefaultEventDispatcher(this, map);
		
		//Map<String, Float> lifeExpByCountry = loadLifeExpectancyFromCSV("data/");
	}
	
	
	public void draw() {
		
	}
	
	
}
