package com.cognizant.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cognizant.model.Student;
import com.cognizant.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public ModelAndView insertPage(@RequestParam(value = "msg", required = false) String msg) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("insert");
		if (msg != null) {
			modelAndView.addObject("msg", msg);
		}
		modelAndView.addObject("student", new Student());
		return modelAndView;
	}

	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insert(@ModelAttribute("student") Student student, RedirectAttributes redirectAttributes) {
		Boolean result = studentService.insert(student);
		if (result) {
			return "redirect:getAll";
		} else {
			redirectAttributes.addAttribute("msg", "Failure");
			return "redirect:insert";
		}
	}

	@RequestMapping(value = { "", "/", "getAll" })
	public String getAll(HttpServletRequest request) {
		List<Student> list = studentService.getAll();
		request.setAttribute("list", list);
		return "display";
	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public ModelAndView updatePage(@RequestParam("id") int id,
			@RequestParam(value = "msg", required = false) String msg) {
		Student student = studentService.getStudent(id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("update");
		if (msg != null) {
			modelAndView.addObject("msg", msg);
		}
		modelAndView.addObject("student", student);
		return modelAndView;
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(@ModelAttribute Student student, RedirectAttributes redirectAttributes) {
		Boolean result = studentService.update(student.getId(), student.getName(), student.getMarks());
		if (result) {
			return "redirect:getAll";
		} else {
			redirectAttributes.addAttribute("id", student.getId());
			redirectAttributes.addAttribute("msg", "Failure");
			return "redirect:update";
		}
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public ModelAndView deletePage(@RequestParam("id") int id, @RequestParam(value="msg",required=false) String msg) {
		Student student = studentService.getStudent(id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("delete");
		if (msg != null) {
			modelAndView.addObject("msg", msg);
		}
		modelAndView.addObject("student", student);
		return modelAndView;
	}

	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String delete(@ModelAttribute("student") Student student,RedirectAttributes redirectAttributes) {
		Boolean result = studentService.delete(student.getId());
		if (result) {
			return "redirect:getAll";
		}else {
			redirectAttributes.addAttribute("msg", "Failure");
			redirectAttributes.addAttribute("id", student.getId());
			return "redirect:delete";
		}
	}
}
