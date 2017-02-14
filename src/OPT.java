
public class OPT extends ReplacementAlgorithm
{
	private int frames;
	private int[] memory;
	private int pointer;
	private int[] reference;
	private int referenceLength;
	private boolean isFull;


	public OPT(int pageFrameCount, int[] referenceString)
	{
		super(pageFrameCount);

		isFull = false;
		frames = pageFrameCount;
		referenceLength = referenceString.length;
		reference = new int[referenceLength];
		memory = new int[frames];
		reference = referenceString;

		for (int j = 0; j < frames; j++)
		{
			memory[j] = -1;
		}

		System.out.println();
		for (int x = 0; x < referenceLength; x++)
		{
			int compare = -1;
			for (int y = 0; y < frames; y++)
			{
				if (memory[y] == reference[x])
				{
					compare = y;
					break;
				}
			}
			if (compare == -1)
			{
				if (isFull)
				{
					int index[] = new int[frames];
					boolean indexMarker[] = new boolean[frames];
					for (int y = x + 1; y < referenceLength; y++)
					{
						for (int z = 0; z < frames; z++)
						{
							if ((reference[y] == memory[z]) && (indexMarker[z] == false))
							{
								index[z] = y;
								indexMarker[z] = true;
								break;
							}
						}
					}
					int max = index[0];
					pointer = 0;
					if (max == 0)
					{
						max = 200;
					}
					for (int j = 0; j < frames; j++)
					{
						if (index[j] == 0)
						{
							index[j] = 200;
						}
						if (index[j] > max)
						{
							max = index[j];
							pointer = j;
						}
					}
				}
				memory[pointer] = reference[x];
				pageFaultCount++;
				if (!isFull)
				{
					pointer++;
					if (pointer == frames)
					{
						pointer = 0;
						isFull = true;
					}
				}
			}
			System.out.println("Inserting: " + reference[x]);
			
			for (int k = 0; k < pageFrameCount; k++)
			{
				String value = "(Empty)";
				if (memory[k] != -1)
				{
					value = String.valueOf(memory[k]);
				}
				System.out.println((k + 1) + " - " + value);
			}

			System.out.println("-------------------------");
		}
	}


	@Override
	public void insert(int pageNumber)
	{
		// TODO Auto-generated method stub

	}

}
