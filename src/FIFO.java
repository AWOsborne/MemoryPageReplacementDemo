public class FIFO extends ReplacementAlgorithm
{
	private int[] frames;
	private int count;


	public FIFO(int pageFrameCount)
	{
		super(pageFrameCount);

		frames = new int[pageFrameCount];
		for (int i = 0; i < pageFrameCount; i++)
		{
			frames[i] = -1;
		}
		count = 0;
	}


	@Override
	public void insert(int pageNumber)
	{
		System.out.println("-------------------------");
		System.out.println("Inserting: " + pageNumber);

		boolean flag = true;
		for (int i = 0; i < pageFrameCount; i++)
		{
			if (frames[i] == pageNumber)
			{
				flag = false;
				break;
			}
		}

		if (count == pageFrameCount)
		{
			count = 0;
		}

		if (flag)
		{
			frames[count] = pageNumber;
			count++;
			pageFaultCount++;
		}

		for (int i = 0; i < pageFrameCount; i++)
		{
			String value = "(Empty)";
			if (frames[i] != -1)
			{
				value = String.valueOf(frames[i]);
			}
			System.out.println((i + 1) + " - " + value);
		}
	}

}
