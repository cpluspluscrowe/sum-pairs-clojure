(ns sum-pairs.core
  (:gen-class))

(defstruct pair :i :j :sum)

(defn pair-key-val [key val]
  (struct pair key val (+ key val)))

(defn create-pairs [vals, index, pairs]
  (def current (nth vals index))
  (def new-pairs (reduce conj pairs
                         (map (partial pair-key-val current) vals)))
  (if (= (- (count vals) 1) index)
    pairs
    (create-pairs vals (+ index 1) new-pairs)))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (def input [1 3 2 6 1 2])
  (println (create-pairs [1 2 3] 0 [])))
