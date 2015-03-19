Paths.scala.js
==============

[Paths.js](https://github.com/andreaferretti/paths-js) is a library to generate [SVG paths](http://www.w3.org/TR/SVG/paths.html), allowing you to create your own charts using a functional and testable API. Paths.scala.js is the binding of Paths.js for [Scala.js](http://www.scala-js.org/).

Documentation
-------------

The usage of Paths.scala.js is mostly similar to its parent library. You can

- browse the [documentation of Paths.js](https://github.com/andreaferretti/paths-js/wiki)
- explore the [Scaladocs API](http://andreaferretti.github.io/paths-scala-js)
- see an [example application](https://github.com/andreaferretti/paths-scala-js-demo) ([live demo](http://andreaferretti.github.io/paths-scala-js-demo/))

The demo application is still incomplete, and fails to show many of Paths.scala.js features. The [Paths.js demo](http://andreaferretti.github.io/paths-js-demo/) better showcases what can be done.

Usage
-----

Paths.scala.js is published on the Sonatype snapshots repository, for Scala 2.11 with Scala.js 0.6. In a Scala.js project, you can depend on Paths.scala.js with

    resolvers += "Sonatype snapshots" at
      "https://oss.sonatype.org/content/repositories/snapshots"

    libraryDependencies += "eu.unicredit" %%% "paths-scala-js" % "0.3.2-SNAPSHOT"

You will also need to depend on the original JS library, which is available on Webjars:

    jsDependencies += "org.webjars" % "paths-js" % "0.3.2" / "paths.js"

Compatibility
-------------

Paths.scala.js is meant to have an API that is exactly equivalent to its parent library. The only exception is in the `Graph` and `Sankey` charts, where instead of accepting a parameter `data` with `nodes` and `links` fields, the Scala.js API directly requires `nodes` and `links` parameters. This removes one leve of nesting and eliminates the need for structural typing in this particular case.

Please, file any other incompatibility between Paths.js and Paths.scala.js as an issue.