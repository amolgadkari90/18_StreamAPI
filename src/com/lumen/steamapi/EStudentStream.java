package com.lumen.steamapi;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class EStudentStream {
	
	int id;
	String name;
	String dept;
	int age;
	
	public EStudentStream(int id, String name, String dept, int age) {
		super();
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.age = age;
	}

	@Override
	public String toString() {
		return "EStudentStream [id=" + id + ", name=" + name + ", dept=" + dept + ", age=" + age + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		//print the first 2 students Name whose age is greater than 25
		//print all the students
		//print only those students whose age is greater than 25
		//print student name only / not the entire object
		
		
		List <EStudentStream> sm = new ArrayList<EStudentStream>();
		sm.add(new EStudentStream (1, "Amit", "Electronic", 21 ));
		sm.add(new EStudentStream (2, "Bhushan", "Electrical", 25));
		sm.add(new EStudentStream (3, "Chandan", "Computer", 23 ));
		sm.add(new EStudentStream (4, "Amruta", "Electronic", 22));
		sm.add(new EStudentStream (5, "Bhavana", "Electrical", 23));
		sm.add(new EStudentStream (6, "Chetana", "Computer", 24));
		sm.add(new EStudentStream (7, "Dinesh", "Electronic", 22));
		sm.add(new EStudentStream (8, "Dolly", "Computer", 23));
		
		System.out.println("*******************Names of student whoes age >= 23***********************");
		sm.stream()
					.filter(fSm -> fSm.getAge() >= 23)
					.map(mSm  -> mSm.getName())
					.forEach(map -> System.out.println(map));
		
		System.out.println("********************Name of the students starts with 'A' **********************");
		List<String > list = sm.stream()
					.filter(fsm -> fsm.getName().charAt(0) == 'A')
					.map(msm -> msm.getName()) 
					.collect(Collectors.toList());
		System.out.println(list);	
		System.out.println("********************How many student in Electronic deparment **********************");
		long count = sm.stream()
								.filter(fsm -> fsm.getDept().equals("Electronic"))
								.count();
		System.out.println("Students in Electronics -> " + count);
		System.out.println("********************How many student in Electronic deparment maximum count can be procesed 2**********************");
		count = sm.stream()
				.filter(fsm -> fsm.getDept().equals("Electronic"))
				.limit(2)
				.count();
		System.out.println("Students in Electronics -> " + count);
	}
}

