package com.roytuts.spring.mvc.jdbc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.roytuts.spring.mvc.jdbc.model.UserDetail;
import com.roytuts.spring.mvc.jdbc.service.UserDetailService;

@Controller
@RequestMapping("/")
public class UserDetailController {

	@Autowired
	private UserDetailService userDetailService;

	@RequestMapping(value = "user/{id}", method = RequestMethod.GET)
	public String getUserDetail(@PathVariable int id, ModelMap userModel) {
		userModel.addAttribute("userDetail", userDetailService.getUserDetail(id));
		return "user";
	}

	@RequestMapping(value = "users", method = RequestMethod.GET)
	public String getUsersDetails(Model model) {
		model.addAttribute("userDetail", userDetailService.getAllUserDetail());
		return "users";
	}

	@RequestMapping(value = "addUser")
	public String addPage(Model model) {

		model.addAttribute("userModel", new UserDetail());

		return "add";
	}

	@RequestMapping("/add")
	public String addUser(@Valid @ModelAttribute("userModel") UserDetail userDetail, BindingResult br, Model model,
			HttpServletRequest request) {

		System.out.println(br.hasErrors());
		if (br.hasErrors()) {
			return "add";
		} else {
			int resp = userDetailService.addUserDetail(userDetail);

			model.addAttribute("msg", "User with id : " + resp + " added successfully.");

			model.addAttribute("userDetail", userDetailService.getAllUserDetail());
			return "users";

		}
	}

	/*
	 * @RequestMapping(value = "add/user", method = RequestMethod.POST) public
	 * String addUser(@Valid @RequestParam(value = "fname", required = true) String
	 * fname,
	 * 
	 * @Valid @RequestParam(value = "lname", required = true) String lname,
	 * 
	 * @Valid @RequestParam(value = "email", required = true) String email,
	 * 
	 * @Valid @RequestParam(value = "dob", required = true) String dob, ModelMap
	 * userModel, BindingResult result) {
	 * 
	 * if (result.hasErrors()) { userModel.addAttribute("msg",
	 * "User addition failed."); return "add";
	 * 
	 * } else {
	 * 
	 * UserDetail userDetail = new UserDetail(); userDetail.setFirstName(fname);
	 * userDetail.setLastName(lname); userDetail.setEmail(email);
	 * userDetail.setDob(dob); int resp =
	 * userDetailService.addUserDetail(userDetail);
	 * 
	 * userModel.addAttribute("msg", "User with id : " + resp +
	 * " added successfully."); userModel.addAttribute("userDetail",
	 * userDetailService.getAllUserDetail()); return "users";
	 * 
	 * }
	 * 
	 * }
	 */
	@RequestMapping(value = "delete/user/{id}", method = RequestMethod.GET)
	public String deleteUser(@PathVariable("id") int id, ModelMap userModel) {
		int resp = userDetailService.deleteUserDetail(id);
		userModel.addAttribute("userDetail", userDetailService.getAllUserDetail());
		if (resp > 0) {
			userModel.addAttribute("msg", "User with id : " + id + " deleted successfully.");
		} else {
			userModel.addAttribute("msg", "User with id : " + id + " deletion failed.");
		}
		return "users";
	}

	@RequestMapping(value = "update/{id}", method = RequestMethod.GET)
	public String updatePage(@PathVariable("id") int id, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("userModel", userDetailService.getUserDetail(id));
		return "update";
	}

	@RequestMapping(value = "/update/update" ,method = RequestMethod.POST )
	public String updateUser(/* @RequestParam int id, */ @Valid @ModelAttribute("userModel") UserDetail userDetail,
			BindingResult br, Model model, HttpServletRequest request) {

		System.out.println(br.hasErrors());
		if (br.hasErrors()) {
			return "update";
		} else {
			int resp = userDetailService.updateUserDetail(userDetail);
			model.addAttribute("id", userDetail.getId());
			model.addAttribute("msg", "User with id : " + userDetail.getId() + " updated successfully.");
			model.addAttribute("userDetail", userDetailService.getAllUserDetail());
			return "users";

		}
	}

	/*
	 * @RequestMapping(value = "update/user", method = RequestMethod.POST) public
	 * String updateUser(@RequestParam int id, @NotBlank @RequestParam(value =
	 * "fname", required = true) String fname,
	 * 
	 * @NotBlank @RequestParam(value = "lname", required = true) String lname,
	 * 
	 * @Valid @RequestParam("email") String email, @Valid @RequestParam("dob")
	 * String dob, ModelMap userModel) { UserDetail userDetail = new UserDetail();
	 * userDetail.setId(id); userDetail.setFirstName(fname);
	 * userDetail.setLastName(lname); userDetail.setEmail(email);
	 * userDetail.setDob(dob); int resp =
	 * userDetailService.updateUserDetail(userDetail); userModel.addAttribute("id",
	 * id); if (resp > 0) { userModel.addAttribute("msg", "User with id : " + id +
	 * " updated successfully."); userModel.addAttribute("userDetail",
	 * userDetailService.getAllUserDetail()); return "users"; } else {
	 * userModel.addAttribute("msg", "User with id : " + id + " updation failed.");
	 * userModel.addAttribute("userDetail", userDetailService.getUserDetail(id));
	 * return "update"; } }
	 */
}
