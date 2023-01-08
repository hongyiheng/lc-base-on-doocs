# [1865. 找出和为指定值的下标对](https://leetcode-cn.com/problems/finding-pairs-with-a-certain-sum)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你两个整数数组 <code>nums1</code> 和 <code>nums2</code> ，请你实现一个支持下述两类查询的数据结构：</p>

<ol>
	<li><strong>累加</strong> ，将一个正整数加到 <code>nums2</code> 中指定下标对应元素上。</li>
	<li><strong>计数 </strong>，统计满足 <code>nums1[i] + nums2[j]</code> 等于指定值的下标对 <code>(i, j)</code> 数目（<code>0 <= i < nums1.length</code> 且 <code>0 <= j < nums2.length</code>）。</li>
</ol>

<p>实现 <code>FindSumPairs</code> 类：</p>

<ul>
	<li><code>FindSumPairs(int[] nums1, int[] nums2)</code> 使用整数数组 <code>nums1</code> 和 <code>nums2</code> 初始化 <code>FindSumPairs</code> 对象。</li>
	<li><code>void add(int index, int val)</code> 将 <code>val</code> 加到 <code>nums2[index]</code> 上，即，执行 <code>nums2[index] += val</code> 。</li>
	<li><code>int count(int tot)</code> 返回满足 <code>nums1[i] + nums2[j] == tot</code> 的下标对 <code>(i, j)</code> 数目。</li>
</ul>

<p> </p>

<p><strong>示例：</strong></p>

<pre>
<strong>输入：</strong>
["FindSumPairs", "count", "add", "count", "count", "add", "add", "count"]
[[[1, 1, 2, 2, 2, 3], [1, 4, 5, 2, 5, 4]], [7], [3, 2], [8], [4], [0, 1], [1, 1], [7]]
<strong>输出：</strong>
[null, 8, null, 2, 1, null, null, 11]

<strong>解释：</strong>
FindSumPairs findSumPairs = new FindSumPairs([1, 1, 2, 2, 2, 3], [1, 4, 5, 2, 5, 4]);
findSumPairs.count(7);  // 返回 8 ; 下标对 (2,2), (3,2), (4,2), (2,4), (3,4), (4,4) 满足 2 + 5 = 7 ，下标对 (5,1), (5,5) 满足 3 + 4 = 7
findSumPairs.add(3, 2); // 此时 nums2 = [1,4,5,<em><strong>4</strong></em><code>,5,4</code>]
findSumPairs.count(8);  // 返回 2 ；下标对 (5,2), (5,4) 满足 3 + 5 = 8
findSumPairs.count(4);  // 返回 1 ；下标对 (5,0) 满足 3 + 1 = 4
findSumPairs.add(0, 1); // 此时 nums2 = [<em><strong><code>2</code></strong></em>,4,5,4<code>,5,4</code>]
findSumPairs.add(1, 1); // 此时 nums2 = [<code>2</code>,<em><strong>5</strong></em>,5,4<code>,5,4</code>]
findSumPairs.count(7);  // 返回 11 ；下标对 (2,1), (2,2), (2,4), (3,1), (3,2), (3,4), (4,1), (4,2), (4,4) 满足 2 + 5 = 7 ，下标对 (5,3), (5,5) 满足 3 + 4 = 7
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= nums1.length <= 1000</code></li>
	<li><code>1 <= nums2.length <= 10<sup>5</sup></code></li>
	<li><code>1 <= nums1[i] <= 10<sup>9</sup></code></li>
	<li><code>1 <= nums2[i] <= 10<sup>5</sup></code></li>
	<li><code>0 <= index < nums2.length</code></li>
	<li><code>1 <= val <= 10<sup>5</sup></code></li>
	<li><code>1 <= tot <= 10<sup>9</sup></code></li>
	<li>最多调用 <code>add</code> 和 <code>count</code> 函数各 <code>1000</code> 次</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class FindSumPairs:

    def __init__(self, nums1: List[int], nums2: List[int]):
        self.cnt1 = Counter(nums1)
        self.cnt2 = Counter(nums2)
        self.nums2 = nums2

    def add(self, index: int, val: int) -> None:
        self.cnt2[self.nums2[index]] -= 1
        self.cnt2[self.nums2[index] + val] += 1
        self.nums2[index] += val
        
    def count(self, tot: int) -> int:
        ans = 0
        for v in self.cnt1.keys():
            if v >= tot:
                continue
            ans += (self.cnt1[v] * self.cnt2.get(tot - v, 0))
        return ans



# Your FindSumPairs object will be instantiated and called as such:
# obj = FindSumPairs(nums1, nums2)
# obj.add(index,val)
# param_2 = obj.count(tot)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class FindSumPairs {

    int[] nums2;
    Map<Integer, Integer> cnt1, cnt2;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums2 = nums2;
        cnt1 = new HashMap<>();
        cnt2 = new HashMap<>();
        for (int v : nums1) {
            cnt1.put(v, cnt1.getOrDefault(v, 0) + 1);
        }
        for (int v : nums2) {
            cnt2.put(v, cnt2.getOrDefault(v, 0) + 1);
        }
    }

    public void add(int index, int val) {
        cnt2.put(nums2[index], cnt2.get(nums2[index]) - 1);
        cnt2.put(nums2[index] + val, cnt2.getOrDefault(nums2[index] + val, 0) + 1);
        nums2[index] += val;
    }

    public int count(int tot) {
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : cnt1.entrySet()) {
            if (entry.getKey() > tot) {
                continue;
            }
            int v = entry.getKey(), cnt = entry.getValue();
            ans += cnt * cnt2.getOrDefault(tot - v, 0);
        }
        return ans;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */
```

### **...**

```

```

<!-- tabs:end -->
