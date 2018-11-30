package me.bello.chapter0304.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@Controller
public class UploadController {

    @RequestMapping("/upload")
    public String main() {
        return "upload";
    }



    @PostMapping("/uploadFile")
    @ResponseBody
    public String uploadFile(HttpServletRequest request,
                             @RequestParam("description") String desc,
                             @RequestParam("file") MultipartFile file
    ) throws Exception {

        System.out.println(desc);

        if (file.isEmpty()) {
            return "error";
        }

        String path = request.getServletContext().getRealPath("/upload/");
        System.out.println("path: "+path);

        String fileName = file.getOriginalFilename();

        File filePath = new File(path, fileName);
        if (!filePath.getParentFile().exists()){
            filePath.getParentFile().mkdir();
        }
        file.transferTo(new File(path+File.separator+fileName));
        return "success";

    }
}
