import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class SoundsOfSorting {
    private static void randomizeArray(SoundArray arr, int maxValue) {
        double duration = arr.getDuration();
        arr.setDuration(0);
        for (int i = 0; i < arr.length(); i++)
            arr.set(i, StdRandom.uniform(maxValue));
        arr.setDuration(duration);
    }

    public static void main(String[] args) {
        SoundArray arr1 = new SoundArray(15, 300, 2, 0.1);

        // insertion sort
        randomizeArray(arr1, 100);
        InsertionSound.sort(arr1);
        for (int i = 0; i < arr1.length(); i++)
            StdOut.println(arr1.get(i));
        StdAudio.save("insertion.wav", arr1.audioRecord());
        arr1.clearAudioRecord();

        // selection sort
        randomizeArray(arr1, 100);
        SelectionSound.sort(arr1);
        for (int i = 0; i < arr1.length(); i++)
            StdOut.println(arr1.get(i));
        StdAudio.save("selection.wav", arr1.audioRecord());
        arr1.clearAudioRecord();
    }
}
