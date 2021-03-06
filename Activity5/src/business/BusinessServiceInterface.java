package business;

import java.util.ArrayList;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import beans.Album;
@Stateless
@Local
@Alternative
public interface BusinessServiceInterface {
	
	public int deleteOne(int id);
	public int insertOne(Album a);
	public ArrayList<Album> readAll();
	public int updateOne(int id, Album a);

}
