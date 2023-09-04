package active;

public class TestClass {

    public int wxmPKUKsnXQSS(String ha, String nee) {
        int n = ha.length();
        int m = nee.length();
        for (int i = 0; i + m <= n; i++) {
            boolean flag = true;
            for (int j = 0; j < m; j++) {
                if (ha.charAt(i + j) != nee.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }

}
