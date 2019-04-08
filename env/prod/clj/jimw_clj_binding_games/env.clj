(ns jimw-clj-binding-games.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[jimw-clj-binding-games started successfully]=-"))
   :stop
   (fn []
     (log/info "\n-=[jimw-clj-binding-games has shut down successfully]=-"))
   :middleware identity})
