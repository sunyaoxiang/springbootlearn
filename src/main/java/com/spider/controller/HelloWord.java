package com.spider.controller;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.util.UriComponents;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URI;
import java.util.Random;

/**
 * Created by yaoxiang.sun on 2018/5/3.
 */
//@RestController
//@RequestMapping("/h")
//@SessionAttributes("helloClass")
public class HelloWord {
    @RequestMapping("/h")
    public String sayHello(RedirectAttributes attr) {
        return "Hello,World!";
    }


    @RequestMapping("/booking")
    public void getBooking(HttpServletResponse response) throws IOException {
        UriComponents uriComponents = MvcUriComponentsBuilder
                .fromMethodName(BookingController.class, "getBooking", 21).buildAndExpand(42);

        URI uri = uriComponents.encode().toUri();
        response.sendRedirect(uri.toString());
    }


    @RequestMapping("/{tickerSymbol}")
    public void getBondSpiderAnnoInfo(HttpServletResponse response, @PathVariable("tickerSymbol") String tickerSymbol) throws IOException {
        response.sendRedirect(String.format("/api/v1/%s/all", tickerSymbol));
    }

    @RequestMapping(value = "/d", method = RequestMethod.GET)
    public void getSayhello(HttpServletResponse response, Model model, RedirectAttributes attr) throws IOException {
        attr.addAttribute("attributeName", "attributeValue");
        model.addAttribute("book", "abook");
        model.addAttribute("description", "擦擦擦擦擦擦擦车" + new Random().nextInt(100));
        model.addAttribute("price", new Double("1000.00"));
        model.addAttribute("attributeName1", "attributeValue1");
        response.sendRedirect("/h/h");
    }

    @RequestMapping(value = "postPayAmount", method = RequestMethod.GET)
    public RedirectView postPayAmount(HttpSession session, ModelMap map) {
        return new RedirectView("/h/h", true, false, true);//最后的参数为false代表以post方式提交请求
    }

    @RequestMapping(value = "postPayAmountext", method = RequestMethod.GET)
    public ModelAndView postPayAmountext(HttpSession session, ModelMap map) {
        return new ModelAndView(new RedirectView("/h/h"), map);
    }

    @RequestMapping("/{getId}/m/{putId}")
    public String printMap(@PathVariable String getId, @PathVariable String putId) {
        return "Hello,World! " + getId + ": " + putId;
    }

    @RequestMapping(path = "/p", method = RequestMethod.GET)
    public String printParma(@RequestParam("het") int het,
                             @RequestParam(name = "get", required = false, defaultValue = "9") int get) {
        return "Hello,World! " + het;
    }

//    @RequestMapping("/d")
//    public void displayHeaderInfo(@CookieValue("JSESSIONID") String cookie) {
//
//    }
}
