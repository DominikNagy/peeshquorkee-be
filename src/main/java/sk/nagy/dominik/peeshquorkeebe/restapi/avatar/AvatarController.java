package sk.nagy.dominik.peeshquorkeebe.restapi.avatar;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AvatarController {

    @CrossOrigin(originPatterns = "*")
    @GetMapping(path = "/avatarGallery")
    public AvatarGallery ImageController() {

        return new AvatarGallery();
    }
}
