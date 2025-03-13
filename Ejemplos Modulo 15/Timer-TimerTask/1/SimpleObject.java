public class SimpleObject {
	private String name;

	public SimpleObject(String name) {
		System.out.println("Instantiating " + name);
		this.name = name;
	}

	public void finalize() {
		System.out.println(name + " is getting garbage collected");
	}
}
