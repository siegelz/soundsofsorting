import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Quiz {
    private static void randomizeArray(SoundArray arr, int maxValue) {
        double duration = arr.getDuration();
        arr.setDuration(0);
        for (int i = 0; i < arr.length(); i++)
            arr.set(i, StdRandom.uniform(maxValue));
        arr.setDuration(duration);
    }

    public static void main(String[] args) {
        StdOut.println("Welcome to the sorting Quiz! Press enter to start, and I will play a sort.");
        StdIn.readLine();
        int random = StdRandom.uniform(4);

        SoundArray arrSmall = new SoundArray(15, 300, 2, 0.1);
        SoundArray arrLarge = new SoundArray(50, 300, 2, 0.1);
        switch (random) {
            case 0:
                randomizeArray(arrSmall, 100);
                InsertionSound.sort(arrSmall);
                for (int i = 0; i < arrSmall.length(); i++)
                    StdOut.println(arrSmall.get(i));
                StdAudio.save("insertion.wav", arrSmall.audioRecord());
                arrSmall.clearAudioRecord();
                break;
            case 1:
                randomizeArray(arrSmall, 100);
                SelectionSound.sort(arrSmall);
                for (int i = 0; i < arrSmall.length(); i++)
                    StdOut.println(arrSmall.get(i));
                StdAudio.save("selection.wav", arrSmall.audioRecord());
                arrSmall.clearAudioRecord();
                break;
            case 2:
                randomizeArray(arrLarge, 100);
                MergeSound.sort(arrLarge);
                for (int i = 0; i < arrLarge.length(); i++)
                    StdOut.println(arrLarge.get(i));
                StdAudio.save("merge.wav", arrLarge.audioRecord());
                arrLarge.clearAudioRecord();
                break;
            case 3:
                randomizeArray(arrLarge, 100);
                QuickSound.sort(arrLarge);
                for (int i = 0; i < arrLarge.length(); i++)
                    StdOut.println(arrLarge.get(i));
                StdAudio.save("quick.wav", arrLarge.audioRecord());
                arrLarge.clearAudioRecord();
                break;
            default:
                StdOut.println("Invalid choice.");
        }

        StdOut.println("Which sorting algorithm was that? Answer insertion, selection, merge, or quick.");
        String answer = StdIn.readLine();
        boolean repeat = false;
        do {
            switch (random) {
                case 0:
                    if (answer.equals("insertion")) StdOut.println("Correct! Insertion sort.");
                    else StdOut.println("Incorrect! It was insertion sort.");
                    break;
                case 1:
                    if (answer.equals("selection")) StdOut.println("Correct! Selection sort.");
                    else StdOut.println("Incorrect! It was selection sort.");
                    break;
                case 2:
                    if (answer.equals("merge")) StdOut.println("Correct! Merge sort.");
                    else StdOut.println("Incorrect! It was merge sort.");
                    break;
                case 3:
                    if (answer.equals("quick")) StdOut.println("Correct! Quick sort.");
                    else StdOut.println("Incorrect! It was quick sort.");
                    break;
                default:
                    StdOut.println("Invalid response. You must enter insertion, selection, merge, or quick.");
                    repeat = true;
            }
        } while (repeat);
    }
}
