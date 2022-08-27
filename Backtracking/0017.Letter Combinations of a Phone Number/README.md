# [17. 电话号码的字母组合](https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个仅包含数字 <code>2-9</code> 的字符串，返回所有它能表示的字母组合。答案可以按 <strong>任意顺序</strong> 返回。</p>

<p>给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。</p>

<p><img src="https://assets.leetcode-cn.com/aliyun-lc-upload/original_images/17_telephone_keypad.png" style="width: 200px;" /></p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>digits = "23"
<strong>输出：</strong>["ad","ae","af","bd","be","bf","cd","ce","cf"]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>digits = ""
<strong>输出：</strong>[]
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>digits = "2"
<strong>输出：</strong>["a","b","c"]
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>0 <= digits.length <= 4</code></li>
	<li><code>digits[i]</code> 是范围 <code>['2', '9']</code> 的一个数字。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        mp = dict()
        mp[2] = ["a", "b", "c"]
        mp[3] = ["d", "e", "f"]
        mp[4] = ["g", "h", "i"]
        mp[5] = ["j", "k", "l"]
        mp[6] = ["m", "n", "o"]
        mp[7] = ["p", "q", "r", "s"]
        mp[8] = ["t", "u", "v"]
        mp[9] = ["w", "x", "y", "z"]
        ans = []

        def dfs(cur, path):
            if len(path) == len(digits):
                ans.append(path)
                return
            idx = int(digits[cur])
            for c in mp[idx]:
                path += c
                dfs(cur + 1, path)
                path = path[:-1]

        if len(digits) == 0:
            return ans
        dfs(0, "")
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    Map<String, String[]> mp = new HashMap<String, String[]>() {{
        put("1", new String[]{});
        put("2", new String[]{"a", "b", "c"});
        put("3", new String[]{"d", "e", "f"});
        put("4", new String[]{"g", "h", "i"});
        put("5", new String[]{"j", "k", "l"});
        put("6", new String[]{"m", "n", "o"});
        put("7", new String[]{"p", "q", "r", "s"});
        put("8", new String[]{"t", "u", "v"});
        put("9", new String[]{"w", "x", "y", "z"});
    }};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        int len = digits.length();
        if (len == 0) {
            return res;
        }
        dfs(res, 0, path, digits, len);
        return res;
    }

    public void dfs(List<String> res, int depth, StringBuilder path, String digits, int len) {
        if (depth == len) {
            res.add(path.toString());
            return;
        }
        String key = digits.substring(depth, depth + 1);
        for (String item : mp.get(key)) {
            path.append(item);
            dfs(res, depth + 1, path, digits, len);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
```

### **...**

```

```

<!-- tabs:end -->
