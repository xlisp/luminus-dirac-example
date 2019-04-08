(ns user
  (:require
    [jimw-clj-binding-games.config :refer [env]]
    [clojure.spec.alpha :as s]
    [expound.alpha :as expound]
    [mount.core :as mount]
    [jimw-clj-binding-games.figwheel :refer [start-fw stop-fw cljs]]
    [jimw-clj-binding-games.core :refer [start-app]]
    [jimw-clj-binding-games.db.core]
    [conman.core :as conman]
    [luminus-migrations.core :as migrations]))

(alter-var-root #'s/*explain-out* (constantly expound/printer))

(defn start []
  (mount/start-without #'jimw-clj-binding-games.core/repl-server))

(defn stop []
  (mount/stop-except #'jimw-clj-binding-games.core/repl-server))

(defn restart []
  (stop)
  (start))

(defn restart-db []
  (mount/stop #'jimw-clj-binding-games.db.core/*db*)
  (mount/start #'jimw-clj-binding-games.db.core/*db*)
  (binding [*ns* 'jimw-clj-binding-games.db.core]
    (conman/bind-connection jimw-clj-binding-games.db.core/*db* "sql/queries.sql")))

(defn reset-db []
  (migrations/migrate ["reset"] (select-keys env [:database-url])))

(defn migrate []
  (migrations/migrate ["migrate"] (select-keys env [:database-url])))

(defn rollback []
  (migrations/migrate ["rollback"] (select-keys env [:database-url])))

(defn create-migration [name]
  (migrations/create name (select-keys env [:database-url])))


