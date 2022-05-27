# [243. 最短单词距离](https://leetcode-cn.com/problems/shortest-word-distance)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个单词列表和两个单词 <em>word1</em> 和 <em>word2</em>，返回列表中这两个单词之间的最短距离。</p>

<p><strong>示例:</strong><br>
假设 words = <code>[&quot;practice&quot;, &quot;makes&quot;, &quot;perfect&quot;, &quot;coding&quot;, &quot;makes&quot;]</code></p>

<pre><strong>输入:</strong> <em>word1</em> = <code>&ldquo;coding&rdquo;</code>, <em>word2</em> = <code>&ldquo;practice&rdquo;</code>
<strong>输出:</strong> 3
</pre>

<pre><strong>输入:</strong> <em>word1</em> = <code>&quot;makes&quot;</code>, <em>word2</em> = <code>&quot;coding&quot;</code>
<strong>输出:</strong> 1
</pre>

<p><strong>注意:</strong><br>
你可以假设 <em>word1</em> 不等于 <em>word2</em>, 并且 <em>word1</em> 和 <em>word2</em> 都在列表里。</p>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def shortestDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        nums = []
        for i, w in enumerate(wordsDict):
            if w == word1:
                nums.append(i)
        ans = len(wordsDict)
        for i, w in enumerate(wordsDict):
            if w == word2:
                left, right = 0, len(nums) - 1
                while left < right:
                    mid = (left + right) >> 1
                    if nums[mid] < i:
                        left = mid + 1
                    else:
                        right = mid
                if left > 0 and abs(nums[left - 1] - i) < abs(nums[left] - i):
                    left = left - 1
                ans = min(ans, abs(nums[left] - i))
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1)) {
                nums.add(i);
            }
        }
        int ans = wordsDict.length;
        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word2)) {
                int left = 0, right = nums.size() - 1;
                while (left < right) {
                    int mid = (left + right) >> 1;
                    if (nums.get(mid) < i) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                if (left > 0 && Math.abs(nums.get(left - 1) - i) < Math.abs(nums.get(left) - i)) {
                    left = left - 1;
                }
                ans = Math.min(ans, Math.abs(nums.get(left) - i));
            }
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
