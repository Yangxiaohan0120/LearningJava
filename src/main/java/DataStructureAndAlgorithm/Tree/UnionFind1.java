package DataStructureAndAlgorithm.Tree;

/**
 * @ author: yxh
 * @ created: 2022-01-04 : 5:03 PM
 */
public class UnionFind1 implements UF {

    private int[] id;

    public UnionFind1(int size) {
        id = new int[size];

        for (int i = 0; i < size; i++) {
            id[i] = i;
        }
    }

    @Override
    public int getSize() {
        return id.length;
    }

    // 查找元素p所对应的集合编号
    // O(1)复杂度
    private int find(int p) {
        if (p < 0 || p >= id.length)
            throw new IllegalArgumentException("Index is out of range");

        return id[p];
    }

    // 合并元素p和元素q所属的集合
    // O(n) 复杂度
    @Override
    public void unionElements(int p, int q) {
        int pID = find(p);
        int qID = find(q);

        if(pID == qID)
            return;

        // 原本其他不相连的元素也会随着相连
        for (int i = 0; i < id.length; i++) {
            if(id[i] == pID)
                id[i] = qID;
        }
    }

    // 查看元素p和元素q是否所属一个集合
    // O(1)复杂度
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

}