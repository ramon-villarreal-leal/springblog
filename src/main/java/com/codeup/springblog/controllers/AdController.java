package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Ad;
import com.codeup.springblog.repositories.AdRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//@Controller
//public class AdController {
//
//    @GetMapping("/ads")
//    @ResponseBody
//    public List<Ad> getAds() {
//        private final AdRepository adsDao;
//
//        //dependency injection
//
//        public AdController(AdRepository adsDao) {
//            this.adsDao = adsDao;
//        }
//
//        return  adsDao.findAll();
//    }
//}
