package LeetCode;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Chris Yang
 * created 2022-06-08 13:25
 **/
public class temp {
    public void print() throws IOException {
        String temp = "3_0\n" +
                "1_0\n" +
                "2_0\n" +
                "4_0\n" +
                "5_0\n" +
                "5_1\n" +
                "88_0\n" +
                "P2_0\n" +
                "P3_0\n" +
                "11_0\n" +
                "7_1\n" +
                "10_0\n" +
                "11_1\n" +
                "13_0\n" +
                "30_0\n" +
                "30_1\n" +
                "70_0\n" +
                "P1_0\n" +
                "70_1\n" +
                "72_1\n" +
                "P2_1\n" +
                "76_0\n" +
                "78_1\n" +
                "76_1\n" +
                "78_0\n" +
                "83_0\n" +
                "83_1\n" +
                "86_0\n" +
                "48_1\n" +
                "12_0\n" +
                "48_0\n" +
                "1_1\n" +
                "14_0\n" +
                "15_0\n" +
                "2_1\n" +
                "29_0\n" +
                "29_2\n" +
                "15_1\n" +
                "3_2\n" +
                "3_1\n" +
                "31_0\n" +
                "33_0\n" +
                "34_0\n" +
                "35_0\n" +
                "41_0\n" +
                "53_0\n" +
                "14_1\n" +
                "29_1\n" +
                "33_1\n" +
                "35_1\n" +
                "4_1\n" +
                "41_1\n" +
                "42_0\n" +
                "42_1\n" +
                "43_0\n" +
                "45_0\n" +
                "45_1\n" +
                "46_0\n" +
                "46_1\n" +
                "47_0\n" +
                "47_1\n" +
                "49_0\n" +
                "5_2\n" +
                "50_0\n" +
                "50_1\n" +
                "51_0\n" +
                "51_1\n" +
                "52_0\n" +
                "52_1\n" +
                "57_0\n" +
                "57_1\n" +
                "58_0\n" +
                "58_1\n" +
                "59_0\n" +
                "6_0\n" +
                "63_2\n" +
                "71_0\n" +
                "59_1\n" +
                "6_1\n" +
                "6_2\n" +
                "61_0\n" +
                "63_0\n" +
                "63_1\n" +
                "69_0\n" +
                "69_1\n" +
                "72_0\n" +
                "84_0\n" +
                "87_0\n" +
                "89-1_0\n" +
                "89-2_0\n" +
                "91_0\n" +
                "7_0\n" +
                "71_1\n" +
                "71_2\n" +
                "73_0\n" +
                "73_1\n" +
                "74_0\n" +
                "74_1\n" +
                "75_0\n" +
                "77_0\n" +
                "77_1\n" +
                "79_0\n" +
                "79_1\n" +
                "80_0\n" +
                "80_1\n" +
                "81_0\n" +
                "81_1\n" +
                "82_0\n" +
                "82_1\n" +
                "85_0\n" +
                "85_1\n" +
                "86_1\n" +
                "87_1\n" +
                "87_2\n" +
                "9_0\n" +
                "92_0\n" +
                "92_1";
        String[] temps = temp.split("\n");
        for (int i = 0; i < temps.length; i++) {
            BufferedWriter bw = new BufferedWriter(new FileWriter("/Users/yxh/Downloads/temp/" + temps[i] + ".txt"));
            bw.write("@Author: Xiaohan\n" +
                    "@Email: xhanyang@genetics.ac.cn\n" +
                    "\n" +
                    "#This hapscanner pipeline is used to test the IBS matrix and give the final possible samples\n" +
                    "\n" +
                    "#####File parameter -- genotypeDir,bamDir,outputDir,plate\n" +
                    "#Parameter1:\tGenotypeDir\n" +
                    "/data2/junxu/Filter3/\n" +
                    "\n" +
                    "#Parameter2:\tBamDir\n" +
                    "/data2/junxu/SiPAS-tools/" + temps[i] + "/sams/\n" +
                    "\n" +
                    "#Parameter3:\tplate\n" +
                    temps[i] + "\n" +
                    "\n" +
                    "#Parameter4:\tOutputDir\n" +
                    "/data2/xiaohan/hapscanner/output/\n" +
                    "\n" +
                    "#######Hapscanner parameter -- parameterDir,taxaRefBAMDir,posDir,posAlleleDir,referenceDir\n" +
                    "#Parameter5:\tparameterDir\n" +
                    "/data2/xiaohan/hapscanner/parameter\n" +
                    "\n" +
                    "#Parameter6:\ttaxaRefBAMDir\n" +
                    "/data2/xiaohan/hapscanner/taxaRefBAM\n" +
                    "\n" +
                    "#Parameter7:\tposDir\n" +
                    "/data2/xiaohan/hapscanner/poseQTL\n" +
                    "\n" +
                    "#Parameter8:\tposAlleleDir\n" +
                    "/data2/xiaohan/hapscanner/posAlleleeQTL\n" +
                    "\n" +
                    "#Parameter9:\treferenceDir\n" +
                    "/data2/xiaohan/hapscanner/ref\n" +
                    "\n" +
                    "######utils\n" +
                    "#Parameter10:\tsamtools\n" +
                    "/data1/home/xiaohan/miniconda3/bin/samtools\n" +
                    "\n" +
                    "#Parameter11:\tthread\n" +
                    "32\n" +
                    "\n" +
                    "#Parameter12:\tchrNumber\n" +
                    "42\n" +
                    "\n" +
                    "#Parameter13:\trate\n" +
                    "0.4");
            bw.flush();
            bw.close();
        }
    }
}
