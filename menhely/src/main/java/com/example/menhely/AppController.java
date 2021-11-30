package com.example.menhely;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.util.List;

@Controller
public class AppController {
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private MailRepository mailRepository;
    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }
    @GetMapping("index")
    public String viewHomePage2() {
        return "index";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "signup_form";
    }
    @PostMapping("/process_register")
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepo.save(user);
        return "register_success";
    }

    @GetMapping("/contact")

    public String viewContactPage() {
        return "contact";
    }

    @PostMapping("/sendmail")
    public String saveMail(@RequestParam("email") String email, @RequestParam("message") String message, ModelMap modelMap) {
        Long datetime = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(datetime);
        Message m = new Message();
        m.setText(message);
        m.setEmail(email);
        m.setTime(timestamp);
        mailRepository.save(m);

        modelMap.put("email", email);
        modelMap.put("message", message);

        return "viewMail";
    }



    @GetMapping("message")
    public String viewMessagePage(Model model) {
        List<Message> messageList = mailRepository.findAll();
        model.addAttribute("messageList",messageList);
        return "message";
    }

}