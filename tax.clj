; Copyright (C) 2010 Jan Michael Alonzo. All Rights Reserved.
; The use and distribution terms for this software are covered by the
; Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
; which can be found in the file epl-v10.html at the root of this distribution.
; By using this software in any fashion, you are agreeing to be bound by
; the terms of this license.
; You must not remove this notice, or any other, from this software.

(defn calc-espp-purchase-tax [fmv nshares]
  "Calculate the share purchase tax for Employee Shares Purchase Plan
   in Australia. Implementation is based on 2008-09, 2009-10
   calculations. May not be valid for earlier and later years.

   fmv => fair market value of the share at the time it was purchased
   nshares => number of shares purchased
"
  (let [total-market-price-at-purchase (* fmv nshares)
        purchase-price-per-share (* fmv 0.85)
        total-purchase-price (* purchase-price-per-share nshares)
        compensation-income (- total-market-price-at-purchase total-purchase-price)
        income-tax-at-purchase (* compensation-income 0.45)
        medicare-levy (* compensation-income 0.015)]
    (apply + [income-tax-at-purchase medicare-levy])))
 
(defn calc-espp-sales-tax [mp pp nshares]
  "Calculate the share sales tax for ESPP in Australia. Shares are
  assumed held for over a year. Implementation is based on 2009-2010
  formula and may not be valid for earlier and later years.

  mp => market price per share 
  pp => share purchase price
  nshares => number of shares sold
"
  (let [total-sale-price (* mp nshares)
        total-market-price-at-purchase (* pp nshares)
        capital-gain (- total-sale-price total-market-price-at-purchase)
        capital-gains-tax-at-sale (* (* capital-gain 0.50)
                       0.45)
        medicare-levy-at-sale (* (* capital-gain 0.50)
                                 0.015)]
    (apply + [capital-gains-tax-at-sale medicare-levy-at-sale])))

