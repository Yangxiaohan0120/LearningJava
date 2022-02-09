package Alibrary.Tree;

/**
 * @ author: yxh
 * @ created: 2022-01-04 : 9:42 PM
 */

// 基于rank 的优化（深度）
public class UnionFind4 implements UF{

    private int[] parent;
    private int[] rank;

    public UnionFind4(int size) {
        parent = new int[size];
        rank = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
            // 初始化的时候每个元素独立占用一个集合，所以sz为1。
            rank[i] = 1;
        }
    }

    @Override
    public int getSize(){
        return parent.length;
    }

    private int find(int p){
        if(p <0 || p >= parent.length)
            throw new IllegalArgumentException("p is out of bound");

        while(p != parent[p])
            p = parent[p];
        return p;
    }

    @Override
    public boolean isConnected(int p,int q){
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p,int q){
        int pRoot = find(p);
        int qRoot = find(q);

        if(pRoot == qRoot)
            return;


        // 将元素少的集合合并到元素多的集合上,相等时深度加1；
        // 基于size的优化
        if(rank[pRoot] < rank[qRoot]){
            parent[pRoot] = qRoot;
        }else if(rank[qRoot] < rank[pRoot]){
            parent[qRoot] = pRoot;
        }else {
            parent[qRoot] = pRoot;
            rank[pRoot] += 1;
        }
    }
}