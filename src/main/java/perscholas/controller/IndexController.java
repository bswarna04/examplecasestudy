package perscholas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public ModelAndView index() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("index");

        return response;
    }

//    @RequestMapping(value = "/indexSubmit", method = RequestMethod.GET)
//
//    public ModelAndView indexSubmit(HttpServletRequest request, HttpSession session) throws Exception {
//
//          String firstname=request.getParameter("firstname");
//        String lastname=request.getParameter("lastname");
//
//
//        System.out.println("name = " + request.getParameter("firstname") );
//        System.out.println("lastname = " + request.getParameter("lastname") );
//        System.out.println("email = " + request.getParameter("email") );
//        System.out.println("password = " + request.getParameter("password") );
//        System.out.println("confirmpassword = " + request.getParameter("confirmpassword") );
//        System.out.println("dateofbirth = " + request.getParameter("dob") );
//        System.out.println("Registerbutton = " + request.getParameter("formsubmit") );
//
//
//
//        ModelAndView response = new ModelAndView();
//        response.addObject("firstname",firstname);
//        response.addObject("lastname",lastname);
//
//
//        response.addObject("firstname", firstname);
//        response.addObject("lastname", lastname);
//
//        response.setViewName("indexsubmit");
//
//        return response;
//
//    }
//
}
