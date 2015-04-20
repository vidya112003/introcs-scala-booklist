import org.scalatest._
import scala.util.{ Try, Success, Failure }

/*
 * Note to student: You may not change this file (the tests)
 */

class RationalScalaTestFlatSpecMatchers extends FlatSpec with Matchers {

  "adding a book" should "increase the number of books" in {
     val books = new BookList()
     books.addBook(Book("Programming in Scala","Martin Odersky", 2004))
     books.getNumberOfBooks() should be (1)
  }


  "reading from file" should "return the correct number of books" in {
     val books = new BookList()
     books.addFromFile("books.txt")
     books.getNumberOfBooks() should be (5)
  }
     
}

