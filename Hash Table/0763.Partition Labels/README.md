# [763. 划分字母区间](https://leetcode-cn.com/problems/partition-labels)



## 题目描述

<!-- 这里写题目描述 -->

<p>字符串 <code>S</code> 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。</p>

<p> </p>

<p><strong>示例：</strong></p>

<pre>
<strong>输入：</strong>S = "ababcbacadefegdehijhklij"
<strong>输出：</strong>[9,7,8]
<strong>解释：</strong>
划分结果为 "ababcbaca", "defegde", "hijhklij"。
每个字母最多出现在一个片段中。
像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>S</code>的长度在<code>[1, 500]</code>之间。</li>
	<li><code>S</code>只包含小写字母 <code>'a'</code> 到 <code>'z'</code> 。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        def check(cnt, cs):
            for c in cs:
                if cnt[ord(c) - ord('a')] != 0:
                    return False
            return True

        cnt = [0] * 26
        for c in s:
            cnt[ord(c) - ord('a')] += 1
        cs, ans = set(), list()
        cur = 0
        for i, v in enumerate(s):
            cnt[ord(v) - ord('a')] -= 1
            cs.add(v)
            if cnt[ord(v) - ord('a')] == 0 and check(cnt, cs):
                ans.append(i - cur + 1)
                cur = i + 1
                cs.clear()
        return ans       
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        char[] chars = s.toCharArray();
        int[] cnt = new int[26];
        for (char c : chars) {
            cnt[c - 'a']++;
        }
        Set<Character> cs = new HashSet<>();
        int cur = 0;
        for (int i = 0; i < chars.length; i++) {
            cs.add(chars[i]);
            cnt[chars[i] - 'a']--;
            if (cnt[chars[i] - 'a'] == 0 && check(cnt, cs)) {
                ans.add(i - cur + 1);
                cur = i + 1;
                cs.clear();
            }
        }
        return ans;
    }

    public boolean check(int[] cnt, Set<Character> chars) {
        for (char c : chars) {
            if (cnt[c - 'a'] != 0) {
                return false;
            }
        }
        return true;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
