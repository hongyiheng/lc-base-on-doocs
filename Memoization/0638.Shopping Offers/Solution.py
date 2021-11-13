class Solution:
    def shoppingOffers(self, price: List[int], special: List[List[int]], needs: List[int]) -> int:
        min_cost = dict()
        n = len(needs)

        def dfs(cur_needs):
            if str(cur_needs) not in min_cost:
                min_price = 0
                for i in range(n):
                    min_price += cur_needs[i] * price[i]
                for sp in special:
                    sale = sp[n]
                    left_needs = list()
                    for i in range(n):
                        if sp[i] > cur_needs[i]:
                            break
                        else:
                            left_needs.append(cur_needs[i] - sp[i])
                        if len(left_needs) == n:
                            min_price = min(min_price, dfs(left_needs) + sale)
                min_cost[str(cur_needs)] = min_price
            return min_cost[str(cur_needs)]

        return dfs(needs)
