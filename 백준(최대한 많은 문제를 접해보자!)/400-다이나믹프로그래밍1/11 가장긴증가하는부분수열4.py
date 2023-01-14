# 내풀이
import copy

n = int(input())
data = list(map(int, input().split()))

dp = [1] * n
store = [[data[i]] for i in range(n)]
for i in range(1, n):
  for j in range(0, i):
    if data[i] > data[j] and dp[i] < dp[j] + 1:
        dp[i] = dp[j] + 1
        store[i] = copy.deepcopy(store[j])
        store[i].append(data[i])

index = 0
for i in range(1, n):
    if dp[index] < dp[i]:
        index = i

print(dp[index])
print(" ".join(str(number) for number in store[index]))

#
#
# 다른 사람 풀이
from bisect import bisect_left

n = int(input())

array = list(map(int, input().split()))

dp = [1] * n

for i in range(1, n):
    for j in range(i):
        if array[i] > array[j]:
            dp[i] = max(dp[j] + 1, dp[i])

max_value = max(dp)
max_index = dp.index(max_value)

result = []
for value in range(max_value, 0, -1):
    while dp[max_index] != value:
        max_index -= 1
    result.append(array[max_index])
    max_index -= 1

result.reverse()
print(max_value)        
print(*result)