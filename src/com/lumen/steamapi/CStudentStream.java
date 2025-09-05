package com.lumen.steamapi;
import java.util.ArrayList;
import java.util.List;
public class CStudentStream {
	
	int id;
	String name;
	String dept;
	public CStudentStream(int id, String name, String dept) {
		super();
		this.id = id;
		this.name = name;
		this.dept = dept;
	}
	
	@Override
	public String toString() {
		return "StudentStream [id=" + id + ", name=" + name + ", dept=" + dept + "]";
	}

	public static void main(String[] args) {
		List <CStudentStream> sm = new ArrayList<CStudentStream>();
		sm.add(new CStudentStream (1, "Amit", "Electronic"));
		sm.add(new CStudentStream (2, "Bhushan", "Electrical"));
		sm.add(new CStudentStream (3, "Charu", "Computer"));
		
		sm.stream().forEach(students -> System.out.println(students));
	}
}

