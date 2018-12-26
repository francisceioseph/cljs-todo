(ns cljs-todo.header)

(defn app-header
  "A simple app header for the todo list"
  []

  [:div
   [:h1.text-center.text-uppercase "My Todos"]
   [:h6.text-center.text-uppercase "A simple todo list example"]
   [:hr]])
