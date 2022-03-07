package LeetCode;

import java.util.HashMap;

/**
 * @ author: yxh
 * @ created: 2022-02-10 : 11:06 AM
 */
public class NumberOfBoomerangs {

    // 平面上的n个点，寻找存在多少个由这些点构成的三元组，满足i,j 之间的距离等于i,k 之间的距离，n最多为500，坐标范围在[-10000,10000]之间。
    // 如： [0,0],[1,0],[2,0] 结果为2
    // 两个结果为[[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
    public int NumberOfBoomerangs(int[][] points) {
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            HashMap<Integer, Integer> disCountMap = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (j != i) {
                    int dis2 = Dis(points[i][0], points[i][1], points[j][0], points[j][1]);
                    if (disCountMap.containsKey(dis2)) {
                        disCountMap.put(dis2, disCountMap.get(dis2) + 1);
                    } else {
                        disCountMap.put(dis2, 1);
                    }
                }
            }

            for (int dis : disCountMap.keySet()) {
                if (disCountMap.get(dis) > 1) {
                    res += disCountMap.get(dis) * (disCountMap.get(dis) - 1);
                }
            }
        }

        return res;
    }

    private int Dis(int x1, int y1, int x2, int y2) {
        int dis = (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);
        return dis;
    }
}