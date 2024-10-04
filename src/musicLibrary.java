//Importing all the required libraries
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * musicLibrary class to store information about music library
 * and extends musicAlbums class
 * @author (Mehul Sankhe)
 * @version (10/10/2023)
 */
public class musicLibrary extends musicAlbums {
	//Name of the library
	protected String libname;
	//ArrayList to store music tracks of library
	protected ArrayList<musicTracks> librarymusictracks  = new ArrayList<musicTracks>();
	//ArrayList to store music albums of library
	protected ArrayList<musicAlbums> librarymusicalbum = new ArrayList<musicAlbums>();
	//ArrayList to store different libraries
	protected static ArrayList<musicLibrary> libraries = new ArrayList<musicLibrary>();
	//Creating objects of scanner class
	Scanner sc = new Scanner(System.in);
	
	
	
	/**
	 * Constructor for objects of class musicLibrary
	 * @param libname Name of music Library
	 * @param librarymusictracks ArrayList to store tracks associated with the library
	 * @param librarymusicalbum ArrayList to store albums associated with the library
	 */
	public musicLibrary(String libname, ArrayList<musicTracks> librarymusictracks, ArrayList<musicAlbums> librarymusicalbum)
	{
		this.libname = libname;
		this.librarymusictracks = librarymusictracks;
		this.librarymusicalbum = librarymusicalbum;
		
	}
	/**
     * Constructor for objects of class musicLibrary
     * This constructor is used to create object of this class in testProject class
     * to test its methods
     * @param It takes no parameter
     */
	public musicLibrary()
	{	
	}
	/**
     * createLibrary method - Method to create a library
     * @param  It does not take any parameter
     * @return type void  
     */
	public void createLibrary()
	{
		
		try
		{
		boolean flag=true;
		System.out.println("\nEnter name for the library: ");
		String libname = sc.nextLine();
		while(flag) // Execute below steps until user wants to add a track or an album
		{
		int cnt=0, cnt1=0;
		System.out.println("\nWhat do you want to add to the library '"+libname+"' track or album-\t1:Track \t2.Album");
		int choice = Integer.parseInt(sc.nextLine());
		if(choice==1)
		{
			System.out.println("\nSelect the tracks to add from the list below: ");
			for(musicTracks mt:tracks)
			{
				System.out.println(cnt+": "+mt.title);
				cnt++;
			}
			int i = Integer.parseInt(sc.nextLine());
			librarymusictracks.add(tracks.get(i));
			System.out.println("\nTrack '"+tracks.get(i).title+"' added to the '"+libname+"' ");
			System.out.println("\nDo you want to add further?\t1:YES\t2:NO");
			int dec = Integer.parseInt(sc.nextLine());
			if(dec!=1)
				flag=false;
			
		}
		else if(choice==2)
		{
			
			System.out.println("\nSelect the albums to add from list below: ");
			System.out.println(albums.get(0));
			for(musicAlbums ma:albums)
			{
				System.out.println(cnt1+": "+ma.album_name);
				cnt1++;
			}
			int i1 = Integer.parseInt(sc.nextLine());
			librarymusicalbum.add(albums.get(i1));
			System.out.println("\nAlbum '"+albums.get(i1).album_name+"' added to the '"+libname+"' ");
			System.out.println("\nDo you want to add further?\t1:YES\t2:NO");
			int dec = Integer.parseInt(sc.nextLine());
			if(dec!=1)
				flag=false;
					
			
		}
		else
		{
			System.out.println("\nPlease enter correct choice i.e 1 for Track or 2 for Album");
		}
	    }
		libraries.add(new musicLibrary(libname,librarymusictracks,librarymusicalbum));
		System.out.println("\nLibrary '"+libname+"' created. Now the libraries are: ");
		for(musicLibrary md: libraries)
		{
			System.out.println(md.libname);
		}
		}
    	catch(Exception e)
    	{
    		System.out.println("Exception occured "+e.getMessage());
    	}
		
	}
	
	/**
     * addTracksOrAlbum method - This method is used to add more tracks or albums to a particular library 
     * @param libraryname for which tracks or albums need to be added
     * @return type void
     */
	public void addTracksOrAlbum(String libraryname)
	{
		try
		{
		int found = 0;
		boolean flag=true;
		for(musicLibrary ml:libraries)
		{
			if(ml.libname.equals(libraryname)) // Searching for the provided library name
			{
				while(flag) // Execute below steps until user wants to add a track or an album
				{
					int cnt=0,cnt1=0;
					boolean alreadypresent=false,alreadypresent1=false;
					System.out.println("\nDo you want to add a track or an album?\t1:Track\t2:Album");
					int choice = Integer.parseInt(sc.nextLine());
					if(choice==1)
					{
						System.out.println("\nSelect the tracks to add from the list below: ");
						for(musicTracks mt:tracks)
						{
							System.out.println(cnt+": "+mt.title);
							cnt++;
						}
						int i = Integer.parseInt(sc.nextLine());
						for(musicTracks mt1:librarymusictracks)
						{
							if(tracks.get(i).title.equals(mt1.title))
							{
								alreadypresent=true;
							}
						}
						if(alreadypresent)
						{
							System.out.println("\nTrack '"+tracks.get(i).title+"' is already present in "+libraryname);
						}
						else
						{
							ml.librarymusictracks.add(tracks.get(i));
							System.out.println("\nTrack '"+tracks.get(i).title+"' added successfully to "+libraryname);
						}
						System.out.println("\nDo you want to add further?\t1:YES\t2:NO");
						int dec = Integer.parseInt(sc.nextLine());
						if(dec!=1)
							flag=false;
						
						
					}
					else if(choice==2)
					{
						System.out.println("\nSelect the album to add from the list below: ");
						for(musicAlbums ma:albums)
						{
							System.out.println(cnt1+": "+ma.album_name);
							cnt1++;
						}
						int i1 = Integer.parseInt(sc.nextLine());
						for(musicAlbums ma1:librarymusicalbum)
						{
							if(albums.get(i1).album_name.equals(ma1.album_name))
							{
								alreadypresent1=true;
							}
						}
						if(alreadypresent1)
						{
							System.out.println("\nAlbum '"+albums.get(i1).album_name+"' is already present in "+libraryname);
						}
						else
						{
							ml.librarymusicalbum.add(albums.get(i1));
							System.out.println("\nAlbum '"+albums.get(i1).album_name+"' added successfully to "+libraryname);
						}
						System.out.println("\nDo you want to add further?\t1:YES\t2:NO");
						int dec1 = Integer.parseInt(sc.nextLine());
						if(dec1!=1)
							flag=false;
						
					}
					else
					{
						System.out.println("\nPlease enter correct choice i.e 1 for Track or 2 for Album");
					}
				}
				found=1;
				break;
			}
			
		}
		if(found==0)
		{
			System.out.println("\nSorry there is no music library present with the name '"+libraryname+"' ");
		}
		}
    	catch(Exception e)
    	{
    		System.out.println("Exception occured "+e.getMessage());
    	}
		
		
	}
	
	
	
	/**
	 * lowRatedTracks method - This method is used to get the lowest rated tracks in a library
	 * @param libraryname Name of the library for which low rated tracks are required
	 * @return type void
	 */
	public void lowRatedTracks(String libraryname)
	{
		try
		{
		int found=0;
		ArrayList<musicTracks> lowestratedtracks = new ArrayList<musicTracks>();
		ArrayList<musicTracks> uniquelowestratedtracks = new ArrayList<musicTracks>();
		
		for(musicLibrary mm: libraries)
		{
			if(mm.libname.equals(libraryname))
			{
				
				for(musicTracks mt2:mm.librarymusictracks)
				{
					lowestratedtracks.add(mt2);
				}
				for(musicAlbums ma2:mm.librarymusicalbum)
				{
					for(musicTracks mt3:ma2.orderedlistoftracks)
					{
						lowestratedtracks.add(mt3);
					}
				}
				found=1;
				break;
			}
			
		}
		//Removing duplicate tracks that are present in both album as well as track
		if(found==1) {
		for(musicTracks ut:lowestratedtracks)
		{
			if(!uniquelowestratedtracks.contains(ut))
			{
				uniquelowestratedtracks.add(ut);
			}
		}
		}
		if(found==0)
		{
			System.out.println("\nSorry there is no music library present with the name '"+libraryname+"' ");
		}
		else
		{
			//sorting uniquelowestratedtracks on rating using lambda expression
			Collections.sort(uniquelowestratedtracks, (a, b) -> a.rating < b.rating ? -1 : a.rating == b.rating ? 0 : 1);
			int temprating = uniquelowestratedtracks.get(0).rating;
			System.out.println("\nLowest rated track(s) are as follows\n");
			for(musicTracks mt3:uniquelowestratedtracks)
			{
				if(mt3.rating==temprating)
				{
					System.out.println("Track title: "+mt3.title+" - Track Rating: "+mt3.rating);
				}
				
			}
		}
		}
    	catch(Exception e)
    	{
    		System.out.println("Exception occured "+e.getMessage());
    	}
		
		
	}
	
	/**
	 * trackspacking method - Method to determine minimum number of disks that would 
	 * be required to backup all the tracks of a particular library
	 * @param lname - Name of the library for which tracks needs to be backed up
	 * @param size - Size of an individual CD/DVD
	 * @return type void
	 * 
	 * Reference: https://www.geeksforgeeks.org/bin-packing-problem-minimize-number-of-used-bins/ 
	 * 
	 */
	public void trackspacking(String lname,int size)
	{
		try
		{
		int found=0;
		ArrayList<musicTracks> alltracks = new ArrayList<musicTracks>();
		ArrayList<musicTracks> uniquetracks = new ArrayList<musicTracks>();
		
		for(musicLibrary mm: libraries) // search if the entered library is present
		{
			if(mm.libname.equals(lname))
			{
				
				for(musicTracks mt2:mm.librarymusictracks)
				{
					alltracks.add(mt2);
				}
				for(musicAlbums ma2:mm.librarymusicalbum)
				{
					for(musicTracks mt3:ma2.orderedlistoftracks)
					{
						alltracks.add(mt3);
					}
				}
				found=1;
				break;
			}
			
		}
		//Removing duplicate tracks that are present in both album as well as track
		if(found==1) {
		for(musicTracks ut:alltracks)
		{
			if(!uniquetracks.contains(ut))
			{
				uniquetracks.add(ut);
			}
		}
		}
		if(found==0)
		{
			System.out.println("\nSorry there is no music library present with the name '"+lname+"' ");
		}
		else
		{
			int len = uniquetracks.size(),noOfDisks=0,inc=0;
			int[] remspace = new int[len];
			int[] tracksizes = new int[len];
			for(musicTracks mmt: uniquetracks)
			{
				tracksizes[inc++]=mmt.musicfilesize;
			}
			 
			for(int i: tracksizes)
			{
				int k,minimum=size,index=0;
				for(k=0;k<noOfDisks;k++)
				{
					if(remspace[k]>=i&&remspace[k]-i<=minimum)
					{
						index=k;
						minimum = remspace[k]-i;
					}
				}
				if(minimum==size)
				{
					remspace[noOfDisks] = size-i;
					noOfDisks++;
				}
				else
				{
					remspace[index]=remspace[index]-i;
				}
			}
			
			System.out.println("Minimum number of CD/DVD's required will be "+noOfDisks);
		}
		}
    	catch(Exception e)
    	{
    		System.out.println("Exception occured "+e.getMessage());
    	}
	}
		
		
		
}

