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
	}
}
