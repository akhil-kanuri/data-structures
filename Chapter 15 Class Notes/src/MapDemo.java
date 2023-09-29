import java.awt.Color;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
    This program demonstrates a map that maps names to colors.
*/
public class MapDemo
{
    public static void main(String[] args)
    {
        /*Map interface is generic */
        Map<String, Color> favColors = new HashMap<>();
        //Add elements to a map using the out method
        favColors.put("Peter", Color.BLACK);
        favColors.put("Seth", Color.BLUE);
        favColors.put("Celeste", Color.ORANGE);

        //two different keys can have the same value

        favColors.put("Dr. Miller",Color.ORANGE); 

        // the same key can't have two different values
        // Using put method for a key that exists replaces original value that was associated with the key
        favColors.put("Peter", Color.YELLOW);

        // Create a set of keys in a map
        Set<String> keys = favColors.keySet();
        for (String key: keys) {
            System.out.println(key+" ("+key.hashCode()+"): "+ favColors.get(key));

        }
    }
}
