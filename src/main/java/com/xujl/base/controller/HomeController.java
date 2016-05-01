package com.xujl.base.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xujl.base.entity.OrgAccount;
import com.xujl.base.repository.OrgAccountRepository;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

    private static final Logger logger = LoggerFactory
            .getLogger(HomeController.class);
    @Inject
    OrgAccountRepository orgAccountDao;
    
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        logger.info("Welcome home! the client locale is " + locale.toString());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
                DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);

        model.addAttribute("serverTime", formattedDate);
        OrgAccount oa= new OrgAccount();
        oa.setRegId("123465789");
        orgAccountDao.save(oa);
        return "home";
    }
///denied
    @RequestMapping(value = "/denied", method = RequestMethod.GET)
    public String denied() {
        logger.info("the denied  is " );

       
        return "denied";
    }
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        logger.info("Welcome home! the client locale is " );

       
        return "login";
    }
}
