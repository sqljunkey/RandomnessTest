import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Util {

    public static int getRandomInterval(int min, int max){

        Random r = new Random();

        int result = r.nextInt(max - min + 1) + min;

        return result;

    }

    public static List<String> getDataListFromFile(String list) {
        FileInputStream fstream = null;

        List<String> resetList = new ArrayList<>();
        try {
            fstream = new FileInputStream(list);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

            String strLine;


            while ((strLine = br.readLine()) != null) {

                resetList.add(strLine);
            }
            fstream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resetList;
    }

    static public List<String> generatePermutationsBinaryStrings(int n) {
        List<String> result = new ArrayList<>();
        int[] binaryString = new int[n];
        generateBinaryStringsHelper(binaryString, n, 0, result);
        return result;
    }

   static public  void generateBinaryStringsHelper(int[] binaryString, int n, int currentIndex, List<String> result) {
        if (currentIndex == n) {

            StringBuilder permutation = new StringBuilder();
            for (int i : binaryString) {
                permutation.append(i);
            }
            result.add(permutation.toString());
        } else {

            for (int i = 0; i <= 1; i++) {
                binaryString[currentIndex] = i;
                generateBinaryStringsHelper(binaryString, n, currentIndex + 1, result);
            }
        }
    }



}
