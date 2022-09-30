class Solution:
    def flipAndInvertImage(self, image: List[List[int]]) -> List[List[int]]:
        n = len(image)
        for i in range(n):
            l, r = 0, n - 1
            while l < r:
                image[i][l], image[i][r] = image[i][r] ^ 1, image[i][l] ^ 1
                l += 1
                r -= 1
            if l == r:
                image[i][l] ^= 1
        return image
