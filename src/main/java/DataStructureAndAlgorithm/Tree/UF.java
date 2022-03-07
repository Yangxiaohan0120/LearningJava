package DataStructureAndAlgorithm.Tree;

/**
 * @ author: yxh
 * @ created: 2022-01-04 : 5:01 PM
 */
public interface UF {

    int getSize();

    boolean isConnected(int p, int q);

    void unionElements(int p, int q);

}
