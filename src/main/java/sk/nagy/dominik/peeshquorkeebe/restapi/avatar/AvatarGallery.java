package sk.nagy.dominik.peeshquorkeebe.restapi.avatar;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AvatarGallery {
//    String avatar1;
//    String avatar2;
//    String avatar3;
    List<String> avatars = new ArrayList<>();
//    public AvatarGallery() {
//        BufferedReader reader = null;
//        try {
//            reader = new BufferedReader(new FileReader("src/main/java/sk/nagy/dominik/peeshquorkeebe/restapi/avatar/avatars-in-base64"));
//            this.avatar1 = reader.readLine();
//            this.avatar2 = reader.readLine();
//            this.avatar3 = reader.readLine();
//            reader.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }

    public List<String> getAvatars() {
        return avatars;
    }

    public AvatarGallery() {
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader("src/main/java/sk/nagy/dominik/peeshquorkeebe/restapi/avatar/avatars-in-base64"));
            this.avatars.add(reader.readLine());
            this.avatars.add(reader.readLine());
            this.avatars.add(reader.readLine());
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public String getAvatar1() {
//        return avatar1;
//    }
//
//    public String getAvatar2() {
//        return avatar2;
//    }
//
//    public String getAvatar3() {
//        return avatar3;
//    }
}
