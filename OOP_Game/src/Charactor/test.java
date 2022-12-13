package Charactor;

public class test {
	private NPC bot1;
	public test() {
		bot1 = new NPC(100, 100, 100, 100, 100,100);
		System.out.println(bot1.getPositionX());
	}

	public static void main(String[] args) {
		new test();

	}

}
