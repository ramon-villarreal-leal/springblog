package com.codeup.springblog;

import org.apache.coyote.Request;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MathController {
    //======INSTRUCTOR USED @GETMAPPING INSTEAD=====/////


    @RequestMapping(path = "/add/{num1}/and/{num2}", method = RequestMethod.GET)
    @ResponseBody
    public String add(@PathVariable long num1, @PathVariable long num2) {
        return "addition of numbers " + (num1 + num2);
    }

    @RequestMapping(path = "/subtract/{num1}/from/{num2}", method = RequestMethod.GET)
    @ResponseBody
    public String subtract(@PathVariable long num1, @PathVariable long num2) {
        return "subtraction of numbers " + (num1 - num2);
    }

    @RequestMapping(path = "/multiply/{num1}/and/{num2}", method = RequestMethod.GET)
    @ResponseBody
    public String multiply(@PathVariable long num1, @PathVariable long num2) {
        return "multiplication of numbers " + (num1 * num2);
    }

    @RequestMapping(path = "/divide/{num1}/by/{num2}", method = RequestMethod.GET)
    @ResponseBody
    public String divide(@PathVariable long num1, @PathVariable long num2) {
        return "multiplication of numbers " + (num1 / num2);
    }


}
