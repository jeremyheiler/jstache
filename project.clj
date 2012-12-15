(defproject jstache "0.1.0-SNAPSHOT"
  :description "A service that renders Mustache templates."
  :url "http://api.jstache.org"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [stencil "0.3.1"]
                 [cheshire "5.0.1"]
                 [ring/ring-core "1.1.6"]
                 [ring/ring-jetty-adapter "1.1.6"]]
  :plugins [[lein-ring "0.7.5"]]
  :min-lein-version "2.0.0"
  :ring {:handler jstache.core/api})
