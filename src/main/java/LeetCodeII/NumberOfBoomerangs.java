package LeetCodeII;

import java.util.HashMap;

/**
 * @ author: yxh
 * @ created: 2022-02-16 : 8:39 PM
 */
public class NumberOfBoomerangs {

    // 平面上的n个点，寻找存在多少个由这些点构成的三元组，满足i,j 之间的距离等于i,k 之间的距离，n最多为500，坐标范围在[-10000,10000]之间。
    // 如： [0,0],[1,0],[2,0] 结果为2
    // 两个结果为[[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
    public int NumberOfBoomerangs(int[][] points) {
        int res = 0;

        for (int i = 0; i < points.length; i++) {
            HashMap<Integer, Integer> disMap = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (j != i) {
                    int dis = getDis2(points[i][0], points[j][0], points[i][1], points[i][1]);
                    if (disMap.containsKey(dis)) {
                        disMap.put(dis, 1);
                    } else {
                        disMap.put(dis, disMap.get(dis) + 1);
                    }
                }
            }

            for (int dis : disMap.keySet()) {
                if (dis > 1) {
                    res += disMap.get(dis) * (disMap.get(dis) - 1);
                }
            }
        }

        return res;
    }

    private int getDis2(int x1, int x2, int y1, int y2) {
        return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
    }

}