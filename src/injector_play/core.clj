(ns injector-play.core
  (:require [injector-play.injector :as injector])
  (:gen-class))

(defn do-stuff []
  (let [db (injector/system :get :db)]
    (println (str "The db connection is " (:conn db)))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (do
    (println "starting")
    (injector/system :set :db {:conn "localhost:5555"})
    (injector/system :set :mailer {:address "somewhere"})
    (do-stuff)
    (println "done")))
