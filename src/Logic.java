import java.util.*;

public class Logic {

    public static String getAllLines(Airline airline) {
        StringBuilder sb = new StringBuilder();
        for (City c : airline.getCities()) {
            Set<City> cities = c.getAdjacentNodes().keySet();
            StringBuilder sb2 = new StringBuilder();
            for (City city : cities) {
                sb2.append(city.getName() + " ");
            }
            sb.append("From " + c.getName() + "these are the destinations: " + sb2);
        }
        return sb.toString();
    }

    public String getShortestDistanceFromSmallestToBiggest(Airline airline) {
        String result;
        City smallestCity = airline.getCities()
                .stream()
                .min(Comparator.comparing(City::getPopulation))
                .orElseThrow(NoSuchElementException::new);
        City biggestCity = airline.getCities()
                .stream()
                .max(Comparator.comparing(City::getPopulation))
                .orElseThrow(NoSuchElementException::new);
        airline = Dijkstra.calculateShortestPathFromSource(airline,smallestCity);
        List<City> cityList = new ArrayList<>();
        for (City c : airline.getCities()) {
            if (c.equals(biggestCity)){
                cityList = c.getShortestPath();
            }
        }
        StringBuilder sb = new StringBuilder();
        for (City city : cityList) {
            sb.append(city.getName() + " ");
        }
        return sb.toString();
    }
}
