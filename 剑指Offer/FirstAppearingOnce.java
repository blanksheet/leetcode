import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by tianze
 * 2019/1/6 15:15
 */
public class FirstAppearingOnce {
    //Insert one char from stringstream
    static  LinkedList<Character> linkedList = new LinkedList<>();
    public static void Insert(char ch)
    {
       if(!linkedList.contains(ch)){
           linkedList.add(ch);
       }
       else {
           for(int i = 0; i < linkedList.size(); i++){
               if(linkedList.get(i) == ch){
                   linkedList.remove(i);
               }
           }
       }

    }
    //return the first appearence once char in current stringstream
    public static char FirstAppearingOnce()
    {
        if(linkedList.isEmpty()){
            return '#';
        }
        else {
            return linkedList.getFirst();
        }

    }

    public static void main(String[] args){
        Insert('h');
        System.out.println(FirstAppearingOnce());
        Insert('e');
        System.out.println(FirstAppearingOnce());
        Insert('l');
        System.out.println(FirstAppearingOnce());
        Insert('l');
        System.out.println(FirstAppearingOnce());
        Insert('o');
        System.out.println(FirstAppearingOnce());

    }

}
