package controller;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import day5.jdbc.dto.*;

@Controller
@SessionAttributes({"userInfo"})
public class UsersController {
   private static Logger logger = LoggerFactory.getLogger(UsersController.class);
   @InitBinder
   public void bindData(WebDataBinder binder) {
      logger.trace("bindData 호출됨");
      SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd (E)");
      binder.registerCustomEditor(Date.class, "birthDate", 
            new CustomDateEditor(format, true));
      DecimalFormat df = new DecimalFormat("$##,###");
      binder.registerCustomEditor(Long.class, "salary",
            new CustomNumberEditor(Long.class, df, true));
   }
   
   @InitBinder
   public void checkEssentialField(WebDataBinder binder){
      binder.setRequiredFields("name","pass","email");
   }
   
   @ModelAttribute
   public void initMenu(Model model){
	   Map<String, String> majoroption = new HashMap<>();
       majoroption.put("civil", "토목공학");
       majoroption.put("computer", "컴퓨터공학");
       majoroption.put("elec", "전기공학");
       model.addAttribute("majoroption", majoroption);

       Map<String, String> genderOption = new HashMap<>();
       genderOption.put("male", "남성");
       genderOption.put("female", "여성");
       model.addAttribute("genderOption", genderOption);

       List<Role> roleOptions = new ArrayList<>();
       roleOptions.add(new Role("DB 관리", "dbadmin"));
       roleOptions.add(new Role("버전 관리", "committer"));
       roleOptions.add(new Role("뷰 관리", "clientadmin"));
       model.addAttribute("roleOptions", roleOptions);
   }
   
   @ModelAttribute
   public Users setDefaultUserInfo(Model model){
	   Users info = new Users();
	   info.setId("hong123");
	   info.setPass("1234");
	   info.setNickname("hong");
	   info.setEmail("honggil@naver.com");
	   return info;
   }

   @RequestMapping(value = "/user", method = RequestMethod.POST)
   public String confirmUserData(Model model, UserInfo userInfo) {
      logger.trace("userINfo : {}", userInfo);
      return "confirmuserInfo";
   }
   
   @RequestMapping(value = "/user_error", method = RequestMethod.POST)
   public String errorHandling(Model model, UserInfo userInfo, BindingResult result,RedirectAttributes redir/*, HttpSession session*/) {
      if(result.hasErrors()){
         return "userform_error";
      }  
      //redir.addFlashAttribute(userInfo);
      //session.setAttribute("userInfo", userInfo);
      return "redirect:confirmuserInfo";//새로운 request 생성
   }
   @RequestMapping(value = "/confirmuserInfo", method = RequestMethod.GET)
   public String showUserInfo(Model model) {
      return "confirmuserInfo";
   }
   @RequestMapping(value = "/user", method = RequestMethod.GET)
   public String getUserForm(Model model) {
      return "userform";
   }

   @RequestMapping(value = "/user_select", method = RequestMethod.GET)
   public String getUserFormSelect(Model model) {
      return "userform_select";
   }

   @RequestMapping(value = "/userformat", method = RequestMethod.GET)
   public String getUserFormFormat(Model model) {
      return "userformat";
   }

   @RequestMapping(value = "/user_error", method = RequestMethod.GET)
   public String getUserFormError(Model model) {
      return "userform_error";
   }
}