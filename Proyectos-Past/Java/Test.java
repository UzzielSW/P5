import JButton;
import JFrame;

public class Test extends JFrame{
	public Test() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLocationRelativeTo(null);

		JButton btn = new JButton("Hola");
	}

	public static void main(String[] args) {
		Integer an = 0;
		Test gui = new Test();

		while (true) {
			if (++an == 10) {
				break;
			}
			System.out.println(an);
		}
	}
}
