package Alibrary.Tree;

import java.util.Random;

/**
 * @ author: yxh
 * @ created: 2022-01-20 : 2:18 PM
 */
public class testUF {

    private static double test(UF uf, int m ){

        int size = uf.getSize();
        Random random = new Random();

        long startTime = System.nanoTime();

        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.unionElements(a,b);
        }

        long endTime = System.nanoTime();

        return (endTime - startTime)/ 1000000000.0;
    }

    public static void main(String[] args) {
        int size = 100000;
        int m = 100000;

        UnionFind1 uf1 = new UnionFind1(size);
        System.out.println("UnionFind1:" + test(uf1,m) + " s");

        UnionFind2 uf2 = new UnionFind2(size);
        System.out.println("UnionFind2:" + test(uf2,m) + " s");

        UnionFind3 uf3 = new UnionFind3(size);
        System.out.println("UnionFind3:" + test(uf3,m) + " s");
    }
}