# This giter8 template is where I start all my scala projects. #

## Use this template ##

- [Install giter8 (g8)](https://github.com/n8han/giter8).
- Get the g8 template and run it:

```sh
$ g8 ymasory/sbt
$ cd <name-of-app>
$ ./sbt
> run
```

## Modify this template ##

- [Install sbt](https://github.com/harrah/xsbt/wiki/Getting-Started-Setup), version 0.12.0 or higher.
- Fork [ymasory/sbt.g8](https://github.com/ymasory/sbt.g8) on GitHub to your account.
Let's assume your account is "foo".
- Clone it.

```sh
$ git clone git@github.com:foo/sbt.g8.git
```

- Now make your desired changes.
- Do a local deploy of your modified template and try it out.

```sh
$ cd sbt.g8
$ rm -rf target
$ sbt
> g8-test # must result in SUCCESS
> exit
$ cd target/sbt-test/default-*/scripted
$ sbt
$ run
```

- If you like your new template, push it to GitHub.

```sh
$ cd sbt.g8
$ git push
```

- You can now access your modified template using g8.

```sh
$ cd
$ g8 foo/sbt
```

- If you'd like to share your changes, send a pull request.
