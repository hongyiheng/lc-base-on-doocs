/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    Map<Integer, Integer> mp = new HashMap<>();
    public int getImportance(List<Employee> employees, int id) {
        if (mp.containsKey(id)) {
            return mp.get(id);
        }
        int res = 0;
        for (Employee e : employees) {
            if (e.id == id) {
                res = e.importance;
                if (e.subordinates.isEmpty()) {
                    break;
                } else {
                    for (Integer itemId : e.subordinates) {
                        res += getImportance(employees, itemId);
                    }
                }
            }
        }
        mp.put(id, res);
        return res;
    }
}