(defproject tweet-scrap "0.1.0"
  :description "Scraping Midjournal twitter account."
  :url "http://midjournal.com"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
  							 [twitter-api "0.7.6"]]
  :main ^:skip-aot tweet-scrap.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
