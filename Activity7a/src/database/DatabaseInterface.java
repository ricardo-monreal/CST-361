package database;

import java.util.ArrayList;

import javax.ejb.Local;

import beans.Album;
@Local

public interface DatabaseInterface {
	
	public int deleteOne(int id);
	public int insertOne(Album a);
	public ArrayList<Album> readAll();
	public int updateOne(int id, Album a);
	public Album readOne(int id);
	public ArrayList<Album> searchFor(String name);

}
