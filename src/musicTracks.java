//Importing required libraries
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * musicTracks class to store the information about music tracks.
 *
 * @author (Mehul Sankhe)
 * @version (7th October, 2023)
 */
public class musicTracks {
	//The track's title
    protected String title;
    //The track's artist
    protected String artist;
    //The track's date
    protected LocalDate date;
    //The length of track
    protected double length;
    //Track's rating
    protected int rating;
    //The track's location
    protected String location;
    //The track's size
    protected int musicfilesize;
    //Array List for guest artists for the track
    protected ArrayList<String> guestartist=new ArrayList<String>();
    //Variable to store the number of times a track has been played
    protected int playcount=0;
    //ArrayList to store list of musicTracks
    protected static ArrayList<musicTracks> tracks=new ArrayList<musicTracks>();
    
    public int cnt=1;

    /**
     * Constructor for objects of class musicTracks
     * @param title The track's title.
     * @param artist The track's artist.
     * @param date The track's date.
     * @param length The length of track.
     * @param rating track's rating.
     * @param location The track's location.
     * @param musicfilesize The track's size.
     * @param guestartist Guest artists for the track.
     * @param playcount Playcount of the track
     */
    public musicTracks(String title, String artist, LocalDate date, double length,
    int rating, String location, int musicfilesize, ArrayList<String> guestartist, int playcount)
    {
        // calling the setDetails method to initialise instance variables
        setDetails(title,artist,date,length,rating,location,musicfilesize,guestartist,playcount);
    }
    /**
     * Constructor for objects of class musicTracks
     * This constructor is used to create object of this class in testProject class
     * to test its methods
     * @param It takes no parameter
     */
    public musicTracks()
    {	
    }
    
    /**
     * setDetails method - Set details of the track.
     * @param title The track's title.
     * @param artist The track's artist.
     * @param date The track's date.
     * @param length The length of track.
     * @param rating track's rating.
     * @param location The track's location.
     * @param musicfilesize The track's size.
     * @param guestartist Guest artists for the track.
     * @param playcount Playcount of the track
     */
    private void setDetails(String title, String artist, LocalDate date, double length,
    int rating, String location, int musicfilesize, ArrayList<String> guestartist, int playcount)
    {
        this.title = title;
        this.artist = artist;
        this.date = date;
        this.length = length;
        this.rating = rating;
        this.location = location;
        this.musicfilesize = musicfilesize;
        this.guestartist = guestartist;
        this.playcount = 0;
        

    }
    
    
    /**
     * createTrack method - Method to create a new track and add it to the list of musicTracks
     * @param title The track's title.
     * @param artist The track's artist.
     * @param date The track's date.
     * @param length The length of track.
     * @param rating track's rating.
     * @param location The track's location.
     * @param musicfilesize The track's size.
     * @param guestartist Guest artists for the track.
     */
    public void createTrack(String title, String artist, LocalDate date, double length,
    int rating, String location, int musicfilesize, ArrayList<String> guestartist, int playcount)
    {
        try
        {
        tracks.add(new musicTracks(title,artist,date,length,rating,location,musicfilesize,guestartist,playcount));
        
        if(cnt<8)//  This condition is added to avoid printing initially added data set on terminal
        	cnt++;
        else
        {
        System.out.println("New track '"+title+"' added. Now total number of tracks are: "+tracks.size());
        }
        }
        catch(Exception e)
        {
        	System.out.println("Exception occured "+e.getMessage());
        }
    }
    
    
    /**
     * addguestartist method - To add guest artist to a particular track
     * @return type - void
     * @param tracktitle It takes title of the track to which guest artist has to be added  
     * @param guestartistnames ArrayList for the names of guest artist
     */
    public void addguestartist(String tracktitle,ArrayList<String> guestartistnames)
    {
    	try
    	{
        int flag=0;
        for(musicTracks trk:tracks)
        {
            
            if(trk.title.equals(tracktitle))
            {
                trk.guestartist=guestartistnames;
                flag=1;
                System.out.println("Guest artists added to track: "+trk.title);
                break;
            }
        }
        if (flag==0)
        {
            System.out.println("\nSorry there is no track present with the name '"+tracktitle+"'. Please enter correct title");
        }
    	}
    	catch (Exception e)
    	{
    		System.out.println("Exception occured "+e.getMessage());
    	}
    }
    
    
    /**
     * getindividualslist method - To get name of the artist and guest artist for a particular track
     * @return type - void
     * @param tracktitle It takes title of the track for which individual's list is required  
     */
    public void getindividualslist(String tracktitle)
    {
    	try
    	{
        int flag=0;
        for(musicTracks trk:tracks)
        {
            
            if(trk.title.equals(tracktitle))
            {
            	System.out.println("\nIndividuals for track "+tracktitle+" are:");
                System.out.println("Artist: "+trk.artist);
                for(String s: trk.guestartist) 
                {
                System.out.println("Guest Artist: "+s);
                }
                flag=1;
                break;
            }
        }
        if (flag==0)
        {
            System.out.println("Sorry there is no track present for entered title. Please enter correct title");
        }
    	}
    	catch (Exception e)
    	{
    		System.out.println("Exception occured "+e.getMessage());
    	}
    }
    
    
    /**
     * addplaycount method - To maintain the counter for number of times a track has been played
     * @return type void
     * @param tracktitle It takes title of the track which needs to be played
     */
    public void addplaycount(String tracktitle)
    {
    	try
    	{
        int flag=0;
        for(musicTracks trk:tracks)
        {
            
            if(trk.title.equals(tracktitle))
            {
                trk.playcount++;
                flag=1;
                System.out.println("Track "+trk.title+" played.");
                break;
            }
        }
        if (flag==0)
        {
            System.out.println("Sorry there is no track present for entered title. Please enter correct title to play");
        }
    	}
    	catch(ArithmeticException e)
    	{
    		System.out.println(e.toString());
    	}
    	catch(Exception e)
    	{
    		System.out.println("Exception occured "+e.getMessage());
    	}
        
    }
    
    
    /**
     * getplaycount method - To display number of times a track has been played
     * @return type void
     * @param tracktitle It takes title of the track for which playcount needs to be displayed
     */
    public void getplaycount(String tracktitle)
    {
    	try
    	{
        int flag=0;
        for(musicTracks trk:tracks)
        {
            
            if(trk.title.equals(tracktitle))
            {
                System.out.println("Playcount of track "+trk.title+" is: "+trk.playcount);
                flag=1;
                break;
            }
        }
        if (flag==0)
        {
            System.out.println("Sorry there is no track present for entered title. Please enter correct title to get playcount");
        }
    	}
    	catch(Exception e)
    	{
    		System.out.println("Exception occured "+e.getMessage());
    	}
    }
    
    /**
     * getTitle method - Method to get titles of the track
     * @return type void
     * @param It takes no parameter
     */
    public void getTitle()
    {
        int cnt=1;
        for(musicTracks trk:tracks)
        {
            System.out.println("Track "+cnt+": "+trk.title);
            cnt++;
        }
    }
    
    /**
     * getArtist method - Method to get artist name for the specified track
     * @return type String
     * @param tracktitle It takes title of the track for which artist needs to be returned
     */
    public String getArtist(String tracktitle)
    {
        int flag=0;
        String art=null;
        for(musicTracks trk:tracks)
        {
            
            if(trk.title.equals(tracktitle))
            {
                art = trk.artist;
                flag=1;
            }
        }
        if (flag==0)
        {
            return null;
        }
        else
        {
            return art;
        }
    }
    
    /**
     * getDate method - Method to get date of the specified track
     * @return type void
     * @param tracktitle It takes title of the track for which date needs to be returned
     */
    public void getDate(String tracktitle)
    {
        int flag=0;
        
        for(musicTracks trk:tracks)
        {
            
            if(trk.title.equals(tracktitle))
            {
            	System.out.println("Date is "+trk.date);
                
                flag=1;
            }
        }
        if (flag==0)
        {
            
            System.out.println("Sorry there is no track present for entered title. Please enter correct title to get date");
        }
        
    }
    
    
    /**
     * getLength method - Method to get length of the specified track
     * @return type double
     * @param tracktitle It takes title of the track for which length needs to be returned
     */
    public double getLength(String tracktitle)
    {
        int flag=0;
        double ln=0.0;
        for(musicTracks trk:tracks)
        {
            
            if(trk.title.equals(tracktitle))
            {
                ln = trk.length;
                flag=1;
            }
        }
        if (flag==0)
        {
            return ln;
        }
        else
        {
            return ln;
        }
    }
    
    /**
     * getRating method - To get rating of a track
     * @return type void
     * @param tracktitle It takes title of the track for which rating needs to be returned
     */
    public void getRating(String tracktitle)
    {
        int flag=0;
        for(musicTracks trk:tracks)
        {
            
            if(trk.title.equals(tracktitle))
            {
                System.out.println("Rating of track "+trk.title+" is: "+trk.rating);
                flag=1;
                break;
            }
        }
        if (flag==0)
        {
            System.out.println("Sorry there is no track present for entered title. Please enter correct title to get rating");
        }
    }
    
    /**
     * getLocation method - To get location of a track
     * @return type void
     * @param tracktitle It takes title of the track for which location needs to be returned
     */
    public void getLocation(String tracktitle)
    {
        int flag=0;
        for(musicTracks trk:tracks)
        {
            
            if(trk.title.equals(tracktitle))
            {
                System.out.println("Location of track "+trk.title+" is: "+trk.location);
                flag=1;
                break;
            }
        }
        if (flag==0)
        {
            System.out.println("Sorry there is no track present for entered title. Please enter correct title to get location");
        }
    }
    
    /**
     * getSize method - To get size of a track
     * @return type void
     * @param tracktitle It takes title of the track for which size needs to be returned
     */
    public void getSize(String tracktitle)
    {
        int flag=0;
        for(musicTracks trk:tracks)
        {
            
            if(trk.title.equals(tracktitle))
            {
                System.out.println("Size of track "+trk.title+" is: "+trk.musicfilesize+" KB");
                flag=1;
                break;
            }
        }
        if (flag==0)
        {
            System.out.println("Sorry there is no track present for entered title. Please enter correct title to get size");
        }
    }

}
