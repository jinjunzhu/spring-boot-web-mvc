package web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {
	private Log log = LogFactory.getLog(this.getClass());

	@RequestMapping(value = "/greet", method=RequestMethod.GET)
	public String greet(@RequestParam(value = "name", required=false, defaultValue="World!")final String name, final Model model) {
		log.info("Controller has been invoked with Request Parameter name = '" + name + "'.");
		model.addAttribute("name", name);
		return "hello";
	}

	@RequestMapping(value = "/greet/{name}", method=RequestMethod.GET)
	public String greetTwoWays(@PathVariable(value="name") final String name, final Model model) {
		log.info("Controller has been invoked with Path Variable name = '" + name + "'.");
		model.addAttribute("name", name);
		return "hello";
	}
	
	@RequestMapping(value = "/greet/{name}", method=RequestMethod.POST)
	public String greetForm(@RequestParam final String id,@RequestParam final String content,@PathVariable final String name,Model model) {
		log.info("Controller has been invoked with Path Variable id = '" + id + ";name=" + name + ";content=" + content +"'.");
		model.addAttribute("name", name);
		model.addAttribute("id", id);
		model.addAttribute("content", content);
		return "greetings";
	}
	
	@RequestMapping(value = "/greet", method=RequestMethod.POST)
	public String greetFormNoVariable(@RequestParam final String id,@RequestParam final String content,@RequestParam final String name,Model model) {
		log.info("Controller has been invoked with Path Variable id = '" + id + ";name=" + name + ";content=" + content +"'.");
		model.addAttribute("name", name);
		model.addAttribute("id", id);
		model.addAttribute("content", content);
		return "greetings";
	}
}
