import processing.core.PApplet;
public class Main extends PApplet {
    public static int[] i = {345, 98, 423, 867, 234, 567, 756, 534, 423};
    public static int height = 1000;
    public static int width = 1000;
    public static int counter = 0;
    public static int[] x = createArray(1000);

    public static void main(String[] args) {

        PApplet.main("Main");

        insertionSort(x);
    }

    public void settings() {
        size(1000, 1000);
    }

    public void setup() {
        frameRate(60);
    }

    public void draw() {
        fill(0);
        stroke(0);
        background(255);
        for(int j = 0; j<x.length; j++){
            rect(j*width/x.length, height-x[j], width/x.length, x[j]);
        }
    }

    public static void BogoSort(int[] i) {

        while (!isSorted(i)) {
            shuffle(i);
            counter++;
            /*
             * if(counter%1000000==0) { System.out.println(counter); }
             */

        }
        System.out.println("Solution found! (shuffled " + counter + " times)");
        print(i);
    }


    private static void shuffle(int[] i) {
        for (int x = 0; x < i.length; ++x) {
            int index1 = (int) (Math.random() * i.length);
            int index2 = (int) (Math.random() * i.length);
            int a = i[index1];
            i[index1] = i[index2];
            i[index2] = a;
        }
    }

    private static boolean isSorted(int[] i) {
        for (int x = 0; x < i.length - 1; ++x) {
            if (i[x] > i[x + 1]) {
                return false;
            }
        }
        return true;
    }
    public static int[] createArray(int size){
        int[] arr = new int[size];

        for (int i=0;i<arr.length; i++){
            arr[i] = (int)(Math.random() * 1000);
        }

        return arr;
    }
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j])
                    minIndex = j;
                try {
                    Thread.currentThread().sleep(1);
                }catch(Exception e){
                    System.out.println(e);
                }
            }

            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public static void insertionSort(int[] arr) {

        for(int i=1; i<arr.length; i++) {
            int temp = arr[i];
            int j;
            for(j = i-1; j>=0 && temp < arr[j]; j--) {
                arr[j+1] = arr[j];
                try {
                    Thread.currentThread().sleep(1);
                }catch(Exception e){
                    System.out.println(e);
                }
            }

            arr[j+1] = temp;
        }

    }
}