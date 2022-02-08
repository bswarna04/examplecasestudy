package perscholas.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import perscholas.form.LoginFormBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/session")
public class LoginSessionController {

    private static String SESSION_KEY = "usernameSessionKey";
    private static String SESSION_ERROR_MESSAGE="errorMessageKey";

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(HttpServletRequest request, HttpSession session) throws Exception {
        // this method is checking to see if the user is logged in by looking at the session
        // if logged in ( user is in the session ) then show the success page.
        // if not logged in ( user is not in the session ) then show the login page
        ModelAndView response = new ModelAndView(); //Modeland View is used to get and  the data we generated in the webpage

        String username = (String) session.getAttribute(SESSION_KEY);
        if (StringUtils.equals(username, "tom")) {
            // when using redirect you will use the URL of the controller method
            // that you want to display.  In this case the /success RequestMapping
            response.setViewName("redirect:http://localhost:8080/success");

        } else {
            // when using the name of a view we use the path to the JSP page
            // within the jsp folder.
            String errorMessage= (String)session.getAttribute(SESSION_ERROR_MESSAGE);
            response.addObject("errorMessage",errorMessage);
            response.setViewName("login/login");
        }

        return response;
    }


    @RequestMapping(value = "/loginFormSubmit", method = RequestMethod.GET)
    public ModelAndView loginSubmit(LoginFormBean form, @RequestParam String usernameFromForm, @RequestParam String passwordFromForm,
                                                            HttpServletRequest request, HttpSession session) throws Exception {
        ModelAndView response = new ModelAndView();

        String username = request.getParameter("usernameFromForm");
        String password = request.getParameter("passwordFromForm");

        // if ("tom".equals(username) && "jerry".equals(password) ){
        if (StringUtils.equals(username, "tom") && StringUtils.equals(password, "jerry")) {
            session.setAttribute(SESSION_KEY, username);
            response.setViewName("redirect:/success");
            session.setAttribute(SESSION_ERROR_MESSAGE,null);
        } else {
            // invalid login
            // setting session to null to ensure the user is logged out
            session.setAttribute(SESSION_KEY, null);
            response.setViewName("redirect:/login");
            session.setAttribute(SESSION_ERROR_MESSAGE,"Invalid Login");
        }

        return response;
    }

    @RequestMapping(value = "/loginFormSubmit1", method = RequestMethod.GET)
    public ModelAndView loginSubmit(LoginFormBean form, HttpSession session) throws Exception {
        ModelAndView response = new ModelAndView();

        String username = form.getUsernameFromForm();
        String password = form.getPasswordFromForm();

        if (StringUtils.equals(username, "tom") && StringUtils.equals(password, "jerry")) {
            session.setAttribute(SESSION_KEY, form.getUsernameFromForm());
            response.setViewName("redirect:/success");
            session.setAttribute(SESSION_ERROR_MESSAGE,null);
        } else {
            // invalid login
            // setting session to null to ensure the user is logged out
            session.setAttribute(SESSION_KEY, null);
            response.setViewName("redirect:/login");

            session.setAttribute(SESSION_ERROR_MESSAGE,"Invalid Login");
        }

        return response;
    }

    @RequestMapping(value = "/success", method = RequestMethod.GET)
    public ModelAndView success(HttpSession session) throws Exception {
        // this method is checking to see if the user is logged in by looking at the session
        // if logged in ( user is in the session ) then show the success page.
        // if not logged in ( user is not in the session ) then show the login page
        ModelAndView response = new ModelAndView();

        String username = (String) session.getAttribute(SESSION_KEY);
        if (StringUtils.equals(username, "tom")) {
            // add the username to the response model so that it can be displayed on the jsp page.
            response.addObject("loggedInUser", username);

            response.setViewName("login/success");
        } else {
            // need to implement here to redirect back to login page
            // because it means the user has requested the /success url
            // but is not in the session
            response.setViewName("redirect:/login");
        }

        return response;
    }


//    @RequestMapping(value = "/logout", method = RequestMethod.GET)
//    public ModelAndView logout(HttpSession session) throws Exception {
//        // this is how to destroy the current user session
//        // always implement a logout method this way.
//        session.invalidate();
//        ModelAndView response = new ModelAndView();
//        // this is how to do a redirect in spring mvc using the model
//        // this will change the url to be localhost:8080/login
//        // which is preferable because the URL is the same as the page you are on
//        response.setViewName("redirect:/login");
//
//        // doing it this way will work but is not best practice
//        //response.setViewName("login/login");
//
//        return response;
//    }

}







