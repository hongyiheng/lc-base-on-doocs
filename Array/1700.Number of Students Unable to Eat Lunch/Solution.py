class Solution:
    def countStudents(self, students: List[int], sandwiches: List[int]) -> int:
        a = b = 0
        for v in students:
            if v == 0:
                a += 1
            else:
                b += 1
        for v in sandwiches:
            if v == 0:
                if a > 0:
                    a -= 1
                else:
                    break
            else:
                if b > 0:
                    b -= 1
                else:
                    break
        return a + b
