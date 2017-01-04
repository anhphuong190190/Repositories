package kms.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClassTest {
	public static int count(char[] text, char search) {
		int count = 0;
		for (char c : text) {
			if (search == c) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) throws IOException {
		// BufferedReader br = new BufferedReader(new
		// InputStreamReader(System.in));
		// String line = br.readLine();
		String line = "hello everyone";

		char[] text = line.toCharArray();
		int[] temp = new int[text.length];
		List<String> list = new ArrayList<>();
		int i = 0;
		for (char c : text) {
			if (c != ' ') {
				String search = new String(new char[] { c });
				if (!list.contains(search)) {
					list.add(search);
					temp[i] = count(text, c);
					i++;
				}
			}
		}
		for (int j = 0; j < list.size(); j++) {
			System.out.println(list.get(j) + ": " + temp[j]);
			if (temp[j] > 3) {
				line = line.replace(list.get(j), "");
			}
		}
		System.out.println("Result:" + line);
	}
}