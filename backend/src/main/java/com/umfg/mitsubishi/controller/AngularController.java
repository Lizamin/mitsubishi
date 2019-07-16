package com.umfg.mitsubishi.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

import java.io.IOException;
import java.io.InputStream;

@RestController
public class AngularController {

    @GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
    public byte[] angular() throws IOException {
        InputStream in = getClass()
                .getResourceAsStream("/static/frontend/index.html");
        return IOUtils.toByteArray(in);
    }
}
