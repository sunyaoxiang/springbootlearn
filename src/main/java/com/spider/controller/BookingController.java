package com.spider.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yaoxiang.sun on 2018/5/9.
 */
@Controller
@RequestMapping("/hotels/{hotel}")
public class BookingController {

    @RequestMapping("/bookings/{booking}")
    public String getBooking(@PathVariable("booking") Long booking) {

//        UriComponents uriComponents = MvcUriComponentsBuilder
//                .fromMethodName(BookingController.class, "getBooking", 21).buildAndExpand(42);
//
//        URI uri = uriComponents.encode().toUri();

        return booking.toString();
    }
}
