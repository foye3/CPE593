package hw;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class GrowArray {

	private int[] data;
	private int used;

	// constructor
	public GrowArray(int initialSize) {
		if (initialSize > 0) {
			this.data = new int[initialSize];
			used = 0;
		} else {
			this.data = new int[0];
			used = 0;
		}
	}

	// constructor with out parameter
	public GrowArray() {
		this.data = new int[0];
		used = 0;
	}

	// length * 2
	private void grow() {
		if (data.length == 0) {
			data = new int[1];
		} else {
			data = Arrays.copyOf(data, data.length << 1);
		}
	}

	public void addEnd(int v) {
		if (used >= data.length)
			grow();
		data[used] = v;
		used++;

	}

	public void addStart(int v) {
		if (used >= data.length)
			grow();
		for (int i = used; i > 0; i--) {
			data[i] = data[i - 1];
		}
		data[0] = v;
		used++;

	}

	public void removeEnd() {
		used--;
	}

	public void removeStart() {
		for (int i = 0; i < used - 1; i++) {
			data[i] = data[i + 1];
		}
		used--;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("src/hw/HW4a.txt"));
		GrowArray ga = new GrowArray(0);
		String c;
		while ((c = br.readLine()) != null) {
			if (!(c.equals(""))) {
				System.out.println(c);
				switch (c.charAt(0)) {
				case 'A':
					int start = Integer.valueOf(c.substring(c.lastIndexOf(" ") + 1, c.indexOf(":")));
					int step = Integer.valueOf(c.substring(c.indexOf(":") + 1, c.lastIndexOf(":")));
					int end = Integer.valueOf(c.substring(c.lastIndexOf(":") + 1, c.length()));
					// add front
					if (c.charAt(4) == 'F') {
						while (start <= end) {
							ga.addStart(start);
							start += step;
						}
					}
					// add back
					if (c.charAt(4) == 'B') {
						while (start <= end) {
							ga.addEnd(start);
							start += step;
						}
					}
					break;
				case 'R':
					int n = Integer.valueOf(c.substring(c.lastIndexOf(" ") + 1, c.length()));
					// remove front
					if (c.charAt(7) == 'F') {
						for (int i = 0; i < n; i++) {
							ga.removeStart();
						}
					}
					// remove back
					if (c.charAt(7) == 'B') {
						for (int i = 0; i < n; i++) {
							ga.removeEnd();
						}
					}
					break;
				// output
				case 'O':
					for (int i = 0; i < ga.used; i++) {
						System.out.print(ga.data[i] + " ");
					}
					System.out.println("");
					break;
				default:
					break;
				}
			}
		}
	}
}
