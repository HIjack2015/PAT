import java.util.List;

public class StringBufferSub1 {
	public static String printArrayWithSpace(List<?> list) {
		StringBuilder resultStringBuilder = new StringBuilder();
		for (Object object : list) {
			resultStringBuilder.append(object + " ");
		}
		if (resultStringBuilder.length() != 0) {
			resultStringBuilder.substring(0, resultStringBuilder.length() - 1);
			return resultStringBuilder.toString();
		} else {
			return "";
		}
	}
}
