const getPermutations = (arr, selectNumber) => {
  const result = [];
  if (selectNumber === 1) return arr.map((value) => [value]);

  arr.forEach((fixed, index, origin) => {
    const permutations = getPermutations(origin, selectNumber - 1);
    const attached = permutations.map((value) => [fixed, ...value]);
    result.push(...attached);
  });

  return result;
};
