import java.util.Scanner;

class ArrayMerger
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int length = getLength(scan);

		int[] arr1 = genRandomArr(length);
		int[] arr2 = genRandomArr(length);
		int[] sortedArr = sortArrays(arr1, arr2);

		System.out.println("\nFirst Array: " + arrToString(arr1));
		System.out.println("\nSecond Array: " + arrToString(arr2));
		System.out.println("\nMerged Array: " + arrToStringNoZeros(sortedArr));

	}

	// gets the length of the array from the user, as per Edhesive's instructions.
	public static int getLength(Scanner scan)
	{
		// the instructions call for a value of at least 10
		final int MIN_VALUE = 10;
		// in order for the code to compile this must have an initial value, using
		// Integer.MIN_VALUE will ensure that it's always small enough even if the
		// variable MIN_VALUE changes
		int enteredValue = Integer.MIN_VALUE;
		do
		{
			System.out.print("Enter an array length (must be 10 or greater):");
			if (scan.hasNextInt())
			{
				enteredValue = scan.nextInt();
			}
			else
			{
				// clear the scanner buffer
				System.out.println();
				scan.nextLine();
			}
		} while (enteredValue < MIN_VALUE);
		return enteredValue;
	}

	// returns true if arg1 exists in arg2.
	public static boolean isInArr(int num, int[] arr)
	{
		for (int i = 0; i < arr.length; i++)
		{
			if (num == arr[i])
			{
				return true;
			}
		}
		return false;
	}

	// randomly generates an array according to Edhesive's instructions.
	public static int[] genRandomArr(int length)
	{
		int[] arr = new int[length];
		// these values are from the instructions
		final int MIN = 1, MAX = 100;
		for (int i = 0; i < length; i++)
		{
			arr[i] = getRandomNumber(MIN, MAX);
		}
		return arr;
	}

	// gets a random integer between the first parameter and the second one
	public static int getRandomNumber(int min, int max)
	{
		return min + (int) (Math.random() * ((max - min) + 1));
	}

	// sorts the array in the way the instruction call for
	public static int[] sortArrays(int[] arr1, int[] arr2)
	{
		// due to the nature of this method we will assume they are the same length
		int length = arr1.length * 2;
		int[] sortedArr = new int[length];
		int nextSlot = 0;
		for (int i = 0; i < length; i++)
		{
			int[] arrayToChooseFrom;
			// this if-else block is used to switch between the 2 arrays each time
			if (i % 2 == 0)
			{
				arrayToChooseFrom = arr1;
			}
			else
			{
				arrayToChooseFrom = arr2;
			}
			
			//add it to the array if it's not already in it
			if (!isInArr(arrayToChooseFrom[i / 2], sortedArr))
			{
				sortedArr[nextSlot] = arrayToChooseFrom[i / 2];
				nextSlot++;
			}
		}

		return sortedArr;
	}

	// gets all the values of an array as a string
	public static String arrToString(int[] arr)
	{
		String str = "";
		for (int i = 0; i < arr.length; i++)
		{
			str += arr[i] + " ";
		}
		return str;
	}

	// gets all the values of an array as a string, ending once it's at zero as the
	// instructions require.
	public static String arrToStringNoZeros(int[] arr)
	{
		String str = "";
		for (int i = 0; i < arr.length; i++)
		{
			if (arr[i] != 0)
			{
				str += arr[i] + " ";
			}
			else
			{
				break;
			}
		}
		return str;
	}
}
