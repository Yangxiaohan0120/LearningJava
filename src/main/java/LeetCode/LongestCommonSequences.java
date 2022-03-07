package LeetCode;

/**
 * @ author: yxh
 * @ created: 2022-02-15 : 10:34 AM
 */
public class LongestCommonSequences {

    // LCS 问题
    // 在S1 和 S2 中找到两个字符串的公共子序列的长度
    // 状态：LCS(m,n) S1[0...m] 和 S2[0...n] 的最长公共子序列的长度
    // 状态转移：   S1[m] == S2[n]:  LCS(m,n) = 1 + LCS(m-1,n-1)
    //            S1[m] != S2[n]:  LCS(m,n) = max{LCS(m-1,n),LCS(m,n-1)}
    public LongestCommonSequences() {

    }

}