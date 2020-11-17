import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class City {

    private String name;

    private Integer population;

    private LinkedList<City> shortestPath = new LinkedList<>();

    private Integer distance = Integer.MAX_VALUE;

    private Map<City, Integer> adjacentNodes = new HashMap<>();

    public City(String name, Integer population) {
        this.name = name;
        this.population = population;
    }

    public void addDestination(City destination, int distance) {
        adjacentNodes.put(destination, distance);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public Map<City, Integer> getAdjacentNodes() {
        return adjacentNodes;
    }

    public void setAdjacentNodes(Map<City, Integer> adjacentNodes) {
        this.adjacentNodes = adjacentNodes;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public List<City> getShortestPath() {
        return shortestPath;
    }

    public void setShortestPath(LinkedList<City> shortestPath) {
        this.shortestPath = shortestPath;
    }
}
