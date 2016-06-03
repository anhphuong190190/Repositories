package finantix.assignment.part2;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Student implements Externalizable {
	private static final long serialVersionUID = 4174367359358490807L;

	private String name;
	private int age;
	private String className;

	public Student() {
	}

	public Student(String name, int age, String className) {
		this.name = name;
		this.age = age;
		this.className = className;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getClassName() {
		return className;
	}

	public String toString() {
		return String.format("Student{'name': '%s', 'age': %d, 'className': '%s',}", this.name, this.age,
				this.className);
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeUTF(this.name);
		out.writeInt(this.age);
		out.writeUTF(this.className);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		this.name = in.readUTF();
		this.age = in.readInt();
		this.className = in.readUTF();
	}
}
