class Solution:
    def pancakeSort(self, arr: List[int]) -> List[int]:
        n = len(arr)

        def get_max_index(target):
            nonlocal arr
            for i, v in enumerate(arr):
                if v == target:
                    return i
            return -1

        def reverse(right):
            nonlocal arr
            arr = arr[:right][::-1] + arr[right:]

        ans = []
        while n > 1:
            index = get_max_index(n)
            reverse(index + 1)
            reverse(n)
            ans.append(index + 1)
            ans.append(n)
            n -= 1
        return ans