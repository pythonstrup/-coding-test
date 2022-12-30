function solution(n) {
  let answer = 0;

  function backtracking(board, x) {
    if (n === x) {
      answer += 1;
      return;
    }

    for (let i = 1; i <= n; i++) {
      board[x + 1] = i;
      if (check(board, x + 1)) {
        backtracking(board, x + 1);
      }
    }
  }

  function check(board, x) {
    for (let i = 1; i < x; i++) {
      if (board[i] === board[x]) {
        return false;
      }
      if (Math.abs(board[i] - board[x]) === x - i) {
        return false;
      }
    }
    return true;
  }

  for (let i = 1; i <= n; i++) {
    const board = Array(n + 1).fill(0);
    board[1] = i;
    backtracking(board, 1);
  }
  return answer;
}
