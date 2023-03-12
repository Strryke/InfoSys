package piano;

import java.util.ArrayList;

import javax.sound.midi.MidiUnavailableException;

import midi.Instrument;
import midi.Midi;
import music.Pitch;

public class PianoMachine {
    ArrayList<Pitch> playingNotes = new ArrayList<>();

    Instrument currentInstrument = Instrument.PIANO;
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
        for (Pitch playing : playingNotes) {
            if (rawPitch.equals(playing)) return;
        }

        midi.beginNote(rawPitch.toMidiFrequency(), currentInstrument);
        playingNotes.add(rawPitch);
    }

    //TODO write method spec
    public void endNote(Pitch rawPitch) {
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
        //TODO: implement for question 3
    }

    //TODO write method spec
    public void shiftDown() {
        //TODO: implement for question 3
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
