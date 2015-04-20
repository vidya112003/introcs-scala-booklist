import scala.collection.mutable.MutableList
import scala.util.Try
import scala.io.Source

// We provide the Book class, which is used to hold book information.
// You will use it to make a book list.

case class Book(title : String, author : String, year : Int)

// Your job is to replace all ??? with your own code.

class BookList {
   var list = MutableList[Book]()

   def addBook(book : Book) : Unit = {
      // write code to add the book to 'list'.
   }

   def getNumberOfBooks() : Int = list.length
      // instructor has done this for you

   def printList() : Unit = {
      // write code to printList()
      // you should also show how to use the method in your main
   }

   def getTitlesByAuthor(author : String) : MutableList[String] = {
      // return a list of all titles that are written by author
   }

   def getTitlesContaining(substring : String) : MutableList[String] = {
      // return a list of all titles that contain a substring
   }

   def getBooksBetweenYears(firstYear : Int, lastYear : Int) : Unit = {
      // get all books between two years
   }

   def addFromFile(name : String) : Unit = {
     // instructor did this one for you...mostly
     for (file <- Try(Source.fromFile(name))) {
        for (line <- file.getLines) {
           val parts = line.split(":")
           if (parts.length >= 3) {
              val title = parts(0)
              val author = parts(1)
              val year = Try(parts(2).toInt).getOrElse(0)
              list += Book(title, author, year)
           } else {
              println("Ignoring: " + line)
           }
        } 
     } 
   }

   def addAll(books : BookList) : Unit = {
      // instructor did this one for you, too
      books.list foreach { n => list += n }
   }
}
