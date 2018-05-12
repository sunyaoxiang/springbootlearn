package com.spider.service;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * Created by yaoxiang.sun on 2018/5/9.
 */
public class UrlBuild {

    public void makeUrl() {
        UriComponents uriComponents = UriComponentsBuilder.fromUriString(
                "http://myhost.com/{}").build();
        URI uri = uriComponents.expand("41").encode().toUri();
    }

    public void makeUrlt() {
        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .scheme("http")
                .host("myhost.com")
                .path("/{}")
                .build()
                .expand("41")
                .encode();
    }

//    public void useServletUriComponentsBuilder(HttpServletRequest request) {
//        ServletUriComponentsBuilder ucb = ServletUriComponentsBuilder.fromRequest(request)
//                .replaceQueryParam("accountId", "{id}").build()
//                .expand("123")
//                .encode();
//
//        ServletUriComponentsBuilder ucb = ServletUriComponentsBuilder.fromContextPath(request)
//                .path("/accounts").build();
//
//        ServletUriComponentsBuilder ucb = ServletUriComponentsBuilder.fromServletMapping(request)
//                .path("/accounts").build();
//    }
}
