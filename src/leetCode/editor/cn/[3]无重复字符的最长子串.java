//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 104 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 4740 👎 0

package leetCode.editor.cn;

class LongestSubstringWithoutRepeatingCharacters{

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] chars = s.toCharArray();
        int[] fre = new int[256];//每个asiic码上次出现的位置（不是下标是下标加1），0为没有出现

        // [l...r] 内无重复字符
        int l = 0;
        int r = -1;
        int ret = 0;
        while (l < chars.length) {
            if (r + 1 < chars.length && fre[chars[r + 1]] == 0) {
                fre[chars[++r]]++;
            } else {
                fre[chars[l]]--;
                l++;
            }

            if (fre[chars[r]] != 0) {
                ret = Math.max(ret, (r - l + 1));
            }

        }

        if (ret == 0) {
            return chars.length;
        }

        return ret;
    }

    public int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] chars = s.toCharArray();
        int fre[] = new int[256];
        int l = 0;
        int r = 0;
        int ret = 0;
        while (r < chars.length) {

            while (r < chars.length && fre[chars[r]] == 0) {
                fre[chars[r]]++;
                r++;
            }

            ret = Math.max(ret, r - l);

            do {
                fre[chars[l]]--;
                l++;
            }
            while (r < chars.length && chars[l - 1] != chars[r]);


        }

        return ret;

    }

    public int lengthOfLongestSubstring3(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);//index[s.charAt(j)] 在i之后的证明[i..j]中有与char[j] 重复的则直接位移到上次出现的下一位
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }


        return ans;
    }


    public int lengthOfLongestSubstring4(String s) {
        int left = 0;
        int right = 0;
        int max = 0;
        int[] arr = new int[255];
        if (s == null) return max;
        if ("".equals(s)) return max;
        while (right < s.length()) {
            int r = (int) s.charAt(right);
            int l = s.substring(0, right).lastIndexOf(s.charAt(right)) + 1;
            if (arr[r] == 0 || l < left) {
                arr[r]++;
                right++;
            } else {
                max = max > (right - left) ? max : (right - left);
                left = l;
                right++;
            }
        }
        max = max > (right - left) ? max : (right - left);
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
       Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        String s = "abcabcbb";
        int i = solution.lengthOfLongestSubstring2(s);
        System.out.println(i);
    }
}