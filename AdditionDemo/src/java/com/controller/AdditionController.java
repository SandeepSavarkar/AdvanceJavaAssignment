/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import com.service.AddService;

/**
 *
 * @author Sandeep Savarkar
 */
public class AdditionController extends SimpleFormController {
    private AddService additionService;
    public void setAdditionService(AddService additionService)
    {
        this.additionService=additionService;
    }
    
    public AdditionController() {
        //Initialize controller properties here or 
        //in the Web Application Context

        setCommandClass(AdditionModel.class);
        setCommandName("additionModel");
        setSuccessView("result");
        setFormView("home");
    }
    
    @Override
    protected ModelAndView onSubmit(
            HttpServletRequest request, 
            HttpServletResponse response, 
            Object command, 
            BindException errors) throws Exception {
            AdditionModel addition = (AdditionModel) command;
        ModelAndView modelAndView = new ModelAndView(getSuccessView());
        modelAndView.addObject("answer",AddService.add(addition.getNum1(),addition.getNum2()));
      
        return modelAndView;
    }
    
     
}
