version in ThisBuild := "0.1.0-SNAPSHOT"

scalaVersion in ThisBuild := "2.11.2"

lazy val root = (project in file("."))
  .settings(
    name := "project_4"
  )

// Source: https://mvnrepository.com/artifact/org.apache.spark/spark-core
libraryDependencies += "org.apache.spark" %% "spark-core" % "2.4.7"

libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.4.7"