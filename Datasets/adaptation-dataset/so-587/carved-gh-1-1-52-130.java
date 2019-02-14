public class foo{
	public int compare(String version1, String version2)
	{
		if(version1 == null)
			return version2 == null ? 0 : Integer.MIN_VALUE;
		if(version2 == null)
			return Integer.MAX_VALUE;
		
		VersionTokenizer tokenizer1 = new VersionTokenizer(version1);
		VersionTokenizer tokenizer2 = new VersionTokenizer(version2);

		int number1 = 0, number2 = 0;
		String suffix1 = "", suffix2 = "";

		while(tokenizer1.moveNext())
		{
			if(!tokenizer2.moveNext())
			{
				do
				{
					number1 = tokenizer1.getNumber();
					suffix1 = tokenizer1.getSuffix();
					if(number1 != 0 || suffix1.length() != 0)
					{	// Version one is longer than number two, and non-zero
						return 1;
					}
				}
				while(tokenizer1.moveNext());
				// Version one is longer than version two, but zero
				return 0;
			}

			number1 = tokenizer1.getNumber();
			suffix1 = tokenizer1.getSuffix();
			number2 = tokenizer2.getNumber();
			suffix2 = tokenizer2.getSuffix();

			if(number1 < number2)
			{	// Number one is less than number two
				return -1;
			}
			if(number1 > number2)
			{	// Number one is greater than number two
				return 1;
			}

			boolean empty1 = suffix1.length() == 0;
			boolean empty2 = suffix2.length() == 0;

			if(empty1 && empty2)
				continue; // No suffixes
			if(empty1)
				return 1; // First suffix is empty (1.2 > 1.2b)
			if(empty2)
				return -1; // Second suffix is empty (1.2a < 1.2)

			// Lexical comparison of suffixes
			int result = suffix1.compareTo(suffix2);
			if(result != 0)
				return result;
		}
		if(tokenizer2.moveNext())
		{
			do
			{
				number2 = tokenizer2.getNumber();
				suffix2 = tokenizer2.getSuffix();
				if(number2 != 0 || suffix2.length() != 0)
				{
					// Version one is longer than version two, and non-zero
					return -1;
				}
			}
			while(tokenizer2.moveNext());

			// Version two is longer than version one, but zero
			return 0;
		}
		return 0;
	}
}