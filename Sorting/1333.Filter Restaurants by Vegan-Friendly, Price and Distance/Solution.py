class Solution:
    def filterRestaurants(self, restaurants: List[List[int]], veganFriendly: int, maxPrice: int, maxDistance: int) -> \
    List[int]:
        def cmp(a, b):
            return b[1] - a[1] if a[1] != b[1] else b[0] - a[0]

        res = []
        for v in restaurants:
            _, _, vegan, price, distance = v
            if veganFriendly == 1 and vegan != veganFriendly:
                continue
            if price > maxPrice or distance > maxDistance:
                continue
            res.append(v)
        res.sort(key=cmp_to_key(cmp))
        return [v[0] for v in res]
