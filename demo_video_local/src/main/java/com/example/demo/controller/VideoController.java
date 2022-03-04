package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Objects;


/**
 * @author elinx
 */
@RestController
public class VideoController {

    public static ArrayList<String> getFiles(String path) {
        ArrayList<String> files = new ArrayList<String>();
        File file = new File(path);
        File[] tempList = file.listFiles();

        for (int i = 0; i < Objects.requireNonNull(tempList).length; i++) {
            if (tempList[i].isFile()) {
                files.add(tempList[i].toString());
            }
            if (tempList[i].isDirectory()) {
                System.out.println("文件夹：" + tempList[i]);
            }
        }
        return files;
    }

    @GetMapping("playlist")
    public void playlist(HttpServletResponse response) {
        try {

            ArrayList<String> list = getFiles("D:\\");

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


    @GetMapping("play/{name}")
    public void play(HttpServletRequest request, HttpServletResponse response, @PathVariable String name) throws IOException {

        String filename = "D:\\videos\\" + name;
        playVideo(request, response, filename);
    }

    public void playVideo(HttpServletRequest request, HttpServletResponse response, String filename) throws IOException {
        response.reset();

        System.out.println("准备播放文件地址：" + filename);

        File file = new File(filename);
        long fileLength = file.length();
        // 随机读文件
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");

        //获取从那个字节开始读取文件
        String rangeString = request.getHeader("Range");
        long range = 0;
        if (rangeString != null && !"".equals(rangeString)) {
            range = Long.parseLong(rangeString.substring(rangeString.indexOf("=") + 1, rangeString.indexOf("-")));
        }
        //获取响应的输出流
        OutputStream outputStream = response.getOutputStream();
        //设置内容类型
        response.setHeader("Content-Type", "video/mp4");
        //返回码需要为206，代表只处理了部分请求，响应了部分数据
        response.setStatus(HttpServletResponse.SC_PARTIAL_CONTENT);

        // 移动访问指针到指定位置
        randomAccessFile.seek(range);

        // 每次请求只返回1MB的视频流
        byte[] bytes = new byte[1024 * 1024 * 10];
        int len = randomAccessFile.read(bytes);

        //设置此次相应返回的数据长度
        response.setContentLength(len);
        //设置此次相应返回的数据范围
        response.setHeader("Content-Range", "bytes " + range + "-" + (fileLength - 1) + "/" + fileLength);
        // 将这1MB的视频流响应给客户端
        outputStream.write(bytes, 0, len);
        outputStream.close();
        randomAccessFile.close();
        System.out.println("返回数据区间:【" + range + "-" + (range + len) + "】");
    }

}
