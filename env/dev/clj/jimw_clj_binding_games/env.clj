(ns jimw-clj-binding-games.env
  (:require
    [selmer.parser :as parser]
    [clojure.tools.logging :as log]
    [jimw-clj-binding-games.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[jimw-clj-binding-games started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[jimw-clj-binding-games has shut down successfully]=-"))
   :middleware wrap-dev})
