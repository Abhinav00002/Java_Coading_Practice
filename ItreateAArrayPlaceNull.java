import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ItreateAArrayPlaceNull {
    
    public static void main(String args[]){
      List<Integer> num=Arrays.asList(1,2,3,4,1,0,2,0,3,0,1,2,03,303,3,2,0,1,0,293,23,2);

      //Identify the position of 0 and 1
      List<Integer> nullPosition=IntStream.range(0,num.size()).filter(i->num.get(i)==0 || num.get(i)==1)
        .boxed().collect(Collectors.toList());
        System.out.println("Null Position: "+nullPosition);

        
      //collect and sort Non null 
          List<Integer> nonNullElements=num.stream().filter(val -> val != 0 && val != 1)
            .sorted()
            .collect(Collectors.toList());
            System.out.println("Non Null List: "+ nonNullElements);

      //track a index of non null and placed back  
        List<Integer> sortedList=new ArrayList<>(num);

        int nonNullIndex=0;
        for(int i=0;i<sortedList.size();i++){
            if(!nullPosition.contains(i)){
                sortedList.set(i, nonNullElements.get(nonNullIndex++));
            }else{
                sortedList.set(i,null);
            }
        }
        System.out.println("Sorted List: "+sortedList);
    }
}
