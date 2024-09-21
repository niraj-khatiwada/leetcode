package LexicographicalNumbers386;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumber {
    public List<Integer> lexicalOrder(int n) {
        var rs = new ArrayList<Integer>();
        this._lexicalOrder(0, n, rs);
        return rs;
    }

    private void _lexicalOrder(int p, int n, List<Integer> rs) {
        if (p > n) {
            return;
        }
        if (p != 0) {
            rs.add(p);
        }
        for (var i = 0; i < 10; i++) {
            if (p == 0 && i == 0) {
                continue;
            }
            _lexicalOrder(p * 10 + i, n, rs);
        }
    }
}
