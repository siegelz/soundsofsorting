import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdIn;
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
        StdOut.println("Which sort would you like to hear? Answer insertion, selection, merge, quick, or heap.");
        String answer = StdIn.readLine().toLowerCase();
        SoundArray arrSmall = new SoundArray(15, 300, 1, 0.1);
        SoundArray arrLarge = new SoundArray(50, 300, 1, 0.1);

        switch (answer) {
            case "insertion":
                randomizeArray(arrSmall, 100);
                InsertionSound.sort(arrSmall);
                for (int i = 0; i < arrSmall.length(); i++)
                    StdOut.println(arrSmall.get(i));
                StdAudio.save("insertion.wav", arrSmall.audioRecord());
                arrSmall.clearAudioRecord();
                break;
            case "selection":
                randomizeArray(arrSmall, 100);
                SelectionSound.sort(arrSmall);
                for (int i = 0; i < arrSmall.length(); i++)
                    StdOut.println(arrSmall.get(i));
                StdAudio.save("selection.wav", arrSmall.audioRecord());
                arrSmall.clearAudioRecord();
                break;
            case "merge":
                randomizeArray(arrLarge, 100);
                MergeSound.sort(arrLarge);
                for (int i = 0; i < arrLarge.length(); i++)
                    StdOut.println(arrLarge.get(i));
                StdAudio.save("merge.wav", arrLarge.audioRecord());
                arrLarge.clearAudioRecord();
                break;
            case "quick":
                randomizeArray(arrLarge, 100);
                QuickSound.sort(arrLarge);
                for (int i = 0; i < arrLarge.length(); i++)
                    StdOut.println(arrLarge.get(i));
                StdAudio.save("quick.wav", arrLarge.audioRecord());
                arrLarge.clearAudioRecord();
                break;
            case "heap":
                randomizeArray(arrSmall, 100);
                HeapSound.sort(arrSmall);
                for (int i = 0; i < arrSmall.length(); i++)
                    StdOut.println(arrSmall.get(i));
                StdAudio.save("heap.wav", arrSmall.audioRecord());
                arrSmall.clearAudioRecord();
                break;
            default:
                StdOut.println("Invalid choice.");
        }
    }
}
