package Alibrary.Tree;

/**
 * @ author: yxh
 * @ created: 2022-01-04 : 9:42 PM
 */

// 路径压缩，将较深的树进行压缩变浅 Path  Compression 变为只有根节点和叶子节点的树
public class UnionFind6 implements UF{

    private int[] parent;
    private int[] rank;

    public UnionFind6(int size) {
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

//        while(p != parent[p]){
//            // 将父亲的父亲作为自己的新父亲，爷爷变爸爸
//            parent[p] = parent[parent[p]];
//            p = parent[p];
//        }

        if(p != parent[p])
            parent[p] = find(parent[p]);
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
        // rank 只作为比较并不代表height或者depth
        if(rank[pRoot] < rank[qRoot]){
            parent[pRoot] = qRoot;
        }else if(rank[qRoot] < rank[pRoot]){
            parent[qRoot] = pRoot;
        }else {
            parent[pRoot] = qRoot;
            // 统一前面为后面的孩子
            rank[pRoot] += 1;
        }
    }
}