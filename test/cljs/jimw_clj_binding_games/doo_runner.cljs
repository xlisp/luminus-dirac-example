(ns jimw-clj-binding-games.doo-runner
  (:require [doo.runner :refer-macros [doo-tests]]
            [jimw-clj-binding-games.core-test]))

(doo-tests 'jimw-clj-binding-games.core-test)

