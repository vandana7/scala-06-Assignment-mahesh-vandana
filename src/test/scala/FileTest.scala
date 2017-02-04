
import org.scalatest.FunSuite
import scala.concurrent.Await
import scala.concurrent.duration._



class FileTesting extends FunSuite {
  val myObj = new FindingFiles
  val list = Await.result(myObj.getListOfAllFiles("C:\\Users\\Dell\\Desktop\\Resume"), 3.second)
  test("Checking directory") {
    assert(list.size > 0)

  }
  test("Number of Files in given folder") {
    assert(list.size == 14)
  }

  test(" is  file exist") {
    val list1 = Await.result(myObj.getListOfAllFiles("G:\\Mca\\mahesh"), 3.second)
    assert(list1.size == 0)
  }
}
