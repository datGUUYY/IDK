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
       model.addAttribute("TableName", "Inventory");
       if(Items.inventory == null)
       {
            Items.inventory = new ArrayList<Items>();
            Items.inventory.add(new Items("Red Potion", (short) 15, "Smells kinda fishy"));
            Items.inventory.add(new Items("Pink Potion", (short) 11, "Smells kinda beefy"));
       }
       model.addAttribute("Table", Items.inventory);
        return "Menu";
    }
    @PostMapping("menu")
    public String consume(@RequestParam("name") String name,Model model)
    {
        //TODO: in actual implementation, something to get menu type
       model.addAttribute("TableName", "Inventory");
       if(Items.inventory == null)
       {
            Items.inventory = new ArrayList<Items>();
            Items.inventory.add(new Items("Red Potion", (short) 15, "Smells kinda fishy"));
            Items.inventory.add(new Items("Pink Potion", (short) 11, "Smells kinda beefy"));
       }
       if(name != null)
           model.addAttribute("output", "You consumed a " + name);
       else
            model.addAttribute("output", "What would you like to do?");
       model.addAttribute("Table", Items.inventory);
        return "Menu";
    }
}
