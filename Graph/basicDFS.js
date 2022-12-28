graph = [[], [2, 3, 8], [1, 7], [1, 4, 5], [3, 5], [3, 4], [7], [2, 6, 8], [1, 7]];

const dfs = (graph, v, visited) => {
  visited[v] = true;
  process.stdout.write(v + ' ');

  for (const value of graph[v]) {
    if (visited[value] === false) dfs(graph, value, visited);
  }
};

const visited = Array(9).fill(false);
dfs(graph, 1, visited);
