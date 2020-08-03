package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class PostController {
    //=====instructor used a getmapping here and below until last one====/
    @GetMapping("/posts")
    public String index(Model model) {
        ArrayList<Post> posts = new ArrayList<>();
        Post post1 = new Post("Gaming Blog", "I am a super pro gamer. ",1);
        Post post2 = new Post("Gaming Blog for Noobs", "So not a pro gamer.", 2);
        posts.add(post1);
        posts.add(post2);

        model.addAttribute("posts", posts);

        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String show(@PathVariable long id, Model model) {
        Post post1 = new Post("Gaming Blog", "I am a super pro gamer. ", 1);
        Post post2 = new Post("Gaming Blog for Noobs", "So not a pro gamer.", 2);



        model.addAttribute("id", id);
        model.addAttribute("Post", post1);
        model.addAttribute("Post2", post2);
        return "posts/show";
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
