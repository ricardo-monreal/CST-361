package beans;

import javax.faces.bean.ManagedBean;
import javax.xml.bind.annotation.XmlRootElement;


@ManagedBean
@XmlRootElement(name="Album")
public class Album {
	
	int id;
	String albumTitle;
	String albumArtitst;
	int albumYear;
	int albumTracks;
	
	
	
	public Album(int id, String albumTitle, String albumArtitst, int albumYear, int albumTracks) {
		super();
		this.id = id;
		this.albumTitle = albumTitle;
		this.albumArtitst = albumArtitst;
		this.albumYear = albumYear;
		this.albumTracks = albumTracks;
	}
	
	public Album() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAlbumTitle() {
		return albumTitle;
	}
	public void setAlbumTitle(String albumTitle) {
		this.albumTitle = albumTitle;
	}
	public String getAlbumArtitst() {
		return albumArtitst;
	}
	public void setAlbumArtitst(String albumArtitst) {
		this.albumArtitst = albumArtitst;
	}
	public int getAlbumYear() {
		return albumYear;
	}
	public void setAlbumYear(int albumYear) {
		this.albumYear = albumYear;
	}
	public int getAlbumTracks() {
		return albumTracks;
	}
	public void setAlbumTracks(int albumTracks) {
		this.albumTracks = albumTracks;
	}

}
