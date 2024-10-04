//Importing required libraries
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 * musicAlbums class to store information about music albums
 * and extends musicTracks class
 * @author (Mehul Sankhe)
 * @version (09/10/2023)
 */
public class musicAlbums extends musicTracks {
	// Name of the album
    protected String album_name;
    // Type of album
    protected String album_type;
    // Name of album artist
    protected String album_artist;
    // Ordered list of tracks in a album
    protected ArrayList<musicTracks> orderedlistoftracks = new ArrayList<musicTracks>();
    // ArrayList to store list of musicAlbums
    protected static ArrayList<musicAlbums> albums = new ArrayList<musicAlbums>();
    // Creating object of scanner class
    Scanner sc = new Scanner(System.in);
    

    /**
     * Constructor for objects of class musicAlbums
     * @param albumname Name of the album
     * @param albumtype Type of the album
     * @param albumartist Artist of the album
     * @param orderedlistoftracks Ordered list of tracks for the album
     */
    public musicAlbums(String albumname, String albumtype, String albumartist, ArrayList<musicTracks> orderedlistoftracks)
    {
        // initializing instance variables
        this.album_name = albumname;
        this.album_type = albumtype;
        this.album_artist = albumartist;
        this.orderedlistoftracks = orderedlistoftracks;
    }
    /**
     * Constructor for objects of class musicAlbums
     * This constructor is used to create object of this class in testProject class
     * to test its methods
     * @param It takes no parameter
     */
    public musicAlbums()
    {    
    }
    /**
     * createAlbum method - Method to create an album
     * @param  It does not take any parameter
     * @return type void  
     */
    public void createAlbum()
    {
    	try
    	{
        String aname, atype, aartist;
        int flag=1,cnt=0,i,decision;
        ArrayList<musicTracks> olot = new ArrayList<musicTracks>();
        System.out.println("Enter name of the album: ");
        aname = sc.nextLine();
        System.out.println("Enter type of the album: ");
        atype = sc.nextLine();
        System.out.println("Enter artist of the album: ");
        aartist = sc.nextLine();
        System.out.println("Select track number from the list to add in the album (Eg: 0 or 1 or 2 so on)\n");
        for(musicTracks mt: tracks)
            {
                System.out.println(cnt+": "+mt.title);
                cnt++;
            }
        while(flag==1)
        {
        	System.out.println("Enter track number: ");
            i = Integer.parseInt(sc.nextLine());
            olot.add(tracks.get(i));
            System.out.println("Want to add more tracks: 1 - YES    2 - NO");
            decision = Integer.parseInt(sc.nextLine());
            
            if(decision==2)
            {
                flag=0;
            }
        }
        //Ordering the list of tracks in the album on the basis of track title
        Collections.sort(olot, (a,b) -> a.title.compareTo(b.title));
        albums.add(new musicAlbums(aname,atype,aartist,olot));
        System.out.println("\nAlbum: '"+aname+"' created with ordered list of tracks as follows on basis of title\n");
        for(musicTracks mtt: olot)
        {
        	System.out.println(mtt.title);
        }
    	}
    	catch(Exception e)
    	{
    		System.out.println("Exception occured "+e.getMessage());
    	}
          
    }
    
    
    
    /**
     * definelstoftrks method - This method is used to add more tracks to a particular album 
     * @param albumname for which tracks need to be added
     * @return type void
     */
    public void definelstoftrks(String albumname)
    {
    	try
    	{
    	boolean found=false, alreadyexist=false;
    	int i, decision,cnt=0, flag=1;
    	for(musicAlbums ma: albums)//Iterate through albums to check if album exist
    	{
    		if(ma.album_name.equals(albumname))//If album found then execute
    		{
    			System.out.println("\nSelect track number from the list to add in the album (Eg: 0 or 1 or 2 so on)\n");
    			for(musicTracks mt: tracks)//display available tracks
                {
                    System.out.println(cnt+": "+mt.title);
                    cnt++;
                }
    			while(flag==1)// Run until user wants to keep adding tracks
    	        {
    				alreadyexist=false;
    				System.out.println("\nEnter track number: ");
    	            
    	            i = Integer.parseInt(sc.nextLine());
    	            for(musicTracks mt1:ma.orderedlistoftracks)
    	            {
    	            	if(tracks.get(i).title.equals(mt1.title))
    	            	{
    	            		alreadyexist = true;
    	            	}
    	            	
    	            }
    	            if(alreadyexist)
    	            {
    	            	System.out.println(tracks.get(i).title+": Track already exists in this album");
    	            }
    	            else
    	            {
    	            	ma.orderedlistoftracks.add(tracks.get(i));
    	            	// Sorting list of tracks in album using lambda expression on basis of title
    	            	Collections.sort(ma.orderedlistoftracks, (a, b) -> a.title.compareTo(b.title));
    	            	System.out.println("\nTrack '"+tracks.get(i).title+"' added successfully");
    	            }
    	            System.out.println("\nWant to add more tracks: 1 - YES    2 - NO");
    	            decision = Integer.parseInt(sc.nextLine());
    	            
    	            if(decision==2)
    	            {
    	            	System.out.println("\nThankyou for adding tracks to the album: "+albumname+"\n");
    	            	System.out.println("Now ordered tracks in album '"+albumname+"' on basis of title are:\n");
    	            	for(musicTracks mt2:ma.orderedlistoftracks)
    	            	{
    	            		System.out.println(mt2.title);
    	            	}
    	                flag=0;
    	            }
    	        }
    			found = true;
    			break;
    		}
    	}
    	if(!found)
    	{
    		System.out.println("\nSorry "+albumname+" does not exist. Please check if you typed album name correctly.");
    	}
    	}
    	catch(Exception e)
    	{
    		System.out.println("Exception occured "+e.getMessage());
    	}
    	
    }
    
    
    /**
     * runningTime method = Method to get overall running time of the album
     * @param albumname - Name of the album for which overall running time is required
     * @return type double - returns overall running time of the album
     */
    public double overallRunningTime(String albumname)
    {
    	
    	double runningtime=0;
    	boolean found=false;
    	for(musicAlbums ma1:albums)
    	{
    		if(ma1.album_name.equals(albumname))
    		{
    			for(musicTracks mt3:ma1.orderedlistoftracks)
    			{
    				runningtime = runningtime+mt3.length;
    			}
    			found=true;
    			break;
    		}
    	}
    	if(found==false)
    	{
    		return 0;
    	}
    	else
    	{
    		return runningtime;
    	}
    	
    }
    
    /**
     * overallFileSize method - Method to return overall file size of the album
     * @param albumname - Name of the album for which overall file size needs to be returned
     * @return type int - Returns the overall file size of the album
     */
    public int overallFileSize(String albumname)
    {
    	
    	int filesize=0;
    	boolean found=false;
    	for(musicAlbums ma2:albums)
    	{
    		if(ma2.album_name.equals(albumname))
    		{
    			for(musicTracks mt4:ma2.orderedlistoftracks)
    			{
    				filesize = filesize+mt4.musicfilesize;
    			}
    			found=true;
    			break;
    		}
    	}
    	if(found==false)
    	{
    		return 0;
    	}
    	else
    	{
    		return filesize;
    	}
    	
    	
    }
    
    
    /**
     * averageRating method - Method to return average rating of tracks on a album
     * @param albumname - Name of the album for which average rating of tracks needs to be returned
     * @return type double - Returns the average rating of tracks on the album
     */
    public double averageRating(String albumname)
    {
    	
    	double rating=0,average=0;
    	boolean found=false;
    	for(musicAlbums ma3:albums)
    	{
    		if(ma3.album_name.equals(albumname))
    		{
    			for(musicTracks mt5:ma3.orderedlistoftracks)
    			{
    				rating = rating+mt5.rating;
    			}
    			average = rating/ma3.orderedlistoftracks.size();
    			found=true;
    			break;
    		}
    	}
    	if(found==false)
    	{
    		return 0;
    	}
    	else
    	{
    		return average;
    	}
    	
    	
    }
    
    /**
     * getAlbumNames method - Method to get names of all albums
     * @param no parameters
     * @return type void
     */
    public void getAlbumNames()
    {
    	System.out.println("Please find the album names below: ");
    	for(musicAlbums ma4: albums)
    	{
    		System.out.println(ma4.album_name);
    	}
    }
    
    
    /**
     * getAlbumType method - Method to get album type of an album
     * @param albumname - Name of album for which type is required
     * @return type void
     */
    public void getAlbumType(String albumname)
    {
    	boolean found = false;
    	for(musicAlbums ma5: albums)
    	{
    		if(ma5.album_name.equals(albumname))
    		{
    			System.out.println("Type of album "+albumname+" is: "+ma5.album_type);
    			found = true;
    		}
    	}
    	if (found==false)
    	{
    		System.out.println("Sorry the album name you entered "+albumname+" does not exist. Please check if you have typed album name correctly");
    	}
    }
    
    
    /**
     * getAlbumArtist method - Method to get name of artist for given album
     * @param albumname - Name of album for which artist is required
     * @return type void
     */
    public void getAlbumArtist(String albumname)
    {
    	boolean found = false;
    	for(musicAlbums ma6: albums)
    	{
    		if(ma6.album_name.equals(albumname))
    		{
    			System.out.println("Artist of album "+albumname+" is: "+ma6.album_artist);
    			found = true;
    		}
    	}
    	if (found==false)
    	{
    		System.out.println("Sorry the album name you entered "+albumname+" does not exist. Please check if you have typed album name correctly");
    	}
    	
    }
    

}
