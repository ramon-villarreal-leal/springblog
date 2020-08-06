package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class PostController {
    //start of exercise
    //dependency injection
    private final UserRepository usersDao;

    public PostController(PostRepository usersDao){

    }


    private final PostRepository postsDao;

    public PostController(PostRepository postsDao) {
        this.postsDao = postsDao;
    }

    @GetMapping("/posts/{id}")
    public String show(@PathVariable long id, Model model) {
        Post postToShow;

        postToShow = postsDao.getOne(id);
        model.addAttribute("post", postToShow);
        return "posts/show";
    }

    //like writing a do get
    @GetMapping("/posts")
    public String index(Model model) {
        model.addAttribute("posts", postsDao.findAll());
        return "posts/index";
    }

    @PostMapping("/posts/delete")
    public String deleteId(@RequestParam(name = "deleteButton") long id){
        postsDao.deleteById(id);
        //save method below to use for later
//        postsDao.save(new Post("BRance made me man", "wooooo edit buttton woop dee doooo", 3));
        return "redirect:/posts";
    }

    //Postmapping is like writing do post for the form
    @PostMapping("/posts/edit")
    public String editId(@RequestParam(name = "editTitle") String newTitle,
                         @RequestParam(name = "editBody") String newBody,
                         @RequestParam(name = "editId") long newId) {
        //getOne(returns a Post) is a built in function in Spring Boot like getById
        Post postToSave = postsDao.getOne(newId);

        postToSave.setTitle(newTitle);
        postToSave.setBody(newBody);


        postsDao.save(postToSave);
        //redirecting to GetMapping for "/posts" LOOK ABOVE line 27
        return "redirect:/posts";
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
