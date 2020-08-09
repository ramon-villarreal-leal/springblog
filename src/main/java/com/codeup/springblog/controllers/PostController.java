package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.User;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
import com.codeup.springblog.services.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Email;
import java.util.ArrayList;

@Controller
public class PostController {


    //You add the Users Repository to it
    private final UserRepository usersDao;
    private final PostRepository postsDao;
    private final EmailService emailService;



    public PostController(PostRepository postsDao, UserRepository usersDao, EmailService emailService) {
        this.postsDao = postsDao;
        this.usersDao = usersDao;
        this.emailService = emailService;
    }

    //=======method for editing a specific id===========/
    @GetMapping("posts/{id}/edit")
    public String editSpecificID(@PathVariable long id, Model model) {
        model.addAttribute("post", postsDao.getOne(id));
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String editPost(@ModelAttribute Post post,
                        @PathVariable long id) {

        // TODO: Change user to logged in user dynamic
        User user = usersDao.getOne(1L);
        post.setUser(user);
        postsDao.save(post);
        return "redirect:/posts";

//        Post postsToShow;
//        postsToShow = postsDao.getOne(id);
//        //getOne(returns a Post) is a built in function in Spring Boot like getById
//        Post postToSave = postsDao.getOne(idNew);
//
//        postToSave.setTitle(titleNew);
//        postToSave.setBody(bodyNew);



        //redirecting to GetMapping for "/posts" LOOK ABOVE line 27

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



    @GetMapping("/posts/create")
    public String create(Model model){
        model.addAttribute("posts", new Post());
        return "posts/create";
    }

    @PostMapping("posts/create")
    public String insert(@RequestParam String title, @RequestParam String body){
        User user = usersDao.getOne(1L);
        Post post = new Post(title, body, user);
        postsDao.save(post);
        emailService.prepareAndSend(post,  title, body);
        return "redirect:/posts";
    }





}
