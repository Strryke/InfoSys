package piano;

import java.util.ArrayList;

import javax.sound.midi.MidiUnavailableException;

import midi.Instrument;
import midi.Midi;
import music.Pitch;

public class PianoMachine {
    ArrayList<Pitch> playingNotes = new ArrayList<>();

    Instrument currentInstrument = Instrument.PIANO;
    int currentShift = 0;


    private Midi midi;

    /**
     * constructor for PianoMachine.
     *
     * initialize midi device and any other state that we're storing.
     */
    public PianoMachine() {
        try {
            midi = Midi.getInstance();
        } catch (MidiUnavailableException e1) {
            System.err.println("Could not initialize midi device");
            e1.printStackTrace();
            return;
        }
    }

    //TODO write method spec
    public void beginNote(Pitch rawPitch) {
        rawPitch = rawPitch.transpose(currentShift * 12);
        for (Pitch playing : playingNotes) {
            if (rawPitch.equals(playing)) return;
        }

        midi.beginNote(rawPitch.toMidiFrequency(), currentInstrument);
        playingNotes.add(rawPitch);
    }

    //TODO write method spec
    public void endNote(Pitch rawPitch) {
        rawPitch = rawPitch.transpose(currentShift * 12);
        Pitch toDelete = null;
        for (Pitch playing : playingNotes) {
            if (rawPitch.equals(playing)) {
                toDelete = playing;
            }
        }
        if (toDelete == null) return;
        midi.endNote(rawPitch.toMidiFrequency(), currentInstrument);
        playingNotes.remove(toDelete);
    }

    public void changeInstrument() {
        Instrument nextInstrument = currentInstrument.next();
        currentInstrument = nextInstrument;
    }

    //TODO write method spec
    public void shiftUp() {
        if (currentShift < 2) {
            currentShift += 1;
        }
    }

    //TODO write method spec
    public void shiftDown() {
        if (currentShift > -2) {
            currentShift -= 1;
        }
    }

    //TODO write method spec
    public boolean toggleRecording() {
        return false;
        //TODO: implement for question 4
    }

    //TODO write method spec
    public void playback() {
        //TODO: implement for question 4
    }

}
