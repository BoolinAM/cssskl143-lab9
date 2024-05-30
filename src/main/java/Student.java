import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Student implements Comparable<Student>,Cloneable, Serializable {
	private double gpa;
	private String name;
	
	public Student(String name, double gpa) {
		this.name = name;
		this.gpa = gpa;
	}
	public double getGPA() {
		return this.gpa;
	}
	public String getName() {
		return this.name;
	}
	public void setGPA(double gpa) {
		this.gpa = gpa;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Student other) {
		return Double.compare(this.gpa, other.gpa);
	}

	@Override
	public Student clone() {
		try {
			return (Student) super.clone();
		}
		catch (CloneNotSupportedException e) {
			return new Student(this.name, this.gpa);
		}
	}

	public String toString() {
		return "Student{name='" + name + "', gpa=" + gpa + "}";
	}
}
