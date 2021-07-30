package com.example.emp.controller;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
 
import com.example.emp.domain.Student;
import com.example.emp.service.StudentService;
 
@RestController
public class StudentController {
	
	 	@Autowired
	    private StudentService service;
 
//	    @GetMapping("/")
//	    public String viewHomePage(Model model) {
//	        List<Student> liststudent = service.listAll();
//	        model.addAttribute("liststudent", liststudent);
//	        System.out.print("Get / ");	
//	        return "index";
//	    }
	    //
	 
	    
	    @GetMapping("/")
	    public ModelAndView viewHomePage(Model model) {
	        List<Student> liststudent = service.listAll();
//	        model.addAttribute("liststudent", liststudent);
	        ModelAndView modelAndView = new ModelAndView();
	        modelAndView.addObject("liststudent", liststudent);
	        modelAndView.setViewName("index");
	        System.out.print("Get / ");	
	        return modelAndView;
	    }

	 
 
//	    @GetMapping("/new")
//	    public String add(Model model) {
//	        model.addAttribute("student", new Student());
//	        return "new";
//	    }
	    
	    
	    @GetMapping("/new")
	    public ModelAndView add(Model model) {
	        model.addAttribute("student", new Student());
	        ModelAndView modelAndView = new ModelAndView();
	        return modelAndView;
	    }
	    
	    
 
//	    @RequestMapping(value = "/save", method = RequestMethod.POST)
//	    public String saveStudent(@ModelAttribute("student") Student std) {
//	        service.save(std);
//	        return "redirect:/";
//	    }
	    
	    
	    @RequestMapping(value = "/save", method = RequestMethod.POST)
	    public ModelAndView saveStudent(@ModelAttribute("student") Student std) {
	        service.save(std);
//	        return modelAndView;
	        return new ModelAndView("redirect:/");
	    }
	    
	    
 
	    @RequestMapping("/edit/{id}")
	    public ModelAndView showEditStudentPage(@PathVariable(name = "id") int id) {
	        ModelAndView mav = new ModelAndView("new");
	        Student std = service.get(id);
	        mav.addObject("student", std);
	        return mav;
	    }
	    
	    
//	    @RequestMapping("/delete/{id}")
//	    public String deletestudent(@PathVariable(name = "id") int id) {
//	        service.delete(id);
//	        return "redirect:/";
//	    }
	    
	    @RequestMapping("/delete/{id}")
	    public ModelAndView deletestudent(@PathVariable(name = "id") int id) {
	        service.delete(id);
	        return new ModelAndView("redirect:/");
	    }
	    
	    
}