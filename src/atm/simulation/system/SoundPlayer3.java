package atm.simulation.system;

import javax.sound.sampled.*;
import java.io.File;

public class SoundPlayer3 {

    public static void play() {
        new Thread(() -> {
            try {
                File soundFile = new File(
                        "C:\\Users\\purve\\OneDrive\\Desktop\\JAVA PROJECT\\BANK MANAGEMENT SYSTEM\\src\\project_images\\cashwithdraw.wav"
                );

                AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
                Clip clip = AudioSystem.getClip();
                clip.open(audioIn);

                clip.start();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}