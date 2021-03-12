package education;

public class Main {

    public static void main(String[] args) {
        /*long avg = 0;
        Qsort.setPrintLog(false);
        int length = 100;
        int[] arr = new int[length];
        int fifty;
        for (int i = 0; i < length; i++) {
            arr[i] = ThreadLocalRandom.current().nextInt();
            if (i==50)
                fifty=arr[i];
        }
        int[] array = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        //System.out.println(Arrays.toString(array));
        *//*int tests = 1000;
        for (int j = 0; j < tests; j++) {
            for (int i = 0; i < length; i++) {
                arr[i] = ThreadLocalRandom.current().nextInt(-99, 100);
            }
            Qsort.sort(arr);
            *//**//*System.out.println(Arrays.toString(arr));
            System.out.println("Counter: " + Qsort.getCounter);*//**//*
            avg += Qsort.getCounter;
        }*//*
        var array1 = array.clone();
        Instant startMy = Instant.now();
        Qsort.sort(array);
        Instant finishMy = Instant.now();
        long durationMy = Duration.between(startMy, finishMy).toNanos();
        Instant start = Instant.now();
        Arrays.sort(array1);
        Instant finish = Instant.now();
        long duration = Duration.between(start, finish).toNanos();
        System.out.println("MY: "+durationMy+"\nJava: "+duration);

*/

        Tree t = new Tree(10);
        t.add(5);
        t.add(15);
        t.add(3);
        t.add(8);
        t.add(12);
        t.add(18);
        t.goBreadth();
        System.out.println(t);
    }
}
