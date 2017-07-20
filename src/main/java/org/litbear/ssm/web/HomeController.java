package org.litbear.ssm.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.litbear.ssm.pojo.User;
import org.litbear.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by litbear on 2017/6/29.
 */
@Controller
@RequestMapping(value = {"/", "/users"})
public class HomeController {

    private static final Log LOGGER = LogFactory.getLog(HomeController.class);

    @Autowired
    private UserService userService;

    /**
     * 显示列表
     *
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("userList", userService.getAllUsers());
        return "index";
    }

    /**
     * 以传统POST方式提交表单
     *
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() {
        return "add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public User addUserByForm(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            for (ObjectError resultItem : result.getAllErrors()) {
                LOGGER.info(resultItem.toString());
            }
        }
        LOGGER.info(user);
        userService.insertUser(user);
        return user;
    }

    /**
     * 处理新增用户请求
     *
     * @param user
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<User> addUser(@RequestBody User user) {
        LOGGER.info(user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    /**
     * 显示用户列表 json/xml
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/json", method = RequestMethod.GET)
    @ResponseBody
    public List<User> userList(Model model) {
        return userService.getAllUsers();
    }
}
