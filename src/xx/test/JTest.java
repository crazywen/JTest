package xx.test;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public class JTest {

	private String Jprivate;
	public String Jpublic;
	protected String Jprotected;
	String Jdefaut;

	private void JTest() {

	}

	private void privateMethod() {
	}

	protected void protectedMethod() {
	}

	public void publicMethod() {
	}

	public static void main(String[] args) throws IOException {
		int i = 1;
		int j = 1;
		System.out.println("i:" + i);
		System.out.println("i:" + (i++));
		System.out.println("i:" + i);
		System.out.println("--");
		System.out.println("j:" + j);
		System.out.println("j:" + (++j));
		System.out.println("j:" + j);

		String xx = "xx";
		System.out.println(xx.length());
		int[] ii = new int[3];
		System.out.println(ii.length);

		JTest.writeProperties();
		JTest.arrayTest();

	}

	public static void arrayTest() {
		int[] aFrom = { 1, 2, 3, 7, 9 }; // array size 5
		int[] aTo = new int[5];
		System.arraycopy(aFrom, 0, aTo, 0, aFrom.length);
		for (int i : aTo) {
			System.out.print(i + " ");
		}

	}

	public static void writeProperties() throws IOException {
		Properties p = System.getProperties();
		Set<Entry<Object, Object>> set = p.entrySet();

		FileWriter writer = new FileWriter("sys.txt");
		BufferedWriter bw = new BufferedWriter(writer);
		BufferedOutputStream bos = new BufferedOutputStream(
				new FileOutputStream("sys-.txt"));
		try {

			for (Entry<Object, Object> entry : set) {
				String line = entry.getKey() + ":" + entry.getValue();
				bw.write(line);
				bw.newLine();
				bos.write((new String(line + "\n")).getBytes());
			}
		} finally {
			bw.flush();
			bw.close();
			bos.flush();
			bos.close();
		}
	}

	public static void readFile() {
		System.out.println(System.getProperty("user.dir"));
		String path = "test.txt";
		try {
			FileReader fileReader = new FileReader(path);
			BufferedReader reader = new BufferedReader(fileReader);
			FileWriter fileWriter = new FileWriter(path + ".bak");
			BufferedWriter writer = new BufferedWriter(fileWriter);

			FileInputStream fis = new FileInputStream("test.txt");
			InputStreamReader isReader = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isReader);

			String line = reader.readLine();
			// 1
			while (null != line) {
				// System.out.println(line);
				writer.write(line);
				writer.newLine();
				line = reader.readLine();
			}
			// 2
			char[] chars = new char[1024];
			int len = -1;
			while (-1 != (len = reader.read(chars))) {
				writer.write(chars, 0, len);
			}
			writer.flush();
			reader.close();
			writer.close();
		} catch (IOException e) {

		}
	}
}
