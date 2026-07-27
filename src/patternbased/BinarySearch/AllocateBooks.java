package patternbased.BinarySearch;

public class AllocateBooks {
   public int allocateBooks(int[] books, int students){
       if(students > books.length){
           return -1;
       }

       int left = 0;
       int right = 0;

       for (int pages : books){
           left = Math.max(left,pages);
           right += pages;
       }

       while (left < right){
           int mid = left + (right - left ) /2;

           if(canAllocate(books,students,mid)){
               right = mid;
           } else {
               left = mid + 1;
           }
       }

       return left;
   }

   private boolean canAllocate(int[] books, int students, int maxPages){
       int studentCount = 1;
       int currentPages = 0;

       for(int pages : books){
           if(currentPages + pages > maxPages){
               studentCount++;
               currentPages = 0;
           }

           currentPages +=pages;
       }

       return studentCount <=students;
   }

    public static void main(String[] args) {
        AllocateBooks allocateBooks = new AllocateBooks();
        int[] arr = {12, 34, 67, 90};
        int k = 2;
        int result = allocateBooks.allocateBooks(arr, k);
        System.out.println(result);
    }
}
