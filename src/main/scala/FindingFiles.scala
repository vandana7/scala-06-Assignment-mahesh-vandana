

import java.io.File
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class FindingFiles {

  def getListOfAllFiles(directoryPath: String): Future[List[File]] = {

    def getAllFiles(directoryPath: String, allFiles: List[File]): List[File] = {
      val directory = new File(directoryPath)

      if (directory.exists() && directory.isDirectory) {

        val listOfFiles = allFiles ::: directory.listFiles.filter(_.isFile).toList

        val listOfDirectories = directory.listFiles.filter(_.isDirectory).toList
        listOfFiles ::: listOfDirectories.flatMap(x => getAllFiles(x.getPath, List[File]()))
      }
      else {
        allFiles
      }
    }

    Future {
      getAllFiles(directoryPath, List())
    }

  }
}
