<h2>How to's...</h2>

**<u>CFR - 478</u>**

1.sort string alphabetically.

**<u>Answer</u>:**

- Sort characters in a string in java. e.g. `String s = "edcba"  ->  "abcde"`

         String original = "edcba";
         char[] chars = original.toCharArray();
         Arrays.sort(chars);
         String sorted = new String(chars);
         System.out.println(sorted);

2.Copy an array into another array or into a collection.

**<u>Answer</u>:**

- Using `System.arraycopy()` (shallow copy)

         int[] src  = new int[]{1,2,3,4,5};
         int[] dest = new int[5];
         System.arraycopy( src, 0, dest, 0, src.length );

- Using `Arrays.copyOf()` (shallow copy)

         int[] a = new int[5]{1,2,3,4,5};
         int[] b = Arrays.copyOf(a, a.length);

- Using `Arrays.copyOfRange()` (deep copy - create a new instance)

         public static <T> T[] copyOfRange(T[] original, int from, int to)

- Using `Object.clone()` (deep copy - create a new instance)

         int[] a = new int[]{1,2,3,4,5};
         int[] b = a.clone();

- Copy a collections to another collections (use constructor):

      List<Integer> a1 = Arrays.asList(1, 3, 49, 2, 4, 89);
      List<Integer> a2 = new ArrayList<>(a1);
      a1.set(1, 1000);
      System.out.println("a1 = " + a1);
      System.out.println("a2 = " + a2);

      Output:
      a1 = [1, 1000, 49, 2, 4, 89]
      a2 = [1, 3, 49, 2, 4, 89]

3.A declared array contains default values as instance variable.

- Example

         int[] a = new int[5];
         
         for (int i = 0; i < 10; i++) {
             System.out.print(a[i] + " ");
         }
         output:
             0 0 0 0 0

4.String to <code>Set</code> conversion:

- To Set:

          String s = "welcome bro";
          Set<Character> st = s.chars()
                               .mapToObj(c -> (char) c)
                               .collect(Collectors.toSet());

- To TreeSet:

        String s = "welcome bro";
        Set<Character> st = s.chars()
                             .mapToObj(c -> (char) c)
                             .collect(Collectors.toCollection(TreeSet::new));
