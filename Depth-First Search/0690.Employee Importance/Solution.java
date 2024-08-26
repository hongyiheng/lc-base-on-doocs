/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {

    Employee[] es;

    public int dfs(int i) {
        Employee e = es[i];
        if (e == null) {
            return 0;
        }
        int ans = e.importance;
        for (int j : e.subordinates) {
            ans += dfs(j);
        }
        return ans;
    }

    public int getImportance(List<Employee> employees, int id) {
        es = new Employee[2010];
        for (Employee e : employees) {
            es[e.id] = e;
        }
        return dfs(id);
    }
}