class Node {
  constructor(value) {
    this.value = value;
    this.next = null;
  }
}

class Queue {
  constructor() {
    this.first = null;
    this.last = null;
    this.size = 0;
  }
  enqueue(val) {
    let newNode = new Node(val);
    if (!this.first) {
      this.first = newNode;
      this.last = newNode;
    } else {
      this.last.next = newNode;
      this.last = newNode;
    }
    return ++this.size;
  }
  dequeue() {
    if (!this.first) return null;
    let temp = this.first;
    if (this.first === this.last) {
      this.last = null;
    }
    this.first = this.first.next;
    this.size--;
    return temp.value;
  }
}

graph = [[], [2, 3, 8], [1, 7], [1, 4, 5], [3, 5], [3, 4], [7], [2, 6, 8], [1, 7]];

const dfs = (graph, start, visited) => {
  const queue = new Queue();
  queue.enqueue(start);
  visited[start] = true;

  while (queue.size) {
    const v = queue.dequeue();
    process.stdout.write(v + ' ');

    for (const value of graph[v]) {
      if (visited[value] === false) {
        queue.enqueue(value);
        visited[value] = true;
      }
    }
  }
};

const visited = Array(9).fill(false);
dfs(graph, 1, visited);
