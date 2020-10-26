package business;

import java.util.ArrayList;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import beans.Album;
import database.DatabaseInterface;

@Stateless
@Local
@Alternative
public class BusinessService1 implements BusinessServiceInterface {

	@Inject
	DatabaseInterface db;
	
	@Override
	public int deleteOne(int id) {
		// TODO Auto-generated method stub
		return db.deleteOne(id);
	}

	@Override
	public int insertOne(Album a) {
		// TODO Auto-generated method stub
		return db.insertOne(a);
	}

	@Override
	public ArrayList<Album> readAll() {
		// TODO Auto-generated method stub
		return db.readAll();
	}

	@Override
	public int updateOne(int id, Album a) {
		// TODO Auto-generated method stub
		return db.updateOne(id, a);
	}

	@Override
	public Album readOne(int id) {
		// TODO Auto-generated method stub
		return db.readOne(id);
	}

	@Override
	public ArrayList<Album> searchFor(String name) {
		// TODO Auto-generated method stub
		return db.searchFor(name);
	}
	
	

}
