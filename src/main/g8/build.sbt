/* basic project info */
name := "$project_artifact_id$"

organization := "$project_group_id$"

version := "$project_version$"

description := "$project_description$"

homepage := Some(url("https://github.com/$github_username$/$github_repo_name$"))

startYear := Some(2013)

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
scalaVersion := "2.10.0"

// crossScalaVersions := Seq("2.9.1")

offline := false

scalacOptions ++= Seq(
  "-feature",
  // "-language:postfixOps",
  // "-language:reflectiveCalls",
  // "-language:implicitConversions",
  // "-language:higherKinds",
  // "-language:existentials",
  // "-language:experimental.macros",
  // "-language:experimental.dynamics",
  "-deprecation",
  "-unchecked"
)

javacOptions ++= Seq("-Xlint:unchecked", "-Xlint:deprecation")

/* entry point */
mainClass in (Compile, packageBin) := Some("$project_group_id$.$project_artifact_id$.Main")

mainClass in (Compile, run) := Some("$project_group_id$.$project_artifact_id$.Main")

// CONTINUATIONS
// autoCompilerPlugins := true
// addCompilerPlugin("org.scala-lang.plugins" % "continuations" % "2.9.2")
// scalacOptions += "-P:continuations:enable"

/* dependencies */
libraryDependencies ++= Seq (
  // -- lang --
  "org.apache.commons" % "commons-lang3" % "3.1",
  "org.scalaz" %% "scalaz-core" % "7.0.0-M7",
  "org.scalaz" %% "scalaz-effect" % "7.0.0-M7",
  // -- util --
  "com.github.nscala-time" %% "nscala-time" % "0.2.0",
  "org.spire-math" % "spire_2.10.0" % "0.3.0-M7",
  "com.github.scopt" %% "scopt" % "2.1.0",
  "org.rogach" %% "scallop" % "0.6.3",
  // -- collections --
  "com.google.guava" % "guava" % "13.0.1",
  "com.chuusai" %% "shapeless" % "1.2.3",
  "de.sciss" %% "fingertree" % "1.2.+",
  "com.assembla.scala-incubator" % "graph-core_2.10" % "1.6.0",
  // -- io --
  "commons-io" % "commons-io" % "2.4",
  // -- logging & configuration --
  "com.typesafe" %% "scalalogging-slf4j" % "1.0.0",
  "ch.qos.logback" % "logback-classic" % "1.0.7" % "provided",
  "com.typesafe" % "config" % "1.0.0",
  // -- database drivers --
  "com.h2database" % "h2" % "1.2.127",
  "mysql" % "mysql-connector-java" % "5.1.10",
  // -- persistence --
  // "com.novus" %% "salat" % "1.9.2-SNAPSHOT",
  "net.debasishg" %% "redisclient" % "2.9",
  "com.typesafe" %% "slick" % "1.0.0-RC1",
  "org.squeryl" %% "squeryl" % "0.9.5-6",
  // "com.github.nikita-volkov" % "sorm" % "0.3.5",
  "fi.reaktor" %% "sqltyped" % "0.1.0",
  "com.imageworks.scala-migrations" %% "scala-migrations" % "1.1.1",
  // -- serialization --
  "org.json4s" %% "json4s-native" % "3.1.0",
  "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.1.3",
  // -- concurrency --
  // "com.typesafe.akka" %% "akka-actor" % "2.2-SNAPSHOT",
  "org.scala-stm" %% "scala-stm" % "0.7",
  // -- network --
   "net.databinder.dispatch" %% "dispatch-core" % "0.9.2",
  // -- testing --
  "org.scalacheck" %% "scalacheck" % "1.10.0" % "test",
  "org.specs2" %% "specs2" % "1.13",
  "org.scalatest" % "scalatest_2.10" % "2.0.M5b"
)

/* you may need these repos */
resolvers ++= Seq(
  // Resolver.sonatypeRepo("snapshots")
  // Resolver.typesafeIvyRepo("snapshots")
  // Resolver.typesafeIvyRepo("releases")
  // Resolver.typesafeRepo("releases")
  // Resolver.typesafeRepo("snapshots")
  // JavaNet2Repository,
  // JavaNet1Repository,
  // "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"
)

// ivyXML := <dependencies>
//             <exclude module="logback-classic" />
//           </dependencies>

/* testing */
parallelExecution in Test := false

// testOptions += Tests.Argument(TestFrameworks.Specs2, "console", "junitxml")

// parallelExecution in Global := false //no parallelism between subprojects

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

mappings in (Compile, packageBin) ~= { (ms: Seq[(File, String)]) =>
  ms filter { case (file, toPath) =>
      toPath != "application.conf"
  }
}

publishArtifact in Test := false

// publishArtifact in (Compile, packageDoc) := false

// publishArtifact in (Compile, packageSrc) := false

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
// http://www.scala-sbt.org/using_sonatype.html

/* assembly plugin */
mainClass in AssemblyKeys.assembly := Some("$project_group_id$.$project_artifact_id$.Main")

assemblySettings

test in AssemblyKeys.assembly := {}
