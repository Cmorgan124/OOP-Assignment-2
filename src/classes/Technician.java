package classes;
import java.util.Objects;

public class Technician {
	private String name;
	private int servicePoints;
	
	public Technician(String name) {
		if(name == null || name.isBlank()) {
			throw new IllegalArgumentException("Technician name cannot be null or blank");
		}
		this.name = name;
		this.servicePoints = 0; //starts at 0
	}
	
	//adds amount from a request as long as it doesn't make the total negative
	public void addPoints(int amount) {
		if (this.servicePoints + amount < 0) {
            throw new IllegalArgumentException("Service points cannot become negative.");
        }
        this.servicePoints += amount;
	}
	
	//getters
	public String getName() {
        return name;
    }
	public int getServicePoints() {
		return servicePoints;
	}
	
	@Override
	public String toString() {
		return "Technician name: " + name + ", Points: " + servicePoints;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true; //memory reference check
		if(o == null || getClass() != o.getClass()) return false; //null or different class check
		
		//Technician name check
		Technician that = (Technician) o;
		return Objects.equals(name, that.name);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name); //hashes based off name
	}
	
	
}
