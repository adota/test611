package cn.dw.demo;


public class JvmDemo {
	
	public static void main(String[] args) {
		
		JvmDemo demo =new JvmDemo();
//		JvmDemo demo3;
		demo.setName("admin");
		JvmDemo.setAge(18);	
		System.out.println(demo.getName()+","+JvmDemo.getAge());
		
		
		JvmDemo demo2 =new JvmDemo();
		demo2.setName("admin2");
		JvmDemo.setAge(19);
		System.out.println(demo2.getName()+","+JvmDemo.getAge());
		
		
	}

	private String name;

	private static int age;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static int getAge() {
		return age;
	}

	public static void setAge(int age) {
		JvmDemo.age = age;
	}

	
}
