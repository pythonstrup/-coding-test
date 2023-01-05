const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
let [count, inputs] = fs.readFileSync(filePath).toString().trim().split('\n');
inputs = inputs.split(' ').map(Number);

/**
 *
 * @param {number} count
 * @param {number[]} inputs
 */
function solution(count, inputs) {
  inputs = [0, ...inputs];
  const cache = new Array(count + 1).fill(0);

  for (let i = 1; i <= count; i++) {
    for (let j = 1; j <= i; j++) {
      cache[i] = Math.max(cache[i], cache[i - j] + inputs[j]);
    }
  }
  return cache[count];
}

console.log(solution(Number(count), inputs));

//
//
//
// ctrl+alt+n
var input = require('fs').readFileSync('/dev/stdin').toString().split('\n');
// let input = require("fs").readFileSync("example.txt").toString().split("\n");

const n = +input.shift();
const arr = input
  .shift()
  .split(' ')
  .map((v) => +v);
const arr2 = [...arr];

for (let i = 1; i < arr.length; i++) {
  // arr2.push(Math.max(arr2[i - 1] + arr[0], arr[i]));
  for (let j = 0; j < i; j++) {
    arr2[i] = Math.max(arr2[j] + arr[i - j - 1], arr2[i]);
  }
}
console.log(arr2[arr2.length - 1]);
