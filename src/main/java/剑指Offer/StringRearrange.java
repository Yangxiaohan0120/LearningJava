package 剑指Offer;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Chris Yang
 * created 2022-07-28 16:46
 **/
public class StringRearrange {
    HashSet<String> set = new HashSet<>();

    boolean[] visited;

    public String[] permutation(String s) {
        visited = new boolean[s.length()];
        char[] c = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            dfs(s, i, 0, c);
        }
        String[] res = set.toArray(new String[set.size()]);
        return res;
    }

    public void dfs(String s, int cur, int index, char[] c) {
        visited[cur] = true;
        c[index] = s.charAt(cur);
        if(index == s.length()-1){
            set.add(String.valueOf(c));
            visited[cur] = false;
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (!visited[i]) {
                dfs(s, i,index + 1,c);
            }

        }
        visited[cur] = false;
    }

    public static void main(String[] args) {
        String s = "abcd";
        String[] res = new StringRearrange().permutation(s);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
