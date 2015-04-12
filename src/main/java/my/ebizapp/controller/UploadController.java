package my.ebizapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by Vance on 4/12/2015.
 */
@Controller
public class UploadController {
    @Autowired
    private Environment env;

    @RequestMapping(value = "/uploadImg", method = RequestMethod.POST)
    @ResponseBody
    String uploadImg(@RequestParam MultipartFile file) {
        try {
            BufferedImage in = ImageIO.read(file.getInputStream());
            File output = new File("external/image/avatar-" + UUID.randomUUID() + ".png");
            boolean png = ImageIO.write(in, "png", output);
            return output.getName();
        } catch (IOException e) {
            throw new BadRequestException("invalidUpload");
        }
    }
}
