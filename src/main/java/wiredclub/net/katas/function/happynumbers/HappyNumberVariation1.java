package wiredclub.net.katas.function.happynumbers;

public class HappyNumberVariation1 extends HappyNumber {

	public static void main(String[] args) {
		new HappyNumberVariation1().run();
	}

	public HappyNumberVariation1() {
	}

	private void run() {
		for (int number = 10; number <= 20; number++) {
			System.out.println(number + " is a " + (isHappyNumber(number) ? "happy" : "sad") + " number");
		}
	}
}

