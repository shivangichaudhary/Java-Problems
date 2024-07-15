public class BankerAlgorithm {
    public static void main(String[] args) {
        int n = 5; // Number of processes
        int m = 3; // Number of resources
        int[][] alloc = { { 0, 1, 0 }, { 2, 0, 0 }, { 3, 0, 2 }, { 2, 1, 1 }, { 0, 0, 2 } }; // Allocation Matrix
        int[][] max = { { 7, 5, 3 }, { 3, 2, 2 }, { 9, 0, 2 }, { 2, 2, 2 }, { 4, 3, 3 } }; // MAX Matrix
        int[] avail = { 3, 3, 2 }; // Available Resources

        int[] f = new int[n];
        int[] ans = new int[n];
        int ind = 0;
        for (int k = 0; k < n; k++) {
            f[k] = 0;
        }
        int[][] need = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                need[i][j] = max[i][j] - alloc[i][j];
        }
        int y = 0;
        for (int k = 0; k < 5; k++) {
            for (int i = 0; i < n; i++) {
                if (f[i] == 0) {
                    int flag = 0;
                    for (int j = 0; j < m; j++) {
                        if (need[i][j] > avail[j]) {
                            flag = 1;
                            break;
                        }
                    }
                    if (flag == 0) {
                        ans[ind++] = i;
                        for (y = 0; y < m; y++)
                            avail[y] += alloc[i][y];
                        f[i] = 1;
                    }
                }
            }
        }
        int flag1 = 1;
        for (int i = 0; i < n; i++) {
            if (f[i] == 0) {
                flag1 = 0;
                System.out.println("The following system is not safe");
                break;
            }
        }
        if (flag1 == 1) {
            System.out.println("Following is the SAFE Sequence");
            for (int i = 0; i < n - 1; i++)
                System.out.print(" P" + ans[i] + " ->");
            System.out.print(" P" + ans[n - 1]);
        }
    }
}
