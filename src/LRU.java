
public class LRU extends ReplacementAlgorithm
{
	private int[] frames;
	private int marker;
	private int[] buffer;


	public LRU(int pageFrameCount)
	{
		super(pageFrameCount);

		frames = new int[pageFrameCount];
		buffer = new int[pageFrameCount];
		for (int i = 0; i < pageFrameCount; i++)
		{
			frames[i] = -1;
			buffer[i] = -1;
		}
		marker = 0;
	}

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
		
		for (int i = 0; i < pageFrameCount && flag; i++)
		{
			if (frames[i] == buffer[pageFrameCount-1])
			{
				marker = i;
				break;
			}
		}
		
		if (flag)
		{
			frames[marker] = pageNumber;
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
