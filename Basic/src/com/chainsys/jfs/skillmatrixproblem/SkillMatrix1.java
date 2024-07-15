package com.chainsys.jfs.skillmatrixproblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SkillMatrix1 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = scanner.nextInt();
        System.out.print("Enter the value of k: ");
        int k = scanner.nextInt();

        List<List<Integer>> results = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        int start = 1;
        int currentSum = 0;

        int[] indices = new int[k];

        while (indices[0] < n - k + 1) {
            path.clear();
            currentSum = 0;

            for (int i = 0; i < k; i++) {
                path.add(indices[i] + start);
                currentSum += indices[i] + start;
            }

            if (currentSum == n) {
                results.add(new ArrayList<>(path));
            }

            indices[k - 1]++;

            for (int i = k - 1; i > 0; i--) {
                if (indices[i] > n - k + i) {
                    indices[i - 1]++;
                    indices[i] = indices[i - 1] + 1;
                }
            }
        }

        System.out.println("Valid combinations of " + k + " numbers that sum up to " + n + ":");
        for (List<Integer> combination : results) {
            System.out.println(combination);
        }
    }
}
