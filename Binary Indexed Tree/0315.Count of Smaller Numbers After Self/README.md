# [315. 计算右侧小于当前元素的个数](https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个整数数组 <em>nums</em>，按要求返回一个新数组&nbsp;<em>counts</em>。数组 <em>counts</em> 有该性质： <code>counts[i]</code> 的值是&nbsp; <code>nums[i]</code> 右侧小于&nbsp;<code>nums[i]</code> 的元素的数量。</p>

<p>&nbsp;</p>

<p><strong>示例：</strong></p>

<pre><strong>输入：</strong>nums = [5,2,6,1]
<strong>输出：</strong><code>[2,1,1,0] 
<strong>解释：</strong></code>
5 的右侧有 <strong>2 </strong>个更小的元素 (2 和 1)
2 的右侧仅有 <strong>1 </strong>个更小的元素 (1)
6 的右侧有 <strong>1 </strong>个更小的元素 (1)
1 的右侧有 <strong>0 </strong>个更小的元素
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>0 &lt;= nums.length &lt;= 10^5</code></li>
	<li><code>-10^4&nbsp;&lt;= nums[i] &lt;= 10^4</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def countSmaller(self, nums: List[int]) -> List[int]:
        n = len(nums)
        tree = [0] * (n + 10)
        
        def lowbit(x):
            return x & -x

        def query(x):
            i, ans = x, 0
            while i > 0:
                ans += tree[i]
                i -= lowbit(i)
            return ans
        
        def add(index, incr):
            i = index
            while i <= len(tree):
                tree[i] += incr
                i += lowbit(i)

        temp = nums[::]
        temp.sort()
        index = 1
        mp = dict()
        for v in temp:
            if v in mp:
                continue
            mp[v] = index
            index += 1
        ans = []
        for v in nums[::-1]:
            index = mp[v]
            ans.append(query(index - 1))
            add(index, 1)
        return ans[::-1]
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    int[] tree;

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        tree = new int[n + 10];
        int[] temp = nums.clone();
        Arrays.sort(temp);
        Map<Integer, Integer> mp = new HashMap<>();
        int index = 1;
        for (int num : temp) {
            if (mp.containsKey(num)) {
                continue;
            }
            mp.put(num, index++);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            ans.add(query(mp.get(nums[i]) - 1));
            add(mp.get(nums[i]), 1);
        }
        Collections.reverse(ans);
        return ans;
    }

    public int lowbit(int x) {
        return x & -x;
    }

    public int query(int x) {
        int ans = 0;
        for (int i = x; i > 0; i -= lowbit(i)) {
            ans += tree[i];
        }
        return ans;
    }

    public void add(int index, int incr) {
        for (int i = index; i <= tree.length; i += lowbit(i)) {
            tree[i] += incr;
        }
    }
}
```

### **...**

```

```

<!-- tabs:end -->
