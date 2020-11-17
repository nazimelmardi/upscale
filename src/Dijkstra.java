import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Dijkstra {

    public static Airline calculateShortestPathFromSource(Airline airline, City source) {

        source.setDistance(0);

        Set<City> settledCities = new HashSet<>();
        Set<City> unsettledCities = new HashSet<>();
        unsettledCities.add(source);

        while (unsettledCities.size() != 0) {
            City currentCity = getLowestDistanceNode(unsettledCities);
            unsettledCities.remove(currentCity);
            for (Map.Entry<City, Integer> adjacencyPair : currentCity.getAdjacentNodes().entrySet()) {
                City adjacentCity = adjacencyPair.getKey();
                Integer edgeWeigh = adjacencyPair.getValue();

                if (!settledCities.contains(adjacentCity)) {
                    CalculateMinimumDistance(adjacentCity, edgeWeigh, currentCity);
                    unsettledCities.add(adjacentCity);
                }
            }
            settledCities.add(currentCity);
        }
        return airline;
    }

    private static void CalculateMinimumDistance(City evaluationCity, Integer edgeWeigh, City sourceCity) {
        Integer sourceDistance = sourceCity.getDistance();
        if (sourceDistance + edgeWeigh < evaluationCity.getDistance()) {
            evaluationCity.setDistance(sourceDistance + edgeWeigh);
            LinkedList<City> shortestPath = new LinkedList<>(sourceCity.getShortestPath());
            shortestPath.add(sourceCity);
            evaluationCity.setShortestPath(shortestPath);
        }
    }

    private static City getLowestDistanceNode(Set<City> unsettledCities) {
        City lowestDistanceCity = null;
        int lowestDistance = Integer.MAX_VALUE;
        for (City city : unsettledCities) {
            int nodeDistance = city.getDistance();
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceCity = city;
            }
        }
        return lowestDistanceCity;
    }
}
