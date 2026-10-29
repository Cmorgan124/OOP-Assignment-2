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

}
