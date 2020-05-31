package module3;

//Java utilities libraries
import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
import java.util.List;

//Processing library
import processing.core.PApplet;

//Unfolding libraries
import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.providers.MBTilesMapProvider;
import de.fhpotsdam.unfolding.utils.MapUtils;

//Parsing library
import parsing.ParseFeed;

/** EarthquakeCityMap
 * An application with an interactive map displaying earthquake data.
 * Author: UC San Diego Intermediate Software Development MOOC team
 * @author Your name here
 * Date: July 17, 2015
 * */
public class EarthquakeCityMap extends PApplet {

	// You can ignore this.  It's to keep eclipse from generating a warning.
	private static final long serialVersionUID = 1L;

	// IF YOU ARE WORKING OFFLINE, change the value of this variable to true
	private static final boolean offline = true;
	
	// Less than this threshold is a light earthquake
	public static final float THRESHOLD_MODERATE = 5;
	// Less than this threshold is a minor earthquake
	public static final float THRESHOLD_LIGHT = 4;

	/** This is where to find the local tiles, for working without an Internet connection */
	public static String mbTilesString = "blankLight-1-3.mbtiles";
	
	// The map
	private UnfoldingMap map;
	
	//feed with magnitude 2.5+ Earthquakes
	private String earthquakesURL = "https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/2.5_week.atom";

	
	public void setup() {
		size(950, 600, OPENGL);

		if (offline) {
		    map = new UnfoldingMap(this, 200, 50, 700, 500, new MBTilesMapProvider(mbTilesString));
		    earthquakesURL = "2.5_week.atom"; 	// Same feed, saved Aug 7, 2015, for working offline
		}
		else {
			map = new UnfoldingMap(this, 200, 50, 700, 500, new Google.GoogleMapProvider());
			// IF YOU WANT TO TEST WITH A LOCAL FILE, uncomment the next line
			//earthquakesURL = "2.5_week.atom";
		}
		
	    map.zoomToLevel(2);
	    MapUtils.createDefaultEventDispatcher(this, map);
	    
	    List<PointFeature> bigEqs = new ArrayList<PointFeature>();
	    // The List you will populate with new SimplePointMarkers
	    List<Marker> markers = new ArrayList<Marker>();
	    for(PointFeature eq: bigEqs) {
			markers.add(new SimplePointMarker(eq.getLocation(), eq.getProperties()));
		}
	    
	    //Use provided parser to collect properties for each earthquake
	    //PointFeatures have a getLocation method
	    List<PointFeature> earthquakes = ParseFeed.parseEarthquake(this, earthquakesURL);
	    
	    // Creating a new SimplePointMarker for each PointFeature in 
	    // earthquakes.  Then add each new SimplePointMarker to the 
	    // List markers
	    for(PointFeature earthquake: earthquakes) {
	    	SimplePointMarker marker = createMarker(earthquake);
	    	markers.add(marker);
	    }
	    
	    // Add the markers to the map so that they are displayed
	    map.addMarkers(markers);
	}
		
	/** createMarker: A suggested helper method that takes in an earthquake 
	 * feature and returns a SimplePointMarker for that earthquake
	 * 
	 * @param feature	PointFeature object. e.g. could be an earthquake PointFeature.
	 * @return
	 */
	private SimplePointMarker createMarker(PointFeature feature)
	{  
		// To print all of the features in a PointFeature (so you can see what they are)
		// uncomment the line below.  Note this will only print if you call createMarker 
		// from setup
		System.out.println(feature.getProperties());
		
		// Create a new SimplePointMarker at the location given by the PointFeature
		SimplePointMarker marker = new SimplePointMarker(feature.getLocation());
		
		Object magObj = feature.getProperty("magnitude");
		float mag = Float.parseFloat(magObj.toString());
		
		// Styling marker according to magnitude of earthquakes.
	    if (mag < THRESHOLD_LIGHT) {
	    	// Blue and Small.
	    	marker.setColor(color(0, 0, 255));
	    	marker.setRadius(5);
	    } else if (mag >= THRESHOLD_LIGHT && mag < THRESHOLD_MODERATE ){
	    	// Yellow and Medium.
	    	marker.setColor(color(255, 255, 0));
	    	marker.setRadius(10);
	    } else {
	    	// mag >= THRESHOLD_MODERATE
	    	// Red and Large
	    	marker.setColor(color(255, 0, 0));
	    	marker.setRadius(20);
	    }
	    return marker;
	}
	
	public void draw() {
	    background(10);
	    map.draw();
	    addKey();
	}
	
	// helper method to draw key table in GUI
	private void addKey() {	
		// Drawing Table at coordinate position (10, 50)
		fill(255, 250, 240);
		int xbase = 10;
		int ybase = 50;
		rect(xbase, ybase, 180, 200);
		
		//Title of Key table
		fill(0);
		textAlign(LEFT, CENTER);
		textSize(12);
		text("Earthquake Key", xbase+40, ybase+20);
		
		// Keys
		//Red Marker
		fill(255, 0, 0);
		ellipse(xbase + 40, ybase + 60, 20, 20);
		// Text
		fill(0);
		textAlign(LEFT);
		text("5.0 + Magnitude",xbase + 70, ybase + 63);
		
		// Yellow Marker
		fill(255, 255, 0);
		ellipse(xbase + 40, ybase + 100, 10, 10);
		// Text
		fill(0);
		textAlign(LEFT);
		text("4.0 + Magnitude", xbase + 70, ybase + 104);
		
		// Blue Marker
		fill(0, 0, 255);
	    ellipse(xbase + 40, ybase + 140, 5, 5);
	    // Text
	    fill(0);
	    textAlign(LEFT);
	 	text("Below 4.0", xbase + 70, ybase + 145);
		
	}
}
