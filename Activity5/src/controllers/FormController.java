package controllers;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import beans.Album;
import business.BusinessServiceInterface;


@ManagedBean

public class FormController {
	
	

	public void FormController() {
		
	}
	
	@Inject
	BusinessServiceInterface bs;
	
	
	public String onSubmitCreate() throws SQLException {
		// when user creates a new item
		
		
		
		// read the "get" values form the form
		FacesContext context = FacesContext.getCurrentInstance();
		
		// store the "get" values in an object
		Album a = context.getApplication().evaluateExpressionGet(context, "#{album}", Album.class);
		// a holds the value of submitted object that was on the web form
		
		System.out.println("The object you entered is " + a.getAlbumTitle());
		
		// store the object in the database. 
			// todo
		
		bs.insertOne(a);
		
		
		// put the get values into a response page. 
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("album", a);
		
		// show the response page. 
		return"ResponsePage.xhtml";
		
	}

	public String onSubmitEdit() throws SQLException {
		// when user creates a new item
		
		
		
		// read the "get" values form the form
		FacesContext context = FacesContext.getCurrentInstance();
		
		// store the "get" values in an object
		Album a = context.getApplication().evaluateExpressionGet(context, "#{album}", Album.class);
		// a holds the value of submitted object that was on the web form
		
		System.out.println("The object you edited is " + a.getAlbumTitle());
		
		// store the object in the database. 
			// todo
		
		bs.updateOne(a.getId(), a);
		
		
		// put the get values into a response page. 
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("album", a);
		
		// show the response page. 
		return"ResponsePage.xhtml";
		
	}
	
	public ArrayList<Album> getAll() throws SQLException {


		return bs.readAll();
	}

	
	public String onDelete(Album a) throws SQLException {
		
		// when user creates a new item
		
		
		
				
				
				System.out.println("The object you plan to delete is " + a.getAlbumTitle());
				
				// store the object in the database. 
					// todo
				
				
				bs.deleteOne(a.getId());
				
				
				// put the get values into a response page. 
				FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("album", a);
				
				// show the response page. 
				return"ResponsePage.xhtml";
		
	}
	
	public String onShowEdit(Album a) {
		System.out.println("The object you plan to edit is " + a.getAlbumTitle());
		
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("album", a);
		return "EditForm.xhtml";
	}
	
	
	public String showEntryForm() {
		
		return "EntryForm.xhtml";
	}
	
	public String showIndex() {
		
		return "index.xhtml";
	}
	
//	public String onShowEdit(Album a) {
//		
//		System.out.println("The object you plan to edit is " + a.getAlbumTitle());
//		
//		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("album", a);
//		
//		
//		
//		
//		return "EditForm.xhtml";
//	}
}
