import java.util.*;

class Activity {
    int start, finish;

    Activity(int s, int f) {
        start = s;
        finish = f;
    }
}

public class ActivitySelection {

    public static void main(String args[]) {

        Activity activities[] = {
                new Activity(1,4),
                new Activity(3,5),
                new Activity(0,6),
                new Activity(5,7),
                new Activity(8,9),
                new Activity(5,9)
        };

        Arrays.sort(activities, Comparator.comparingInt(a -> a.finish));

        System.out.println("========= Activity Selection =========");

        System.out.println("\nSelected Activities");

        int i = 0;
        System.out.println("A1 (1,4)");

        for(int j=1;j<activities.length;j++){

            if(activities[j].start >= activities[i].finish){

                System.out.println("A"+(j+1)+" ("+activities[j].start+","+activities[j].finish+")");
                i=j;
            }
        }
    }
}
