package finantix.assignment.part4;

public class Test {

	public static String shiftByK(String value, Integer k) {
		if (value == null || value.length() < k) {
			return value;
		}
		char[] s = value.toCharArray();
		char[] shift = new char[s.length];

		for (int i = 0; i < s.length; i++) {
			int index = (i + k) % s.length;
			shift[index] = s[i];
		}
		return new String(shift);
	}

	public static String sortByIndex(String value, Integer start, Integer end) {
		if (value == null || value.length() < start || value.length() < end) {
			return value;
		}
		String s = value.substring(start, end);
		return value.replaceAll(s, sort(s));
	}

	public static String sort(String value) {
		if (value == null || value.length() == 0) {
			return value;
		}
		char[] sorted = value.toCharArray();
		char temp;
		for (int i = 0; i < sorted.length - 1; i++) {
			for (int j = i + 1; j < sorted.length; j++) {
				if (String.valueOf(sorted[i]).compareTo(String.valueOf(sorted[j])) > 0) {
					temp = sorted[i];
					sorted[i] = sorted[j];
					sorted[j] = temp;
				}
			}
		}
		return new String(sorted);
	}

	public static String[] bubble_sort(String values[]) {
		for (int i = 0; i < values.length - 1; i++) {
			for (int j = i + 1; j < values.length; j++) {
				if (values[i].toLowerCase().compareTo(values[j].toLowerCase()) > 0) {
					String temp = values[i];
					values[i] = values[j];
					values[j] = temp;
				}
			}
		}
		return values;
	}

	public static int[] preProcessPattern(char[] ptrn) {
		int i = 0, j = -1;
		int ptrnLen = ptrn.length;
		int[] b = new int[ptrnLen + 1];

		b[i] = j;
		while (i < ptrnLen) {
			while (j >= 0 && ptrn[i] != ptrn[j]) {
				// if there is mismatch consider the next widest border
				// The borders to be examined are obtained in decreasing order
				// from
				// the values b[i], b[b[i]] etc.
				j = b[j];
			}
			i++;
			j++;
			b[i] = j;
		}
		return b;
	}

	public static void searchSubString(char[] text, char[] ptrn) {
		int i = 0, j = 0;
		// pattern and text lengths
		int ptrnLen = ptrn.length;
		int txtLen = text.length;

		// initialize new array and preprocess the pattern
		int[] b = preProcessPattern(ptrn);

		while (i < txtLen) {
			while (j >= 0 && text[i] != ptrn[j]) {
				j = b[j];
			}
			i++;
			j++;

			// a match is found
			if (j == ptrnLen) {
				System.out.println("found substring at index:" + (i - ptrnLen));
				j = b[j];
			}
		}
	}

	public static int search(String value, String search) {
		int count = 0;
		for (int i = 0; i < value.length(); i++) {
			boolean found = true;
			for (int j = 0; j < search.length(); j++) {
				if (!search.substring(j - i, j - i + 1).equals(value.substring(j, j + 1))) {
					found = false;
					break;
				}
			}
			if (found)
				count++;
		}

		return count;
	}

	public static Integer[] bubble_sort(Integer values[]) {
		return new Integer[1];
	}

	public static void main(String[] args) {
		// Object[][] testcases = { { "hlleo", 1, 3 }, { "ooneefspd", 0, 8 }, {
		// "effort", 2, 4 } };
		// for (int i = 0; i < testcases.length; i++) {
		// System.out.println("Shift:" + shiftByK((String) testcases[i][0],
		// (Integer) testcases[i][1]));
		// System.out.println("Sort:" + sortByIndex((String) testcases[i][0],
		// (Integer) testcases[i][1], (Integer) testcases[i][2]));
		// }
		// System.out.println(Arrays.toString(bubble_sort(new String[] { "B",
		// "e", "d", "a", "c", "f", "s", "k", "g", "p", "h", "a", "s" })));
		//
		// System.out.println(search("sadasda", "da"));
		searchSubString("sadasadas".toCharArray(), "ada".toCharArray());

		// System.out.println("s".compareTo("p"));

		Subject subject = new Subject();
		Observer topic1 = new Subscribe("Topic 1", subject);
		Observer topic2 = new Subscribe("Topic 2", subject);

		System.out.println("First state change: START");
		subject.setState("START");
		System.out.println("Second state change: RUNNING");
		subject.setState("RUNNING");
		System.out.println("Last state change: STOP");
		subject.setState("STOP");
	}
}
