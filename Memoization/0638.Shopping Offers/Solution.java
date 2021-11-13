class Solution {
    Map<List<Integer>, Integer> minCost = new HashMap<>();

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return dfs(price, special, needs);
    }

    public int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        if (!minCost.containsKey(needs)) {
            int n = needs.size();
            int minPrice = 0;
            for (int i = 0; i < n; i++) {
                minPrice += needs.get(i) * price.get(i);
            }
            for (List<Integer> sp : special) {
                int salePrice = sp.get(n);
                List<Integer> lessNeeds = new ArrayList<>();
                for (int i = 0; i < n; ++i) {
                    if (sp.get(i) > needs.get(i)) {
                        break;
                    }
                    lessNeeds.add(needs.get(i) - sp.get(i));
                }
                if (lessNeeds.size() == n) {
                    minPrice = Math.min(minPrice, dfs(price, special, lessNeeds) + salePrice);
                }
            }
            minCost.put(needs, minPrice);
        }
        return minCost.get(needs);
    }
}