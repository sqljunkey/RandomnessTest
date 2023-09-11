import java.util.ArrayList;
import java.util.List;

public class ParseCommandLine {

    String filename = "";
    Integer permutationLength;
    Integer testIterations ;



    public String getFilename(){return filename;}
    public int getTestIterations(){return testIterations;}
    public int permutationLength(){return permutationLength;}

    class Parameter{

        String parameter = "";
        List<String> values = new ArrayList<>();

        Parameter(String parameter){
            this.parameter=parameter;
        }

        void addValue(String value){
            if(value!=null && !values.contains(value)){
                values.add(value);
            }

        }

        String getValue(){
            if(values.isEmpty()){
                return "0";
            }
            return values.get(0);
        }



    }

    List<Parameter> parameters = new ArrayList<>();

    public void parse(String[] args) throws Exception {

        populateParameters(args);


        extractParameters();


        checkIfCommandIsWellFormed();

    }

    private void populateParameters(String[] args) {
        for (int i = 0; i < args.length; i++) {

                    if(args[i].contains("-")){
                        parameters.add(new Parameter(args[i]));
                    }
                    else if(!parameters.isEmpty()){
                        parameters.get(parameters.size()-1).addValue(args[i]);
                    }

        }
    }

    private void extractParameters() {
        for(Parameter parameter: parameters){
            if(parameter.parameter.equals("-f")){

                filename=parameter.getValue();
            }
            if(parameter.parameter.equals("-s")){

                permutationLength = Integer.parseInt(parameter.getValue());
            }
            if(parameter.parameter.equals("-i")){

                testIterations= Integer.parseInt(parameter.getValue());
            }


        }
    }

    private void checkIfCommandIsWellFormed() throws MalformedCommandLineArgument {
        if (filename.equals("") || filename.equals("0") || permutationLength == 0 || testIterations == 0) {
            throw new MalformedCommandLineArgument("Usage: java -jar permutations -f file.bits -s 10 -i 100000000");
        }
    }

    public class MalformedCommandLineArgument extends Exception {
        public MalformedCommandLineArgument(String errorMessage) {
            super(errorMessage);
        }
    }


}
