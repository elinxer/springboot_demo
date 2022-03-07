package com.example.demo_assembly.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;


/**
 * @author elinx
 */
@RestController
public class VideoController {

    @GetMapping("playlist")
    public void playlist(HttpServletResponse response) {
        try {

            response.setContentType("application/json;charset=utf-8");
            ServletOutputStream out;

            String result = "xxxxxxxxxxxx22222222222";

            out = response.getOutputStream();
            byte[] data = result.getBytes();
            out.write(data);
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
