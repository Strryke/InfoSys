package piano;

import java.util.ArrayList;

import javax.sound.midi.MidiUnavailableException;

import midi.Instrument;
import midi.Midi;
import music.NoteEvent;
import music.Pitch;

public class PianoMachine {
    ArrayList<Pitch> playingNotes = new ArrayList<>();

    Instrument currentInstrument = Instrument.PIANO;
    int currentShift = 0;
    boolean recording = false;
    ArrayList<NoteEvent> record = new ArrayList<>();

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
        record.add(new NoteEvent(rawPitch, System.currentTimeMillis(),currentInstrument, NoteEvent.Kind.start));
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
        record.add(new NoteEvent(rawPitch, System.currentTimeMillis(),currentInstrument, NoteEvent.Kind.stop));

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
        recording = !recording;
        if (recording && !record.isEmpty()) {
            record.clear();
        }
        return recording;
    }


    // create function that playback the recorded notes
    public void playback() {
        for (int i=0; i<record.size(); i++) {

            long time = i == record.size()-1 ? 0 : (record.get(i+1).getTime() - record.get(i).getTime());
            NoteEvent note = record.get(i);
//            System.out.printf("pitch:%s, time:%s, instrument:%s, kind:%s \n", note.getPitch(), time, note.getInstr(), note.getKind());

            if (note.getKind() == NoteEvent.Kind.start) {
                midi.beginNote(note.getPitch().toMidiFrequency(), note.getInstr());
                try {
                    Thread.sleep(time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            else if (note.getKind() == NoteEvent.Kind.stop) {
                midi.endNote(note.getPitch().toMidiFrequency(), note.getInstr());
                try {
                    Thread.sleep(time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
        return;
    }

}
