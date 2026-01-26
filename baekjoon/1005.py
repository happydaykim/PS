from collections import deque
import sys

input = sys.stdin.readline

def sol(N, K):
    indegree = [0] * (N + 1)
    graph = [[] for _ in range(N + 1)]

    times = [0] + list(map(int, input().split()))
    cost = times[:]

    for _ in range(K):
        a, b = map(int, input().split())
        indegree[b] += 1
        graph[a].append(b)

    q = deque()

    for i in range(1, N + 1):
        if indegree[i] == 0:
            q.append(i)

    W = int(input())

    while q:
        now = q.popleft()
        if now == W:
            print(cost[W])
            return

        for nxt in graph[now]:
            indegree[nxt] -= 1
            cost[nxt] = max(cost[nxt], cost[now] + times[nxt])
            if indegree[nxt] == 0:
                q.append(nxt)

    print(cost[W])

T = int(input())
for _ in range(T):
    N, K = map(int, input().split())
    sol(N, K)