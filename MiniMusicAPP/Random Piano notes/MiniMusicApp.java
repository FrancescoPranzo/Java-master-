//we have to import a package
import javax.sound.midi.*;
//import java.util.random;
public class MiniMusicApp {
	
	public static void main(String[] args) {
		MiniMusicApp mini = new MiniMusicApp();
		mini.play();
	}
	
	public void play() {
		//HANDLE the exception
		for (int i=0;i<10;i++) {
			
			try {
				// FIRST STEP: get a sequencer
				Sequencer player = MidiSystem.getSequencer(); 
				player.open();
				System.out.println("We got a sequencer");
				
				// SECOND STEP: get a sequence
				Sequence seq = new Sequence(Sequence.PPQ, 4);
				
				// THIRD STEP: get a new track
				Track track = seq.createTrack();
				int rand = (int) (Math.random() * 127);
				// FOURTH STEP:	fill the track with midi events
				ShortMessage a = new ShortMessage();
				a.setMessage(144, 1, rand, 0);
				MidiEvent noteOn = new MidiEvent(a, 1);
				track.add(noteOn);
				
				ShortMessage b = new ShortMessage();
				a.setMessage(128,1,rand,0);
				MidiEvent noteOff = new MidiEvent(b, 16);
				track.add(noteOff);
				
				player.setSequence(seq); //give the sequence to the sequencer
				
				// FIFTH STEP: push the button
				player.start();
				//maybe a delay
			} catch (MidiUnavailableException ex) {
				ex.printStackTrace();
			} catch (InvalidMidiDataException ex) { //this is not an exception specified in the book
				ex.printStackTrace();
				ex.getCause();
			}
		}		
	}	
}
