import java.awt.print.Printable;
import java.util.List;

public class StringBufferSub1 {
	public static void printArrayWithSpace(List<?> list) {
		StringBuilder resultStringBuilder = new StringBuilder();
		for (Object object : list) {
			resultStringBuilder.append(object + " ");
		}
		if (resultStringBuilder.length() != 0) {
			System.out.println(resultStringBuilder.substring(0,
					resultStringBuilder.length() - 1));
		} else {
			System.out.println("need to print if 0");
		}
	}
}
