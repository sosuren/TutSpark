lazy val commonSettings = Seq(
	name := "Spark Tutorials",
	organization := "com.nw",
	scalaVersion := "2.10.4"
)

lazy val root = (project in file("."))
					.settings(commonSettings: _*)