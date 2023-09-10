import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PatternDistributionTest {

    DecimalFormat fte = new DecimalFormat("###,###,##0.00");
    String data = "";
    int permutationLength =0;



    List<Permutation> permutations = new ArrayList<>();

    PatternDistributionTest(int length){
        this.permutationLength = length;

        List<String> returnValues = Util.generatePermutationsBinaryStrings(permutationLength);
        for(String permutation: returnValues){

            permutations.add(new Permutation(permutation));

        }

    }

    public void loadData(String file) throws Exception{

            List<String> info= Util.getDataListFromFile(file);

            for(String line: info){
                data+=line;

            }

            if(data.contains("0")){

            }else if (data.contains("1")){

            }else{

                throw new Exception("ERROR: File contains something other than 1 or 0.");

            }

    }





    public void calculateDistribution(int iterations){

        for(int i = 0; i < iterations; i++){

           int position = Util.getRandomInterval(0,data.length()- permutationLength);

           String subSection = data.substring(position,position+permutationLength);


           for(Permutation permutation: permutations){

               if(permutation.getPermutation().equals(subSection)){
                   permutation.increaseOccurrence();

               }



           }




        }


        System.out.println("====Final=====");
        System.out.println("");

        Collections.sort(permutations, Comparator.comparing(Permutation::getOccurrence));

        for(Permutation permutation:permutations){
            System.out.println(permutation.getPermutation()
                    +" : "+
                    fte.format(permutation.getOccurrence()/(double)iterations*100.0+"%"));


        }


    }

    public void identityPermutationTest(int length){

        for(Permutation permutation: permutations){

            permutation.reset();

        }

        for(int i =0 ; i < length; i++){

            int position = Util.getRandomInterval(0, permutations.size()-1);


            for(Permutation permutation: permutations){

               if(permutation.getPermutation().equals(permutations.get(position).getPermutation())){
                   permutation.increaseOccurrence();
               }

            }

        }

        System.out.println("=====Identity=====");
        System.out.println("");

        Collections.sort(permutations, Comparator.comparing(Permutation::getOccurrence));

        for(Permutation permutation:permutations){
            System.out.println(permutation.getPermutation()
                    +" : "+
                    permutation.getOccurrence()/(double)length*100.0+"%");


        }



    }













}
