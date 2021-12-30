class Solution:
    def isNStraightHand(self, hand: List[int], groupSize: int) -> bool:
        n = len(hand)
        if n % groupSize != 0:
            return False
        hand.sort()
        cnt = Counter(hand)
        for num in hand:
            if cnt[num] == 0:
                continue
            for i in range(num, num + groupSize):
                if cnt[i] == 0:
                    return False
                else:
                    cnt[i] -= 1
        return True

