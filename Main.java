import EncodeAndDecodeString1980.EncodeAndDecodeString;

import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        var a = new EncodeAndDecodeString();

        List<String> list = new ArrayList<String>();
        list.add("we");
        list.add("say");
        list.add(":");
        list.add("yes");
        list.add("/");
        list.add("\"!@#$%^&*()\"");

        var encoded = a.encode(list);
        System.out.println(encoded);

        System.out.println(a.decode(encoded));
    }

}
