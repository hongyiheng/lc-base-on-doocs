# [599. 两个列表的最小索引总和](https://leetcode-cn.com/problems/minimum-index-sum-of-two-lists)



## 题目描述

<!-- 这里写题目描述 -->

<p>假设Andy和Doris想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。</p>

<p>你需要帮助他们用<strong>最少的索引和</strong>找出他们<strong>共同喜爱的餐厅</strong>。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设总是存在一个答案。</p>

<p><strong>示例 1:</strong></p>

<pre><strong>输入:</strong>
[&quot;Shogun&quot;, &quot;Tapioca Express&quot;, &quot;Burger King&quot;, &quot;KFC&quot;]
[&quot;Piatti&quot;, &quot;The Grill at Torrey Pines&quot;, &quot;Hungry Hunter Steakhouse&quot;, &quot;Shogun&quot;]
<strong>输出:</strong> [&quot;Shogun&quot;]
<strong>解释:</strong> 他们唯一共同喜爱的餐厅是&ldquo;Shogun&rdquo;。
</pre>

<p><strong>示例 2:</strong></p>

<pre><strong>输入:</strong>
[&quot;Shogun&quot;, &quot;Tapioca Express&quot;, &quot;Burger King&quot;, &quot;KFC&quot;]
[&quot;KFC&quot;, &quot;Shogun&quot;, &quot;Burger King&quot;]
<strong>输出:</strong> [&quot;Shogun&quot;]
<strong>解释:</strong> 他们共同喜爱且具有最小索引和的餐厅是&ldquo;Shogun&rdquo;，它有最小的索引和1(0+1)。
</pre>

<p><strong>提示:</strong></p>

<ol>
	<li>两个列表的长度范围都在&nbsp;[1, 1000]内。</li>
	<li>两个列表中的字符串的长度将在[1，30]的范围内。</li>
	<li>下标从0开始，到列表的长度减1。</li>
	<li>两个列表都没有重复的元素。</li>
</ol>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def findRestaurant(self, list1: List[str], list2: List[str]) -> List[str]:
        mp = dict()
        for i, v in enumerate(list1):
            mp[v] = i
        index = float('inf')
        ans = list()
        for i, v in enumerate(list2):
            if v in mp:
                j = mp.get(v)
                if i + j > index:
                    continue
                if i + j < index:
                    index = i + j
                    ans.clear()
                ans.append(v)
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Set<String> ans = new HashSet<>();
        int index = Integer.MAX_VALUE;
        Map<String, Integer> mp = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            mp.put(list1[i], i);
        }
        for (int i = 0; i < list2.length; i++) {
            if (mp.containsKey(list2[i])) {
                int j = mp.get(list2[i]);
                if (i + j > index) {
                    continue;
                }
                if (i + j < index) {
                    index = i + j;
                    ans.clear();
                }
                ans.add(list2[i]);
            }
        }
        String[] res = new String[ans.size()];
        int i = 0;
        for (String s : ans) {
            res[i++] = s;
        }
        return res;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
