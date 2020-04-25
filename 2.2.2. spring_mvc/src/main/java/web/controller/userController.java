package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import web.model.User;
import web.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

@Controller
public class userController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "users", method = RequestMethod.GET)
    public String listUsers(Model model){
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }
    @RequestMapping(value = "/new_user", method = RequestMethod.GET)
    public String newUser(Model model) {
        User user = new User();
        user.setId(0L);
        model.addAttribute("user", user);
        model.addAttribute("bdmethod", "Create new user");
        return "update";
    }
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String updateUser(Model model, HttpServletRequest request){
        User user = userService.getUser(
                Long.parseLong(request.getParameter("userID")));
        model.addAttribute("user", user);
        model.addAttribute("bdMethod", "Update user");
        return "update";
    }


    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateBd(HttpServletRequest request, Model model) throws SQLException {

        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        String id = request.getParameter("userID");
        User user = new User(name, password, role);
        if (id.equals("0")) {
            userService.addUser(user);
        }
        else {

            user.setId(Long.parseLong(id));
            userService.updateUser(user);
        }
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteUser(HttpServletRequest request, Model model) throws SQLException {
        userService.deleteUser(request.getParameter("userID"));
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

}
