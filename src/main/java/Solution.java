import java.util.Arrays;

class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        char[][] res = new char[n][m];
        for(int i = 0; i < n; i++) {
            Arrays.fill(res[i], '.');
        }
        int[] minLevel = new int[m];
        Arrays.fill(minLevel, n - 1);
        for(int j = n - 1; j >= 0; j--){
            for(int i = m - 1; i >= 0; i--) {
                char ogBoxPos = box[i][j];
                if(ogBoxPos == '*') {
                    res[j][m - 1 - i] = '*';
                    minLevel[m - 1 - i] = j - 1;
                }else if(ogBoxPos == '#') {
                    int insertLevel = minLevel[m - 1 - i];
                    res[insertLevel][m - 1 - i] = '#';
                    minLevel[m - 1 - i]--;
                }
            }
        }
            
        return res;
    }
}