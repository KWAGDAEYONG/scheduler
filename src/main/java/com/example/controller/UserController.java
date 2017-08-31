package com.example.controller;

import com.example.model.Schedule;
import com.example.service.ScheduleService;
import com.example.service.UserService;
import com.example.model.User;
import com.example.utility.JsonConverter;
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
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by user on 2017-05-12.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @Autowired
    ScheduleService scheduleService;

    @PostMapping("/login")
    public String login(User user, HttpSession httpSession, RedirectAttributes rttr, Model model){
        User dbUser = userService.selectByEmail(user.getEmail());

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

        Date today = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");

        model.addAttribute("user",dbUser);
        model.addAttribute("schedules",JsonConverter.schedulesToJson(scheduleService.selectByMonth(sdf.format(today), dbUser)));
        return "/schedule/schedule_sample2";

    }

    @GetMapping("/logout")
    public String logout(HttpSession httpSession){
        if(httpSession!=null) {
            httpSession.removeAttribute("loginUser");
            log.debug("로그아웃 성공, 세션값 제거합니다.");
        }
        return "/user/login";
    }

    @GetMapping("/registerForm")
    public String registerForm(){
        return "/user/register";
    }


    @PostMapping("/register")
    public String register(User user){
        userService.insert(user);

        return "/user/login";
    }

}
