//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串 
// 👍 621 👎 0

package leetCode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class GroupAnagrams{

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = new String(chars);
            map.computeIfAbsent(s, k->new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
       Solution solution = new GroupAnagrams().new Solution();
    }
}