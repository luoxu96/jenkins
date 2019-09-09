package com.example.study.controller;

        import com.example.study.entity.User;
        import com.example.study.service.UserService;
        import com.example.study.util.Result;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;
        import org.springframework.web.bind.annotation.ResponseBody;

        import javax.servlet.http.Cookie;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;

//controller注解，让springBoot框架知道这个类是控制层
@Controller
public class LoginController {
    @Autowired
    public UserService userService;

    /**
     * 跳转到注册页面
     */
    @RequestMapping(value="/RegisterHtml",method = RequestMethod.GET)
    public String registerHtml(){
        return "Register";
    }

    /**
     * 跳转到登录页面
     * @requestMapping注解，设置用户访问地址
     */
    @RequestMapping(value = "/LoginHtml",method = RequestMethod.GET)
    public String LoginHtml(){
        return "Login";
    }

    /**
     * 跳转到登录成功页面
     * @requestMapping注解，设置用户访问地址
     */
    @RequestMapping(value = "/LoginSuccess",method = RequestMethod.GET)
    public String LoginSuccess(HttpServletRequest request, HttpServletResponse response, Model model){
        User userInfo=userService.queryUserByName(request.getParameter("name"));
        model.addAttribute("userInfo",userInfo);
        return "LoginSuccess";
    }

    /**
     * 登录方法
     */
    @RequestMapping(value = "/LoginInfo",method = RequestMethod.POST)
    @ResponseBody
    public Result LoginInfo(HttpServletRequest request,HttpServletResponse response, User user){
        Result result=new Result();
        //判断该用户是否存在
        User userInfo=userService.queryUserByName(user.getName());
        if(userInfo==null){
            result.setStatus(300);
            result.setErroMsg("登录失败，没有该用户，请注册！");
        }else{
            if(user.getName().equals(userInfo.getName())&&user.getPassword().equals(userInfo.getPassword())){
                Cookie cookie  =  new Cookie("name",user.getName());
                response.addCookie(cookie);
                result.setStatus(200);
                result.setMsg("登录成功");
            }else {
                result.setStatus(300);
                result.setErroMsg("密码错误！");
            }
        }
        return result;
    }

    /**
     * 注册方法
     * @param user
     */
    @RequestMapping(value = "/RegisterInfo",method = RequestMethod.POST)
    @ResponseBody
    public Result registerInfo(User user){
        Result result=new Result();
        //判断该用户名是否已经注册了
        User user1=userService.queryUserByName(user.getName());
        if(user1==null){
            //将用户信息插入到数据库
            int count=userService.insertUser(user);
            //判断是否插入成功
            if(count>0){
                result.setStatus(200);
                result.setMsg("注册成功");
            }else {
                result.setStatus(300);
                result.setMsg("注册失败");
            }
        }else {
            result.setStatus(300);
            result.setMsg("用户名已被注册");
        }
        return result;
    }


    /**
     * 跳转到Jquery.Vaildata页面
     */
    @RequestMapping(value = "/Vaildata",method = RequestMethod.GET)
    public String Vaildata(){
        return "JjqueryValidata";
    }
}
