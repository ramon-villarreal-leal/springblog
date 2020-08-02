package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    //=====instructor used a getmapping here and below until last one====/
    @RequestMapping(path = "/posts", method = RequestMethod.GET)
    @ResponseBody
    public String index() {
        return "Here are all the posts!";
    }

    @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String show(@PathVariable long id) {
        return "Viewing book with post id of " + id;
    }

    @RequestMapping(path ="/posts/create", method = RequestMethod.GET)
    @ResponseBody
    public String create(){
        return "Here is a form to create a post";
    }

    @PostMapping(path = "posts/create")
    @ResponseBody
    public String insert(){
        return "Post has been created!";
    }
}
