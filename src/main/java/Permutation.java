public class Permutation {

        String data;
        Double occurrence=0.0;

        Permutation(String data){
            this.data = data;
        }

        public String getPermutation(){
            return data;
        }

        public void increaseOccurrence(){
            occurrence++;
        }

        public Double getOccurrence(){
            return occurrence;
        }

        public void reset(){
            occurrence=0.0;
        }


}
