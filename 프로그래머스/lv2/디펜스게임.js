// 실패1 - 시간초과 - 너무 많은 정렬
function insertionSort(arr) {
  for (let i = 1; i < arr.length; i++) {
    let currentVal = arr[i];
    let j;
    for (j = i - 1; j >= 0 && arr[j] < currentVal; j--) {
      arr[j + 1] = arr[j];
    }
    arr[j + 1] = currentVal;
  }
  return arr;
}

function solution(n, k, enemy) {
  const length = enemy.length;
  let answer = k;

  const array = enemy.slice(0, k).sort((a, b) => b - a);
  let i = 0;
  while (n - enemy[0] > 0) {
    if (enemy[i] > array[k - 1]) {
      answer += 1;
      const out = array.pop();
      n -= out;
      array.push(enemy[i]);
      insertionSort(array);
    }

    i += 1;
  }
  return answer;
}

// 이진탐색
// 테스트 10 〉	통과 (6972.58ms, 133MB)
// 너무 높게 나온다.
function solution(n, k, enemy) {
  let answer = k;
  let right = enemy.length;
  let left = 0;
  let mid = 0;
  if (k === right) return k;

  while (left <= right) {
    mid = Math.floor((left + right) / 2);

    const arr = enemy.slice(0, mid).sort((a, b) => b - a);
    const enemyAmount = arr.reduce((acc, cur, idx) => {
      if (idx < k) return acc;
      else return acc + cur;
    }, 0);

    if (enemyAmount === n) {
      console.log(enemyAmount, n);
      answer = mid;
      break;
    } else if (enemyAmount < n) {
      console.log(enemyAmount, n);
      answer = mid;
      left = mid + 1;
    } else {
      right = mid - 1;
    }
  }

  return answer;
}
