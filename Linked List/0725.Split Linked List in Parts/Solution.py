# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def splitListToParts(self, head: ListNode, k: int) -> List[ListNode]:
        dummp = ListNode()
        dummp.next = head

        def get_len(node, n):
            if not node:
                return n
            return get_len(node.next, n + 1)

        n = get_len(dummp.next, 0)
        num, extra = n // k, n % k
        ans = []
        for _ in range(k):
            if n > 0:
                son_len = num if extra <= 0 else num + 1
                extra -= 1
                cur, temp = ListNode(), ListNode()
                cur.next = head
                while son_len > 1 and head:
                    head = head.next
                    son_len -= 1
                if head:
                    temp.next = head.next
                    head.next = None
                head = temp.next
                ans.append(cur.next)
            else:
                ans.append(None)
            n -= 1
        return ans