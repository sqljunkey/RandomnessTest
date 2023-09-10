public class Handler {


    public static void main(String[] args){


        try {
            ParseCommandLine parser = new ParseCommandLine();
            parser.parse(args);



            PatternDistributionTest pd = new PatternDistributionTest( parser.permutationLength());
            pd.loadData("file");

            pd.calculateDistribution(parser.getTestIterations());
            pd.identityPermutationTest(parser.getTestIterations());

        }catch(Exception e){
            e.printStackTrace();
        }



    }
}