(ns sum-pairs.core
  (:use clojure.test)
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
    new-pairs
    (create-pairs vals (+ index 1) new-pairs)))

(defn is-mod-k [k val]
  (if (= (mod val k) 0)
    1
    0))

(defn add-divisibles [k pairs]
  (reduce + (map (partial is-mod-k k) pairs)))

(deftest pairing
  (def input [1 2 1])
  (def pairs (create-pairs input 0 []))
  (is (= pairs [3 3]))
  )

(deftest pairing2
  (def input [2 1 1])
  (def pairs (create-pairs input 0 []))
  (is (= pairs [3 3]))
  )


(deftest pairing3
  (def input [1 1 2])
  (def pairs (create-pairs input 0 []))
  (is (= pairs [3 3]))
  )



(defn -main
  "Solves hackerrank problem Sum Pairs"
  [& args]
  (run-all-tests)
  (def input [43 95 51 55 40 86 65 81 51 20 47 50 65 53 23 78 75 75 47 73 25 27 14 8 26 58 95 28 3 23 48 69 26 3 73 52 34 7 40 33 56 98 71 29 70 71 28 12 18 49 19 25 2 18 15 41 51 42 46 19 98 56 54 98 72 25 16 49 34 99 48 93 64 44 50 91 44 17 63 27 3 65 75 19 68 30 43 37 72 54 82 92 37 52 72 62 3 88 82 71])
  (def k 22)
  (def pairs (create-pairs input 0 []))
  (println (add-divisibles k pairs)))

