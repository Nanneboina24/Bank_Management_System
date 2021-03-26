package jbr.springmvc.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jbr.springmvc.model.Action;


@Controller
public class ActionController {
	
	@RequestMapping(value = "/action", method = RequestMethod.GET)
	  public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
	    
		  ModelAndView mav = new ModelAndView("action"); // line 1
	      Action action=new Action();  // No need to create model class because we are not getting any data to fill in form
	      mav.addObject("action",action); // for simply calling form we use line 1
	      return mav;
	  }
	
	

}
