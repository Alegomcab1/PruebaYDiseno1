/*
 * ProfileController.java
 * 
 * Copyright (C) 2018 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the
 * TDG Licence, a copy of which you may download from
 * http://www.tdg-seville.info/License.html
 */

package controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import forms.Calculator;

@Controller
@RequestMapping("/profile")
public class ProfileController extends AbstractController {

	// Action-1 ---------------------------------------------------------------		

	@RequestMapping(value = "/quotes", method = RequestMethod.GET)
	public ModelAndView action1() {
		ModelAndView result;
		List<String> quotes;

		quotes = new ArrayList<String>();
		quotes.add("Make it simple, not simpler -- Albert Einstein");
		quotes.add("A day without sunshine is like, you know, night -- Steve Martin");
		quotes.add("Yeah, well, that's just, like, your opinion, man -- The Big Lewosky");
		quotes.add("Insanity: doing the same thing over and over again and expecting different results -- Albert Einstein");
		quotes.add("I'd like to live like a poor man, only with lots of money -- Pablo Picasso");
		quotes.add("Money doesn't make you happy. I now have $50 million but I was just as happy when I had $48 million -- Arnold Schwarzenegger");
		quotes.add("One of the great things about books is sometimes there are some fantastic pictures -- George W. Bush");
		quotes.add("The problem with quotes found on the internet is that they are often not true -- Mazinger Z");

		Collections.shuffle(quotes);
		quotes = quotes.subList(0, 3);

		result = new ModelAndView("profile/quotes");
		result.addObject("quotes", quotes);

		return result;
	}

	// Action-2 ---------------------------------------------------------------		

	@RequestMapping(value = "/calculator", method = RequestMethod.GET)
	public ModelAndView action2() {
		ModelAndView result;
		Calculator calculator;

		calculator = new Calculator();

		result = new ModelAndView("profile/calculator");
		result.addObject("calculator", calculator);

		return result;
	}
	@RequestMapping(value = "/calculator", method = RequestMethod.POST)
	public ModelAndView action2Post(@Valid final Calculator calculator, final BindingResult binding) {

		ModelAndView result;
		calculator.compute();

		result = new ModelAndView("profile/calculator");
		result.addObject("calculator", calculator);

		return result;
	}

	// Action-2 ---------------------------------------------------------------		

	@RequestMapping("/panic")
	public ModelAndView action3() {
		throw new RuntimeException("Oops! An *expected* exception was thrown. This is normal behaviour.");
	}

}
