import sbt.Keys.version

lazy val root = (project in file(".")).
  settings(
    name := "experiments",
    version := "0.1",
    scalaVersion := "2.11.8",
    mainClass in Compile := Some("com.example.MyApp")
  )



// https://mvnrepository.com/artifact/org.apache.spark/spark-core
libraryDependencies += "org.apache.spark" % "spark-core_2.11" % "2.3.0"

// https://mvnrepository.com/artifact/org.apache.spark/spark-sql
libraryDependencies += "org.apache.spark" % "spark-sql_2.11" % "2.3.0"