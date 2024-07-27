package EncodeAndDecodeString1980;

import java.util.List;
import java.util.ArrayList;

// Medium
public class EncodeAndDecodeString {
    // Encoding logic is
    // <length><delimeter><value>
    // For example, [hello ,world] -> 5|hello5|world
    public String encode(List<String> strs) {
        if (strs.size() == 0) {
            return "";
        }
        var result = new StringBuilder();

        for (var i = 0; i < strs.size(); i++) {
            var str = strs.get(i);
            result.append(String.format("%s%s%s", str.length(), "|", str));
        }

        return result.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<String>();
        if (str == "") {
            return result;
        }
        var currentIndex = 0;
        while (currentIndex <= (str.length() - 1)) {
            var delimiterIndex = str.indexOf("|", currentIndex);
            var length = Integer.parseInt(str.substring(currentIndex, delimiterIndex));
            currentIndex = delimiterIndex + 1;
            result.add(str.substring(currentIndex, currentIndex + length));
            currentIndex += length;

        }
        return result;
    }
}
