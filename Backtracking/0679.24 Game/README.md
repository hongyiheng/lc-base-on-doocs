# [679. 24 点游戏](https://leetcode-cn.com/problems/24-game)



## 题目描述

<!-- 这里写题目描述 -->

<p>你有 4 张写有 1 到 9 数字的牌。你需要判断是否能通过&nbsp;<code>*</code>，<code>/</code>，<code>+</code>，<code>-</code>，<code>(</code>，<code>)</code>&nbsp;的运算得到 24。</p>

<p><strong>示例 1:</strong></p>

<pre><strong>输入:</strong> [4, 1, 8, 7]
<strong>输出:</strong> True
<strong>解释:</strong> (8-4) * (7-1) = 24
</pre>

<p><strong>示例 2:</strong></p>

<pre><strong>输入:</strong> [1, 2, 1, 2]
<strong>输出:</strong> False
</pre>

<p><strong>注意:</strong></p>

<ol>
	<li>除法运算符&nbsp;<code>/</code>&nbsp;表示实数除法，而不是整数除法。例如 4 / (1 - 2/3) = 12 。</li>
	<li>每个运算符对两个数进行运算。特别是我们不能用&nbsp;<code>-</code>&nbsp;作为一元运算符。例如，<code>[1, 1, 1, 1]</code>&nbsp;作为输入时，表达式&nbsp;<code>-1 - 1 - 1 - 1</code>&nbsp;是不允许的。</li>
	<li>你不能将数字连接在一起。例如，输入为&nbsp;<code>[1, 2, 1, 2]</code>&nbsp;时，不能写成 12 + 12 。</li>
</ol>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def judgePoint24(self, cards: List[int]) -> bool:
        ans = False
        diff = 1e-6

        def fill_array(nums, new_nums, i, j):
            idx = 0
            for k in range(1, len(new_nums)):
                while idx == i or idx == j:
                    idx += 1
                new_nums[k] = nums[idx]
                idx += 1

        def dfs(nums):
            nonlocal ans
            if ans:
                return
            n = len(nums)
            if n == 1:
                if abs(nums[0] - 24) < diff:
                    ans = True
                    return
            for i in range(n):
                for j in range(n):
                    if i == j:
                        continue
                    new_nums = [0] * (n - 1)
                    new_nums[0] = nums[i] + nums[j]
                    fill_array(nums, new_nums, i, j)
                    dfs(new_nums)
                    new_nums[0] = nums[i] - nums[j]
                    fill_array(nums, new_nums, i, j)
                    dfs(new_nums)
                    new_nums[0] = nums[i] * nums[j]
                    fill_array(nums, new_nums, i, j)
                    dfs(new_nums)
                    if nums[j]:
                        new_nums[0] = nums[i] / nums[j]
                        fill_array(nums, new_nums, i, j)
                        dfs(new_nums)

        dfs(cards)
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    boolean ans = false;
    double diff = 1e-6;

    public boolean judgePoint24(int[] cards) {
        int n = cards.length;
        double[] nums = new double[n];
        for (int i = 0; i < n; i++) {
            nums[i] = cards[i];
        }
        dfs(nums);
        return ans;
    }

    public void dfs(double[] nums) {
        if (ans) {
            return;
        }
        int n = nums.length;
        if (n == 1) {
            if (Math.abs(nums[0] - 24) < diff) {
                ans = true;
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                double[] newNums = new double[n - 1];
                newNums[0] = nums[i] + nums[j];
                fillArray(nums, newNums, i, j);
                dfs(newNums);
                newNums[0] = nums[i] - nums[j];
                fillArray(nums, newNums, i, j);
                dfs(newNums);
                newNums[0] = nums[i] * nums[j];
                fillArray(nums, newNums, i, j);
                dfs(newNums);
                if (nums[j] != 0) {
                    newNums[0] = nums[i] / nums[j];
                    fillArray(nums, newNums, i, j);
                    dfs(newNums);
                }
            }
        }
    }

    public void fillArray(double[] nums, double[] newNums, int i, int j) {
        int idx = 0;
        for (int k = 1; k < newNums.length; k++) {
            while (idx == i || idx == j) {
                idx++;
            }
            newNums[k] = nums[idx++];
        }
    }
}
```

### **...**

```

```

<!-- tabs:end -->
