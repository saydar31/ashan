package ru.itis.ashan.controllers.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.itis.ashan.services.FileService;

import java.io.File;
import java.util.Optional;

@Controller
public class FilesController {

    @Autowired
    private FileService fileService;

    @GetMapping(produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
    @RequestMapping(value = "/image/{image-id:.+}", method = RequestMethod.GET)
    public @ResponseBody byte[] getFile(@PathVariable("image-id") Long imageId) {
       return fileService.downloadFileById(imageId);
    }
}
