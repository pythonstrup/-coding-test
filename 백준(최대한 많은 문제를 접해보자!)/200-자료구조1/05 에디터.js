const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
let input = fs.readFileSync(filePath).toString().trim().split('\n');

const str = input
  .splice(0, 1)[0]
  .split('')
  .filter((val) => val !== '\r');

const n = parseInt(input.splice(0, 1));

const mySolution = (str, data) => {
  let lStack = str;
  let rStack = [];

  for (let d of data) {
    const oper = d[0];

    if (oper === 'P') {
      lStack.push(d[2]);
    } else if (oper === 'L' && lStack.length) {
      rStack.push(lStack.pop());
    } else if (oper === 'D' && rStack.length) {
      lStack.push(rStack.pop());
    } else if (oper === 'B' && lStack.length) {
      lStack.pop();
    }
  }

  return lStack.concat(rStack.reverse()).join('');
};

console.log(mySolution(str, input));
