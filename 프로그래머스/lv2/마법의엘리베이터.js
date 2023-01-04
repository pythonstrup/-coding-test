// 효율성은 꽤 좋게 나옴. 전부 0.08ms 이내
function solution(storey) {
  let answer = 0;
  let number = 0;
  let criteria = 1;
  while (storey - criteria >= 0) {
    criteria *= 10;
    const number = storey % criteria;
    const nextNumber = parseInt((storey % (criteria * 10)) / criteria);

    if (number === 5 && nextNumber >= 5) {
      answer += parseInt((criteria - number) / (criteria / 10));
      storey += criteria - number;
    } else if (number <= criteria - number) {
      answer += parseInt(number / (criteria / 10));
      storey -= number;
    } else {
      answer += parseInt((criteria - number) / (criteria / 10));
      storey += criteria - number;
    }
  }
  return answer;
}

// 가장 감명깊었던 풀이
function solution(storey) {
  if (storey < 5) return storey;
  const r = storey % 10;
  const m = (storey - r) / 10;
  return Math.min(r + solution(m), 10 - r + solution(m + 1));
}

// 감명깊은 풀이2
// 나도 사실 dfs로 풀고 싶었는데.. 풀 자신이 없었다.
function solution(storey) {
  let answer = Number.MAX_SAFE_INTEGER;

  const dfs = (num, counter) => {
    if (counter >= answer) return;
    if (num === 0) {
      answer = counter;
      return;
    }

    let res = num % 10;

    dfs((num - res) / 10, counter + res);
    dfs((num - res) / 10 + 1, counter + 10 - res);
  };

  dfs(storey, 0);
  return answer;
}
