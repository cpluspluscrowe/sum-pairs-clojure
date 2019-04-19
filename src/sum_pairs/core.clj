(ns sum-pairs.core
  (:gen-class))

(defn pair-key-val [key val]
  (+ key val))

(defn create-pairs [vals, index, pairs]
  (if (= (count vals) 0) [])
  (def current (nth vals index))
  (def filtered-vals (filter (partial < current) vals))
  (def new-pairs (reduce conj pairs
                         (map (partial pair-key-val current) filtered-vals)))
  (if (= (- (count vals) 1) index)
    pairs
    (create-pairs vals (+ index 1) new-pairs)))

(defn is-mod-k [k val]
  (if (= (mod val k) 0)
    1
    0))

(defn add-divisibles [k vals]
  (reduce + (map (partial is-mod-k k)

                 (create-pairs vals 0 []))))

(defn -main
  "Solves hackerrank problem Sum Pairs"
  [& args]
  (def input [1 3 2 6 1 2])
  (def k 3)
  (println (add-divisibles k input)))

