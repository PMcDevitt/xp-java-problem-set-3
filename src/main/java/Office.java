/**
 * Created by localadmin on 14/06/2016.
 */
class Office {
    private String name;
    private String location;
    private int numberOfEmployees;

    Office(String name, String location, int numberOfEmployees) {
        this.name = name;
        this.location = location;
        this.numberOfEmployees = numberOfEmployees;
    }

    Office(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public int getEmployees() {
        return numberOfEmployees;
    }
}
