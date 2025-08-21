package mindistance;

public class MinDistance {



    public static int minDistance(String txt, String s1, String s2){

        //Split from " "
        String[] strArr = txt.split("\\s+");
        // Indexes
        int inx1=-1, ind2=-1;
        //Maximum Int Vlaue
        int minDis=Integer.MAX_VALUE;

        for (int i = 0; i < strArr.length; i++) {
            if(strArr[i].equals( s1))
                inx1=i;
            else if (strArr[i].equals(s2)) {
                ind2=i;
            }
            if (inx1 != -1 && ind2 != -1 ){
                //Distence in Between
                int i1 = Math.abs(inx1 - ind2) - 1;
                minDis=Math.min(minDis,i1);
            }
        }
        return  (minDis == Integer.MAX_VALUE)?-1:minDis;
    }

    public static void main(String[] args) {
        System.out.println("Min Distance : "+ minDistance("I am Abhinav Tripathi","I","Tripathi"));
    }
}
