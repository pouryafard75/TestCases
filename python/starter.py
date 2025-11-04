def parse_ints(s):
    parts = s.split(',')
    nums = []
    for p in parts:
        if p.strip() != '':
            nums.append(int(p))
    return nums

def mean(nums):
    return sum(nums) / len(nums)
