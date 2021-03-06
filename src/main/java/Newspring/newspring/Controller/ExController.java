package Newspring.newspring.Controller;

import Newspring.newspring.auth.MyUserDetail;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import Newspring.newspring.entity.User;
import Newspring.newspring.service.ExService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ExController {
    private final ExService service;

    @GetMapping("/MainPage")
    public String MainPage() {
        return "MainPage";
    }
    @GetMapping("/signUp")
    public String signUpForm() {
        return "signup";
    }

    @PostMapping("/signUp")
    public String signUp(User user) {
        user.setRole("USER");
        service.joinUser(user);
        log.info(user.getEmail());
        return "redirect:/login";
    }

    @GetMapping("/")
    public String userAccess(Model model, Authentication authentication) {
        MyUserDetail userDetail = (MyUserDetail)authentication.getPrincipal();
        log.info(userDetail.getUsername());
        model.addAttribute("info", userDetail.getUsername());
        return "user_access";
    }
}