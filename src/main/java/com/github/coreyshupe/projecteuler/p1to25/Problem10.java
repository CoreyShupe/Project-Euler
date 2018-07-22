package com.github.coreyshupe.projecteuler.p1to25;

import com.github.coreyshupe.projecteuler.MathUtils;
import com.github.coreyshupe.projecteuler.Problem;
import com.github.coreyshupe.projecteuler.ProjectEulerProblem;

/**
 * To solve this problem, you must find the sum of all prime numbers under 2 million.
 *
 * @see <a href="https://projecteuler.net/problem=10">Problem 10</a>
 */
@ProjectEulerProblem(10)
public class Problem10 implements Problem<Long> {

    @Override
    public Long getSolution() {
        long sum = 5;
        for(int i = 5; i < 2_000_000; i+=2) {
            if(MathUtils.isPrime(i)) {
                sum += i;
            }
        }
        return sum;
    }
}
