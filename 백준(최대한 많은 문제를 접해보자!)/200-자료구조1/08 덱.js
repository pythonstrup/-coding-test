let fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
let input = fs.readFileSync(filePath).toString().trim().split('\n');

input.shift();

input = input.map((v) => v.trim().split(' '));

let deque = [];
let answer = [];

for (let command of input) {
  if (command[0] === 'push_front') deque.unshift(command[1]);
  if (command[0] === 'push_back') deque.push(command[1]);
  if (command[0] === 'pop_front') {
    if (deque.length) answer.push(deque.shift());
    else answer.push(-1);
  }
  if (command[0] === 'pop_back') {
    if (deque.length) answer.push(deque.pop());
    else answer.push(-1);
  }
  if (command[0] === 'size') answer.push(deque.length);
  if (command[0] === 'empty') {
    if (deque.length) answer.push(0);
    else answer.push(1);
  }
  if (command[0] === 'front') {
    if (deque.length) answer.push(deque[0]);
    else answer.push(-1);
  }
  if (command[0] === 'back') {
    if (deque.length) answer.push(deque[deque.length - 1]);
    else answer.push(-1);
  }
}

console.log(answer.join('\n'));

//
//
// 다른 풀이
const I = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n');
const [N, deque, O] = [+I[0], [], []];
for (let i = 1; i <= N; i++) {
  const [command, num] = I[i].split(' ');
  const l = deque.length;
  switch (command) {
    case 'push_back':
      deque.push(num);
      break;
    case 'push_front':
      deque.unshift(num);
      break;
    case 'pop_back':
      O.push(l ? deque.pop() : -1);
      break;
    case 'pop_front':
      O.push(l ? deque.shift() : -1);
      break;
    case 'size':
      O.push(l);
      break;
    case 'empty':
      O.push(+!l);
      break;
    case 'front':
      O.push(l ? deque[0] : -1);
      break;
    case 'back':
      O.push(l ? deque[l - 1] : -1);
      break;
  }
}
console.log(O.join('\n'));
