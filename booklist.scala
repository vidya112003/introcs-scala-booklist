import scala.collection.mutable.ListBuffer
import scala.util.Try
import scala.io.Source



case class Book(title : String, author : String, year : Int)



class BookList {
   var list = MutableList[Book]()

   def addBook(book : Book) : Unit = {
   
       list+=book
   }

   def getNumberOfBooks() : Int = list.length
      

   def printList() : Unit = {
       for(books<-list){
           println(books)
       }
   }

   def getTitlesByAuthor(author : String) : MutableList[String] = {
      val byAuthorList = MutableList[String]()
      


      byAuthorList
   }

   def getTitlesContaining(substring : String) : MutableList[String] = {
      val titles = MutableList[String]()
      
      for(booktitles<-list){
          if(booktitles.title contains substring){
              titles+=booktitles.title
          }
      }    
      titles
   }

   def getBooksBetweenYears(firstYear : Int, lastYear : Int) : MutableList[Book] = {
     
      val betweenYearList = MutableList[Book]()
      
       for(thebooks<-list){
           if(thebooks.year>=firstYear&&thebooks.year<=lastYear){
               betweenYearList+=thebooks
           }
       }

      betweenYearList
   }

   def addFromFile(name : String) : Unit = {
     
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
       var bookorama=new BookList()
	   for(books<-list){
		   bookorama.addBook(books)
	   }
	   println(bookorama.getBooksBetweenYears(2000,2013))
   }

   def addAll(books : BookList) : Unit = {
     
      books.list foreach { n => list += n }
   }
}
object Library extends App{
	val judyMoody=new Book("Judy Moody","Megan McDonald", 2000)
	val theHungerGames=new Book("Catching Fire","Suzanne Collins", 2009)
	var bookworld=new BookList()
	bookworld.addBook(judyMoody)
	bookworld.addBook(theHungerGames)
	var booktastic=new BookList()
	booktastic.addAll(bookworld)
	println(">>>")
	booktastic.printList()
	println(">>>")
	println(bookworld.getTitlesByAuthor("Megan McDonald"))
	println(bookworld.getBooksBetweenYears(2000,2009))
	println(bookworld.getTitlesContaining("Judy"))
	bookworld.addFromFile("books.txt")
}
