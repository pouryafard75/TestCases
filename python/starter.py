from typing import Iterable

def parse_ints(s: str) -> list[int]:
    """
    Parse a string of integers separated by commas and/or spaces.
    Ignores extra whitespace and empty tokens.
    """
    # Allow both commas and spaces as separators
    tokens = s.replace(",", " ").split()
    return [int(tok) for tok in tokens]

def mean(nums: Iterable[int]) -> float:
    """
    Compute the arithmetic mean of an iterable of ints.
    Raises ValueError if no numbers are provided.
    """
    values = list(nums)
    if not values:
        raise ValueError("mean() requires at least one number")
    return sum(values) / len(values)
