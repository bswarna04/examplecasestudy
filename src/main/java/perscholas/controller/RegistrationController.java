package perscholas.controller;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import perscholas.database.dao.UserDAO;
import perscholas.database.entity.User;
import perscholas.form.RegisterFormBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/registration-url-path")
public class RegistrationController {

    public static final Logger LOG = LoggerFactory.getLogger(RegistrationController.class);

    @Autowired
    private UserDAO userDao;

    @RequestMapping(value = "/userList", method = RequestMethod.GET)
    public ModelAndView userList(@RequestParam(required = false) String search, @RequestParam(required = false) String firstName,
                                 @RequestParam(required = false) String lastName) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("registration/userList");

        if (!StringUtils.isEmpty(search)) {
            List<User> users = userDao.findByFirstNameIgnoreCaseOrLastNameIgnoreCase(search, search);
            response.addObject("userListKey", users);
            response.addObject("searchInput", search);
        }

        if (!StringUtils.isEmpty(firstName) && !StringUtils.isEmpty(lastName)) {
            List<User> users = userDao.findByFirstNameContainingIgnoreCaseAndLastNameContainingIgnoreCase(firstName, lastName);
            response.addObject("userListKey", users);
        }

        return response;
    }


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register(@RequestParam(required = false) Integer id) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("registration/register");

        if (id != null) {
            User user = userDao.findById(id);
            RegisterFormBean form = new RegisterFormBean();
            form.setUsername(user.getUsername());
            form.setEmail(user.getEmail());
            form.setPassword(user.getPassword());
            form.setFirstName(user.getFirstName());
            form.setLastName(user.getLastName());
            form.setId(user.getId());

            response.addObject("formBeanKey", form);

        } else {

            RegisterFormBean form = new RegisterFormBean();
            response.addObject("formBeanKey", form);
        }

        return response;
    }


//      @RequestMapping(value = "/register" , method= RequestMethod.GET)
//       public ModelAndView register() throws Exception{
//          ModelAndView response = new ModelAndView();
//          response.setViewName("registration/register");
//
//          RegisterFormBean form =new RegisterFormBean();
//          response.addObject("formBeanKey", form);
//
//          return response;
//      }

    @RequestMapping(value = "/registerSubmit", method = RequestMethod.GET)
    public ModelAndView registerSubmit(@Valid RegisterFormBean form, BindingResult errors) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("registration/register");


        System.out.println(form);

        if (errors.hasErrors()) {

            for (FieldError error : errors.getFieldErrors()) {
                form.getErrorMessages().add(error.getDefaultMessage());
//            System.out.println(error);
                System.out.println("error field = " + error.getField() + " message = " + error.getDefaultMessage());
            }

//            response.addObject("formErrors" , errors);
            response.addObject("formBeanKey", form);
            response.setViewName("registration/register");
        } else {

            // User user= new User();
            User user;

            if (form.getId() == null) {
                //This is an update
                user = new User();

            } else {
                user = userDao.findById(form.getId());
            }

            user.setEmail(form.getEmail());
            user.setFirstName(form.getFirstName());
            user.setLastName(form.getLastName());
            user.setPassword(form.getPassword());
            user.setUsername(form.getUsername());

            userDao.save(user);
           // response.setViewName("redirect:/login");
            response.setViewName("registration/register");
        }

        return response;
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
    public ModelAndView delete(@RequestParam Integer id) throws Exception {

        ModelAndView response = new ModelAndView();
        response.setViewName("redirect:/registration-url-path/userList");

        User delete= userDao.findById(id);
        if(delete !=null){
            userDao.delete(delete);
        }
        return response;
    }

}