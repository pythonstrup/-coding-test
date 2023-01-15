# 걸린 시간: 30분
# 시간복잡도: 136ms
n = int(input())
direction = list(map(int, input().split()))

for i, value in enumerate(direction):
    if direction[i] == 2: direction[i] = -1

left = [0] * n
right = [0] * n
for i in range(n):
    left[i] = max(direction[i], direction[i] + left[i-1])
    right[i] = max(-direction[i], right[i-1] - direction[i])

print(max(max(left), max(right)))