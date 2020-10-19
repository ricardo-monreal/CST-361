package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import beans.Album;

@Stateless
@Local
@Alternative
public class DatabaseService implements DatabaseInterface{
	
	// connect
	
	String dbURL = "jdbc:mysql://localhost:3306/musicStore";
	String user = "root";
	String password = "root";
	
	// four crud operations
	
	public int deleteOne(int id) {
		
		int numberOfRowsAffected = 0;
		
		// database work
		
		
		Connection c = null;
		PreparedStatement stmt = null;
		//Statement stmt = null;
		//ResultSet rs = null;
		int rowsAffected = 0;
		
		try {
			c = DriverManager.getConnection(dbURL, user, password);
			System.out.println("Connection is successful" + dbURL + " user = " + user + " pw = " + password);
			
			// create a SQL statement
			
			stmt = c.prepareStatement("delete from musicStore.albumsTable where id = ?");
			stmt.setInt(1, id);
			
			
			// execute the statement
			
			rowsAffected = stmt.executeUpdate();
			
			// success message
			System.out.println("Rows affected " + rowsAffected);
			
			// process the rows in the result set. 
			
//			while(rs.next()) {
//				System.out.println("id = " + rs.getInt("id") + " album = " + rs.getString("album_title") + " artist = " + rs.getString("album_artist") + " year = " + rs.getInt("album_year") + " tracks = " + rs.getInt("album_tracks"));
//			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Eror communication with the database");
			e.printStackTrace();
		} finally {
			// close the connection to the db. 
//			rs.close();
			
			try {
				stmt.close();
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		return numberOfRowsAffected;
	}
	
	public int insertOne(Album a){
		
		int numberOfRowsAffected = 0;
		
		// database work
		Connection c = null;
		PreparedStatement stmt = null;
//		ResultSet rs = null;
		int rowsAffected = 0;
		
		try {
			c = DriverManager.getConnection(dbURL, user, password);
			System.out.println("Connection is successful" + dbURL + " user = " + user + " pw = " + password);
			
			// create a SQL statement
			
			stmt = c.prepareStatement("insert into musicStore.albumsTable (id, album_title, album_artist, album_year, album_tracks) values (null, ?, ?, ?, ?)");
			
			stmt.setString(1, a.getAlbumTitle());
			stmt.setString(2, a.getAlbumArtitst());
			stmt.setInt(3, a.getAlbumYear());
			stmt.setInt(4, a.getAlbumTracks());
			// execute the statement
			
			rowsAffected = stmt.executeUpdate();
			
			// success message
			System.out.println("Rows inserted " + rowsAffected);
			
			// process the rows in the result set. 
			
//			while(rs.next()) {
//				System.out.println("id = " + rs.getInt("id") + " album = " + rs.getString("album_title") + " artist = " + rs.getString("album_artist") + " year = " + rs.getInt("album_year") + " tracks = " + rs.getInt("album_tracks"));
//			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Eror communication with the database");
			e.printStackTrace();
		} finally {
			// close the connection to the db. 
//			rs.close();
			
			try {
				stmt.close();
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
		
		return numberOfRowsAffected;
		
	}
	
	public ArrayList<Album> readAll(){
		ArrayList<Album> everyone = new ArrayList<>();
		Album a;
		
		// database work
				
				Connection c = null;
				Statement stmt = null;
				ResultSet rs = null;
				
				try {
					c = DriverManager.getConnection(dbURL, user, password);
					System.out.println("Connection is successful" + dbURL + " user = " + user + " pw = " + password);
					
					// create a SQL statement
					
					stmt = c.createStatement();
					
					
					
					// execute the statement
					
					rs = stmt.executeQuery("select * from musicStore.albumsTable");
					
					// process the rows in the result set. 
					
					while(rs.next()) {
						System.out.println("id = " + rs.getInt("id") + " album = " + rs.getString("album_title") + " artist = " + rs.getString("album_artist") + " year = " + rs.getInt("album_year") + " tracks = " + rs.getInt("album_tracks"));
						a = new Album(rs.getInt("id"), rs.getString("album_title"), rs.getString("album_artist"), rs.getInt("album_year"),rs.getInt("album_tracks"));
						everyone.add(a);
						
					}
					
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("Eror communication with the database");
					e.printStackTrace();
				} finally {
					// close the connection to the db. 
					try {
						rs.close();
						stmt.close();
						c.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					
					
				}
		
		
		return everyone;
	}
	
	public int updateOne(int id, Album a) {
		int numberOfRowsAffected = 0;
		
		// database work		
		Connection c = null;
		PreparedStatement stmt = null;
//		ResultSet rs = null;
		int rowsAffected = 0;
		
		try {
			c = DriverManager.getConnection(dbURL, user, password);
			System.out.println("Connection is successful" + dbURL + " user = " + user + " pw = " + password);
			
			// create a SQL statement
			
			stmt = c.prepareStatement("update musicStore.albumsTable set album_title = ?, album_artist = ?, album_year = ?, album_tracks = ? where id = ?");
			
			stmt.setString(1, a.getAlbumTitle());
			stmt.setString(2, a.getAlbumArtitst());
			stmt.setInt(3, a.getAlbumYear());
			stmt.setInt(4, a.getAlbumTracks());
			stmt.setInt(5, id);
			
			
			
			// execute the statement
			
			rowsAffected = stmt.executeUpdate();
			
			// success message
			System.out.println("Rows affected " + rowsAffected);
			
			// process the rows in the result set. 
			
//			while(rs.next()) {
//				System.out.println("id = " + rs.getInt("id") + " album = " + rs.getString("album_title") + " artist = " + rs.getString("album_artist") + " year = " + rs.getInt("album_year") + " tracks = " + rs.getInt("album_tracks"));
//			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Eror communication with the database");
			e.printStackTrace();
		} finally {
			// close the connection to the db. 
//			rs.close();
			
			try {
				stmt.close();
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
		
		return numberOfRowsAffected;
	}

}
