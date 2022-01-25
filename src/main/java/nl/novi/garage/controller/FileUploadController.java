package nl.novi.garage.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class FileUploadController {

    @Value("${app.uploads}")
    private String storageLocation;

    @RequestMapping(value = "/file-upload", method = RequestMethod.POST)
    @ResponseBody
    public String uploadFile(@RequestParam("file") MultipartFile multipartFile) throws IOException {

        multipartFile.transferTo(new File(storageLocation + multipartFile.getOriginalFilename()));
        return "File successfully uploaded!";
    }

}
