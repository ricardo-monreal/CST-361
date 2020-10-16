package beans;

public class Album {
	
	String albumName = "";
	String albumArtist = "";
	int albumYear = 0;
	int numberOfSongs = 0;
	
	public Album(String albumName, String albumArtist, int albumYear, int numberOfSongs) {
		
		this.albumName = albumName;
		this.albumArtist = albumArtist;
		this.albumYear = albumYear;
		this.numberOfSongs = numberOfSongs;
	}
	



	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public String getAlbumArtist() {
		return albumArtist;
	}

	public void setAlbumArtist(String albumArtist) {
		this.albumArtist = albumArtist;
	}

	public int getAlbumYear() {
		return albumYear;
	}

	public void setAlbumYear(int albumYear) {
		this.albumYear = albumYear;
	}

	public int getNumberOfSongs() {
		return numberOfSongs;
	}

	public void setNumberOfSongs(int numberOfSongs) {
		this.numberOfSongs = numberOfSongs;
	}
	
	

}
