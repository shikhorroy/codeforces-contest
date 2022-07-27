# Matrix Chain Multiplication (MCM)

> ### [[GFG] Matrix Chain Multiplication](https://practice.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1)

**Short Description:**

Given dimensions of some matrix in an **arr[]**. Find minimum cost to multiply these matrices.

Example 1:

    Input: N = 5
    arr = {40, 20, 30, 10, 30}
    Output: 26000

    Explaination: There are 4 matrices of dimension
    40x20, 20x30, 30x10, 10x30. Say the matrices are
    named as A, B, C, D. Out of all possible combinations,
    the most efficient way is (A*(B*C))*D.
    The number of operations are -
    20*30*10 + 40*20*10 + 40*10*30 = 26000.

Example 2:

    Input: N = 4
    arr = {10, 30, 5, 60}
    Output: 4500

    Explaination: The matrices have dimensions
    10*30, 30*5, 5*60. Say the matrices are A, B
    and C. Out of all possible combinations,the
    most efficient way is (A*B)*C. The
    number of multiplications are -
    10*30*5 + 10*5*60 = 4500.

