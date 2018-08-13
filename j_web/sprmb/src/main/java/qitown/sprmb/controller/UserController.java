package qitown.sprmb.controller;

 

import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import qitown.sprmb.pojo.User;
import qitown.sprmb.service.UserService;

/**
 * 
 *  http://localhost:8080/sprmb/user/addUser
 *  http://localhost:8080/sprmb/user/list
 * @author alvin
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private static final Logger LOGGER = Logger  
            .getLogger(UserController.class);  
    
	@Autowired
	UserService userService;
	@RequestMapping("/list")
	public String UserList(Model model) {
		
		List<User> list =userService.findAll();
		model.addAttribute("list",list);
		return  "itemsList";
	}
	@RequestMapping("/edit")
	public String Edit(Integer iduser,Model model)
	{
		User user=userService.findById(iduser);
		model.addAttribute("item",user);
		return "editItem";
	}
	@RequestMapping(value ="/saveOrUpdate",method = RequestMethod.POST)
	public String saveOrUpdate(User user)
	{
		
		userService.update(user);
		return "redirect:list";
	}
	@RequestMapping("/deleteByID")
	public String deleteByID(Integer iduser)
	{
		
		userService.deleteById(iduser);
		return "redirect:list";
	}
	//�����ӵ���Ӧ��ҳ��
	@RequestMapping("/add")
	public String Add()
	{
		LOGGER.info("qitown AddUser user " );  
		return "AddUser";
	}
	//
	@RequestMapping("/addUser")
	public String Insert(User user)
	{
		userService.insert(user);
		return "redirect:list";
	}
}
