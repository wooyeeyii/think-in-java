package com.chapter3.P174;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class RunTest {
	
	public static void main(String[] args) {
		try {
			WriteData writeData = new WriteData();
			ReadData readData = new ReadData();
			
			PipedReader inputStream = new PipedReader();
			PipedWriter outputStream = new PipedWriter();
			
			inputStream.connect(outputStream);
			//outputStream.connect(inputStream);
			
			ThreadRead threadRead = new ThreadRead(readData, inputStream);
			threadRead.start();
			
			ThreadWrite threadWrite = new ThreadWrite(writeData, outputStream);
			threadWrite.start();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
