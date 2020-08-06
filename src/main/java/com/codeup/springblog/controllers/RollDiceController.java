package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RollDiceController {


    @GetMapping("/roll-dice")
    public String viewRollDice(){
        return "roll-dice";
    }

//    @GetMapping("/roll-dice/{n}")
//    public String viewRollDice(){
//        return
//    }

    @RequestMapping(path = "/roll-dice/{n}", method = RequestMethod.GET)

    public String viewRollDice(@PathVariable int n, Model model) {
       String message;

        int diceNumber = (int) ((Math.random()* 6) + 1) ;

        if(n == diceNumber){
            message = "Correct guess awesome!";
        } else {
            message = "incorrect guess";
        }
        model.addAttribute("n", n);
        model.addAttribute("diceNumber", diceNumber);
        model.addAttribute("message", message);

        return "roll-dice-result";
    }
}
