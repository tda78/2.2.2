package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import web.model.User;
import web.model.UserRole;
import web.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listUsers(Model model){
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @RequestMapping(value = "/new_user", method = RequestMethod.GET)
    public String newUser(Model model, HttpServletRequest request) {
        User user = new User();
        user.setUser_id(0L);
        model.addAttribute("user", user);
        model.addAttribute("roles", userService.getAllRoles());
        model.addAttribute("bdMethod", "Create new user");
        return "update";
    }
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String updateUser(Model model, HttpServletRequest request){
        Object user = userService.getUser(
                Long.parseLong(request.getParameter("userID")));
        model.addAttribute("user", user);
        model.addAttribute("roles", userService.getAllRoles());
        model.addAttribute("bdMethod", "Update user");
        return "update";
    }


    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateBd(HttpServletRequest request, Model model) throws SQLException {

        String name = request.getParameter("name");
        String password = request.getParameter("password");

        String id = request.getParameter("userID");
        User user = new User(name, password);
        for (UserRole role: userService.getAllRoles() ) {
            if(!(request.getParameter(role.getRolename())==null)){
                user.getRoles().add(role);
            }else {
                user.getRoles().remove(role);
            }
        }
        if (id.equals("0")) {
            userService.addUser(user);
        }
        else {

            user.setUser_id(Long.parseLong(id));
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
