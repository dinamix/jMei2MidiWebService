package org.DDMAL.jMei2MidiWebService;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;

import org.apache.commons.io.IOUtils;
import org.ddmal.jmei2midi.MeiSequence;

import ca.mcgill.music.ddmal.mei.MeiXmlReader.MeiXmlReadException;
import lombok.Cleanup;

public class ConversionLogic {
	public void mei2Midi(InputStream inputStream, OutputStream outputStream) throws IOException {
		File meiFile = null;
		try {
			meiFile = stream2File(inputStream);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		MeiSequence Msequence = null;
		try {
			Msequence = new MeiSequence(meiFile);
		} catch (MeiXmlReadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidMidiDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MidiSystem.write(Msequence.getSequence(), 1, File.createTempFile("temp", ".midi"));
		InputStream midi = new FileInputStream("temp.midi");
		IOUtils.copy(midi, outputStream);
	}

	public static File stream2File(InputStream inputStream) throws IOException {
		final String prefix = "test";
		final String suffix = ".midi";
		final File tempFile = File.createTempFile(prefix, suffix);
		try(FileOutputStream outputStream = new FileOutputStream(tempFile)) {
			IOUtils.copy(inputStream, outputStream);
		}
		return tempFile;
	}
}
