package beans;

import java.util.ArrayList;

public class Albums {
	
	ArrayList<Album> albumList = new ArrayList<Album>();
	
	public void add(Album ab) {
		albumList.add(ab);
	}
	
	public void printAll() {
		System.out.println(" ++++++++++++++ These are a few of my albums ++++++  ");
		for (Album ab: albumList) {
			System.out.println("ID = " + ab.id + " Album: " + ab.albumTitle + " Artist: " + ab.albumArtitst + " Year: " + ab.albumYear + " Tracks: " + ab.albumTracks);
		}
		
		System.out.println(" ++++++++++++++ End of the list ++++++  ");
	}
	

}
