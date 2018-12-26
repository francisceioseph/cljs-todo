(ns cljs-todo.todo-list
  (:require [cljs-todo.state :as s]
            [cljs-todo.todo-item :as ti]))

(defn todo-list []
  [:div.mt-4
   [:form
    [:ul.list-group
     (for [todo (:todos @s/app-state)] (ti/todo-item todo))]]])
