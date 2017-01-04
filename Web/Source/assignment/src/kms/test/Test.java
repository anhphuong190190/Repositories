package kms.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
	public static HashMap<Character, Integer> count(String text) {
		HashMap<Character, Integer> result = new HashMap<>();
		for (Character c : text.toCharArray()) {
			Integer count = result.get(c);
			int newCount = (count == null ? 1 : count + 1);
			result.put(c, newCount);
		}
		return result;
	}

	public static void main(String[] args) {
		String line = "hello everyone";
		String text = line.replaceAll(" ", "");
		Map<Character, Integer> map = count(text);
		for (Character c : text.toCharArray()) {
			int count = map.get(c);
			if (count != 0) {
				System.out.println(c + ": " + count);
				if (count > 3) {
					line = line.replace(c, '#');
				}
				map.put(c, 0);
			}
		}
		line = line.replaceAll("#", "");
		System.out.println("Result: " + line);

		WeatherStatus weatherStatus = new WeatherStatus();
		Observer listener1 = new Listener1(weatherStatus);
		Observer listener2 = new Listener2(weatherStatus);

		System.out.println("First status change: HOT");
		weatherStatus.setStatus("HOT");
		System.out.println("Second status change: RAIN");
		weatherStatus.setStatus("RAIN");
		System.out.println("Last status change: COOL");
		weatherStatus.setStatus("COOL");
	}
}