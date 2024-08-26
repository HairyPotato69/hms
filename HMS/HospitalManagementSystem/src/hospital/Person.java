package hospital;

public abstract class Person {
	String id;
	String name;
	String sex;
	public Person() {}
	public Person(String id, String name) {
		this.id = id;
		this.name = name;
	}
	public Person(String id, String name, String sex) {
		this.id = id;
		this.name = name;
		this.sex = sex;
	}
	public void setID(String id) {
		this.id = id;
	}
	public String getID() {
		return this.id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getSex() {
		return this.sex;
	}
}
