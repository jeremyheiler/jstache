(ns jstache.heroku
  (:require [jstache.core :as jstache]
            [ring.adapter.jetty :as jetty]))

(defn -main [port]
  (jetty/run-jetty jstache/api {:port (Integer. port)}))