package finantix.assignment.part2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class main {
	public static void main(String[] args) {
		String path = "d:/student.json";
		Student student = new Student("Phuong", 26, "Finantix");
		try {
			FileOutputStream fileOut = new FileOutputStream(path);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(student);
			out.flush();
			out.close();
			fileOut.close();
			System.out.println("Serialized data is saved in " + path);
		} catch (IOException e) {
			System.err.println(e);
		}

		try {
			FileInputStream fileIn = new FileInputStream(path);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			Student s = (Student) in.readObject();
			in.close();
			fileIn.close();
			System.out.println(s);
		} catch (IOException | ClassNotFoundException e) {
			System.err.println(e);
		}

	}
}
