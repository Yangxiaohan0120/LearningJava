package LeetCode;

import DataStructureAndAlgorithm.Linear.array.Array;

import java.util.Arrays;

/**
 * @author Chris Yang
 * created 2022-03-28 17:27
 **/
public class AverageSalaryExcludeMinMax {

    public double average(int[] salary) {
        Arrays.sort(salary);

        double mean = 0;
        for (int i = 1; i < salary.length - 1; i++) {
            mean += salary[i];
        }

        mean = mean  / (salary.length-2 + 0.0);

        return mean;
    }
}
