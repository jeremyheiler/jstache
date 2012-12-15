(ns jstache.core
  (:require [clojure.java.io :as io]
            [cheshire.core :as json]
            [stencil.core :as stencil]
            [ring.middleware.params :refer [wrap-params]]
            [ring.middleware.nested-params :refer [wrap-nested-params]]
            [ring.middleware.keyword-params :refer [wrap-keyword-params]]))

(defn render [request]
  {:status 200
   :headers {"Content-Type" "text/plain"}
   :body (stencil/render-string
          (get-in request [:jstache :template])
          (get-in request [:jstache :data]))})

(defn error [error]
  {:status 404
   :headers {"Content-Type" "application/json"}
   :body (json/generate-string {:error error})})

(defn do-render
  [request]
  (render request))

(defn check-render
  [handler]
  (fn [request]
    (if (= "/render" (:uri request))
      (handler request)
      (error "Invalid API call; Only replies to /render"))))

(defn handle-json
  [request]
  (let [body (json/parse-stream (io/reader (:body request)) keyword)]
    (assoc request :jstache body)))

(defn check-content-type
  [handler]
  (fn [request]
    (if (= "application/json" (:content-type request))
      (handler (handle-json request))
      (error "Can only accept JSON; Check your content type"))))

(def api
  (-> do-render
      check-render
      check-content-type
      wrap-keyword-params
      wrap-nested-params
      wrap-params))