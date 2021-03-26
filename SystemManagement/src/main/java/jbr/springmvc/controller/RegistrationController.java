package jbr.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jbr.springmvc.model.User;
import jbr.springmvc.service.UserService;

@Controller
public class RegistrationController {
  @Autowired
  public UserService userService;
  public int count,c;
  @RequestMapping(value = "/register", method = RequestMethod.GET)
  public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
    
	  ModelAndView mav = new ModelAndView("register");
	  count= userService.getcount(); 
	  c=count+1;
	  System.out.println("regCount"+count);
	  System.out.println("regId"+c);
	  User user=new User();
	 
      mav.addObject("user", user);
      user.setId(c);
      return mav;
  }

  @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
  public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
      @ModelAttribute("user") User user) {

    userService.register(user);

    return new ModelAndView("welcome", "firstname", user.getFirstname());
  }
}
