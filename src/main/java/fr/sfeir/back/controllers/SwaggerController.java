package fr.sfeir.back.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// FIXME fonctionnalité KO au 07/09/2016

@Controller
public class SwaggerController {

	@RequestMapping(value = "/swagger-ui", method = RequestMethod.GET)
	public String swagger(Model model) {
		System.out.println("request swagger-ui");
		return "redirect:swagger/index.html";
	}

}
