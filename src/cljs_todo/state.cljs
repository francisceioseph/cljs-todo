(ns cljs-todo.state
  (:require
    [reagent.core :as reagent :refer [atom]]))

(defonce app-state (atom {:todos []}))

