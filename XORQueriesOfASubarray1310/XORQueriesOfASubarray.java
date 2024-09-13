package XORQueriesOfASubarray1310;

public class XORQueriesOfASubarray {
    public int[] xorQueries(int[] arr, int[][] queries) {
        var xor = new int[arr.length];
        for (var i = 0; i < xor.length; i++) {
            xor[i] = (i == 0 ? 0 : xor[i - 1]) ^ arr[i];
        }
        var answer = new int[queries.length];
        for (var i = 0; i < queries.length; i++) {
            var query = queries[i];
            var rs = query[0] == 0 ? 0 : xor[query[0] - 1];
            answer[i] = rs ^ xor[query[1]];
        }
        return answer;
    }
}
