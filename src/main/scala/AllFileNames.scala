
package edu.knoldus

import java.io.File

import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global


import scala.collection.mutable.ListBuffer

class AllFileNames {
  val fileList = new ListBuffer[File]


  def getListOfAllFiles(directoryPath: String): Future[List[File]] = Future {

    val directory = new File(directoryPath)
    if (directory.exists && directory.isDirectory) {
      for (file <- directory.listFiles.toList) {
        if (file.isFile) {
          fileList += file
        }
        else {
        getListOfAllFiles(file.toString)
      }
    }
      fileList.toList
    }
    else
      {
        Nil
      }
  }
}
