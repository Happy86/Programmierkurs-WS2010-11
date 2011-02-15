package v4;

public class Hauptklasse {

		public static void main(String[] args)
		{
			TextFileReader txt = new TextFileReader("./test.dat");
			try {
				String s = txt.readString();
				System.out.println(s);
				
				int i = txt.readInteger();
				System.out.println(i);
				
				double d = txt.readDouble();
				System.out.println(d);
				
				int[] a = txt.readIntArray(4);
				for(int j : a)
				{
					System.out.println(" - " + j);
				}
				
			} catch (TextFileReaderException e) {
				e.printStackTrace();
			}		}
}
