(ns jimw-clj-binding-games.app
  (:require [jimw-clj-binding-games.core :as core]))

;;ignore println statements in prod
(set! *print-fn* (fn [& _]))

(core/init!)
