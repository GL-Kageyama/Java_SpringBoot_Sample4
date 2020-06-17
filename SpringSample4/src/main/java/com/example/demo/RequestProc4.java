package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/*
 * Controller class to display and send the text box
 */
@Controller
public class RequestProc4 {

	/*
	 * Function to display the route path
	 * @param model An object used to pass values from the controller to the view.
	 * @return "index" Return index.html
	 */
	@RequestMapping(value="/")
	public String index(Model model) {

		// Create a ParamObject when it is initially displayed.
		ParamObject paramObject = new ParamObject();
		// Add a 10line Member object.
		for (int i = 0; i < 10; i++) {
			paramObject.members.add(new Member());
		}
		// Pass the object to the view.
		model.addAttribute("paramObject", paramObject);

		return "index4";
	}

	/*
	 * Function to process the value sent by the Send button
	 * @param members Receive a text string in a text box as a list value (object).
	 * @return mav Returns a string stored in ModelAndView.
	 */
	@RequestMapping(value="/post")
	public ModelAndView response(@ModelAttribute ParamObject members) {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("index4");
		// Get all list values.
		mav.addObject("result", members.getMembers());

		return mav;
	}

	/*
	 * Inner class for an object to be passed to the respopnse function
	 */
	public static class ParamObject {

		// Let members have a list to pass the list values to.
		private List<Member> members = new ArrayList<>();

		// Input values Getter/Setter
		public List<Member> getMembers() { return members; }
		public void setMembers(List<Member> members) { this.members = members; }

	}
}

