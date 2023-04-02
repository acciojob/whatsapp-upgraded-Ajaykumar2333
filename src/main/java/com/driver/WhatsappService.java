package com.driver;

import java.util.HashMap;
import java.util.List;

public class WhatsappService {

    WhatsappRepository whatsappRepository = new WhatsappRepository();


    public String createUser(String name, String mobile) throws Exception {
        return whatsappRepository.createUser(name,mobile);

    }

    public Group createGroup(List<User> users) {

        return whatsappRepository.createGroup(users);
    }
}
