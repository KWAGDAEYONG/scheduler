package com.example.controller;

import com.example.service.UserService;
import com.example.model.User;
import com.example.utility.UserUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * Created by user on 2017-05-12.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @GetMapping("/loginPage")
    public String loginPage(){
        return "/user/login";
    }

    @PostMapping("/login")
    public String login(User user, HttpSession httpSession, RedirectAttributes rttr, Model model){
        System.out.println(user.getUserId());
        User dbUser = userService.selectByUserId(user.getUserId());

        if(dbUser==null){
            rttr.addAttribute("error",true);
            log.debug("해당 유저가 없습니다.");
            return "redirect:/user/loginPage";
        }

        if(!UserUtility.matchPassword(dbUser, user.getPassword())){
            rttr.addAttribute("error",true);
            log.debug("비밀번호가 틀립니다.");
            return "redirect:/user/loginPage";
        }

        httpSession.setAttribute("loginUser",dbUser);
        log.debug("로그인 성공, 세션값에 저장합니다.");

        model.addAttribute("schedules", dbUser.getSchedules());
        return "/schedule/scheduleList";
    }
}
