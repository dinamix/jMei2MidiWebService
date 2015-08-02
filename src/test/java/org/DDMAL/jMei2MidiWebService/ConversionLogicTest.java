package org.DDMAL.jMei2MidiWebService;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

import org.junit.Ignore;
import org.junit.Test;

public class ConversionLogicTest {

	@Test
	public void testMei2Midi() throws IOException {
		File input = new File("./src/test/java/TestResources/Input");
		InputStream in = new FileInputStream(input);
		OutputStream out = new FileOutputStream("./src/test/java/TestResources/Output");
		
		ConversionLogic logic = new ConversionLogic();
		logic.mei2Midi(in, out);
		
		in.close();
		out.close();
	}
	
	@Test
	public void testStream2File() throws IOException{
		File input = new File("./src/test/java/TestResources/Input");
		InputStream in = new FileInputStream(input);
		File test = ConversionLogic.stream2File(in);
		Scanner scan = new Scanner(test);
		
		String firstLine = scan.nextLine();
		String secondLine = scan.nextLine();
		assertEquals("testing test",firstLine);
		assertEquals("testing 2 test", secondLine);
		
		scan.close();
		in.close();
	}

}
