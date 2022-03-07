package DataStructureAndAlgorithm.Tree;

/**
 * @ author: yxh
 * @ created: 2022-01-04 : 9:42 PM
 */
public class UnionFind3 implements UF{

    private int[] parent;
    private int[] sz;

    public UnionFind3(int size) {
        parent = new int[size];
        sz = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
            // 初始化的时候每个元素独立占用一个集合，所以sz为1。
            sz[i] = 1;
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


        // 将元素少的集合合并到元素多的集合上，保证深度h不改变太大 （其实是个数）
        // 基于size的优化
        if(sz[pRoot] < sz[qRoot]){
            parent[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        }else {
            parent[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }

    }

}