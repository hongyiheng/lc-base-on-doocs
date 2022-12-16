class Solution:
    def sequenceReconstruction(self, nums: List[int], sequences: List[List[int]]) -> bool:
        mp = defaultdict(set)
        in_deg = [0] * (len(nums) + 1)
        for seq in sequences:
            for i in range(1, len(seq)):
                mp[seq[i - 1]].add(seq[i])
                in_deg[seq[i]] += 1
        q = []
        for i in range(1, len(nums) + 1):
            if in_deg[i] == 0:
                q.append(i)
        idx = 0
        while q:
            if len(q) != 1:
                return False
            cur = q.pop(0)
            if cur != nums[idx]:
                return False
            idx += 1
            for nxt in mp[cur]:
                in_deg[nxt] -= 1
                if in_deg[nxt] == 0:
                    q.append(nxt)
        return True
