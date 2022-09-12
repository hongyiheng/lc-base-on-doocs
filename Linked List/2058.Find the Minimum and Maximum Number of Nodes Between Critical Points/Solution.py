# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def nodesBetweenCriticalPoints(self, head: Optional[ListNode]) -> List[int]:
        f = s = 0
        f_idx = last_idx = -1
        min_dis, max_dis = float('inf'), float('-inf')
        idx = 1
        while head:
            if f == 0:
                f = head.val
            elif s == 0:
                s = head.val
            else:
                if f > s < head.val or f < s > head.val:
                    if f_idx == -1:
                        f_idx = idx - 1
                    if last_idx != -1:
                        min_dis = min(min_dis, abs(last_idx - idx + 1))
                        max_dis = max(max_dis, abs(f_idx - idx + 1))
                    last_idx = idx - 1
                f = s
                s = head.val
            head = head.next
            idx += 1
        return [-1, -1] if min_dis == float('inf') else [min_dis, max_dis]