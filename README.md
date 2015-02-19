Paths.scala.js
==============

[Paths.js](https://github.com/andreaferretti/paths-js) is a library to generate [SVG paths](http://www.w3.org/TR/SVG/paths.html), allowing you to create your own charts using a functional and testable API. Paths.scala.js is the binding of Paths.js for [Scala.js](http://www.scala-js.org/).

Documentation
-------------

The bindings are complete, but there is not much in terms of documentation or examples yet. You can refer to [the documentation of Paths.js](https://github.com/andreaferretti/paths-js/wiki), or explore the [Scaladocs API](http://andreaferretti.github.io/paths-scala-js).

Usage
-----

Paths.scala.js is not published yet. In order to use it, clone this repository, then

    sbt publishLocal

This will publish the artifact locally, for Scala 2.11 with Scala.js 0.6. In another Scala.js project, you can then depend on this artifact with

    libraryDependencies += "eu.unicredit" %%% "paths-scala-js" % "0.3.2"

You will also need to link to the [global build](https://github.com/andreaferretti/paths-js/tree/master/dist/global) of Paths.js - which contains the library as a single script - inside your HTML file.

To do
-----

The next steps are:

- publish Paths.js on webjars
- publish Paths.scala.js on Maven central
- make an example application