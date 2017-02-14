/**
 * Test harness for LRU and FIFO page replacement algorithms
 *
 * Usage: java [-Ddebug] Test <reference string size> <number of page frames>
 */

public class Test
{
	public static void main(String[] args)
	{
		PageGenerator ref = new PageGenerator(new Integer(args[0]).intValue());

		int[] referenceString = ref.getReferenceString();

		System.out.print("Created reference string: ");
		for (int i = 0; i < referenceString.length; i++)
		{
			System.out.print(referenceString[i]);
		}

		/** Use either the FIFO or LRU algorithms */
		ReplacementAlgorithm fifo = new FIFO(new Integer(args[1]).intValue());
		ReplacementAlgorithm lru = new LRU(new Integer(args[1]).intValue());
		
		
		System.out.println("\nRunning " + referenceString.length + " inputs through a FIFO algorithm\nof size " + args[1] + ".\n");
		// output a message when inserting a page
		for (int i = 0; i < referenceString.length; i++)
		{
			fifo.insert(referenceString[i]);
		}
		System.out.println("-------------------------");

		// report the total number of page faults
		System.out.println("FIFO faults = " + fifo.getPageFaultCount());
		
		
		
		
		System.out.println("\nRunning " + referenceString.length + " inputs through a OPR algorithm\nof size " + args[1] + ".\n");
		// output a message when inserting a page
		System.out.println("-------------------------");

		ReplacementAlgorithm opt = new OPT(new Integer(args[1]).intValue(), referenceString);
		
		// report the total number of page faults
		System.out.println("OPT faults = " + opt.getPageFaultCount());
		
		
		
		
		System.out.println("\nRunning " + referenceString.length + " inputs through a LRU algorithm\nof size " + args[1] + ".\n");
		// output a message when inserting a page
		for (int i = 0; i < referenceString.length; i++)
		{
			lru.insert(referenceString[i]);
		}
		System.out.println("-------------------------");

		// report the total number of page faults
		System.out.println("LRU faults = " + lru.getPageFaultCount());
	}
}
