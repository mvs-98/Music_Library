//Importing required libraries
import java.util.List;
/**
 * musicArtist class to store information about artist, their name
 * and membership to band if any
 * @author (Mehul Sankhe)
 * @version (7th October, 2023)
 */
public class musicArtist {
	// artistName - variable to store name of an artist
    protected String artistName;
    // ArrayList to store bandMembership
    protected List<String> bandMembership;
    
    

    /**
     * Constructor for objects of class musicArtist
     */
    public musicArtist(String artistName, List<String> bandMembership)
    {
        // initialise instance variables
        
        
        this.artistName = artistName;
        this.bandMembership = bandMembership;
    }
}
