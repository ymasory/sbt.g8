/* basic project info */
name := "$name__snake$"

organization := "$organization$"

version := "$project_version$"

description := "$project_description$"

homepage := Some( url("$project_homepage$"))

// organizationName := "My Company"

/* scala versions and options */
scalaVersion := "2.9.2"

crossScalaVersions := Seq("2.9.1")

scalacOptions ++= Seq("-deprecation", "-unchecked")

javacOptions ++= Seq("-Xlint:unchecked", "-Xlint:deprecation")

/* entry point */
mainClass in (Compile, packageBin) := Some("$project_package$.Main")

mainClass in (Compile, run) := Some("$project_package$.Main")

/* dependencies */
libraryDependencies ++= Seq (
  "org.scalaz" %% "scalaz-core" % "7.0.0-M2",
  "org.scalaz" %% "scalaz-effect" % "7.0.0-M2",
  "org.scalacheck" %% "scalacheck" % "1.9" % "test"
)

/* improve REPL */
initialCommands in console :=
  """|import scalaz._
     |import Scalaz._
     |import com.example._
     |println("scalaz 7 loaded!")
     |""".stripMargin

/* you may need these repos */
resolvers ++= Seq(
  // "sonatype snapshots" at "https://oss.sonatype.org/content/repositories/snapshots",
  // "sonatype releases" at "https://oss.sonatype.org/content/repositories/releases",
  // Classpaths.typesafeResolver,
  // Classpaths.typesafeSnapshots,
  // JavaNet1Repository,
  // JavaNet2Repository,
)

/* sbt behavior */
logLevel in compile := Level.Warn

traceLevel := 5

/* publishing */
publishMavenStyle := true

publishTo <<= version { (v: String) =>
  val nexus = "https://oss.sonatype.org/"
  if (v.trim.endsWith("SNAPSHOT")) Some(
    "snapshots" at nexus + "content/repositories/snapshots"
  )
  else Some("releases" at nexus + "service/local/staging/deploy/maven2")
                      }

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

pomExtra := (
  <url>https://github.com/$github_username$/$name__snake$</url>
  <licenses>
    <license>
      <name>LICENSE NAME</name>
      <url>https://github.com/$github_username$/$name__snake$/blob/master/LICENSE</url>
      <distribution>repo</distribution>
    </license>
  </licenses>
  <scm>
    <url>git@github.com:$github_username$/$name__snake$.git</url>
    <connection>scm:git:git@github.com:$github_username$/$name__snake$.git</connection>
  </scm>
  <developers>
    <developer>
      <id>$developer_handle$</id>
      <name>$developer_name$</name>
      <email>$developer_email$</email>
      <url>$developer_homepage$</url>
    </developer>
  </developers>
)

// Josh Suereth's step-by-step guide to publishing on sonatype
// httpcom://www.scala-sbt.org/using_sonatype.html
