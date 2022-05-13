import java.io.*;

public class DataStreamTest {
	public static void dataWrite() {
		int age = 20;
		String name = "hong";
		double weight = 79.3;
		
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		
		try {
			fos = new FileOutputStream("info.dat");
			dos = new DataOutputStream(fos);
			dos.writeInt(age);
			dos.writeUTF(name);
			dos.writeDouble(weight);
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (dos != null) dos.close();
			}catch(IOException e) {}
		}
	}
	
	public static void main(String[] args) {
		//dataWrite();
		FileInputStream fis = null;
		DataInputStream dis = null;
		try { 
			fis = new FileInputStream("info.dat");
			dis = new DataInputStream(fis);
			int age = dis.readInt();
			String name = dis.readUTF();
			double weight = dis.readDouble();
			System.out.println(age);
			System.out.println(name);
			System.out.println(weight);
		}catch(IOException E) {
			E.printStackTrace();
		}finally {
			try {
				if(dis != null) dis.close();
			} catch(IOException e) {}
		}
				
	}

}
