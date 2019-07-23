package hello;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import form.UserForm;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "Greetings from Spring Boot!";
    }
    @RequestMapping("/hello2") 
    public String hello2(HttpServletRequest request, @RequestParam(value = "invcode", defaultValue = "springboot-thymeleaf") String invcode) { 
        request.setAttribute("invcode", invcode); 
        return "hello"; 
    } 
	
	 @RequestMapping("/Hi")
    public ModelAndView sayHello() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hello");
        modelAndView.addObject("name", 12345);
        //System.out.println("test");
        return modelAndView;
    }
	
	 @ResponseBody
	 @RequestMapping(value="/add",method=RequestMethod.POST)
	 public String add(@ModelAttribute UserForm user){
	     String username = user.getUsername();
	     String password = user.getPassword();
	     return username+"__"+password;
	 }

}