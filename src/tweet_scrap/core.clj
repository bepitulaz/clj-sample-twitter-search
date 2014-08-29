(ns tweet-scrap.core
	(:use 
		[twitter.oauth]
   	[twitter.callbacks]
   	[twitter.callbacks.handlers]
   	[twitter.api.restful]
   	clojure.java.io)
	(:import
   (twitter.callbacks.protocols SyncSingleCallback))
  (:gen-class))

;; Consumer Key 
(def ^:dynamic *app-consumer-key* "")
;; Consumer Secret
(def ^:dynamic *app-consumer-secret* "")
;; Access Token
(def ^:dynamic *user-access-token* "")
;; Access Token Secret
(def ^:dynamic *user-access-token-secret* "")

;; Creating credential
;; @param app-consumer-key
;; @param app-consumer-secret
;; @param user-access-token
;; @param user-access-token-secret
(def my-creds (make-oauth-creds *app-consumer-key*
																*app-consumer-secret*
																*user-access-token*
																*user-access-token-secret*))

;; Do the twitter search
;; @param query is a query keyword
;; @return json of result
(defn search
	[query]
	(search-tweets :oauth-creds my-creds
		:params { :q query :result_type "recent" }))

;; Get current date
(def now (.format (java.text.SimpleDateFormat. "yyyy-MM-dd") (java.util.Date.)))

(defn -main
	"Entry point for the twitter app."
	[& args]
	(spit 
		(clojure.string/join "." [now "json"]) 
		(clojure.data.json/write-str (search args))))
