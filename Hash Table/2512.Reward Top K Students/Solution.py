class Solution:
    def topStudents(self, positive_feedback: List[str], negative_feedback: List[str], report: List[str], student_id: List[int], k: int) -> List[int]:
        pos = set(positive_feedback)
        neg = set(negative_feedback)
        q = []
        for s, i in zip(report, student_id):
            degree = 0
            for w in s.split(" "):
                if w in pos:
                    degree += 3
                elif w in neg:
                    degree -= 1
            q.append((degree, i))
        q.sort(key=lambda x:(-x[0], x[1]))
        return [i for _, i in q][:min(k, len(student_id))]