//Importing required libraries
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
/*
 * testProject class contains the main method and
 * tests all the methods from other classes.
 * @author (Mehul Sankhe)
 * @version (08/10/2023)
 */
public class testProject {
	// ArrayList to store list of artist
	protected static ArrayList<musicArtist> artists = new ArrayList<musicArtist>();
    /**
     * Constructor for objects of class testProject
     */
    public testProject()
    {
    }
    /**
     * main method to test all the methods from all the classes
     * @param args
     * @return type void
     */
	public static void main(String[] args) {
		
		//Declaring required fields
		  String title;
	      String artist;
	      LocalDate date= LocalDate.now();
	      double length;
	      int rating;
	      String location;
	      int size;
	      ArrayList<String> guestartist=new ArrayList<String>();
	      int playcount=0;
	      boolean cantinue=true;
	      ArrayList<String> data = new ArrayList<String>();
	      ArrayList<musicTracks> at1 = new ArrayList<musicTracks>();
	      ArrayList<musicTracks> at2 = new ArrayList<musicTracks>();
	      ArrayList<musicAlbums> la = new ArrayList<musicAlbums>();
	      
	    //Creating required objects of class for testing its methods  
        Scanner sc = new Scanner(System.in);
        musicTracks mt = new musicTracks();
        musicAlbums ma = new musicAlbums();
        musicLibrary ml = new musicLibrary();
        compilationAlbum ca = new compilationAlbum();
        
        //Adding artist data set for testing purpose
        artists.add(new musicArtist("Beyonce", Arrays.asList("Soloist")));
        artists.add(new musicArtist("George Harrison", Arrays.asList("The Beatles", "Beasty boys")));
        artists.add(new musicArtist("Bob Marley", Arrays.asList("Wailers")));
        artists.add(new musicArtist("Al Foster", Arrays.asList("Soloist")));
        artists.add(new musicArtist("Peter Murphy", Arrays.asList("Bauhaus","post-punk")));
        artists.add(new musicArtist("Billy Idol", Arrays.asList("punk rock")));
        artists.add(new musicArtist("Cat Stevens", Arrays.asList("Soloist")));
        artists.add(new musicArtist("Chris Martin", Arrays.asList("Coldplay")));
        artists.add(new musicArtist("Ed Sheeran", Arrays.asList("Green Day", "The Jam")));
        artists.add(new musicArtist("Taylor Swift", Arrays.asList("Soloist")));
        
        //Adding few music tracks for methods testing purpose
        mt.createTrack("Tonight","Beyonce",date,3.5,8,"D:\\Project\\Musics\\Tonight.mp3",54,guestartist,0);
        mt.createTrack("Love Me Do","George Harrison",date,4.0,9,"D:\\Project\\Musics\\Love Me Do.mp3",89,guestartist,0);
        mt.createTrack("One Love","Bob Marley",date,2.5,7,"D:\\Project\\Musics\\One Love.mp3",24,guestartist,0);
        mt.createTrack("Strange","Al Foster",date,5.5,9,"D:\\Project\\Musics\\Strange.mp3",35,guestartist,0);
        mt.createTrack("Prada","Taylor Swift",date,4.5,6,"D:\\Project\\Musics\\Prada.mp3",45,guestartist,0);
        mt.createTrack("Darkside","Ed Sheeran",date,3.2,6,"D:\\Project\\Musics\\Darkside.mp3",59,guestartist,0);
        mt.createTrack("Closure","Chris Martin",date,3.0,7,"D:\\Project\\Musics\\Closure.mp3",62,guestartist,0);
        
        //Adding two albums for testing purpose
        at1.add(musicTracks.tracks.get(0));at1.add(musicTracks.tracks.get(6));
        at2.add(musicTracks.tracks.get(1));at2.add(musicTracks.tracks.get(5));
        musicAlbums.albums.add(new musicAlbums("Album 1", "Chill Hits", "Aviator Sam", at1));
        musicAlbums.albums.add(new musicAlbums("Album 2", "Rock Classics", "Free Wanderer", at2));
        
        //Adding one library for testing purpose
        la.add(musicAlbums.albums.get(1));
        musicLibrary.libraries.add(new musicLibrary("Library 1", at1, la));
        
        System.out.println("<-- Initially added data of tracks, albums and library -->\n\nTracks:\t Tonight, Love Me Do, One Love, Strange, Prada, Darkside, Closure\nAlbums:\t Album 1, Album 2\nLibrary: Library 1");
        
        System.out.println("\n******************************************************* Welcome to the Music Library Coursework *****************************************************************");
        try {
        while(cantinue) {
        System.out.println("\nEnter the operation number you want to perform ( FILE BASED I/O ):\n\n1. Create Track \t2. Add Guest Artist \t3. Get Individuals list \t4. Add playcount \t5. Get Playcount \t6. Get track titles \n7. Get track artist \t8.Get track date \t9. Get track length \t10. Get track rating \t11. Get track location \t12. Get track size \n13. Create Album(Terminal I/O) \t14. Define list of tracks for album(Terminal I/O) \t15. Overall running time of album \t16. Overall file size of album \n17. Average rating of album \t18. Get album names \t19. Get album type \t20. Get album artist \t21. Create Library(Terminal I/O) \n22. Add tracks or album to library(Terminal I/O) \t23. Lowest rated tracks from library \t24. Create Compilation Album \t25. Display Compilation Album ");
        System.out.println("\n\t\t\t\t\t OR \n\nEnter the operation number you want to perform ( TERMINAL INPUTS ):\n\n26. Create Track \t27. Add Guest Artist \t28. Get Individuals list \t29. Add playcount \t30. Get Playcount \t31. Get track titles \n32. Get track artist \t33.Get track date \t34. Get track length \t35. Get track rating \t36. Get track location \t37. Get track size \n38. Create Album \t39. Define list of tracks for album \t40. Overall running time of album \t41. Overall file size of album \t42. Average rating of album \n43. Get album names \t44. Get album type \t45. Get album artist \t46. Create Library \t47. Add tracks or album to library \n48. Lowest rated tracks from library \t49. Create Compilation Album \t50. Display Compilation Album \t51. Packing Tracks\t52. Packing Tracks(FILE BASED I/O)");
        int input = Integer.parseInt(sc.nextLine());
        switch(input)
        {
        
        	case 1:
        		try 
        		{
        			File myObj = new File("createtrack.txt");
        			Scanner myReader = new Scanner(myObj);
        			while(myReader.hasNextLine())
        			{
        				data.add(myReader.nextLine());
        			}
        			myReader.close();
        			title = data.get(0);
        			artist = data.get(1);
        			LocalDate date1= LocalDate.now();
        			length = Double.parseDouble(data.get(2));
        			rating = Integer.parseInt(data.get(3));
        			location = data.get(4);
        			size = Integer.parseInt(data.get(5));
        			mt.createTrack(title,artist,date1,length,rating,location,size,guestartist,playcount);
        			data.clear();	
        		}
        		catch(FileNotFoundException e)
        		{
        			System.out.println("\n An error occured while reading the file (FileNotFoundException) "+e.getMessage()+"\n");
        			
        		}
        		catch(IndexOutOfBoundsException e1)
        		{
        			System.out.println("\n An error occured while reading the file. Some lines seem to be missing in the file (IndexOutOfBoundsException) "+e1.getMessage()+"\n");
        			
        		}
        		break;
        		
        	case 2:
        		ArrayList<String> guests1 = new ArrayList<String>();
        		try 
        		{
        			File myObj = new File("addguestartist.txt");
        			Scanner myReader = new Scanner(myObj);
        			while(myReader.hasNextLine())
        			{
        				data.add(myReader.nextLine());
        			}
        			myReader.close();
        			String tracktitle = data.get(0);
        			guests1.add(data.get(1));
        			guests1.add(data.get(2));
        			mt.addguestartist(tracktitle, guests1);
        			
        			data.clear();
                		
        		}
        		catch(FileNotFoundException e)
        		{
        			System.out.println("\n An error occured while reading the file (FileNotFoundException) "+e.getMessage()+"\n");
        			
        		}
        		catch(IndexOutOfBoundsException e1)
        		{
        			System.out.println("\n An error occured while reading the file. Some lines seem to be missing in the file (IndexOutOfBoundsException) "+e1.getMessage()+"\n");
        			
        		}
        		
        		break;
        		
        	case 3:
        		try 
        		{
        			File myObj = new File("tracktitle.txt");
        			Scanner myReader = new Scanner(myObj);
        			while(myReader.hasNextLine())
        			{
        				data.add(myReader.nextLine());
        			}
        			myReader.close();
        			String tracktitle1 = data.get(0);
        			mt.getindividualslist(tracktitle1);
        			data.clear();	
        		}
        		catch(FileNotFoundException e)
        		{
        			System.out.println("\n An error occured while reading the file (FileNotFoundException) "+e.getMessage()+"\n");
        			
        		}
        		catch(IndexOutOfBoundsException e1)
        		{
        			System.out.println("\n An error occured while reading the file. Some lines seem to be missing in the file (IndexOutOfBoundsException) "+e1.getMessage()+"\n");
        			
        		}
        		break;
        		
        	case 4:
        		try 
        		{
        			File myObj = new File("tracktitle.txt");
        			Scanner myReader = new Scanner(myObj);
        			while(myReader.hasNextLine())
        			{
        				data.add(myReader.nextLine());
        			}
        			myReader.close();
        			String tracktitle2 = data.get(0);
        			mt.addplaycount(tracktitle2);
        			data.clear();	
        		}
        		catch(FileNotFoundException e)
        		{
        			System.out.println("\n An error occured while reading the file (FileNotFoundException) "+e.getMessage()+"\n");
        			
        		}
        		catch(IndexOutOfBoundsException e1)
        		{
        			System.out.println("\n An error occured while reading the file. Some lines seem to be missing in the file (IndexOutOfBoundsException) "+e1.getMessage()+"\n");
        			
        		}
        		break;
        		
        	case 5:
        		try 
        		{
        			File myObj = new File("tracktitle.txt");
        			Scanner myReader = new Scanner(myObj);
        			while(myReader.hasNextLine())
        			{
        				data.add(myReader.nextLine());
        			}
        			myReader.close();
        			String tracktitle3 = data.get(0);
        			mt.getplaycount(tracktitle3);
        			data.clear();	
        		}
        		catch(FileNotFoundException e)
        		{
        			System.out.println("\n An error occured while reading the file (FileNotFoundException) "+e.getMessage()+"\n");
        			
        		}
        		catch(IndexOutOfBoundsException e1)
        		{
        			System.out.println("\n An error occured while reading the file. Some lines seem to be missing in the file (IndexOutOfBoundsException) "+e1.getMessage()+"\n");
        			
        		}
        		break;
        		
        	case 6:
        		mt.getTitle();
            	break;
            	
        	case 7:
        		try 
        		{
        			File myObj = new File("tracktitle.txt");
        			Scanner myReader = new Scanner(myObj);
        			while(myReader.hasNextLine())
        			{
        				data.add(myReader.nextLine());
        			}
        			myReader.close();
        			String tracktitle4 = data.get(0);
        			String result = mt.getArtist(tracktitle4);
                	if(result==null)
                	{
                		System.out.println("Sorry there is no track present for entered title. Please enter correct title to get artist ");
                	}
                	else
                	{
                		System.out.println("Artist of the track "+tracktitle4+" is: "+result);
                	}
        			data.clear();	
        		}
        		catch(FileNotFoundException e)
        		{
        			System.out.println("\n An error occured while reading the file (FileNotFoundException) "+e.getMessage()+"\n");
        			
        		}
        		catch(IndexOutOfBoundsException e1)
        		{
        			System.out.println("\n An error occured while reading the file. Some lines seem to be missing in the file (IndexOutOfBoundsException) "+e1.getMessage()+"\n");
        			
        		}
        		break;
        		
        	case 8:
        		try 
        		{
        			File myObj = new File("tracktitle.txt");
        			Scanner myReader = new Scanner(myObj);
        			while(myReader.hasNextLine())
        			{
        				data.add(myReader.nextLine());
        			}
        			myReader.close();
        			String tracktitle5 = data.get(0);
        			mt.getDate(tracktitle5);
        			data.clear();	
        		}
        		catch(FileNotFoundException e)
        		{
        			System.out.println("\n An error occured while reading the file (FileNotFoundException) "+e.getMessage()+"\n");
        			
        		}
        		catch(IndexOutOfBoundsException e1)
        		{
        			System.out.println("\n An error occured while reading the file. Some lines seem to be missing in the file (IndexOutOfBoundsException) "+e1.getMessage()+"\n");
        			
        		}
        		break;
        		
        	case 9:
        		try 
        		{
        			File myObj = new File("tracktitle.txt");
        			Scanner myReader = new Scanner(myObj);
        			while(myReader.hasNextLine())
        			{
        				data.add(myReader.nextLine());
        			}
        			myReader.close();
        			String tracktitle6 = data.get(0);
        			double result1 = mt.getLength(tracktitle6);
        			if(result1>0)
                	{
                		System.out.println("Length of the track '"+tracktitle6+"' is: "+result1);
                	}
                	else
                	{
                		System.out.println("Sorry there is no track present for entered title. Please enter correct title to get length");
                	}
        			data.clear();	
        		}
        		catch(FileNotFoundException e)
        		{
        			System.out.println("\n An error occured while reading the file (FileNotFoundException) "+e.getMessage()+"\n");
        			
        		}
        		catch(IndexOutOfBoundsException e1)
        		{
        			System.out.println("\n An error occured while reading the file. Some lines seem to be missing in the file (IndexOutOfBoundsException) "+e1.getMessage()+"\n");
        			
        		}
        		break;
        		
        	case 10:
        		try 
        		{
        			File myObj = new File("tracktitle.txt");
        			Scanner myReader = new Scanner(myObj);
        			while(myReader.hasNextLine())
        			{
        				data.add(myReader.nextLine());
        			}
        			myReader.close();
        			String tracktitle7 = data.get(0);
        			mt.getRating(tracktitle7);
        			data.clear();	
        		}
        		catch(FileNotFoundException e)
        		{
        			System.out.println("\n An error occured while reading the file (FileNotFoundException) "+e.getMessage()+"\n");
        			
        		}
        		catch(IndexOutOfBoundsException e1)
        		{
        			System.out.println("\n An error occured while reading the file. Some lines seem to be missing in the file (IndexOutOfBoundsException) "+e1.getMessage()+"\n");
        			
        		}
        		break;
        		
        	case 11:
        		try 
        		{
        			File myObj = new File("tracktitle.txt");
        			Scanner myReader = new Scanner(myObj);
        			while(myReader.hasNextLine())
        			{
        				data.add(myReader.nextLine());
        			}
        			myReader.close();
        			String tracktitle8 = data.get(0);
        			mt.getLocation(tracktitle8);
        			data.clear();	
        		}
        		catch(FileNotFoundException e)
        		{
        			System.out.println("\n An error occured while reading the file (FileNotFoundException) "+e.getMessage()+"\n");
        			
        		}
        		catch(IndexOutOfBoundsException e1)
        		{
        			System.out.println("\n An error occured while reading the file. Some lines seem to be missing in the file (IndexOutOfBoundsException) "+e1.getMessage()+"\n");
        			
        		}
        		break;
        		
        	case 12:
        		try 
        		{
        			File myObj = new File("tracktitle.txt");
        			Scanner Reader = new Scanner(myObj);
        			while(Reader.hasNextLine())
        			{
        				data.add(Reader.nextLine());
        			}
        			Reader.close();
        			String tracktitle9 = data.get(0);
        			mt.getSize(tracktitle9);
        			data.clear();	
        		}
        		catch(FileNotFoundException e)
        		{
        			System.out.println("\n An error occured while reading the file (FileNotFoundException) "+e.getMessage()+"\n");
        			
        		}
        		catch(IndexOutOfBoundsException e1)
        		{
        			System.out.println("\n An error occured while reading the file. Some lines seem to be missing in the file (IndexOutOfBoundsException) "+e1.getMessage()+"\n");
        			
        		}
        		break;
        		
        	case 13:
        		ma.createAlbum();
        		break;
        		
        	case 14:
        		System.out.println("\nEnter album name for which tracks need to be defined");
            	String albname = sc.nextLine();
            	ma.definelstoftrks(albname);
            	break;
            	
        	case 15:
        		try
        		{
        			File myObj = new File("albumtitle.txt");
        			Scanner Reader = new Scanner(myObj);
        			while(Reader.hasNextLine())
        			{
        				data.add(Reader.nextLine());
        			}
        			Reader.close();
        			String albumname = data.get(0);
        			double runtime1 = ma.overallRunningTime(albumname);
        			data.clear();
        			if(runtime1>0)
                	{
                		System.out.println("\nOverall running time of album '"+albumname+"' is: "+runtime1);
                	}
                	else
                	{
                		System.out.println("\nSorry the album '"+albumname+"' does not exist. Please enter correct album name.");
                	}
        		}
        		catch(FileNotFoundException e)
        		{
        			System.out.println("\n An error occured while reading the file (FileNotFoundException) "+e.getMessage()+"\n");
        			
        		}
        		catch(IndexOutOfBoundsException e1)
        		{
        			System.out.println("\n An error occured while reading the file. Some lines seem to be missing in the file (IndexOutOfBoundsException) "+e1.getMessage()+"\n");
        			
        		}
        		break;
        		
        	case 16:
        		try
        		{
        			File myObj = new File("albumtitle.txt");
        			Scanner Reader = new Scanner(myObj);
        			while(Reader.hasNextLine())
        			{
        				data.add(Reader.nextLine());
        			}
        			Reader.close();
        			String albumname = data.get(0);
        			int size1 = ma.overallFileSize(albumname);
        			data.clear();
        			if(size1>0)
                	{
                		System.out.println("\nOverall file size of album '"+albumname+"' is: "+size1+" KB");
                	}
                	else
                	{
                		System.out.println("\nSorry the album '"+albumname+"' does not exist. Please enter correct album name.");
                	}
        			
        		}
        		catch(FileNotFoundException e)
        		{
        			System.out.println("\n An error occured while reading the file (FileNotFoundException) "+e.getMessage()+"\n");
        			
        		}
        		catch(IndexOutOfBoundsException e1)
        		{
        			System.out.println("\n An error occured while reading the file. Some lines seem to be missing in the file (IndexOutOfBoundsException) "+e1.getMessage()+"\n");
        			
        		}
        		break;
        		
        	case 17:
        		try
        		{
        			File myObj = new File("albumtitle.txt");
        			Scanner Reader = new Scanner(myObj);
        			while(Reader.hasNextLine())
        			{
        				data.add(Reader.nextLine());
        			}
        			Reader.close();
        			String albumname = data.get(0);
        			double rating1 = ma.averageRating(albumname);
        			data.clear();
        			if(rating1>0)
                	{
                		System.out.println("\nAverage rating of album '"+albumname+"' is: "+rating1);
                	}
                	else
                	{
                		System.out.println("\nSorry the album '"+albumname+"' does not exist. Please enter correct album name.");
                	}
        			
        		}
        		catch(FileNotFoundException e)
        		{
        			System.out.println("\n An error occured while reading the file (FileNotFoundException) "+e.getMessage()+"\n");
        			
        		}
        		catch(IndexOutOfBoundsException e1)
        		{
        			System.out.println("\n An error occured while reading the file. Some lines seem to be missing in the file (IndexOutOfBoundsException) "+e1.getMessage()+"\n");
        			
        		}
        		break;
        		
        	case 18:
        		ma.getAlbumNames();
        		break;
        		
        	case 19:
        		try 
        		{
        			File myObj = new File("albumtitle.txt");
        			Scanner Reader = new Scanner(myObj);
        			while(Reader.hasNextLine())
        			{
        				data.add(Reader.nextLine());
        			}
        			Reader.close();
        			String albumname = data.get(0);
        			ma.getAlbumType(albumname);
        			data.clear();	
        		}
        		catch(FileNotFoundException e)
        		{
        			System.out.println("\n An error occured while reading the file (FileNotFoundException) "+e.getMessage()+"\n");
        			
        		}
        		catch(IndexOutOfBoundsException e1)
        		{
        			System.out.println("\n An error occured while reading the file. Some lines seem to be missing in the file (IndexOutOfBoundsException) "+e1.getMessage()+"\n");
        			
        		}
        		break;
        		
        	case 20:
        		try 
        		{
        			File myObj = new File("albumtitle.txt");
        			Scanner Reader = new Scanner(myObj);
        			while(Reader.hasNextLine())
        			{
        				data.add(Reader.nextLine());
        			}
        			Reader.close();
        			String albumname = data.get(0);
        			ma.getAlbumArtist(albumname);
        			data.clear();	
        		}
        		catch(FileNotFoundException e)
        		{
        			System.out.println("\n An error occured while reading the file (FileNotFoundException) "+e.getMessage()+"\n");
        			
        		}
        		catch(IndexOutOfBoundsException e1)
        		{
        			System.out.println("\n An error occured while reading the file. Some lines seem to be missing in the file (IndexOutOfBoundsException) "+e1.getMessage()+"\n");
        			
        		}
        		break;
        		
        	case 21:
        		ml.createLibrary();
            	break;
            	
        	case 22:
        		System.out.println("\nEnter library name for which Track or Album needs to be added");
            	String lname = sc.nextLine();
            	ml.addTracksOrAlbum(lname);
            	break;
            	
        	case 23:
        		try 
        		{
        			File myObj = new File("librarytitle.txt");
        			Scanner Reader = new Scanner(myObj);
        			while(Reader.hasNextLine())
        			{
        				data.add(Reader.nextLine());
        			}
        			Reader.close();
        			String llibname = data.get(0);
        			ml.lowRatedTracks(llibname);
        			data.clear();	
        		}
        		catch(FileNotFoundException e)
        		{
        			System.out.println("\n An error occured while reading the file (FileNotFoundException) "+e.getMessage()+"\n");
        			
        		}
        		catch(IndexOutOfBoundsException e1)
        		{
        			System.out.println("\n An error occured while reading the file. Some lines seem to be missing in the file (IndexOutOfBoundsException) "+e1.getMessage()+"\n");
        			
        		}
        		break;
        		
        	case 24:
        		try
        		{
        			File myObj = new File("createcompilationalbum.txt");
        			Scanner Reader = new Scanner(myObj);
        			while(Reader.hasNextLine())
        			{
        				data.add(Reader.nextLine());
        			}
        			Reader.close();
        			String cname = data.get(0);
        			ArrayList<String> tmp = new ArrayList<String>();
        			tmp.add(data.get(1));tmp.add(data.get(2));tmp.add(data.get(3));tmp.add(data.get(4));
        			ca.createcompilationalbum(cname, tmp);
        			data.clear();
        			
        		}
        		catch(FileNotFoundException e)
        		{
        			System.out.println("\n An error occured while reading the file (FileNotFoundException) "+e.getMessage()+"\n");
        			
        		}
        		catch(IndexOutOfBoundsException e1)
        		{
        			System.out.println("\n An error occured while reading the file. Some lines seem to be missing in the file (IndexOutOfBoundsException) "+e1.getMessage()+"\n");
        			
        		}
        		break;
        		
        	case 25:
        		try 
        		{
        			File myObj = new File("compilationalbumtitle.txt");
        			Scanner Reader = new Scanner(myObj);
        			while(Reader.hasNextLine())
        			{
        				data.add(Reader.nextLine());
        			}
        			Reader.close();
        			String cname = data.get(0);
        			ca.displaycompilationalbum(cname);
        			data.clear();	
        		}
        		catch(FileNotFoundException e)
        		{
        			System.out.println("\n An error occured while reading the file (FileNotFoundException) "+e.getMessage()+"\n");
        			
        		}
        		catch(IndexOutOfBoundsException e1)
        		{
        			System.out.println("\n An error occured while reading the file. Some lines seem to be missing in the file (IndexOutOfBoundsException) "+e1.getMessage()+"\n");
        			
        		}
        		break;
        	
            case 26:
            	int trialrating,cnt=0;
                System.out.println("Please enter title of the track: ");
                title = sc.nextLine();
                System.out.println("Please select artist name for the track from the list below: (Eg: 0 or 1 or 2...");
                for(musicArtist ma1: artists)
                {
                	System.out.println(cnt+": "+ma1.artistName);
                	cnt++;
                	
                }
                System.out.println("Enter artist number: (Eg: 0 or 1 or 2...)");
                int i = Integer.parseInt(sc.nextLine());
                artist = artists.get(i).artistName;
                System.out.println("Enter length of the track (minutes.seconds) Eg. 3.40 or 5.30");
                length = Double.parseDouble(sc.nextLine());
                System.out.println("Please enter the rating of track between 1-10");
                trialrating = Integer.parseInt(sc.nextLine());
                if(trialrating>10)
                {
                	System.out.println("Please enter rating between 1-10");
                	rating = Integer.parseInt(sc.nextLine());
                }
                else
                {
                	rating = trialrating;
                }
                System.out.println("Enter location of the track");
                location = sc.nextLine();
                System.out.println("Enter size of the track in KBs");
                size = Integer.parseInt(sc.nextLine());
                mt.createTrack(title,artist,date,length,rating,location,size,guestartist,playcount);
                break;
                
            case 27:
            	int dec,cnt1=0;
            	boolean flag = true;
            	String tracktitle=null;
            	ArrayList<String> guests = new ArrayList<String>();
            	System.out.println("Enter track title for which guest artists needs to be added: ");
            	tracktitle = sc.nextLine();
            	System.out.println("Please select guest artists to add from list below: ");
            	for(musicArtist ma2: artists) {
            		System.out.println(cnt1+": "+ma2.artistName);
            		cnt1++;
            	}
            	while(flag)
            	{
            		System.out.println("Enter the artist number to be added as guest artist: (Eg: 0 or 1 or 2...)");
            		int ip = Integer.parseInt(sc.nextLine());
            		guests.add(artists.get(ip).artistName);
            		System.out.println("Guest artist '"+artists.get(ip).artistName+"' added to track: "+tracktitle);
            		System.out.println("\nWant to add more guest artists   1: YES     2: NO");
            		dec = Integer.parseInt(sc.nextLine());
            		if(dec!=1)
            			flag=false;
            	}
            	mt.addguestartist(tracktitle, guests);
            	
            	break;
            	
            case 28:
            	String tracktitle1=null;
            	System.out.println("Enter track title for which individuals list is required: ");
            	tracktitle1 = sc.nextLine();
            	mt.getindividualslist(tracktitle1);
            	break;
            	
            case 29:
            	String tracktitle2=null;
            	System.out.println("Enter track title which needs to be played: ");
            	tracktitle2 = sc.nextLine();
            	mt.addplaycount(tracktitle2);
            	break;
            	
            case 30:
            	String tracktitle3=null;
            	System.out.println("Enter track title for which playcount is required: ");
            	tracktitle3 = sc.nextLine();
            	mt.getplaycount(tracktitle3);
            	break;
            	
            case 31:
            	mt.getTitle();
            	break;
            	
            case 32:
            	String tracktitle4=null;
            	System.out.println("Enter track title for which artist is required: ");
            	tracktitle4 = sc.nextLine();
            	String result = mt.getArtist(tracktitle4);
            	if(result==null)
            	{
            		System.out.println("Sorry there is no track present for entered title. Please enter correct title to get artist ");
            	}
            	else
            	{
            		System.out.println("Artist of the track "+tracktitle4+" is: "+result);
            	}
            	break;
            	
            case 33:
            	String tracktitle5=null;
            	System.out.println("Enter track title for which date is required: ");
            	tracktitle5 = sc.nextLine();
            	mt.getDate(tracktitle5);
            	break;
            	
            case 34:
            	String tracktitle6=null;
            	System.out.println("Enter track title for which length is required: ");
            	tracktitle6 = sc.nextLine();
            	double result1 = mt.getLength(tracktitle6);
            	if(result1>0)
            	{
            		System.out.println("Length of the track '"+tracktitle6+"' is: "+result1);
            	}
            	else
            	{
            		System.out.println("Sorry there is no track present for entered title. Please enter correct title to get length");
            	}
            	break;
            	
            case 35:
            	String tracktitle7=null;
            	System.out.println("Enter track title for which rating is required: ");
            	tracktitle7 = sc.nextLine();
            	mt.getRating(tracktitle7);
            	break;
            	
            case 36:
            	String tracktitle8=null;
            	System.out.println("Enter track title for which location is required: ");
            	tracktitle8 = sc.nextLine();
            	mt.getLocation(tracktitle8);
            	break;
            	
            case 37:
            	String tracktitle9=null;
            	System.out.println("Enter track title for which size is required: ");
            	tracktitle9 = sc.nextLine();
            	mt.getSize(tracktitle9);
            	break;
            	
            case 38:
            	ma.createAlbum();
            	break;
            	
            case 39:
            	System.out.println("\nEnter album name for which tracks need to be defined");
            	String albnamee = sc.nextLine();
            	ma.definelstoftrks(albnamee);
            	break;
            	
            case 40:
            	System.out.println("\nEnter album name for which running time is required");
            	String albname1 = sc.nextLine();
            	double runtime = ma.overallRunningTime(albname1);
            	if(runtime>0)
            	{
            		System.out.println("\nOverall running time of album '"+albname1+"' is: "+runtime);
            	}
            	else
            	{
            		System.out.println("\nSorry the album '"+albname1+"' does not exist. Please enter correct album name.");
            	}
            	break;
            	
            case 41:
            	System.out.println("\nEnter album name for which file size is required");
            	String albname2 = sc.nextLine();
            	int filesize = ma.overallFileSize(albname2);
            	if(filesize>0)
            	{
            		System.out.println("\nOverall file size of album '"+albname2+"' is: "+filesize+" KB");
            	}
            	else
            	{
            		System.out.println("\nSorry the album '"+albname2+"' does not exist. Please enter correct album name.");
            	}
            	break;
            	
            case 42:
            	System.out.println("\nEnter album name for which average rating is required");
            	String albname3 = sc.nextLine();
            	double avgrat = ma.averageRating(albname3);
            	if(avgrat>0)
            	{
            		System.out.println("\nAverage rating of album '"+albname3+"' is: "+avgrat);
            	}
            	else
            	{
            		System.out.println("\nSorry the album '"+albname3+"' does not exist. Please enter correct album name.");
            	}
            	break;
            	
            case 43:
            	ma.getAlbumNames();
            	break;
            	
            case 44:
            	System.out.println("\nEnter album name for which album type is needed");
            	String albname4 = sc.nextLine();
            	ma.getAlbumType(albname4);
            	break;
            	
            case 45:
            	System.out.println("\nEnter album name for which artist is needed");
            	String albname5 = sc.nextLine();
            	ma.getAlbumArtist(albname5);
            	break;
            	
            case 46:
            	ml.createLibrary();
            	break;
            	
            case 47:
            	System.out.println("\nEnter library name for which Track or Album needs to be added");
            	String lnamee = sc.nextLine();
            	ml.addTracksOrAlbum(lnamee);
            	break;
            	
            case 48:
            	System.out.println("\nEnter library name to get lowest rated tracks of the library");
            	String lnameinput = sc.nextLine();
            	ml.lowRatedTracks(lnameinput);
            	break;
            	
            case 49:
            	int i1,inc=0,flag1=1;
            	String name;
            	ArrayList<String> trklist = new ArrayList<String>();
            	System.out.println("\nEnter the name for an compilation album");
            	name = sc.nextLine();
            	System.out.println("\nSelect the tracks that you want to add in this compilation album");
            	for(musicTracks mt1: musicTracks.tracks)
            	{
            		System.out.println(inc+": "+mt1.title);
            		inc++;
            	}
            	while(flag1==1)
            	{
            		System.out.println("\nEnter the track number: ");
            		i1=Integer.parseInt(sc.nextLine());
            		trklist.add(musicTracks.tracks.get(i1).title);
            				
            	
            	System.out.println("\nWant to add more tracks?\t1: YES\t2:NO");
            	int dec1 = Integer.parseInt(sc.nextLine());
            	if(dec1!=1)
            		flag1=0;
            	}
            	ca.createcompilationalbum(name, trklist);
            	break;
            	
            case 50:
            	String cname;
            	System.out.println("\nEnter name of compilation album which needs to be displayed");
            	cname = sc.nextLine();
            	ca.displaycompilationalbum(cname);
            	break;
            	
            case 51:
            	String llname;
            	int ssize;
            	System.out.println("\nEnter the name of library for which tracks needs to be bin packed");
            	llname = sc.nextLine();
            	System.out.println("\nEnter the size of CD/DVD ");
            	ssize = Integer.parseInt(sc.nextLine());
            	ml.trackspacking(llname, ssize);
            	break;
            	
            case 52:
            	try 
        		{
        			File myObj = new File("trackpacking.txt");
        			Scanner Reader = new Scanner(myObj);
        			while(Reader.hasNextLine())
        			{
        				data.add(Reader.nextLine());
        			}
        			Reader.close();
        			String lName = data.get(0);
        			int diskSize = Integer.parseInt(data.get(1));
        			ml.trackspacking(lName, diskSize);
        			data.clear();	
        		}
        		catch(FileNotFoundException e)
        		{
        			System.out.println("\n An error occured while reading the file (FileNotFoundException) "+e.getMessage()+"\n");
        			
        		}
        		catch(IndexOutOfBoundsException e1)
        		{
        			System.out.println("\n An error occured while reading the file. Some lines seem to be missing in the file (IndexOutOfBoundsException) "+e1.getMessage()+"\n");
        			
        		}
        		break;
            	
            default:
            	System.out.println("Please enter correct choice number");
                break;

        }
        System.out.println("\nDo you want to continue\t1:YES     2:NO");
        int decide = Integer.parseInt(sc.nextLine());
        if(decide!=1) 
        {
        	cantinue=false;
        	System.out.println("\n************************************* Thankyou for using Music Library project *************************************");
        }
        }
        }
        catch (Exception e)
        {
        	System.out.println("Exception occured "+e.getMessage());        
        }
	}
	
}
