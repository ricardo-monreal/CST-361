package beans;


import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Albums {
	
	List<Album> albums = new ArrayList<Album>();

	public Albums() {
		albums.add(new Album("Abbey Road", "The Beatles", 1969, 16));
		albums.add(new Album("Rubber Soul", "The Beatles", 1965, 14));
		albums.add(new Album("Revolver", "The Beatles", 1966, 14));
		albums.add(new Album("Thriller", "Michael Jackson", 1982, 9));
		albums.add(new Album("The Joshua Tree", "U2", 1987, 11));
		albums.add(new Album("Rumours", "Fleetwood Mac", 1977, 11));
		albums.add(new Album("Legend", "Bob Marley", 1984, 16));
		albums.add(new Album("London Calling", "The Clash", 1979, 19));
		albums.add(new Album("Born to Run", "Bruce Springsteen", 1975, 8));
		albums.add(new Album("The Queen is Dead", "The Smiths", 1986, 10));
	}
	
	
	

	public List<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}
	
}
