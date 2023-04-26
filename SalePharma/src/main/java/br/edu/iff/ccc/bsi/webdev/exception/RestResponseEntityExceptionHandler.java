package br.edu.iff.ccc.bsi.webdev.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value = Exception.class)
	public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) {
		ModelAndView mav = new ModelAndView("error");
		mav.addObject("exception",e.getMessage());
		mav.addObject("url", req.getRequestURL());
		mav.addObject("message", "Ocorreu um erro inesperado");
		mav.addObject("trace", e.getStackTrace());
		return mav;
		
	}

}
