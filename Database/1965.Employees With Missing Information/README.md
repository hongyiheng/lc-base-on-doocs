# [1965. 丢失信息的雇员](https://leetcode-cn.com/problems/employees-with-missing-information)

## 题目描述

<!-- 这里写题目描述 -->

None

## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **SQL**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```sql
# Write your MySQL query statement below
SELECT
    employee_id
FROM
    ( SELECT employee_id FROM Employees UNION ALL SELECT employee_id FROM Salaries ) t
GROUP BY
    employee_id
HAVING
    count( 0 ) = 1
ORDER BY
    employee_id
```

<!-- tabs:end -->
