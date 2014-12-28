package bg.uni_sofia.fmi.corejava.threads.producer_consumer;

public class Util {

	private static long lastId = 0l;

	public static synchronized long generateUniqueId() {
		lastId++;
		return lastId;
	}

	public static void performSomeProcessing(int weight)
			throws InterruptedException {
		for (int i = 0; i < weight; i++) {
			for (int j = 0; j < 100000; j++) {
				Math.cbrt(Double.MAX_VALUE);
			}
			Thread.sleep(5);
		}
	}

}
