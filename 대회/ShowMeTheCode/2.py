# 1차 시도 - 런타임 에러
# dfs를 사용한 탓에 재귀스택이 깊어져 에러가 발생하는 것 같다.
from collections import deque

n, m = list(map(int, input().split()))
graph = []
for i in range(n):
    graph.append(list(map(int, input().split())))

def dfs(x, y):
    if x == -1: x = n-1
    elif x == n: x = 0
    elif y == -1: y = m-1
    elif y == m: y = 0

    if graph[x][y] == 0:
        graph[x][y] = 1
        dfs(x-1, y)
        dfs(x, y-1)
        dfs(x, y+1)
        dfs(x+1, y)
        return True
    return False

result = 0
for i in range(n):
    for j in range(m):
        if dfs(i, j) == True:
            result += 1
print(result)

# 시간초과...
from collections import deque

n, m = list(map(int, input().split()))
graph = []
for i in range(n):
    graph.append(list(map(int, input().split())))

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(x, y):
    if graph[x][y] == 1:
        return False
    q = deque()
    q.append((x,y))

    while q:
        x, y = q.popleft()
        graph[x][y] = 1
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx == -1:
                nx = n - 1
            elif nx == n:
                nx = 0
            elif ny == -1:
                ny = m - 1
            elif ny == m:
                ny = 0

            if graph[nx][ny] == 0:
                q.append((nx,ny))   
    return True

result = 0
for i in range(n):
    for j in range(m):
        if bfs(i, j) == True:
            result += 1
print(result)

# 또다시 런타임 에러..
n, m = list(map(int, input().split()))
graph = []
for i in range(n):
    graph.append(list(map(int, input().split())))

def dfs(x, y):
    if graph[x][y] == 0:
        graph[x][y] = 1
        if x-1 == -1:
            dfs(n-1, y)
        else:
            dfs(x-1, y)    
        
        if x+1 == n: 
            dfs(0, y)
        else:
            dfs(x+1, y)

        if y-1 == -1: 
            dfs(x, m-1)
        else:
            dfs(x, y-1)

        if y+1 == m: 
            dfs(x, 0)
        else:
            dfs(x, y+1)
        return True
    return False

result = 0
for i in range(n):
    for j in range(m):
        if dfs(i, j) == True:
            result += 1
print(result)


# 시간 초과 못함...
from collections import deque

n, m = list(map(int, input().split()))
graph = []
for i in range(n):
    graph.append(list(map(int, input().split())))

def bfs(x, y):
    if graph[x][y] == 1:
        return False
    q = deque()
    q.append((x,y))

    while q:
        x, y = q.popleft()
        graph[x][y] = 1
        nx = x
        ny = y
        
        if x-1 == -1: nx = n - 1
        else: nx = x- 1
        if graph[nx][y] == 0:
            q.append((nx, y))
        
        if x+1 == n: nx = 0
        else: nx = x + 1
        if graph[nx][y] == 0:
            q.append((nx, y))

        nx = x
        if y-1 == -1: ny = m-1
        else: ny = y-1
        if graph[x][ny] == 0:
            q.append((x, ny))

        if y+1 == m: ny = 0
        else: ny = y + 1
        if graph[x][ny] == 0:
            q.append((x, ny))

    return True

result = 0
for i in range(n):
    for j in range(m):
        if bfs(i, j) == True:
            result += 1
print(result)

# 결국 계속 시간초과, 런타임 에러 발생해서...
# C++로 품....
#include <bits/stdc++.h>
# using namespace std;

# int n, m;
# int graph[1000][1000];

# bool dfs(int x, int y) {
#     if (x == -1) x = n-1;
#     else if (x == n) x = 0;
#     else if (y == -1) y = m-1;
#     else if (y == m) y = 0;

#     if (graph[x][y] == 0) {
#         graph[x][y] = 1;
#         dfs(x - 1, y);
#         dfs(x, y - 1);
#         dfs(x + 1, y);
#         dfs(x, y + 1);
#         return true;
#     }
#     return false;
# }

# int main() {
#     cin >> n >> m;
#     for (int i = 0; i < n; i++) {
#         for (int j = 0; j < m; j++) {
#             scanf("%1d", &graph[i][j]);
#         }
#     }
#     int result = 0;
#     for (int i = 0; i < n; i++) {
#         for (int j = 0; j < m; j++) {
#             if (dfs(i, j)) {
#                 result += 1;
#             }
#         }
#     }
#     cout << result << '\n';
# }