import java.util.HashSet;
import java.util.Set;

public class Airline {

    private String name;

    private Set<City> cities = new HashSet<>();

    public Airline(String name) {
        this.name = name;
    }

    public void addCity(City cityA) {
        cities.add(cityA);
    }

    public Set<City> getCities() {
        return cities;
    }

    public void setCities(Set<City> cities) {
        this.cities = cities;
    }
}
