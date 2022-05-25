package com.treydev.idk;

import java.util.ArrayList;
// import java.util.List;

// import com.treydev.myClass;

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

    @GetMapping("menu")
    public String menu(Model model)
    {
        //TODO: in actual implementation, something to get menu type
        model.addAttribute("TableName", "SAMPLE MOCK item");
        ArrayList<Items> Table = new ArrayList<Items>();

        Table.add(new Items("Potions",(short) 3,"They taste like fish."));
        Table.add(new Items("Capsules",(short) 65 ,"They also taste like fish."));
        model.addAttribute("Table", Table);
        return "Menu";
    }
}
