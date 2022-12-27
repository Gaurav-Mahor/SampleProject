
public class RemoveExtraSpaceFromString
{
	public static void main(String[] args)
	{
		String updatedText, text = "This   is    a   practice     question";
		updatedText = text.replaceAll("\\s+", " "); // \\s+ matches a space one or more occurences.
		System.out.println(updatedText);
	}
}
