class Solution:
    def reachingPoints(self, sx: int, sy: int, tx: int, ty: int) -> bool:
        while (tx > 0 and ty > 0) and (sx < tx or sy < ty):
            if tx >= ty:
                tx = tx - max((tx - sx) // ty, 1) * ty
            else:
                ty = ty - max((ty - sy) // tx, 1) * tx
        return sx == tx and sy == ty