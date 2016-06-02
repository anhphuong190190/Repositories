package finantix.assignment.part2;

import java.io.Serializable;

public class Student implements Serializable {
	private static final long serialVersionUID = 4174367359358490807L;

	private String name;
	private int age;
	private String className;

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
}
