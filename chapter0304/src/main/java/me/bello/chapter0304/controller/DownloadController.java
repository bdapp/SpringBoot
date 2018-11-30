package me.bello.chapter0304.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.net.URLEncoder;

@Controller
public class DownloadController {

    @RequestMapping("/download")
    public ResponseEntity<byte[]> download(HttpServletRequest request,
                                           @RequestParam("filename") String filename,
                                           @RequestHeader("User-Agent") String userAgent,
                                           Model model) throws Exception {
        String path = request.getServletContext().getRealPath("/upload/");
        File file = new File(path + File.separator + filename);
        ResponseEntity.BodyBuilder bodyBuilder =ResponseEntity.ok();
        bodyBuilder.contentLength(file.length());
        bodyBuilder.contentType(MediaType.APPLICATION_OCTET_STREAM);
        filename = URLEncoder.encode(filename, "UTF-8");
        if (userAgent.indexOf("MSIE")>0){
            bodyBuilder.header("Content-Disposition", "attachment; filename="+filename);
        } else {
            bodyBuilder.header("Content-Disposition", "attachment; filename*=UTF-8''"+filename);
        }

        return bodyBuilder.body(FileUtils.readFileToByteArray(file));
    }

}
