//Importing required libraries
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * compilationAlbum class to store information about compilation albums
 * and extends musicAlbums class
 * @author (Mehul Sankhe)
 * @version (12/10/2023)
 */
public class compilationAlbum extends musicAlbums 
{
	//Name of the compilation album
	protected String caname;
	//HashMap to store music track and the original album where the track came from
	protected HashMap<musicTracks,String> hm = new HashMap<>();
	//To store list of different compilation albums
	protected ArrayList<compilationAlbum> calbums = new ArrayList<compilationAlbum>();
	
	/**
	 * Constructor for objects of class compilationAlbum
	 * @param caname Name of compilation album
	 * @param hm HashMap to store track and its original album
	 */
	public compilationAlbum( String caname, HashMap<musicTracks,String> hm )
	{
		this.caname=caname;
		this.hm=hm;
	}
	/**
     * Constructor for objects of class compilationAlbum
     * This constructor is used to create object of this class in testProject class
     * to test its methods
     * @param It takes no parameter
     */
	public compilationAlbum()
	{	
	}
	
	/**
     * createcompilationalbum method - Method to create a compilation album
     * @param name Name of compilation album
     * @param track Track(s) to store in compilation album
     * @return type void  
     */
	public void createcompilationalbum(String name, ArrayList<String> track)
	{
		try
		{
		ArrayList<String> addedtracks = new ArrayList<String>();
		HashMap<musicTracks,String> temp = new HashMap<>();
		for(String s: track)
		{
			for(musicAlbums ma: albums)
			{
				for(musicTracks mt: ma.orderedlistoftracks)
				{
					if(mt.title.equals(s))
					{
						temp.put(mt,ma.album_name);
						addedtracks.add(mt.title);
						
						
					}
				}
				
			}
			
		}
		for(String s1:track) //To store tracks in compilation album that are not a part of any album
		{
			if(!addedtracks.contains(s1))
			{
				for(musicTracks mT:tracks)
				{
					if(mT.title.equals(s1))
					{
						temp.put(mT, "Not a part of any album");
					}
				}
			}
		}
		calbums.add(new compilationAlbum(name,temp));
		System.out.println("\n Compilation album '"+name+"' created successfully with "+temp.size()+" tracks");
		}
		catch(Exception e)
		{
				System.out.println("Exception occured "+e.getMessage());
		}
	}
	
	/**
	 * displaycompilationalbum method - Method to display compilation album along with its tracks
	 * @param caname Name of compilation album for which tracks needs to be displayed
	 * @return type void
	 */
	public void displaycompilationalbum(String caname)
	{
		boolean found=false;
		for(compilationAlbum ca: calbums)
		{
			if(ca.caname.equals(caname))
			{
				System.out.println("\nTracks in this compilation album along with orignal album are\n");
				for( Map.Entry<musicTracks, String> result : ca.hm.entrySet() )
				{
				    System.out.println( result.getKey().title + ": Orignally part of => " + result.getValue() );
				}
				found=true;
			}
		}
		if(found==false)
		{
			System.out.println("\nSorry! the compilation album '"+caname+"' does not exists. Please check the name once or create new compilation ablum with "+caname+" name");
		}
	}
		

}
