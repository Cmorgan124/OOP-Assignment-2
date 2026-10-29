package classes;

import java.util.List;

public class HelpDeskUtil {
	
	//prints all items in a list, works for any type of object
    public static <T> void printAll(List<T> items)
    {
        for(T item : items)
        {
            System.out.println(item);
        }
    }
    
  //sums the service points of a list of technicians, works for any subclass of Technician
    public static int sumPoints(List<? extends Technician> technicians)
    {
        int totalPoints = 0;
        for(Technician technician : technicians)
        {
            totalPoints += technician.getServicePoints();
        }
        return totalPoints;
    }

}
