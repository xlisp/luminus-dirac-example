(ns jimw-clj-binding-games.dev-middleware
  (:require [ring.middleware.reload :refer [wrap-reload]]
            [selmer.middleware :refer [wrap-error-page]]
            [prone.middleware :refer [wrap-exceptions]]))

(defn wrap-dev [handler]
  (-> handler
      wrap-reload
      wrap-error-page
      (wrap-exceptions {:app-namespaces ['jimw-clj-binding-games]})))
