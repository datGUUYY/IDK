package com.treydev.idk;

import java.util.ArrayList;
// import java.util.List;

// import org.springframework.session.Session;
// import org.springframework.boot.builder.SpringApplicationBuilder;
// import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {
    //@RequestMapping(value="/")
    //@ResponseBody
    @GetMapping("/")
    public String helloWorld(Model model)
    {
        return "MainPage";
    }

    @PostMapping("game")
    public String game(@RequestParam("name") String name, @RequestParam("action") String action, Model model)
    {
        ArrayList<String> gameLog = new ArrayList<String>();
        gameLog.add("LineOne");
        gameLog.add("LineTwo");
        gameLog.add("LineThree");
        gameLog.add("LineFour");
        gameLog.add(action);

        ArrayList<String> actionList = new ArrayList<String>();
        actionList.add("Action 1");
        actionList.add("Action 2");
        actionList.add("Action 3");
        actionList.add("Action 4");

        model.addAttribute("gameLog", gameLog);
        model.addAttribute("actionList", actionList);
        model.addAttribute("name", name);

        return "Game";
    }
    // @PostMapping("game")
    // public String game(@RequestParam("name") String name, Model model)
    // {
    //     ArrayList<String> gameLog = new ArrayList<String>();
    //     gameLog.add("LineOne");
    //     gameLog.add("LineTwo");
    //     gameLog.add("LineThree");
    //     gameLog.add("LineFour");

    //     ArrayList<String> actionList = new ArrayList<String>();
    //     actionList.add("Action 1");
    //     actionList.add("Action 2");
    //     actionList.add("Action 3");
    //     actionList.add("Action 4");

    //     model.addAttribute("gameLog", gameLog);
    //     model.addAttribute("actionList", actionList);
    //     model.addAttribute("name", name);

    //     return "Game";
    // }
}
