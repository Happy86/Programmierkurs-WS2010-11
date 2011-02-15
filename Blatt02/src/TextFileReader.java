package v4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TextFileReader {
	private BufferedReader reader;
	private int zeile;

	public TextFileReader(String fileName) {
		zeile = 0;
		try {
			reader = new BufferedReader(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			reader = null;
		}
	}

	private String readLine() {
		if (reader == null)
			return null;
		try {
			if (!reader.ready())
				return null;
			else {
				boolean readOn = true;
				String line = null;
				while(readOn)
				{
					line = reader.readLine();
					if(line == null)
						return null;
					line = line.trim();
					readOn = false;
					zeile ++;
					if(line.startsWith("#"))
					{
						readOn = true;
				}
					if(line.compareTo("") == 0)
					{
						readOn = true;
					}
					if(readOn)
						line = null;
				}
				return line;
			}
		} catch (IOException e) {
			return null;
		}
	}
	
	public String readString() throws TextFileReaderException
	{
		String s = readLine();
		if(s == null)
			throw new TextFileReaderException("Konnte keine Zeile lesen", zeile);
		return s;
	}
	
	public int readInteger() throws TextFileReaderException
	{
		String s = readLine();
		if(s == null)
			throw new TextFileReaderException("Konnte keine Zeile lesen", zeile);
		int i;
		try
		{
			i = Integer.parseInt(s);
		}
		catch(NumberFormatException e)
		{
			throw new TextFileReaderException("Kein Integer gefunden", zeile);
		}
		return i;
	}
	
	public double readDouble() throws TextFileReaderException
	{
		String s = readLine();
		if(s == null)
			throw new TextFileReaderException("Konnte keine Zeile lesen", zeile);
		double d;
		try
		{
			d = Double.parseDouble(s);
		}
		catch(NumberFormatException e)
		{
			throw new TextFileReaderException("Kein Double gefunden", zeile);
		}
		return d;
	}
	
	public int[] readIntArray(int expectedValues) throws TextFileReaderException
	{
		String s = readLine();
		if(s == null)
			throw new TextFileReaderException("Konnte keine Zeile lesen", zeile);
		
		String[] splits = s.split(",");
		if(splits.length != expectedValues)
			throw new TextFileReaderException("Anzahl erwarteter Werte stimmt nicht mit Anzahl ermittelter Werte überein", zeile);
		int[] toRet = new int[expectedValues];
		for(int i=0;i<splits.length;i++)
		{
			try
			{
				toRet[i] = Integer.parseInt(splits[i].trim());
			}
			catch(NumberFormatException e)
			{
				throw new TextFileReaderException("Element Nr." + (i+1) + " ist kein Integer!", zeile);
			}
		}
		return toRet;
		
	}
	
}
