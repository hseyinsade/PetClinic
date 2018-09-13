package com.petclinic.controller;

import com.petclinic.service.PetclinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PetclinicController {

    @Autowired
    private PetclinicService petclinicService;

    @RequestMapping(value="/login.html")
    public ModelAndView loginPage() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        return mav;
    }

    @RequestMapping(value = {"/","/index.html"})
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        return mav;
    }
    @RequestMapping("/owners")
    public ModelAndView  getOwners(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("owners",petclinicService.findOwners());
        mav.setViewName("owners");
        return mav;
    }

    @RequestMapping("/welcome")
    @ResponseBody
    public String welcome(){
        return "Welcome";
    }
}
