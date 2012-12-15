# jstache

A web service that renders [Mustache](http://mustache.github.com) templates.

## Usage

Try it out with `curl`:

    curl -X POST \
         -H "Content-Type: application/json"
         -d '{"template": "Hello {{name}}!", "data": {"name": "Sophie"}}' http://api.jstache.org/render

## License

Copyright © 2012 Jeremy Heiler

Distributed under the Eclipse Public License, the same as Clojure.
