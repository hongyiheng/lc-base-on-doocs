# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        dummy = ListNode()
        cur = dummy
        while head:
            q = deque()
            cnt = k
            while head and cnt:
                q.append(head)
                head = head.next
                cnt -= 1
            if cnt:
                while q:
                    cur.next = q.popleft()
                    cur = cur.next
            else:
                while q:
                    cur.next = q.pop()
                    cur = cur.next
            if not head:
                cur.next = None
        return dummy.next