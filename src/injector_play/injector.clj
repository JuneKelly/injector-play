(ns injector-play.injector)

(defonce lookup-table (atom {}))

(defn system
  ([op key]
   (if (= op :get)
     (get @lookup-table key)
     (throw (Exception. (str "not a valid operation " op)))))
  ([op key val]
   (if (= op :set)
     (do
       (swap! lookup-table assoc key val)
       val)
     (throw (Exception. (str "not a valid operation " op))))))
