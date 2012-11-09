/* basic project info */
name := "$project_artifact_id$"

organization := "$project_group_id$"

version := "$project_version$"

description := "$project_description$"

homepage := Some(url("https://github.com/$github_username$/$github_repo_name$"))

startYear := Some(2012)

licenses := Seq(
  ("$project_license_name$", url("$project_license_url$"))
)

scmInfo := Some(
  ScmInfo(
    url("https://github.com/$github_username$/$github_repo_name$"),
    "scm:git:https://github.com/$github_username$/$github_repo_name$.git",
    Some("scm:git:git@github.com:$github_username$/$github_repo_name$.git")
  )
)

// organizationName := "My Company"

/* scala versions and options */
scalaVersion := "2.9.2"

// crossScalaVersions := Seq("2.9.1")

offline := false

scalacOptions ++= Seq("-deprecation", "-unchecked")

// scalacOptions ++= Seq("-Ydependent-method-types") // if using shapeless

javacOptions ++= Seq("-Xlint:unchecked", "-Xlint:deprecation")

/* entry point */
mainClass in (Compile, packageBin) := Some("$project_group_id$.$project_artifact_id$.Main")

mainClass in (Compile, run) := Some("$project_group_id$.$project_artifact_id$.Main")

/* continuations */
//autoCompilerPlugins := true

//addCompilerPlugin("org.scala-lang.plugins" % "continuations" % "2.9.2")

//scalacOptions += "-P:continuations:enable"

/* dependencies */
libraryDependencies ++= Seq (
  // -- lang --
  // "org.apache.commons" % "commons-lang3" % "3.1",
  // "org.scalaz" %% "scalaz-core" % "7.0.0-M4",
  // "org.scalaz" %% "scalaz-effect" % "7.0.0-M4",

  // -- collections --
  // "org.scalaj" %% "scalaj-collection" % "1.2",
  // "com.google.guava" % "guava" % "13.0.1",
  // "com.chuusai" %% "shapeless" % "1.2.2",

  // -- io --
  // "commons-io" % "commons-io" % "2.4",
  // "com.github.scala-incubator.io" %% "scala-io-core" % "0.4.1-seq",
  // "com.github.scala-incubator.io" %% "scala-io-file" % "0.4.1-seq",

  // -- logging & configuration --
  // "org.clapper" %% "grizzled-slf4j" % "1.0.1",
  // "ch.qos.logback" % "logback-classic" % "1.0.7",
  // "com.typesafe" % "config" % "1.0.0"

  // -- persistence & serialization --
  // "org.json4s" %% "json4s-native" % "3.0.0",
  // "com.novus" %% "salat" % "1.9.2-SNAPSHOT",
  // "com.typesafe.akka" % "akka-actor" % "2.0.3",
  // "com.h2database" % "h2" % "1.2.127",
  // "mysql" % "mysql-connector-java" % "5.1.10",

  // -- concurrency --
  // "com.typesafe.akka" % "akka-actor" % "2.0.3",
  // "org.scala-stm" %% "scala-stm" % "0.6",

  // -- network --
  //  "net.databinder.dispatch" %% "dispatch-core" % "0.9.2"

  // -- testing --
  // "org.scalacheck" %% "scalacheck" % "1.10.0" % "test",
  // "org.specs2" %% "specs2" % "1.12.2" % "test",
  // "org.scalatest" %% "scalatest" % "2.0.M4" % "test"
)

/* you may need these repos */
resolvers ++= Seq(
  // Resolver.sonatypeRepo("snapshots")
  // Resolver.typesafeIvyRepo("snapshots")
  // Resolver.typesafeIvyRepo("releases")
  // Resolver.typesafeRepo("releases")
  // Resolver.typesafeRepo("snapshots")
  // JavaNet2Repository,
  // JavaNet1Repository
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
  <developers>
    <developer>
      <id>$developer_handle$</id>
      <name>$developer_full_name$</name>
      <email>$developer_email$</email>
      <!-- <url>$developer_homepage$</url> -->
    </developer>
  </developers>
)

// Josh Suereth's step-by-step guide to publishing on sonatype
// httpcom://www.scala-sbt.org/using_sonatype.html

/* assembly plugin */
mainClass in AssemblyKeys.assembly := Some("$project_group_id$.$project_artifact_id$.Main")

assemblySettings

test in AssemblyKeys.assembly := {}
