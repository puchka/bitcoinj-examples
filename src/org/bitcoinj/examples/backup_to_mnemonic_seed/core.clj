(ns org.bitcoinj.examples.backup-to-mnemonic-seed.core
  (:import
    (org.bitcoinj.core
      Utils)
    (org.bitcoinj.params
      TestNet3Params)
    (org.bitcoinj.script
      Script$ScriptType)
    (org.bitcoinj.wallet
      Wallet)))


(defn -main
  []
  (let [params (TestNet3Params/get)
        wallet (Wallet/createDeterministic params Script$ScriptType/P2PKH)
        seed (.getKeyChainSeed wallet)]
    (println "seed:" (.toString seed))
    (println "creation time: " (.getCreationTimeSeconds seed))
    (println "mnemonicCode: " (.join Utils/SPACE_JOINER (.getMnemonicCode seed)))))
