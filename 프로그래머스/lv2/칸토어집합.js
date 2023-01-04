// 무식하게 정규식으로 바꿔서 직접 세기 - 100% 시간 초과될 거라고 생각
// 역시 예상대로 시간 초과됨 => 수학적으로 풀어야할 것 같다.
function solution(n, l, r) {
  let str = '1';
  for (let i = 1; i <= n; i++) {
    const zero = /0/g;
    const one = /1/g;
    str = str.replace(zero, (value) => {
      return '00000';
    });
    str = str.replace(one, (value) => {
      return '11011';
    });
  }

  let answer = 0;
  for (let i = l - 1; i < r; i++) {
    if (str[i] === '1') answer += 1;
  }

  return answer;
}

// 잘 살펴보니 유사 칸토업 집합은 특정 패턴이 반복되는 특징을 가지고 있다.
// 25개의 나열 하나당 1을 16개를 가지고 있다.
// 사실상 n도 쓸모가 없는 문제
function solution(n, l, r) {
  const countNumber = (number) => {
    let count = 0;
    if (number <= 5)
      return '11011'
        .split('')
        .slice(0, number)
        .reduce((acc, cur) => {
          if (cur === '1') return acc + 1;
          return acc;
        }, 0);

    let multiplier = 1;
    while (number > Math.pow(5, multiplier + 1)) {
      multiplier += 1;
    }
    const criteria = Math.pow(5, multiplier);
    const part = parseInt(number / criteria);
    const remainder = number % criteria;
    count += part * Math.pow(4, multiplier);

    if (part === 2) return count;
    else {
      if (part > 2) count -= Math.pow(4, multiplier);
      return count + countNumber(remainder);
    }
    return count;
  };

  return countNumber(r) - countNumber(l - 1);
}

// 5진수로 문제를 풀어버린 신기한 사람들도 있었다.
// 대신 효율성이 엄청 나쁘다.
function solution(n, l, r) {
  let answer = 0;
  for (let i = l - 1; i <= r - 1; i++) {
    if (!i.toString(5).match('2')) answer += 1;
  }
  return answer;
}
