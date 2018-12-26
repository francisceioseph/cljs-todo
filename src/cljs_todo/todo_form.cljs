(ns cljs-todo.todo-form
  (:require [reagent-forms.core :refer [bind-fields]]
            [reagent.core :refer [atom]]
            [cljs-todo.state :as s]))

(def todo-form-template
   [:div.form-group
    [:label {:for :todo.text} "Add a new todo"]
    [:input.form-control {:field :text :id :todo.text}]])

(defrecord Todo
  [id text done])

(defn update-state [state form-data]
  (update-in state [:todos] conj (Todo.
                                   (count (:todos state))
                                   (get-in form-data [:todo :text])
                                   false)))

(defn clear-form-data [form-data]
  (and
    (swap! s/app-state update-state form-data)
    {}))

(defn submit-form-data [form-data]
  (fn [event]
    (.preventDefault event)
    (swap! form-data clear-form-data)))

(defn todo-form []
  (let [form-data (atom {})]
   (fn []
     [:form.card {:on-submit (submit-form-data form-data)}
      [:div.card-body
       [bind-fields todo-form-template form-data]
       [:button.btn.btn-primary {:type :submit} "Add todo"]]])))
