n = int(input())
array = [0] * 10_001
for i in range(1, n + 1):
    array[i] = int(input())

dp = [0] * 10_001
dp[1] = array[1]
dp[2] = array[1]+array[2]
dp[3] = max(dp[1]+array[3], dp[2], array[2]+array[3])

for i in range(4, n+1):
    dp[i] = max(dp[i-3]+array[i-1]+array[i], dp[i-2]+array[i], dp[i-1])
    
print(dp[n])