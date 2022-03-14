class Solution:
    def findRestaurant(self, list1: List[str], list2: List[str]) -> List[str]:
        mp = dict()
        for i, v in enumerate(list1):
            mp[v] = i
        index = float('inf')
        ans = list()
        for i, v in enumerate(list2):
            if v in mp:
                j = mp.get(v)
                if i + j > index:
                    continue
                if i + j < index:
                    index = i + j
                    ans.clear()
                ans.append(v)
        return ans
