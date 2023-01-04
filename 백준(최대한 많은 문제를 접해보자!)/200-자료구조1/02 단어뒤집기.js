const input = require('fs').readFileSync('/dev/stdin').toString().split('\n');

let result = input.slice(1);

result = result.map((x) => {
  return x.split('').reverse().join('').split(' ').reverse().join(' ');
});

console.log(result.join('\n'));

// 다른 사람 풀이
const input = require('fs').readFileSync('/dev/stdin').toString().split('\n');
const cases = input[0];
let result = '';

for (let i = 1; i <= cases; i++) {
  let splited = input[i].split(' ');
  for (let j in splited) {
    result = result + splited[j].split('').reverse().join('') + ' ';
  }
  result += '\n';
}

console.log(result);
