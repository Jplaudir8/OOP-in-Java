package module3;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.GeoJSONReader;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.utils.MapUtils;

import processing.core.PApplet;

public class LifeExpectancyVisualizer extends PApplet{

	UnfoldingMap map;
	Map<String, Float> lifeExpMap;
	
	List<Feature> countries;
	List<Marker> countryMarkers;
	
	/**
	 * Helper method. Build map from String to Floats which will contain the countryID's to average life expectancy value.
	 * 
	 */
	private Map<String, Float> loadLifeExpectancyFromCSV(String fileName){
		lifeExpMap = new HashMap<String, Float>();
		
		String[] rows = loadStrings(fileName);
		for(String row: rows) {
			String[] columnData = row.split(","); // 'filename' does not contain any header.
			if(columnData.length != 0) {
				float value = Float.parseFloat(columnData[5]);
				lifeExpMap.put(columnData[4], value);
			}
		}
		return lifeExpMap; 
	}
	
	/**
	 * Helper method. Color country depending on its life expectancy value. If country is not found then color with grey.
	 */
	private void shadeCountries() {
		for(Marker marker: countryMarkers) {
			String countryId = marker.getId();
			
			if(lifeExpMap.containsKey(countryId)) {
				float lifeExp = lifeExpMap.get(countryId);
				int colorLevel = (int) map(lifeExp, 40, 90, 10, 255);
				marker.setColor(color(255-colorLevel, 100, colorLevel));
			} else {
				marker.setColor(color(150, 150, 150));
			}
			
		}
	}
	
	public void setup() {
		
		
		size(800, 600, OPENGL);
		map = new UnfoldingMap(this, 50, 50, 700 ,500, new Google.GoogleMapProvider());
		MapUtils.createDefaultEventDispatcher(this, map);
		
		
		
		Map<String, Float> lifeExpByCountry = loadLifeExpectancyFromCSV("data/LifeExpectancyWorldBank.csv");
		countries = GeoJSONReader.loadData(this, "data/countries.geo.json");
		countryMarkers = MapUtils.createSimpleMarkers(countries);
		
		map.addMarkers(countryMarkers);
		shadeCountries();
		
	}
	
	
	public void draw() {
		
	}
	
	
}
