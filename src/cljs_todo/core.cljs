(ns cljs-todo.core
    (:require
      [reagent.core :as reagent]
      [cljs-todo.header :as h]
      [cljs-todo.todo-list :as tl]
      [cljs-todo.todo-form :as tf]))

(enable-console-print!)

(defn app []
  [:div.container
   [h/app-header]
   [tf/todo-form]
   [tl/todo-list]])

(reagent/render-component [app]
                          (. js/document (getElementById "app")))

(defn on-js-reload [])
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)

