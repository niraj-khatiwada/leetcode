package CheckIfArrayPairsAreDivisibleByK1497;

import java.util.*;

public class CheckIfArrayPairsAreDivisibleByK {
    private static long OFFSET = (long) 1e9;
    private static long COLS = OFFSET * 2;

    public boolean canArrange(int[] arr, int k) {
        var max = Integer.MIN_VALUE;
        var map = new HashMap<Integer, Set<Integer>>();
        var main = new HashSet<Integer>();
        for (var i = 0; i < arr.length; i++) {
            var s = map.get(arr[i]);
            if (s == null) {
                s = new HashSet<Integer>();
                map.put(arr[i], s);
            }
            s.add(i);
            max = Math.max(max, arr[i]);
            main.add(arr[i]);
        }
        var pairs = new HashSet<Long>();
        var pairsMap = new LinkedHashMap<Integer, Set<Long>>();
        for (var i = 0; i < arr.length; i++) {
            var negativeVal = map.get(-1 * arr[i]);
            if (negativeVal != null && (negativeVal.contains(i) ? (negativeVal.size() > 1) : true)) {
                var flat = this._flat(-1 * arr[i], arr[i]);
                if (!pairs.contains(flat)) {
                    pairs.add(flat);
                    var pairSet = pairsMap.get(arr[i]);
                    if (pairSet == null) {
                        pairSet = new HashSet<Long>();
                        pairsMap.put(arr[i], pairSet);
                    }
                    pairSet.add(flat);
                }
            }
            var p = 1;
            var quo = (k * p) - arr[i];
            while (quo <= max) {
                var val = map.get(quo);
                if (val != null && (val.contains(i) ? (val.size() > 1) : true)) {
                    var flat = this._flat(quo, arr[i]);
                    if (!pairs.contains(flat)) {
                        pairs.add(flat);
                        var pairSet = pairsMap.get(arr[i]);
                        if (pairSet == null) {
                            pairSet = new HashSet<Long>();
                            pairsMap.put(arr[i], pairSet);
                        }
                        pairSet.add(flat);
                    }
                }
                p++;
                quo = (k * p) - arr[i];
            }
        }
        var set = new HashSet<Integer>();
        for (var pair : pairs) {
            var unflat = this._unflat(pair);
            set.add(unflat[0]);
            set.add(unflat[1]);
        }
        System.out.println(set);
        System.out.println(main);

        for (var entry : pairsMap.entrySet()) {
            System.out.println(entry.getKey());
            for (var item : entry.getValue()) {
                System.out.printf(">>> %s", Arrays.toString(this._unflat(item)));
            }
            System.out.println();
        }
        return false;
    }

    private long _flat(int i, int j) {
        long row = i;
        long col = j;
        return (row + OFFSET) * COLS + (col + OFFSET);
    }

    private int[] _unflat(long f) {
        long iy = f % COLS;
        long ix = (f - iy) / COLS;
        long x = (int) (ix - OFFSET);
        long y = (int) (iy - OFFSET);
        return new int[] { (int) x, (int) y };
    }

}