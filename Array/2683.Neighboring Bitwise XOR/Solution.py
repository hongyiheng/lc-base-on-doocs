class Solution:
    def doesValidArrayExist(self, derived: List[int]) -> bool:
        def check(head):
            last = head
            for i in range(len(derived) - 1):
                if derived[i]:
                    last ^= 1
            return head ^ last == derived[-1]

        return check(0) or check(1)
