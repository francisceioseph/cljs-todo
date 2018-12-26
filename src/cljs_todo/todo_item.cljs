(ns cljs-todo.todo-item
  (:require [cljs-todo.state :as s]))

(defn on-todo-change [id]
  #(swap! s/app-state assoc-in [:todos id :done] (.-checked (.-target %))))

(defn todo-item [task]
  [:li.list-group-item {:key (:id task)}
   [:div.form-check
    [:input.form-check-input {:type :checkbox :id :simple-checkbox :on-change (on-todo-change (:id task))}]
    [:label.form-check-label { :for :simple-checkbox } (:text task)]]])

