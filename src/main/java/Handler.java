public class Handler {


    public static void main(String[] args){



        String filename = "";
        Integer permutationLength=0;
        Integer testIterations = 0;

        try {



            for(int i = 0; i < args.length; i ++){

                if(args[i].equals("-f") && i< args.length-1) {
                  filename = args[i+1];
                  continue;
                }

                if(args[i].equals("-s") && i< args.length-1) {
                    permutationLength= Integer.getInteger(args[i+1]);
                    continue;
                }

                if(args[i].equals("-i") && i< args.length-1) {
                    testIterations = Integer.getInteger(args[i+1]);
                    continue;
                }




            }
            if(filename.equals("") || permutationLength ==0 || testIterations ==0 ) {
                throw new Exception("Usage: java -jar perturbations -f file.bits -s 10 -i 100000000");
            }
            PatternDistributionTest pd = new PatternDistributionTest( permutationLength);
            pd.loadData("file");

            pd.calculateDistribution(testIterations);
            pd.identityPermutationTest(testIterations);

        }catch(Exception e){
            e.printStackTrace();
        }



    }
}