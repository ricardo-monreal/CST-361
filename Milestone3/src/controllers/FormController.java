package controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import beans.User;

@ManagedBean
public class FormController {

	public String onSubmit() {
		
		// more work to do here
		FacesContext context = FacesContext.getCurrentInstance();
		User user = context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);
		
		// show the user object data in the console log
		// testing
		System.out.println("You clicked the submit button");
		System.out.println("The first name is " + user.getFirstName());
		System.out.println("Your location is " + user.getLastName());
		
		// put the user object into the POST request
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		// show the next page
		return "Response.xhtml";
	}
}
