package com.alibaba.cainiao.leetcode;

/**
 * 839. 相似字符串组
 * 如果交换字符串 X 中的两个不同位置的字母，使得它和字符串 Y 相等，那么称 X 和 Y 两个字符串相似。如果这两个字符串本身是相等的，那它们也是相似的。
 *
 * 例如，"tars" 和 "rats" 是相似的 (交换 0 与 2 的位置)； "rats" 和 "arts" 也是相似的，但是 "star" 不与 "tars"，"rats"，或 "arts" 相似。
 *
 * 总之，它们通过相似性形成了两个关联组：{"tars", "rats", "arts"} 和 {"star"}。注意，"tars" 和 "arts" 是在同一组中，即使它们并不相似。形式上，对每个组而言，要确定一个单词在组中，只需要这个词和该组中至少一个单词相似。
 *
 * 给你一个字符串列表 strs。列表中的每个字符串都是 strs 中其它所有字符串的一个字母异位词。请问 strs 中有多少个相似字符串组？
 *
 *
 *
 * 示例 1：
 *
 * 输入：strs = ["tars","rats","arts","star"]
 * 输出：2
 * 示例 2：
 *
 * 输入：strs = ["omv","ovm"]
 * 输出：1
 *
 *
 * 提示：
 *
 * 1 <= strs.length <= 300
 * 1 <= strs[i].length <= 300
 * strs[i] 只包含小写字母。
 * strs 中的所有单词都具有相同的长度，且是彼此的字母异位词。
 *
 *
 * 备注：
 *
 * 字母异位词（anagram），一种把某个字符串的字母的位置（顺序）加以改换所形成的新词。
 */
public class LeetCode839 {

    boolean[] visited;
    int n, res = 0;

    public int numSimilarGroups(String[] strs) {
        n = strs.length;
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            dfs(strs, i);
            res++;
        }
        return res;
    }

    private void dfs(String[] strs, int u) {
        String s = strs[u];
        if (visited[u]) {
            return;
        }

        visited[u] = true;
        for (int i = 0; i < strs.length; i++) {
            // 自己不能和自己组成anagram
            if (strs[i].equals(s)) {
                continue;
            }
            if (isAnagram(strs[i], s)) {
                dfs(strs, i);
            }
        }
    }

    // tars, rats 记住判断是否 字母异位词
    private boolean isAnagram(String s1, String s2) {
        int cnt = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                continue;
            } else {
                cnt++;
                if (cnt > 2) {
                    return false;
                }
            }
        }

        return true;
    }
}
