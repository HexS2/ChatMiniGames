package fr.h3x.rdm;

import java.security.SecureRandom;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Message {

    private String randomString;

    public Message(int length, String letters) {
        this.randomString = createRandomCode(length,letters);
    }


    public String getRandomString() {
        return randomString;
    }


    private String createRandomCode(int codeLength, String id) {
        List<Character> temp = id.chars()
                .mapToObj(i -> (char)i)
                .collect(Collectors.toList());
        Collections.shuffle(temp, new SecureRandom());
        return temp.stream()
                .map(Object::toString)
                .limit(codeLength)
                .collect(Collectors.joining());
    }
}
