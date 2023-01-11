package earthquakes;

import java.util.List;
import java.util.Map;

public class QuakePrinter {
	private List<Earthquake> earthquakeList;
	private Map<String, Location> earthquakeMap;

	public QuakePrinter(List<Earthquake> earthquakeList,
			Map<String, Location> earthquakeMap) {
		this.earthquakeList = earthquakeList;
		this.earthquakeMap = earthquakeMap;
	}

	public void printLocationWithMostEarthquakes() {
		Location location = null;
	        location = EarthquakeFinder.findLocationWithMostEarthquakes(earthquakeMap);	
		System.out.println(location + " is the location with the most earthquakes.");
		System.out.println("There have been " +
			       	location.getNumOfEarthquakes() + " earthquakes.");
	}

	public void printMaxMagnitudeEarthquake() {
		System.out.println("The earthquake with the highest magnitude: ");
		System.out.println(EarthquakeFinder.findMaxMagnitude(earthquakeList));
	}

	public void printMaxMagnitudeEarthquake(String searchFor) {
		List<Location> locations = EarthquakeFinder.
			searchByLocation(searchFor, earthquakeMap);
		for (Location location : locations) {
			System.out.println(EarthquakeFinder.
					findMaxMagnitude(location.getEarthquakes()));
		}
	}
}
