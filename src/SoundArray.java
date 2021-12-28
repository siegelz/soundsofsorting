import edu.princeton.cs.algs4.StdAudio;

import java.util.LinkedList;

public class SoundArray {
    private final int[] arr; // array of values
    private final double pitchOffset; // frequency of element with value 0
    private final double pitchMult; // frequency increase per value increase
    private double pitchDuration; // duration of note per element
    private LinkedList<Double> audioRecord; // record of all sounds played

    public SoundArray(int length, double pitchOffset, double pitchMult, double pitchDuration) {
        arr = new int[length];
        this.pitchOffset = pitchOffset;
        this.pitchMult = pitchMult;
        this.pitchDuration = pitchDuration;
        this.audioRecord = new LinkedList<>();

        //for (int i = 0; i < 20; i++) {
        playSound(440, 0.1);
        playSound(450, 0.1);
        //}
    }

    public void setDuration(double duration) {
        this.pitchDuration = duration;
    }

    public double getDuration() {
        return pitchDuration;
    }

    public int length() {
        return arr.length;
    }

    public int get(int i) {
        playSound(pitchOffset + arr[i] * pitchMult, pitchDuration);
        return arr[i];
    }

    public void set(int i, int value) {
        // playSound(pitchOffset + value * pitchMult, pitchDuration);
        arr[i] = value;
    }

    /* @citation Adapted from: https://introcs.cs.princeton.edu/java/15inout/
     * Accessed 12/27/21. */
    private void playSound(double hz, double duration) {
        int SAMPLING_RATE = 44100;
        int n = (int) (SAMPLING_RATE * duration);
        for (int i = 0; i <= n; i++) {
            double a = Math.sin(2 * Math.PI * i * hz / SAMPLING_RATE);
            if ((n - i) < 0.99 * n) {
                a *= (n - i) / (0.99 * n);
            }
            StdAudio.play(a);
            audioRecord.add(a);
        }
    }

    public double[] audioRecord() {
        double[] arr = new double[audioRecord.size()];
        int i = 0;
        for (double e : audioRecord)
            arr[i++] = e;
        return arr;
    }

    public void clearAudioRecord() {
        audioRecord = new LinkedList<>();
    }

    public static void main(String[] args) {
        SoundArray s1 = new SoundArray(0, 0, 0, 0);
    }
}
