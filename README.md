# JStache

A web service that renders [Mustache](http://mustache.github.com) templates.

## Usage

Try it out with `curl`:

    curl -X POST \
         -H "Content-Type: application/json" \
         -d '{"template": "Hello {{name}}!", "data": {"name": "Sophie"}}'
         http://api.jstache.org/render

## About

JStache is built with Clojure, using the following great libraries:

 - [Stencil](https://github.com/davidsantiago/stencil) for rendering Mustache templates.
 - [Cheshire](https://github.com/dakrone/cheshire) for JSON reading and parsing.
 - [Ring](https://github.com/ring-clojure/ring) for handling HTTP.

## License

Copyright © 2012 Jeremy Heiler

Distributed under the Eclipse Public License, the same as Clojure.
