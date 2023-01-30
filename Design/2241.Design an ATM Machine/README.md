# [2241. 设计一个 ATM 机器](https://leetcode-cn.com/problems/design-an-atm-machine)

## 题目描述

<!-- 这里写题目描述 -->

<p>一个 ATM 机器，存有&nbsp;<code>5</code>&nbsp;种面值的钞票：<code>20</code>&nbsp;，<code>50</code>&nbsp;，<code>100</code>&nbsp;，<code>200</code>&nbsp;和&nbsp;<code>500</code>&nbsp;美元。初始时，ATM 机是空的。用户可以用它存或者取任意数目的钱。</p>

<p>取款时，机器会优先取 <b>较大</b>&nbsp;数额的钱。</p>

<ul>
	<li>比方说，你想取&nbsp;<code>$300</code>&nbsp;，并且机器里有&nbsp;<code>2</code>&nbsp;张 <code>$50</code>&nbsp;的钞票，<code>1</code>&nbsp;张&nbsp;<code>$100</code>&nbsp;的钞票和<code>1</code>&nbsp;张&nbsp;<code>$200</code>&nbsp;的钞票，那么机器会取出&nbsp;<code>$100</code> 和&nbsp;<code>$200</code>&nbsp;的钞票。</li>
	<li>但是，如果你想取&nbsp;<code>$600</code>&nbsp;，机器里有&nbsp;<code>3</code>&nbsp;张&nbsp;<code>$200</code>&nbsp;的钞票和<code>1</code>&nbsp;张&nbsp;<code>$500</code>&nbsp;的钞票，那么取款请求会被拒绝，因为机器会先取出&nbsp;<code>$500</code>&nbsp;的钞票，然后无法取出剩余的&nbsp;<code>$100</code>&nbsp;。注意，因为有&nbsp;<code>$500</code>&nbsp;钞票的存在，机器&nbsp;<strong>不能</strong>&nbsp;取&nbsp;<code>$200</code>&nbsp;的钞票。</li>
</ul>

<p>请你实现 ATM 类：</p>

<ul>
	<li><code>ATM()</code>&nbsp;初始化 ATM 对象。</li>
	<li><code>void deposit(int[] banknotesCount)</code>&nbsp;分别存入&nbsp;<code>$20</code>&nbsp;，<code>$50</code>，<code>$100</code>，<code>$200</code>&nbsp;和&nbsp;<code>$500</code>&nbsp;钞票的数目。</li>
	<li><code>int[] withdraw(int amount)</code>&nbsp;返回一个长度为&nbsp;<code>5</code>&nbsp;的数组，分别表示&nbsp;<code>$20</code>&nbsp;，<code>$50</code>，<code>$100</code>&nbsp;，<code>$200</code>&nbsp;和&nbsp;<code>$500</code>&nbsp;钞票的数目，并且更新 ATM 机里取款后钞票的剩余数量。如果无法取出指定数额的钱，请返回&nbsp;<code>[-1]</code>&nbsp;（这种情况下 <strong>不</strong>&nbsp;取出任何钞票）。</li>
</ul>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>
["ATM", "deposit", "withdraw", "deposit", "withdraw", "withdraw"]
[[], [[0,0,1,2,1]], [600], [[0,1,0,1,1]], [600], [550]]
<strong>输出：</strong>
[null, null, [0,0,1,0,1], null, [-1], [0,1,0,0,1]]

<strong>解释：</strong>
ATM atm = new ATM();
atm.deposit([0,0,1,2,1]); // 存入 1 张 $100 ，2 张 $200 和 1 张 $500 的钞票。
atm.withdraw(600);        // 返回 [0,0,1,0,1] 。机器返回 1 张 $100 和 1 张 $500 的钞票。机器里剩余钞票的数量为 [0,0,0,2,0] 。
atm.deposit([0,1,0,1,1]); // 存入 1 张 $50 ，1 张 $200 和 1 张 $500 的钞票。
                          // 机器中剩余钞票数量为 [0,1,0,3,1] 。
atm.withdraw(600);        // 返回 [-1] 。机器会尝试取出 $500 的钞票，然后无法得到剩余的 $100 ，所以取款请求会被拒绝。
                          // 由于请求被拒绝，机器中钞票的数量不会发生改变。
atm.withdraw(550);        // 返回 [0,1,0,0,1] ，机器会返回 1 张 $50 的钞票和 1 张 $500 的钞票。</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>banknotesCount.length == 5</code></li>
	<li><code>0 &lt;= banknotesCount[i] &lt;= 10<sup>9</sup></code></li>
	<li><code>1 &lt;= amount &lt;= 10<sup>9</sup></code></li>
	<li><strong>总共</strong>&nbsp;最多有&nbsp;<code>5000</code>&nbsp;次&nbsp;<code>withdraw</code> 和&nbsp;<code>deposit</code>&nbsp;的调用。</li>
	<li><span style="">函数 </span><code>withdraw</code> 和&nbsp;<code>deposit</code>&nbsp;至少各有 <strong>一次&nbsp;</strong>调用。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class ATM:

    def __init__(self):
        self.cnt = [0] * 5
        self.cash = [20, 50, 100, 200, 500]

    def deposit(self, banknotesCount: List[int]) -> None:
        for i in range(5):
            self.cnt[i] += banknotesCount[i]

    def withdraw(self, amount: int) -> List[int]:
        _cnt = self.cnt
        ans = [0] * 5
        for i in range(4, -1, -1):
            if amount >= self.cash[i]:
                cost = min(_cnt[i], amount // self.cash[i])
                amount -= cost * self.cash[i]
                ans[i] = cost
        if amount == 0:
            for i in range(5):
                _cnt[i] -= ans[i]
            return ans
        return [-1]



# Your ATM object will be instantiated and called as such:
# obj = ATM()
# obj.deposit(banknotesCount)
# param_2 = obj.withdraw(amount)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class ATM {

    long[] cash, cnt;

    public ATM() {
        cash = new long[]{20, 50, 100, 200, 500};
        cnt = new long[5];
    }
    
    public void deposit(int[] banknotesCount) {
        for (int i = 0; i < 5; i++) {
            cnt[i] += banknotesCount[i];
        }
    }
    
    public int[] withdraw(int amount) {
        int[] ans = new int[5];
        for (int i = 4; i > -1; i--) {
            if (amount >= cash[i]) {
                long cost = Math.min(cnt[i], amount / cash[i]);
                amount -= cost * cash[i];
                ans[i] = (int)cost;
            }
        }
        if (amount > 0) {
            return new int[]{-1};
        }
        for (int i = 0; i < 5; i++) {
            cnt[i] -= ans[i];
        }
        return ans;
    }
}

/**
 * Your ATM object will be instantiated and called as such:
 * ATM obj = new ATM();
 * obj.deposit(banknotesCount);
 * int[] param_2 = obj.withdraw(amount);
 */
```

### **...**

```

```

<!-- tabs:end -->
