package com.codeup.springblog;

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
            message = "COrrect guess awesome!";
//            return "You have guessed correctly!";


        } else {
//           return "Incorrect guess sorry.";
            message = "incorrect guess";
        }
        model.addAttribute("n", n);
        model.addAttribute("diceNumber", diceNumber);
        model.addAttribute("message", message);


        return "roll-dice-result";


    }


//    @RequestMapping(path = "/roll-dice", method = RequestMethod.GET)
//    public String viewRollDice(@RequestParam(die = "n") String die, Model model){
//
//        model.addAttribute("die");
//
//        die = (Math.random()*6) + 1;
//            if(die.equals(die)) {
//                return "You have guessed correctly!";
//            } else {
//                return "Try again!";
//            }
//
//        return "roll-dice";
//    }



}
