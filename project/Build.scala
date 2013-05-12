import sbt._,Keys._

object Build extends Build {
  lazy val baseSettings = Seq(
    scalaVersion := "2.10.1",
    organization := "com.github.hexx",
    scalacOptions ++= Seq("-deprecation", "-feature", "-unchecked", "-language:_")
  )

  lazy val effectfulExample = Project(
    id = "effectful-example",
    base = file(".")
  ).settings(
    baseSettings ++ seq(
      libraryDependencies ++= Seq(
      ),
      initialCommands in console += Seq(
        "scalaz._",
        "Scalaz._",
        "effectful._"
      ).map("import " + _ + "\n").mkString
    ) : _*
  ).dependsOn(uri("https://github.com/pelotom/effectful.git"))
}
