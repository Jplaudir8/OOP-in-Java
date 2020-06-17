package module5;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.utils.ScreenPosition;
import processing.core.PGraphics;

/** Implements a visual marker for ocean earthquakes on an earthquake map
 * 
 * @author UC San Diego Intermediate Software Development MOOC team
 * @author Your name here
 *
 */
public class OceanQuakeMarker extends EarthquakeMarker {
	public UnfoldingMap locationMap;
	public OceanQuakeMarker(PointFeature quake) {
		super(quake);
		
		// setting field in earthquake marker
		isOnLand = false;
	}
	

	/** Draw the earthquake as a square */
	@Override
	public void drawEarthquake(PGraphics pg, float x, float y) {
		pg.rect(x-radius, y-radius, 2*radius, 2*radius);
	}
	
	private ScreenPosition getScreenPosition(Marker marker){
		return locationMap.getScreenPosition(marker.getLocation());
	}
	
	/*
	 * Draw line between the OceanQuakeMarker and Marker m
	 */
	private void lineBetweenMarker(PGraphics pg, float x, float y, Marker m){
		float accurateX = ((CityMarker)m).accurateX;
		float accurateY = ((CityMarker)m).accurateY;
		pg.line(x, y, accurateX, accurateY);
	}
	

}
