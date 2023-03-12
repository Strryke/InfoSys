package piano;

import javax.sound.midi.MidiUnavailableException;

import midi.Midi;
import music.Pitch;

/**
 * Created by ngaiman_cheung on 17/10/16.
 */
public class TestPiano {
    public static void main(String[] args) {

        try {
            Midi midi;
            PianoMachine pm;
            midi = Midi.getInstance();
            midi.clearHistory();
            pm = new PianoMachine();


            pm.toggleRecording();

            pm.beginNote(new Pitch(3));

            pm.beginNote(new Pitch(5));

            Midi.rest(10);

            pm.endNote(new Pitch(3));

            pm.endNote(new Pitch(5));

            pm.toggleRecording();
            pm.playback();
            Midi.rest(1000);


        }
        catch (Exception ex) {
            ex.printStackTrace();
        }



    }

}