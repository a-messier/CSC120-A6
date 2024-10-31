import java.util.Hashtable; 

/* This is a stub for the Library class */
public class Library extends Building{
    private Hashtable<String, Boolean> collection; // initilizes collection hashtable

    /**
     * Constructor for Library class extends Building class
     * @param name string
     * @param address string 
     * @param nFloors int 
     */
    public Library(String name, String address, int nFloors) {
      super(name, address, nFloors); 
      this.collection = new Hashtable<>();  // initilizes collection as empty hashtable
      System.out.println("You have built a library: 📖");
    }

    /**
     * Adds a book to the collection hashtable as key: value = book title/author : true,
     *  where true indicates that the boo is currently available 
     * @param title string name of book to add 
     */
    public void addTitle(String title){
      if (this.collection.containsKey(title)){ // if the title is already there...
        throw new RuntimeException("Title is already in collection"); 
      }
      else{ // if book not already there...
        this.collection.put(title, true); // adds to collection, true bc is there 
      }

    }

    /**
     * Removes a book from the collection hashtable
     * @param title name of book to remove 
     * @return name of book removed 
     */
    public String removeTitle(String title){
      if (this.collection.containsKey(title)){ // checks if title is in collection
        this.collection.remove(title); // removes title 
      }
      else{ // issue if title is not in collection, so cannot remove 
        throw new RuntimeException("Title "+title+" not in collection. Cannot be removed.");
      }

      return title; // return title of book 
    }
    /**
     * Checks out a book by making sure the book is in the collection and currently available
     * @param title name of book to check out 
     */
    public void checkOut(String title){
      if ((this.collection.containsKey(title)) && this.collection.get(title)){ // if title is in library andv value is true 
        this.collection.replace(title, false); // set contains value to false 
      }


    }
    /**
     * returns book by setting value to true from false 
     * @param title name of book to return 
     */
  public void returnBook(String title){
    if ((this.collection.containsKey(title)) && !this.collection.get(title)){ // if title is in library andv value is false 
      this.collection.replace(title, true); // set contains value to false 
  }
}
  /**
   * Tells if a certain book is in the collection 
   * @param title name of book 
   * @return true if the library has the title (available or unavailable)
   */
  public boolean containsTitle(String title){
        return this.collection.containsKey(title);
  }
  /**
   * checks if a title is currently available for checkout 
   * @param title name of book
   * @return true if avaialble, false if not. 
   */
  public boolean isAvailable(String title){
    if (!this.collection.containsKey(title)){ // if not in collection
      System.out.println("Book "+ title + " is not in collection.");
    }
    return this.collection.get(title); // returns value corresponding to key of title 
  }
  /** 
   * prints all titles in the collection and if they are available or not 
   */
  public void printCollection(){
    System.out.println(this.collection); // prints collection?
  }

    public static void main(String[] args) {
      Library Neilson = new Library("Neilson", "1 Chapin Way", 4);
      Neilson.addTitle("1984 by George Orwell"); 
      System.out.println(Neilson.containsTitle("1984 by George Orwell")); 
      Neilson.printCollection();
    }
  
  }