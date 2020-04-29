package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/user/")
    public String userPage(Model model) {

        String string = (SecurityContextHolder.getContext().getAuthentication().
                getPrincipal().toString());

        User user = (User) userService.loadUserByUsername(string);
        model.addAttribute("user", user);
        return "userInfo";
    }
}
