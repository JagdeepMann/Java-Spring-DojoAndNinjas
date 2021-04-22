package com.suraj.dojoandninjas.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.suraj.dojoandninjas.models.Dojo;
import com.suraj.dojoandninjas.models.Ninja;
import com.suraj.dojoandninjas.services.DojoNinjaService;

@Controller
public class MainController {
	// Construct maincontroller by pulling in service
	private final DojoNinjaService dnServ;
	public MainController (DojoNinjaService dnServ) {
		this.dnServ = dnServ;
	}
	
	@RequestMapping("/")
	public String index() {
//		model.addAttribute("dojo", dnServ.findAllDojos());
		return "redirect:/dojos/new";
	}
	
	// Display Form to create new Dojo
	@GetMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "newDojo.jsp";
	}
	// Add created Dojo to Database
	@RequestMapping(value="/dojos/new", method=RequestMethod.POST)
    public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
        if (result.hasErrors()) {
            return "newDojo.jsp";
        } else {
            dojo = dnServ.newDojo(dojo);
//            return "info.jsp";
            return "redirect:/dojos/" + dojo.getId();
        }
    }
	//////////////////////////////////////////////
	// Display Form to create new Ninja
	// this renders the page
	@GetMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		model.addAttribute("dojos", dnServ.findAllDojos());
		return "newNinja.jsp";
	}
	
	// Add created Ninja to Database
	@RequestMapping(value="/ninjas/new", method=RequestMethod.POST)
    public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
        if (result.hasErrors()) {
            return "newNinja.jsp";
        } else {
        	// saving the ninja here
            dnServ.newNinja(ninja);
//            return "info.jsp";
            return "redirect:/ninjas/new";
        }
    }
	
	// Render Show Page
	@GetMapping("/dojos/{dojoId}")
	public String info(@PathVariable("dojoId") Long id, Model model) {
		Dojo d = dnServ.findDojoById(id);
		model.addAttribute("dojo", d);
		return "info.jsp";
	}

}
