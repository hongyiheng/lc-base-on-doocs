# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def getAllElements(self, root1: TreeNode, root2: TreeNode) -> List[int]:
        def dfs(root, nums):
            if not root:
                return
            dfs(root.left, nums)
            nums.append(root.val)
            dfs(root.right, nums)

        nums1, nums2 = [], []
        dfs(root1, nums1)
        dfs(root2, nums2)
        ans = []
        idx1, idx2 = 0, 0
        while idx1 < len(nums1) or idx2 < len(nums2):
            if idx1 < len(nums1) and idx2 < len(nums2):
                if nums1[idx1] <= nums2[idx2]:
                    ans.append(nums1[idx1])
                    idx1 += 1
                else:
                    ans.append(nums2[idx2])
                    idx2 += 1
                continue
            if idx1 < len(nums1):
                ans.append(nums1[idx1])
                idx1 += 1
            else:
                ans.append(nums2[idx2])
                idx2 += 1
        return ans