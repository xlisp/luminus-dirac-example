(ns jimw-clj-binding-games.routes.home
  (:require
    [jimw-clj-binding-games.layout :as layout]
    [jimw-clj-binding-games.db.core :as db]
    [clojure.java.io :as io]
    [jimw-clj-binding-games.middleware :as middleware]
    [ring.util.http-response :as response]))

(defn home-page [request]
  (layout/render request "home.html"))

(defn home-routes []
  [""
   {:middleware [middleware/wrap-csrf
                 middleware/wrap-formats]}
   ["/" {:get home-page}]
   ["/docs" {:get (fn [_]
                    (-> (response/ok (-> "docs/docs.md" io/resource slurp))
                        (response/header "Content-Type" "text/plain; charset=utf-8")))}]])

