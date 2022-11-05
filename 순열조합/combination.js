const getCombinations = (arr, selectNumber) => {
  const result = [];
  if (selectNumber === 1) return arr.map((value) => [value]);

  arr.forEach((fixed, index, origin) => {
    const rest = origin.slice(index + 1);
    const combinations = getCombinations(rest, selectNumber - 1);
    const attached = combinations.map((value) => [fixed, ...value]);
    result.push(...attached);
  });

  return result;
};
